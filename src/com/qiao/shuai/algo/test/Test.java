package com.qiao.shuai.algo.test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author qiaoshuai
 * @version 1.0
 * Create by 2022/11/1 10:53
 */
public class Test {

    public static void main(String[] args) throws Exception {
        System.out.println("Testing ");

        List a = Stream.of(null,null).filter(f-> f!=null).collect(Collectors.toList());

        System.out.println("Testing ");
        String b = "asdfasdf";
        //a.substring(a);
    }

    public int mySqrt(int x) {
        int l = 0, r = x;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid == x) {
                return mid;
            } else if ((long) mid * mid < x) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l - 1;
    }
}

