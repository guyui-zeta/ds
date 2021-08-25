package com.atguigu.sort;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int[] array = {53, 3, 542, 748, 14, 214};
        radixsort(array);
        System.out.println(Arrays.toString(array));
    }
    public static void radixsort(int[] array)
    {
        //基数排序思路【桶排序升级版】：
        //将每个元素的每一位取出来，并放到对应的桶中，
        //桶是一个二维数组，t[k]表示个/十位数的数为k，t[k][n]表示该桶的数据个数
        //步骤：
        //1.先找到数组中最大数的个数
        //2.根据最大数的个数，得出遍历几次
        int max = array[0];
        for(int i = 1; i < array.length - 1; i++)
        {
            if(array[i] > max)
            {
                max = array[i];
            }
        }

        int maxLength = (max+"").length();
        //maxlength决定着遍历的次数

        //创建桶的二维数组
        int[][] bucket = new int[10][array.length];
        //创建一维数组来记录每个桶中的数据个数,且初始值都是0，直接可以计数
        int[] bucketCount = new int[10];
        System.out.println("记录个数的一维数组：" + Arrays.toString(bucketCount));

        for(int i = 0,n = 1; i < maxLength; i++,n*=10)//i代表几位数，需要几次循环
        {
            //每次遍历取出一位数字
            for(int j = 0; j < array.length; j++)
            {
                int digitOfElement = array[j]/n%10;//取出最右位，并每次去之前右移
                bucket[digitOfElement][bucketCount[digitOfElement]] = array[j];
                bucketCount[digitOfElement]++;
            }
            int index = 0;
            //数字都放进桶后，按照顺序取出来，重新赋值给array
            //遍历每一个桶(共10个桶)
            for(int k = 0; k < 10; k++)
            {
                if(bucketCount[k] != 0)
                {
                    for(int l = 0; l < bucketCount[k]; l++)
                    {
                        array[index++] = bucket[k][l];
                    }
                }
                //每次处理完k桶后，清空k桶，方便下一位的使用
                bucketCount[k] = 0;
            }

        }
    }
}
