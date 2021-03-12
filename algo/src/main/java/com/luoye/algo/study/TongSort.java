package com.luoye.algo.study;

import java.util.Scanner;

/**
 * @program: algo
 * @Author: yangbai
 * @Date: 2021/2/21 3:22 下午
 * @Version: 1.0
 * @Description: 桶排序
 */
public class TongSort {

    public static void sort() {
        int[] a = {5, 5, 3, 2, 8};
        int[] b = new int[11];
        for (int i = 0; i < a.length; i++) {
            b[a[i]]++;
        }
        for (int i = 0; i < b.length; i++) {
            if (b[i] > 0) {
                for (int j = 0; j < b[i]; j++) {
                    System.out.println(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        sort();
    }
}
