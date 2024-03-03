/*
 * @lc app=leetcode.cn id=61 lang=kotlin
 *
 * [61] 旋转链表
 *
 * https://leetcode.cn/problems/rotate-list/description/
 *
 * algorithms
 * Medium (41.35%)
 * Likes:    1033
 * Dislikes: 0
 * Total Accepted:    361.1K
 * Total Submissions: 873.1K
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：head = [0,1,2], k = 4
 * 输出：[2,0,1]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 链表中节点的数目在范围 [0, 500] 内
 * -100 <= Node.val <= 100
 * 0 <= k <= 2 * 10^9
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
    fun rotateRight(head: ListNode?, k: Int): ListNode? {
        if(head == null || head.next == null) return head
        var length = 0
        var cur = head
        var tail: ListNode? = null
        while(cur != null){
            tail = cur
            cur = cur.next
            length++
        }
        var m = k % length
        if(m == 0) return head
        cur = head
        for(i in 0 until length - m - 1){
            cur = cur?.next
        }
        tail?.next = head
        val newHead = cur?.next
        cur?.next = null
        return newHead
    }
}

// @lc code=end

