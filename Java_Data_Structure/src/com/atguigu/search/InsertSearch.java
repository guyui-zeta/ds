package com.atguigu.search;

import java.lang.annotation.Target;

/**
 * 3.插值查找法
 * 思路：
 *      和二分查找的思路一样，只不过将mid替换为p期望下标
 * 注意：
 *      要注意target越界的问题
 * @author Zeta
 * @version 1.0
 * @date 2021/9/4 10:04
 */
public class InsertSearch {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5,6,7,8,9,11};
        int res = insertSearchRecursion(arr1,10,0,arr1.length - 1);
        int res1 = insertSearch(arr1,11,0,arr1.length - 1);
        System.out.println((res != -1) ? "找到了" : "没找到");
        System.out.println((res1 != -1) ? "找到了" : "没找到");
    }

    /**
     * 递归实现
     * @param arr
     * @param target
     * @return
     */
    public static int insertSearchRecursion(int[] arr, int target, int low, int high){
        //为了防止low==high，导致p的计算中分母为0
        if(low == high){
            high--;
        }
        //按比例计算出的期望下标p【理想状态是均匀分布的】
        int p = low + ((target - arr[low])/(arr[high] - arr[low]))*(high - low);
        if(low > high || target < arr[0] || target > arr[arr.length - 1]){
            return -1;
        }
        if(arr[p] < target){
            return insertSearchRecursion(arr,target,p + 1,high);
        }else if(arr[p] > target){
            return insertSearchRecursion(arr,target,low,p - 1);
        }else{
            return p;
        }
    }

    public static int insertSearch(int[] arr, int target, int low, int high){
        while(low < high){
            int p = low + ((target - arr[0])/(arr[arr.length - 1] - arr[0]))*(high - low);
            if(target > arr[p]){
                low = p + 1;
            }else if(target < arr[p]){
                high = p - 1;
            }else{
                return p;
            }
        }
        return -1;
    }

}
