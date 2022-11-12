package com.qiao.shuai.algo.linear.arrays;

import java.util.*;

/**
 * 线性表中的数组的常用题目的总结
 *
 */
public class ArrayCollect {

    /**
     * 盛最多水的容器
     *
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
     *
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
     *
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
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int k = 0; k < nums.length - 2; k++) {
            if (nums[k] > 0) break;//第一个大于0  则直接跳出
            if (k > 0 && nums[k] == nums[k - 1]) continue;//这句话的目的是 防止 跟上一个值相等
            int i = k + 1, j = nums.length - 1;
            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                if (sum < 0) {
                    while (i < j && nums[i] == nums[++i]) ;//这句话的目的是 防止 跟上一个值相等
                } else if (sum > 0) {
                    while (i < j && nums[j] == nums[--j]) ;//这句话的目的是 防止 跟上一个值相等
                } else {
                    res.add(new ArrayList<Integer>(Arrays.asList(nums[k], nums[i], nums[j])));
                    while (i < j && nums[i] == nums[++i]) ;//这句话的目的是 防止 跟上一个值相等
                    while (i < j && nums[j] == nums[--j]) ;//这句话的目的是 防止 跟上一个值相等
                }
            }
        }//for结束
        return res;
    }

    /**
     *1. 两数和
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
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int p = 0; //重复数字的第一个值的下标；
        int qbianli = 1;
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
     *
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
}
