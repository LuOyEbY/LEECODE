package com.luoye.algo.study2.entity;

import lombok.Data;

import java.util.List;

/**
 * @program: algo
 * @Author: yangbai
 * @Date: 2021/2/21 5:34 下午
 * @Version: 1.0
 * @Description: 队列
 */
@Data
public class QueueEntity{

    private List<Integer> data;

    private int head;

    private int tail;
}
