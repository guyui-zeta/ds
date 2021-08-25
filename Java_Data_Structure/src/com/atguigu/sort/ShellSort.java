package com.atguigu.sort;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] arrays = {8,9,1,7,2,3,5,4,6,0};
        shellSort2(arrays);
        for(int data : arrays)
        {
            System.out.println(data);
        }
        System.out.println("经过shell排序后的数组为" + Arrays.toString(arrays));


    }

    //交换排序法
    public static void shellSort(int[] array)
    {
        //思路：
        //每次按照length/2的间隔去排序
        //参数:step步长，
        int step;
        for(step = array.length/2; step > 0; step/=2)
        {
            //每个step下，比较step区间内的每个数进行排序
            for(int i = step; i < array.length; i++)
            {
                //每次从每个区间的最后一个数开始比较
                //每次和前一个相隔step的数进行比较
                for(int j = i - step; j >= 0; j-=step )
                {
                    if(array[j] > array[j + step])
                    {
                        //从小到大排序
                        int temp = array[j];
                        array[j] = array[j + step];
                        array[j + step] = temp;
                    }
                }
            }
        }
    }

    //移动排序法（用插入排序法）
    public static void shellSort2(int[] array)
    {
        int cout = 0;
        for(int step = array.length; step > 0; step/=2 )
        {
            //i = step是指第一个有 step间隔的数比较，实质上还是遍历了整个数组，只是从第一个满足i-step>=0的数开始
            for(int i = step; i < array.length; i++)
            {
                int j = i;
                int temp = array[j];

                //每次将每组的第一个step之后的数temp=array[i]进行插入排序，将他归位到正确的位置
                while(j - step >=0 && temp < array[j - step])
                {
                    //移动
                    array[j] = array[j - step];
                    j-=step;
                }
                //跳出循环说明，找到了temp=array[j]的位置了
                array[j] = temp;
            }
        }
    }


}
