package com.luoye.algo.study;

import java.util.Arrays;

/**
 * @program: algo
 * @Author: yangbai
 * @Date: 2021/2/21 3:35 下午
 * @Version: 1.0
 * @Description: 冒泡排序
 */
public class MaoPaoSort {

    public static void sort(){
        int[] a = {12, 35, 99, 18, 76};
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if(a[j] < a[j + 1 ]){
                    int temp;
                    temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
        Arrays.stream(a).forEach(x -> System.out.println(x) );
    }

    public static void main(String[] args) {
        sort();
    }
}
