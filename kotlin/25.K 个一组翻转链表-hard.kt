/*
 * @lc app=leetcode.cn id=25 lang=kotlin
 *
 * [25] K 个一组翻转链表
 *
 * https://leetcode.cn/problems/reverse-nodes-in-k-group/description/
 *
 * algorithms
 * Hard (67.75%)
 * Likes:    2284
 * Dislikes: 0
 * Total Accepted:    556.6K
 * Total Submissions: 820.8K
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * 
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[2,1,4,3,5]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 
 * 
 * 输入：head = [1,2,3,4,5], k = 3
 * 输出：[3,2,1,4,5]
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 链表中的节点数目为 n
 * 1 <= k <= n <= 5000
 * 0 <= Node.val <= 1000
 * 
 * 
 * 
 * 
 * 进阶：你可以设计一个只用 O(1) 额外内存空间的算法解决此问题吗？
 * 
 * 
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
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        if(k == 1) return head
        val dummy = ListNode(-1,head)
        var preStart: ListNode? = dummy
        var end: ListNode? = dummy.next
        while(end != null){
            var num = 0
            while(end != null && num < k - 1){
                end = end?.next
                num++
            }
            if(num == k - 1 && end != null){
                val start = preStart?.next
                val endNext = end?.next
                preStart?.next = null
                end?.next = null
                reverseNode(start)
                preStart?.next = end
                start?.next = endNext
                preStart = start
                end = endNext
            }
        }
        return dummy?.next
    }

    fun reverseNode(head: ListNode?){
        var pre: ListNode? = null
        var cur: ListNode? = head
        while(cur != null) {
            val next = cur.next
            cur?.next = pre
            pre = cur
            cur = next
        }
    }
}
// @lc code=end

