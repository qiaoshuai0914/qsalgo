package com.qiao.shuai.algo.linear.stack;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class StackCollect {
    /**
     *  有效的括号（）【】{} 三种括号的组成；
     *  利用栈这种数据结构来判断括号是否有效，利用到了哈希表，栈
     *  在java中 现成的栈我们使用 Deque 接口实现是LinkedList；
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        int n = s.length(); //如果长度是奇数则肯定不是
        if (n % 2 == 1) {
            return false;
        }

        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }}; ///每队括号，放入map中 注意是 右边的当做key
        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) { //如果是右括号的情况下，1 stack 是空的2 stack中的第一个 肯map中的value 不一样 则不是
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }
                stack.pop(); //弹出
            } else {
                stack.push(ch); //是左括号 ，则直接放入stack中去；
            }
        }
        return stack.isEmpty(); //如果stack里面没有元素了 则表示 是
    }

    /**
     * 1. 最小栈（亚马逊在半年内面试常考）： 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
     * 解释：实现的栈能够快速取出最小的值，使用的是双栈；一个负责正常栈的功能，一个负责最小值的保存
     * @author qiaoshuai
     */
    class MinStack {
        Deque<Integer> xStack; //正常栈
        Deque<Integer> minStack; //存储最小值的栈；

        public MinStack() {
            xStack = new LinkedList<Integer>();
            minStack = new LinkedList<Integer>();
            minStack.push(Integer.MAX_VALUE);
        }

        public void push(int x) {
            xStack.push(x);
            minStack.push(Math.min(minStack.peek(), x));
        }

        public void pop() {
            xStack.pop();
            minStack.pop();
        }

        public int top() {
            return xStack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}
