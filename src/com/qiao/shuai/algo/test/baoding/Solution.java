package com.qiao.shuai.algo.test.baoding;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution{
    public int[] getLeastNumber(int[] arr,int k){
        int[] result = new int[k];
        if(k==0){
            return  result;
        }
        //1.初始化大顶堆
        PriorityQueue<Integer> queue = new PriorityQueue(new Comparator<Integer>(){
            @Override
            public int compare(Integer num1, Integer num2) {
                return num2 - num1;
            }
        });
        //1.数组前k个数据放入大顶堆中
        for(int i =0 ;i<k;i++){
            queue.offer(arr[i]);
        }
        //1.数组后面的数据放入大顶堆中，跟最大的比较，如果小则放入去掉大顶，放入堆中；
        for(int j =k;j<arr.length;j++){
            if(queue.peek() > arr[j]){
                queue.poll();
                queue.offer(arr[j]);
            }
        }
        //从大顶堆中取出来放入数组中返回  最顶的元素 第k小的元素 。  也是 第 l-k+1  大的元素
        for (int i = 0; i < k; ++i) {
            result[i] = queue.poll();
        }
        return result;
    }
}