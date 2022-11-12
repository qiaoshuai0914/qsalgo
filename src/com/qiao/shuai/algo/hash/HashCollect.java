package com.qiao.shuai.algo.hash;

import java.util.*;

public class HashCollect {
    /**
     * 242. 有效的字母异位词
     *思路：根据每个字符获取每个字符在数组中的位置，然后+1 另外一个-1；
     * 然后统计数组中是否存在不为0的值，
     * @param s
     * @param t
     * @return
     */
    //哈希表，找到每个字母的下标然后 保存个数；
    public boolean isAnagram(String s, String t) {
        //字符串长度不一致，则肯定不是字母异味词，返回false
        if (s.length() != t.length()) {
            return false;
        }
        //这个就是哈希表的数组了； 下标就是字母：‘x’-‘a’ 的值 则 a是0
        int[] zf = new int[26];
        for (int i = 0; i < s.length(); i++) {
            //获取字符串中的下标为i的字符w，然后减去‘a’ 得到  字符w在数组中zf的位置。然后+1
            zf[s.charAt(i) - 'a']++;
            //获取字符串中的下标为i的字符w，然后减去‘a’ 得到  字符w在数组中zf的位置。然后-1
            zf[t.charAt(i) - 'a']--;
        }
        for (int a : zf) {
            if (a != 0) {
                return false;
            }
        }
        return true;

    }

    /**
     * 字母异位词分组
     *  字母异位词定义：
     *  字母异位词排序后 是一样的；
     *  思路 把字母异位词c排序后为key 然后放到hash中，然后c为value放入map中去
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();// key是 每个strs中的一个字符串的异味衣蛾位词
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            //这里是一个新的字符串，str  这个的异位词，放入map中 ，
            String key = new String(array);
            // 如果不存在则返回list  但是这个list 没有放入map中去 所以后面还需要放进去
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }

    /**
     * 两数之和
     *
     * 思路：1.hash表
     *      2.暴力解法，双循环
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];//空数组；
    }
}
