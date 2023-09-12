package com.gao.leetcode;

public class FindDelayedArrivalTime {

    public static void main(String[] args) {
        int arrivalTime = 15, delayedTime = 5;
        int delayedArrivalTime = findDelayedArrivalTime(arrivalTime, delayedTime);
        System.out.println(delayedArrivalTime);
    }

    public static int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        return (arrivalTime + delayedTime) % 24;
    }

}
