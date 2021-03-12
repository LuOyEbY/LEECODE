package com.luoye.thread.study1;

/**
 * @program: algo
 * @Author: yangbai
 * @Date: 2021/3/2 2:40 下午
 * @Version: 1.0
 * @Description: 等待超时模式
 */
public class TimeOutThread {


    public synchronized Object get(long mills){
        Object result = null;
        long future = System.currentTimeMillis() + mills;
        long remaining = mills;
        while ((result == null) && remaining > 0){
//            wait(remaining);
            remaining = future  - System.currentTimeMillis();
        }
       return result;

    }

}
