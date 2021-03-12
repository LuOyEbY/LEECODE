package com.luoye.algo.study;

import java.util.Arrays;

/**
 * @program: algo
 * @Author: yangbai
 * @Date: 2021/2/21 3:54 下午
 * @Version: 1.0
 * @Description: 快速排序
 */
public class FastSort {

    public static void sort(int left, int right, int[] a) {
        if(left > right) {return;}
        int temp = a[left];
        int i = left;
        int j = right;
        while(i !=j){
            while(a[j] >= temp && j > i){
                j--;
            }
            while(a[i] <= temp && i< j){
                i++;
            }
            if(i< j){
                int temp2;
                temp2 = a[i];
                a[i] = a[j];
                a[j] = temp2;
            }

        }
        a[left] = a[i];
        a[i] = temp;
        sort(left, i-1, a);
        sort(i+1, right, a);

    }

    public static void main(String[] args) {
        int[] a = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        sort(0, 9, a);
        Arrays.stream(a).forEach(x -> System.out.println(x));
    }
}
