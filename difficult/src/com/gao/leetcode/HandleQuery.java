package com.gao.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 2569. 更新数组后处理求和查询
 * 给你两个下标从 0开始的数组nums1 和nums2，和一个二维数组queries表示一些操作。总共有 3 种类型的操作：
 *
 * 操作类型 1 为queries[i]= [1, l, r]。你需要将 nums1从下标 l 到下标 r的所有 0反转成 1或将 1反转成 0。l和 r下标都从 0开始。
 * 操作类型 2 为queries[i]= [2, p, 0]。对于0 <= i < n中的所有下标，令nums2[i] =nums2[i]+ nums1[i]* p。
 * 操作类型 3 为queries[i]= [3, 0, 0]。求nums2中所有元素的和。
 * 请你返回一个数组，包含所有第三种操作类型的答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/handling-sum-queries-after-update
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class HandleQuery {

    public static void main(String[] args) {

    }

}

class Solution004 {
    public long[] handleQuery(int[] nums1, int[] nums2, int[][] queries) {
        int n = nums1.length;
        int m = queries.length;
        SegTree tree = new SegTree(nums1);

        long sum = 0;
        for (int num : nums2) {
            sum += num;
        }
        List<Long> list = new ArrayList<Long>();
        for (int i = 0; i < m; i++) {
            if (queries[i][0] == 1) {
                int l = queries[i][1];
                int r = queries[i][2];
                tree.reverseRange(l, r);
            } else if (queries[i][0] == 2) {
                sum += (long) tree.sumRange(0, n - 1) * queries[i][1];
            } else if (queries[i][0] == 3) {
                list.add(sum);
            }
        }
        long[] ans = new long[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}

class SegTree {
    private SegNode[] arr;

    public SegTree(int[] nums) {
        int n = nums.length;
        arr = new SegNode[n * 4 + 1];
        build(1, 0, n - 1, nums);
    }

    public int sumRange(int left, int right) {
        return query(1, left, right);
    }

    public void reverseRange(int left, int right) {
        modify(1, left, right);
    }

    public void build(int id, int l, int r, int[] nums) {
        arr[id] = new SegNode();
        arr[id].l = l;
        arr[id].r = r;
        arr[id].lazytag = false;
        if(l == r) {
            arr[id].sum = nums[l];
            return;
        }
        int mid = (l + r) >> 1;
        build(2 * id, l, mid, nums);
        build(2 * id + 1, mid + 1, r, nums);
        arr[id].sum = arr[2 * id].sum + arr[2 * id + 1].sum;
    }

    /* pushdown函数：下传懒标记，即将当前区间的修改情况下传到其左右孩子结点 */
    public void pushdown(int x) {
        if(arr[x].lazytag) {
            arr[2 * x].lazytag = !arr[2 * x].lazytag;
            arr[2 * x].sum = arr[2 * x].r - arr[2 * x].l + 1 - arr[2 * x].sum;
            arr[2 * x + 1].lazytag = !arr[2 * x + 1].lazytag;
            arr[2 * x + 1].sum = arr[2 * x + 1].r - arr[2 * x + 1].l + 1 - arr[2 * x + 1].sum;
            arr[x].lazytag = false;
        }
    }

    /* 区间修改 */
    public void modify(int id, int l, int r) {
        if (arr[id].l >= l && arr[id].r <= r) {
            arr[id].sum = (arr[id].r - arr[id].l + 1) - arr[id].sum;
            arr[id].lazytag = !arr[id].lazytag;
            return;
        }
        pushdown(id);
        int mid = (arr[id].l + arr[id].r) >> 1;
        if (arr[2 * id].r >= l) {
            modify(2 * id, l, r);
        }
        if(arr[2 * id + 1].l <= r) {
            modify(2 * id + 1, l, r);
        }
        arr[id].sum = arr[2 * id].sum + arr[2 * id + 1].sum;
    }

    /* 区间查询 */
    public int query(int id, int l, int r) {
        if (arr[id].l >= l && arr[id].r <= r) {
            return arr[id].sum;
        }
        if (arr[id].r < l || arr[id].l > r) {
            return 0;
        }
        pushdown(id);
        int res = 0;
        if (arr[2 * id].r >= l) {
            res += query(2 * id, l, r);
        }
        if (arr[2 * id + 1].l <= r) {
            res += query(2 * id + 1, l, r);
        }
        return res;
    }

    // ==========================================================================================

    int[] tree;
    boolean[] lazy;
    public long[] handleQuery(int[] nums1, int[] nums2, int[][] queries) {
        int n = nums1.length;
        tree = new int[4 * n];
        lazy = new boolean[4 * n];
        buildTree(nums1, 1, 1, n);

        // 计算nums2的和
        long sum = 0;
        for(int num : nums2) sum += num;

        // 计算queries中有多少个第3类型的查询
        int size = 0;
        for(int[] query : queries) if(query[0] == 3) size++;

        long[] res = new long[size];
        if(size == 0) return res;

        int i = 0;
        for(int[] query : queries){
            if(query[0] == 1) update(1, 1, n, query[1]+1, query[2]+1);
            else if(query[0] == 2) sum += (long)query[1] * tree[1];
            else res[i++] = sum;
        }
        return res;
    }

    // public void do_(int p, int l, int r){
    //     tree[p] = r - l + 1 - tree[p];
    //     lazy[p] = 1;
    // }

    // [s, e]需要更新的范围
    // [l, r]当前节点管理的范围
    public void update(int p, int l, int r, int s, int e){
        if(s <= l && r <= e){
            tree[p] = r - l + 1 - tree[p];
            lazy[p] = !lazy[p];
            return;
        }
        int m = l + (r - l) / 2;
        if(lazy[p]){
            tree[p * 2] = m - l + 1 - tree[p * 2];
            tree[p * 2 + 1] = r - m - tree[p * 2 + 1];
            lazy[p * 2] = !lazy[p * 2];
            lazy[p * 2 + 1] = !lazy[p * 2 + 1];
            lazy[p] = false;
        }
        if(m >= s) update(p * 2, l, m, s, e);
        if(m < e) update(p * 2 + 1, m + 1, r, s, e);
        tree[p] = tree[p * 2] + tree[p * 2 + 1];
    }

    public void buildTree(int[] nums, int p, int l, int r){
        if(l == r){
            tree[p] = nums[l - 1];
            return;
        }
        int m = l + (r - l) / 2;
        buildTree(nums, 2 * p, l, m);
        buildTree(nums, 2 * p + 1, m + 1, r);
        tree[p] = tree[p * 2] + tree[p * 2 + 1];
    }
}

class SegNode {
    public int l, r, sum;
    public boolean lazytag;

    public SegNode() {
        this.l = 0;
        this.r = 0;
        this.sum = 0;
        this.lazytag = false;
    }

}
