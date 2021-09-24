package com.atguigu.search;

import com.sun.xml.internal.ws.api.pipe.Fiber;

import java.util.Arrays;

/**
 * 4.斐波那契查找法
 * 思路：
 *      和二分法、插入查找法一样，只不过将mid替换为黄金分割点golden=low + F[k - 1] - 1;
 *      其中F[]为斐波那契数列
 * 原理：
 *      通过斐波那契数列通式：F[k]=F[k-1]+F[k-2]变换而成（F[k]-1）=（F[k-1]-1）+（F[k-2]-1）+1
 *      该式说明：
 *      只要顺序表的长度为F[k]-1，则可以将该表分成长度为F[k-1]-1 和F[k-2]-1 的两段。所有中间的位置是mid=low + F[k - 1] - 1
 *
 * @author Zeta
 * @version 1.0
 * @date 2021/9/7 14:04
 */
public class FibSearch {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,11,123,444,12344};
        int res = fibSearch(arr,11);
        System.out.println((res != -1)? "找到了，下标为：" + res : "未找到！");
    }

    public static int[] fiber(){
        int[] res = new int[20];
        res[0] = 1;
        res[1] = 1;
        for(int i = 2; i < 20; i++){
            res[i] = res[i - 1] + res[i - 2];
        }
        return res;
    }


    /**
     * 非递归形式
     * @param arr
     * @param target
     * @return
     */
    public static int fibSearch(int[] arr,int target){
        int low = 0;
        int high = arr.length - 1;
        //先找到该长度的斐波那契分割数值的下标
        int k = 0;
        int[] fiber = fiber();
        while(high > fiber[k]){
            k++;//找到fiber[k]在数组size附近
        }
        //由于fiber[k]的值可能大于arr的长度，因此要用Arrays类，构造一个新的数组，并指向temp[]，不足的使用0填充/用最后一个数填充
        int[] temp = Arrays.copyOf(arr,fiber[k]);
        for(int i = high + 1; i < temp.length; i++){
            temp[i] = temp[high];
        }
        /*斐波那契的预处理结束，找到了黄金切割点*/
        while(low < high){
            int golden = low + fiber[k] - 1;//黄金分割点下标
            if(target < arr[golden]){
                high = golden - 1;
                k--;
                //为甚是k--
                //说明
                //1. 全部元素= 前面的元素+ 后边元素
                //2. f[k] = f[k-1] + f[k-2]
                //因为前面有f[k-1]个元素,所以可以继续拆分f[k-1] = f[k-2] + f[k-3]
            }else if(target > arr[golden]){
                low = golden + 1;
                k-=2;
                //为什么是k -=2
                //说明
                //1. 全部元素= 前面的元素+ 后边元素
                //2. f[k] = f[k-1] + f[k-2]
                //3. 因为后面我们有f[k-2] 所以可以继续拆分f[k-2] = f[k-3] + f[k-4]
                //4. 即在f[k-2] 的前面进行查找k -=2
                //5. 即下次循环mid = f[k - 1 - 2] - 1
            }else{
                return golden;
            }
        }
        return -1;
    }
}
