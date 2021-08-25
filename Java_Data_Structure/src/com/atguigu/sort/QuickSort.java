package com.atguigu.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = {-9,78,0,23,-567,70, -1,900, 4561};
        quickSort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }

    public static void quickSort(int[] array, int start,int end)
    {
        //终止条件
        if(start >= end)
        {
            return;
        }
        int low = start;
        int high = end;
        int pivot = array[(start + end)/2];
        int temp = 0;
        while(low < high)
        {
            //pivot左边的值比pivot小，直到找到大于等于pivot的
            while(array[low] < pivot)
            {
                low+=1;
            }
            //pivot右边的值比pivot大，直到找到小于等于pivot的值
            while(array[high] > pivot)
            {
                high-=1;
            }
            //经过两个循环，找到了pivot两边的异类值，并对他们进行交换
            temp = array[low];
            array[low] = array[high];
            array[high] = temp;
        }
        //结束while循环时表明；low=high=pivot，此时该排序已完成，左右大小以大局确定
        //下一个递归的范围为：low-1和low+1
        quickSort(array,start,low-1);
        quickSort(array,low+1,end);


    }
}
