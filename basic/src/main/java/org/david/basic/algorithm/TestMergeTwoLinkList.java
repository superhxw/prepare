package org.david.basic.algorithm;
/**
 *  现有两个有序（升序）的单向链表，将这两个链表合并成一个，并确保合并后的链表也是升序的
 * @author hanxiaowei
 *
 */
public class TestMergeTwoLinkList {

	public static void main(String[] arg) {

		ListNode l1 = new ListNode(0);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(5);
		l1.next.next.next = new ListNode(7);

		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(5);

		ListNode l = new Solution().mergeTwoLists(l1, l2);
		while (l != null) {
			System.out.println(l.val);
			l = l.next;
		}
	}
}
/**
 * 单向升序链表定义
 * @author hanxiaowei
 *
 */
class ListNode {
	int val;
	ListNode next;
	ListNode(int x){
		this.val = x;
	}
}
class Solution {

	/**
	 * 将单项链表进行合并排序 (无递归)
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1==null||l2==null) {
			return l1!=null?l1:l2;
		}
		ListNode head = l1.val<l2.val?l1:l2;
		ListNode other = l1.val>=l2.val?l1:l2;
		ListNode prevHead = head;
		ListNode prevOther = other;
		while(prevHead!=null){
			ListNode next = prevHead.next;
			if(next != null && next.val > prevOther.val) {
				prevHead.next = prevOther;
				prevOther = next;
			}
			if(prevHead.next==null){
				prevHead.next=prevOther;
				break;
			}
			prevHead=prevHead.next;
		}
		return head;
	}
	/**
	 * 递归直接实现队列的排序，这样编写节约内存，提升效率。
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
		ListNode result = null;
		result = getResult(result, l1, l2);
		return result;
	}

	public ListNode getResult(ListNode result, ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null) {
			return null;
		}
		if (l1 == null) {
			result = l2;
			return result;
		}
		if (l2 == null) {
			result = l1;
			return result;
		}
		if (l1.val > l2.val) {
			result = l2;
			l2 = l2.next;
		} else {
			result = l1;
			l1 = l1.next;
		}
		result.next = getResult(result.next, l1, l2);
		return result;
	}
}