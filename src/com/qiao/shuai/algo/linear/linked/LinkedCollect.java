package com.qiao.shuai.algo.linear.linked;

public class LinkedCollect {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {
        }
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    /**
     * 206. 反转链表
     * 思路：递归，迭代
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    /**
     * 环形链表
     * 思路：就是死记硬背哈哈
     * 这个开始是快节点从第二个开始，慢节点从第一个开始
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    /**
     * 1. 环形链表 II
     * 不能采用上面的，必须快慢指针都从第一个开始；
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;//必须都从这里开始否则下面的会一直循环；导致超时
        while (true) {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    /**
     *  K 个一组翻转链表
     *  思路就是：链表取出k个翻转，然后循环
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode dummy=new ListNode(0);//补充的第一个元素 哨兵元素
        dummy.next=head;
        ListNode pre=dummy; // k个元素的前置元素
        ListNode end=dummy;//循环k次，这时候end的值 就是k个的最后一个；
        while(end.next!=null){
            for(int i=0;i<k&&end != null;i++){
                end=end.next;
            }
            if(end==null){   //不足k的是直接返回
                break;
            }
            ListNode next=end.next;//保存 下一个k的开头；
            end.next=null;
            ListNode start=pre.next; //k个元素的第一个元素
            pre.next=reverse(start);     // 反转链表
            start.next=next;
            pre=start;   //下个k 运输的前置元素
            end=start;
        }
        return dummy.next;
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode preNode = null;
        ListNode curNode = head;
        ListNode nextNode = null;
        while (curNode != null){
            nextNode = curNode.next;//nextNode 指向下一个节点,保存当前节点后面的链表。
            curNode.next=preNode;//将当前节点next域指向前一个节点   null<-1<-2<-3<-4
            preNode = curNode;//preNode 指针向后移动。preNode指向当前节点。
            curNode = nextNode;//curNode指针向后移动。下一个节点变成当前节点
        }
        return preNode;
    }

    /**
     * 两两交换链表中的节点
     * 每2个交换下，小技巧就是利用了哨兵节点；
     * 很多时候链表都会在前面或者后面加一个节点，这样处理 不用特殊处理边界情况
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }
        return dummyHead.next;
    }

}
