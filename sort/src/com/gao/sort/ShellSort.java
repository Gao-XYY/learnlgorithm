package com.gao.sort;

/**
 * 希尔排序（Shell Sort）
 */
public class ShellSort {


    public static void main(String[] args) {
        int[] data= {1,2,3,5,2,3};
        int n = data.length;
        int[] result = shellSort(data, n);
        for(int i = 0; i < n; i++){
            System.out.print(result[i]);
        }

    }

    public static int[] shellSort(int[] A, int n) {
        if (A == null || A.length < 2) {
            return A;
        }
        int mid = n / 2;
        int index = 0;
        while(mid > 0) {
            for(int i = mid; i < n; i++) {
                index = i;
                while(index >= mid) {
                    if(A[index - mid] > A[index]) {
                        swap(index-mid, index, A);
                        index -= mid;
                    }else {
                        break;
                    }
                }
            }
            mid /= 2;
        }
        return A;

    }

    public static void swap(int i, int j, int[] arr) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }


}
