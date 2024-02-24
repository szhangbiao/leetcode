/*
 * @lc app=leetcode.cn id=21 lang=kotlin
 *
 * [21] 合并两个有序链表
 *
 * https://leetcode.cn/problems/merge-two-sorted-lists/description/
 *
 * algorithms
 * Easy (66.24%)
 * Likes:    3446
 * Dislikes: 0
 * Total Accepted:    1.6M
 * Total Submissions: 2.4M
 * Testcase Example:  '[1,2,4]\n[1,3,4]'
 *
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 两个链表的节点数目范围是 [0, 50]
 * -100 
 * l1 和 l2 均按 非递减顺序 排列
 * 
 * 
 */

// @lc code=start
/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        if(list1 == null){
            return list2
        }else if(list2 == null){
            return list1
        }else if(list1.`val` < list2.`val`){
            list1.next = mergeTwoLists(list1.next, list2)
            return list1
        }else{
            list2.next = mergeTwoLists(list1, list2.next)
            return list2
        }
    }
    fun mergeTwoLists1(list1: ListNode?, list2: ListNode?): ListNode? {
        if(list1 == null) return list2
        if(list2 == null) return list1
        val head = ListNode(-1)
        var next = head
        var node1 = list1
        var node2 = list2
        while(node1 != null && node2 != null){
            if(node1.`val` <= node2.`val`){
                next.next = node1
                node1 = node1.next
            } else {
                next.next = node2
                node2 = node2.next
            }
            next = next.next
        }
        next.next = if(node1 == null) node2 else node1
        return head.next
    }
}
// @lc code=end

