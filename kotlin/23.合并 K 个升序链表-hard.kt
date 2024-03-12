/*
 * @lc app=leetcode.cn id=23 lang=kotlin
 *
 * [23] 合并 K 个升序链表
 *
 * https://leetcode.cn/problems/merge-k-sorted-lists/description/
 *
 * algorithms
 * Hard (58.84%)
 * Likes:    2775
 * Dislikes: 0
 * Total Accepted:    769.8K
 * Total Submissions: 1.3M
 * Testcase Example:  '[[1,4,5],[1,3,4],[2,6]]'
 *
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 * ⁠ 1->4->5,
 * ⁠ 1->3->4,
 * ⁠ 2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * 
 * 
 * 示例 2：
 * 
 * 输入：lists = []
 * 输出：[]
 * 
 * 
 * 示例 3：
 * 
 * 输入：lists = [[]]
 * 输出：[]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] 按 升序 排列
 * lists[i].length 的总和不超过 10^4
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
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        return merge(lists,0,lists.size - 1)
    }

    fun merge(list: Array<ListNode?>, start: Int, end: Int): ListNode? {
        if(start > end) return null
        if(start == end) {
            return list[start]
        }
        val mid = start + (end - start) / 2
        return mergeTwoList(merge(list, start, mid), merge(list, mid + 1, end))
    }

    fun mergeTwoList(l1: ListNode?, l2: ListNode?): ListNode? {
        val head = ListNode(-1)
        var cur: ListNode? = head
        var list1 = l1
        var list2 = l2
        while(list1 != null && list2 != null) {
            if(list1.`val` < list2.`val`) {
                cur?.next = list1
                list1 = list1?.next
            } else {
                cur?.next = list2
                list2 = list2?.next
            }
            cur = cur?.next
        }
        cur?.next = if(list1 == null) list2 else list1
        return head?.next
    }
}
// @lc code=end

