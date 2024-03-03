/*
 * @lc app=leetcode.cn id=86 lang=kotlin
 *
 * [86] 分隔链表
 *
 * https://leetcode.cn/problems/partition-list/description/
 *
 * algorithms
 * Medium (64.47%)
 * Likes:    823
 * Dislikes: 0
 * Total Accepted:    262.5K
 * Total Submissions: 406.7K
 * Testcase Example:  '[1,4,3,2,5,2]\n3'
 *
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * 
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：head = [2,1], x = 2
 * 输出：[1,2]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 链表中节点的数目在范围 [0, 200] 内
 * -100 
 * -200 
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
    fun partition(head: ListNode?, x: Int): ListNode? {
        if(head == null) return head
        val lessHead = ListNode(-1)
        val moreHead = ListNode(-1)
        var lessX: ListNode? = lessHead
        var moreX: ListNode? = moreHead
        var cur = head
        while(cur != null){
            if(cur.`val` < x){
                lessX?.next = cur
                lessX = lessX?.next
            } else {
                moreX?.next = cur
                moreX = moreX?.next
            }
            cur = cur?.next
        }
        moreX?.next = null
        lessX?.next = moreHead.next
        return lessHead.next
    }
}
// @lc code=end

