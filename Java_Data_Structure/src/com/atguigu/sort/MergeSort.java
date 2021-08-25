package com.atguigu.sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = { 8, 4, 5, 7, 1, 3, 6, 2};
        int[] temp = new int[array.length];
        mergeSort(array,0, array.length - 1, temp);
        System.out.println(Arrays.toString(array));
    }

    //归并排序算法
    //思路：分治思想
    //分：按照中间对半，把数组一点点对半划分
    //治：通过划分后的最小单元：left，mid，right，进行排序并放入到temp中
    public static void mergeSort(int[] array,int left,int right,int[] temp)
    {
        //注意终止条件
        if(left < right)
        {//分
            int mid = (left + right)/2;
            mergeSort(array, left, mid,temp);
            mergeSort(array,mid + 1,right,temp);
            //治
            merge(array,left,mid,right,temp);
        }
    }
    public static void merge(int[] array,int left,int mid,int right,int[] temp)
    {
        //治
        int i = left;//作为左边有序序列的第一位
        int j = mid + 1;//作为右边有序序列的第一位
        int t = 0;//作为temp数组的变量
        //将左右+mid有序序列合并成一个大的有序序列
        while(i <= mid && j <= right)
        {
            if(array[i] <= array[j])//左小
            {
                temp[t] = array[i];
                i++;
                t++;
            }
            else if(array[j] < array[i])
            {
                temp[t] = array[j];
                j++;
                t++;
            }
        }//while遍历结束说明：至少有一边有序数组遍历完了
        //将左边剩余的数都赋值给temp
        while(i <= mid)
        {
            temp[t++] = array[i++];
        }

        while(j <= right)
        {
            temp[t++] = array[j++];
        }

        //将temp中的数赋值给array，部分赋值即可
        //从left赋值到right
        int templeft = left;
        t = 0;
        while(templeft <= right)
        {
            array[templeft] = temp[t];
            t+=1;
            templeft+=1;
        }
    }
}
