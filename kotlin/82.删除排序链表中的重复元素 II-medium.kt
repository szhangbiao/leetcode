/*
 * @lc app=leetcode.cn id=82 lang=kotlin
 *
 * [82] 删除排序链表中的重复元素 II
 *
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/description/
 *
 * algorithms
 * Medium (54.08%)
 * Likes:    1274
 * Dislikes: 0
 * Total Accepted:    413.1K
 * Total Submissions: 762.7K
 * Testcase Example:  '[1,2,3,3,4,4,5]'
 *
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：head = [1,1,1,2,3]
 * 输出：[2,3]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序 排列
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
    fun deleteDuplicates(head: ListNode?): ListNode? {
        val dummy: ListNode? = ListNode(-101)
        dummy?.next = head
        var cur: ListNode? = dummy
        while(cur?.next != null && cur?.next?.next != null){
            if(cur?.next?.`val` == cur?.next?.next?.`val`){
                val value = cur?.next?.`val`
                while(cur?.next != null && cur?.next?.`val` == value){
                    cur?.next = cur?.next?.next
                }
            } else {
                cur = cur?.next
            }
        }
        return dummy?.next
    }
}
// @lc code=end

