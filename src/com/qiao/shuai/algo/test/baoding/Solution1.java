package com.qiao.shuai.algo.test.baoding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author qiaoshuai
 * @version 1.0
 * Create by 2022/11/3 19:01
 */
public class Solution1 {
    public static void main(String[] args) throws Exception {
        List<Long> orgBases = new ArrayList<Long>();
        orgBases.add(100L);
        //orgBases.add(null);
        orgBases.add(100L);
        orgBases.add(100L);
        //orgBases.stream().map(orgBasis -> orgBasis.equals(0L)).collect(Collectors.toList());
      List asdfsdf =  Optional.ofNullable(orgBases).map(org -> org.stream().filter(orgBasis -> orgBasis.equals(0L)).collect(Collectors.toList())).orElseThrow(() -> new Exception("sadfasdf"));


        Optional.ofNullable(orgBases).stream().map(org -> org.stream().filter(orgBasis -> orgBasis.equals(0L)).collect(Collectors.toList()));

        System.out.println(9);
    }

}
