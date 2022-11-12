package com.qiao.shuai.algo.test.beijing;

/**
 * @author qiaoshuai
 */
public abstract class  UpdateSum <T,E>{
    /**
     * asdfas
     * @param t
     */
 public void update(T t){
  E e=  get(t);
    update1(e);
   }
   abstract void update1(E e);

abstract E get(T t);
}
