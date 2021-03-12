package com.luoye.thread.study2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: algo
 * @Author: yangbai
 * @Date: 2021/3/2 2:53 下午
 * @Version: 1.0
 * @Description: Lock接口
 */
public class LockStudy {

    public static  void lock(){
        Lock lock = new ReentrantLock();
        lock.lock();
        try{

        }finally {
            lock.unlock();
        }
    }
}
