/*
 * @lc app=leetcode.cn id=92 lang=kotlin
 *
 * [92] 反转链表 II
 *
 * https://leetcode.cn/problems/reverse-linked-list-ii/description/
 *
 * algorithms
 * Medium (55.91%)
 * Likes:    1733
 * Dislikes: 0
 * Total Accepted:    474.9K
 * Total Submissions: 848.5K
 * Testcase Example:  '[1,2,3,4,5]\n2\n4'
 *
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left  。请你反转从位置 left 到位置 right 的链表节点，返回
 * 反转后的链表 。
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 链表中节点数目为 n
 * 1 
 * -500 
 * 1 
 * 
 * 
 * 
 * 
 * 进阶： 你可以使用一趟扫描完成反转吗？
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
    fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
        if(left == right) return head
        val dummy: ListNode? = ListNode(-1)
        dummy?.next = head
        var preLeft = dummy
        for(i in 0 until left - 1){
            preLeft = preLeft?.next
        }
        var leftNode: ListNode? = preLeft?.next
        var rightNode: ListNode? = leftNode
        for(i in 0 until right - left){
            rightNode = rightNode?.next
        }
        var rightNext: ListNode? = rightNode?.next
        preLeft?.next = null
        rightNode?.next = null
        reverseNode(leftNode)
        preLeft?.next = rightNode
        leftNode?.next = rightNext
        return dummy?.next
    }

    fun reverseNode(node: ListNode?) {
        var pre: ListNode? = null
        var cur: ListNode? = node
        var next: ListNode? = null
        while(cur != null){
            next = cur.next
            cur.next = pre
            pre = cur
            cur = next
        }
    }

}
// @lc code=end

