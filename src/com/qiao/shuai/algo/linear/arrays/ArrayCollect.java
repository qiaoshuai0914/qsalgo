package com.qiao.shuai.algo.linear.arrays;

import java.util.*;

/**
 * 线性表中的数组的常用题目的总结
 *
 */
public class ArrayCollect {

    /**
     * 盛最多水的容器
     *  双指针；
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1, res = 0;
        while (i < j) {
            res = height[i] < height[j] ?
                            Math.max(res, (j - i) * height[i++]) :
                            Math.max(res, (j - i) * height[j--]);
        }
        return res;
    }

    /**
     * 移动零
     *思路：双指针方法
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, i, j);
                j++;
            }
        }
    }
    private void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 爬楼梯
     * 思路：动态规划（数组滚动） ，递归
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }

    /**
     * 三数之和（国内、国际大厂历年面试高频老题）
     *  思路：
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);//1.排序从小到大
        List<List<Integer>> res = new ArrayList<>();
        for (int k = 0; k < nums.length - 2; k++) {
            if (nums[k] > 0) break;//第一个大于0  则直接跳出
            if (k > 0 && nums[k] == nums[k - 1]) continue; //这句话的目的是 防止 跟上一个值相等
            int i = k + 1, j = nums.length - 1;
            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                if (sum < 0) {
                    while (i < j && nums[i] == nums[++i]) ; //这句话的目的是 防止 跟上一个值相等
                } else if (sum > 0) {
                    while (i < j && nums[j] == nums[--j]) ; //这句话的目的是 防止 跟上一个值相等
                } else {
                    res.add(new ArrayList<Integer>(Arrays.asList(nums[k], nums[i], nums[j])));
                    while (i < j && nums[i] == nums[++i]) ; //这句话的目的是 防止 跟上一个值相等
                    while (i < j && nums[j] == nums[--j]) ; //这句话的目的是 防止 跟上一个值相等
                }
            }
        }//for结束
        return res;
    }

    /**
     *1. 两数和
     * 思路：哈希表
     * 根据题意，数组中一定存在连个数相加等于target，则说明一个数在前面以后树后面；
     * 第一个数会加到map中去，第二个数则会获取结果；
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
        return new int[0];
    }

    /**
     * 删除排序数组中的重复项
     * 双指针，很多题目都用到了双指针，多多练习双指针的题目；
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int p = 0; //重复数字的第一个值的下标；
        int qbianli = 1;//遍历数组
        while(qbianli < nums.length){
            if(nums[p] != nums[qbianli ]){
                nums[p + 1] = nums[qbianli ]; //兼容挨着的两个数字不等的情况
                p++; //一个新的数值 从新开是；这个保持的是 一组重复的第一个数字；
            }else{
                //如果相等则什么也不做；
            }
            qbianli ++;
        }
        return p + 1;// p是下标  所以个数就是+1
    }

    /**
     * 旋转数组
     * 思路：1.把整个数组反转 数组长度 L
     *       2 反转前k个元素
     *       3.反转后面的全部元素 L-k
     * 备注：反转字符串
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        k %= nums.length; //移动nums.length长度数组不会发生变化；
        reverse(nums, 0, nums.length - 1); //整个数组反转
        reverse(nums, 0, k - 1);//反转前k个元素  则是从0开始到k-1
        reverse(nums, k, nums.length - 1);//反转后面的元素从k开始
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) { //反转，就是第一个后最后一个对调； 然后继续 第二个和倒数第二个对调
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }

    /**
     * 加一
     * 思路：从后开始遍历数组digits, 开始+1，然后% 赋值这一位；如果这一位不等于0 则返回；
     * 因为数组digits 中的每一位都是【0，1，。。。8，9】中的一个；所以如果加一后的结果是0 则表示 进一位，继续循环
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i > 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits; //如果是0 则说明进一 继续+1循环：如果不是0 则表示没有进位返回；
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
