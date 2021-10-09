package com.atguigu.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = {10,10,0,23,-567,70, -1,900, 4561};
        quickSort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }

    public static void quickSort(int[] array, int start,int end) {
        //终止条件
        if(start > end) {
            return;
        }
        int low = start;
        int high = end;
        //设置左边第一位为标准位
        int compare = array[start];
        while(low < high) {
            //【重要：先从左边开始找！！！！！！！！！！！！！！！】
            //找到右边异类：比compare小的【重要：每次比较时，也要比较low和high的位置关系】
            while(array[high] >= compare && low < high) {
                high-=1;
            }
            //找到左边异类：比compare大的
            while(array[low] <= compare && low < high) {
                low+=1;
            }
            //经过两个循环，找到了两边的异类值，并对他们进行交换
            int temp = array[low];
            array[low] = array[high];
            array[high] = temp;
        }
        //交换完异类后，交换标准位和low的值
        array[start] = array[low];
        array[low] = compare;
        //下一个递归的范围为：low-1和low+1
        quickSort(array,start,low-1);
        quickSort(array,low+1,end);
    }
}
