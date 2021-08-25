package com.atguigu.sort;

import java.util.Arrays;

public class insertSort {
    //插入排序法
    public static void main(String[] args) {
        //创建8000随机数组
        int[] array = new int[8000];
        for(int i = 0; i < 8000; i++)
        {
            array[i] = (int) (Math.random()*8000);
        }
        for(int data : array)
        {
            System.out.println(data);
        }
        /**
         * 插入排序法：
         * 思路：
         *      将数组分为有序部分和无序部分，初始时有序为1，无序为n-1
         *      每次将待插入的无序部分的第一个data，在有序数组部分进行排序
         *      insertValue：无序表中即将插入的data
         *      insertIndex：有序表中最后一个有序data的下标，等于insertValue的下标-1
         *      排序过程：
         *          如果insertValue大于等于array[insertIndex]:
         *              此次for循环无事发生，i++进行下一位的判断
         *          如果insertValue小于array[insertIndex]:
         *              将insertIndex的值往后移，直到找到插入的位置
         *              array[insertIndex + 1] = array[insertIndex]
         *              insertIndex--;
         */

        //int[] afterInsertSort = new insertSort().doInsertSort()
        int[] afterInsertSort = doInsertSort(array);
        System.out.println("==========插入排序后的数组==========");
        for(int data : afterInsertSort)
        {
            System.out.println(data);
        }
    }

    //要用静态方法，不然需要创建对象才能使用
    public static int[] doInsertSort(int[] array)
    {
        for(int i = 1 ; i < array.length; i++)
        {
            int insertValue = array[i];
            int insertIndex = i - 1;
            //当insertValue小于array[insertIndex]时，不断寻找可以插入的位置
            //insertIndex>0保证下标不越界
            while(insertIndex > 0 && insertValue < array[insertIndex])
            {
                array[insertIndex + 1] = array[insertIndex];//往后移
                insertIndex--;
            }
            if(insertIndex + 1 != i)
            {
                array[insertIndex + 1] = insertValue;
            }
        }
        return Arrays.copyOfRange(array,0,array.length);
    }
}
