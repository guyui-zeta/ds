package com.atguigu.search;

/**
 * 1.线性查找
 *
 */
public class SeqSearch {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        int res = seqSearch(arr,7);
        System.out.println((res == 1)?"找到了":"没有找到");
    }
    public static int seqSearch(int[] arr,int data){
        for(int i = 0; i < arr.length; i++){
            if(arr[i]  == data){
                return 1;
            }
        }
        return -1;
    }
}
