package com.atguigu.search;

import java.util.ArrayList;
import java.util.List;

/**
 * 2.二分法查找
 * 思路：
 * 注意：二分法的前提是有序数组
 *      1.首先确定该数组的中间下标
 *          mid = (left + right)/2
 *      2.然后让需要查找的数findVal和arr[mid]比较
 *          findVal<arr[mid]：说明要找的数在mid的左侧，因此需要递归向左查找
 *          findVal>arr[mid]:说明要找的数在mid的右侧，因此需要递归向右查找
 *          findVal=arr[mid]:说明已经找到，返回
 *      3.结束递归
 *          1.找到就结束递归
 *          2.遍历完整个数组，left>right结束递归
 *
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        int res1 = binarySearch(arr,15);
        int res2 = binarySearchRecursion(arr,15,0,arr.length - 1);
        System.out.println((res2 == -1) ? "没有找到" : "找到了，下标为：" + res2);
        System.out.println("=====课后习题：查找到所有目标值的小标[包括重复]=====");
        int[] arr2 = {1,2,3,4,5,6,7,8,9,9,9,9,9,10,11,12,13,14,15};
        List<Integer> res = binarySearchSame(arr2,9,0,arr.length - 1);
        if(res == null){
            System.out.println("没有找到");
        }else{
            for(int data : res){
                System.out.println("该数的下标为：" + data);
            }
        }

    }

    /**
     * 常规二分法：无递归实现
     * @param arr
     * @param data
     * @return
     */
    public static int binarySearch(int[] arr, int data){
        int left = 0;
        int right = arr.length - 1;
        while(left <= right){
            int mid = left - (left - right)/2;
            if(data > arr[mid]){
                left = mid + 1;
            }else if(data < arr[mid]){
                right = mid - 1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    /**
     * 递归二分法
     * @param arr
     * @param data
     * @return
     */
    public static int binarySearchRecursion(int[] arr,int data, int left, int right){
        int mid = left - (left - right)/2;
        if(left > right){
            return -1;
        }
        if(data > arr[mid]){
            return binarySearchRecursion(arr,data,mid + 1,right);
        }else if(data < arr[mid]){
            return binarySearchRecursion(arr,data,left,mid - 1);
        }else{
            return mid;
        }

    }

    /**
     * 课后习题：
     * 用二分法找到有序数组中所有的重复值的下标
     * 思路：
     *     找到mid时，不要急着返回，往mid的左右扫描，把相同的值加入到list中
     */
    public static List<Integer> binarySearchSame(int[] arr,int data,int left, int right){
        int mid = left - (left - right)/2;
        if(left > right){
            return null;
        }
        if(data > arr[mid]){
            return binarySearchSame(arr,data,mid + 1,right);
        }else if(data < arr[mid]){
            return binarySearchSame(arr,data,left,mid - 1);
        }else{
            List<Integer> res = new ArrayList<>();
            res.add(mid);
            int mid_left = mid - 1;
            int mid_right = mid + 1;
            while(arr[mid_left] == data){
                res.add(mid_left);
                mid_left--;
            }
            while(arr[mid_right] == data){
                res.add(mid_right);
                mid_right++;
            }
            return res;
        }
    }
}
