package com.gao.leetcode;

/**
 * 860. 柠檬水找零
 * 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
 * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
 * 注意，一开始你手头没有任何零钱。
 * 给你一个整数数组 bills ，其中 bills[i] 是第 i 位顾客付的账。如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
 */
public class MonaledeChange {
    public static void main(String[] args) {
        int[] bills = {5,5,5,10,5,5,10,20,20,20};
        Solution006 solution006 = new Solution006();
        boolean b = solution006.lemonadeChange3(bills);
        System.out.println(b);
    }
}

class Solution006 {
    public boolean lemonaledeChange1(int[] bills) {
        int five = 0, ten = 0;
        for (int bill : bills){
            if (bill == 5){
                five++;
            } else if (bill == 10){
                if (five == 0){
                    return false;
                }
                five--;
                ten++;
            } else {
                if (five > 0 && ten > 0){
                    five--;
                    ten++;
                } else if (five >= 3){
                    five -= 3;
                } else {
                    return false;
                }
            }

        }
        return true;
    }

    public boolean lemonaledeChange2(int[] bills) {
        int five = 0, ten = 0;
        for (int bill : bills){
            if (bill == 5){
                five++;
            } else if (bill == 10){
                five--;
                ten++;
            } else if (ten > 0){
                five--;
                ten--;
            } else {
                five -= 3;
            }
            if (five < 0){
                return false;
            }
        }
        return true;
    }

    public boolean lemonadeChange3(int[] bills) {
        int countFive = 0;
        int countTen = 0;

        for(int i = 0; i < bills.length; i++){
            if(bills[i]==5){
                countFive++;
            } else if(bills[i]==10){
                if(countFive==0){
                    return false;
                }else{
                    countFive--;
                    countTen++;
                }
            } else{
                if(countFive >0 && countTen >0){
                    countFive--;
                    countTen--;
                }else if(countFive >=3){
                    countFive-=3;
                }else{
                    return false;
                }
            }
        }
        return true;
    }

}

