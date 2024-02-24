/*
 * @lc app=leetcode.cn id=148 lang=kotlin
 *
 * [148] 排序链表
 *
 * https://leetcode.cn/problems/sort-list/description/
 *
 * algorithms
 * Medium (65.52%)
 * Likes:    2242
 * Dislikes: 0
 * Total Accepted:    470.4K
 * Total Submissions: 717.8K
 * Testcase Example:  '[4,2,1,3]'
 *
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * 
 * 
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：head = [-1,5,3,4,0]
 * 输出：[-1,0,3,4,5]
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：head = []
 * 输出：[]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 链表中节点的数目在范围 [0, 5 * 10^4] 内
 * -10^5 <= Node.val <= 10^5
 * 
 * 
 * 
 * 
 * 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
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
    fun sortList(head: ListNode?): ListNode? {
        // TODO 空间O(1)  时间O(nlogn)
    }

    fun sortList1(head: ListNode?): ListNode? {
        return sortList(head,null)
    }

    fun sortList(head: ListNode?, tail: ListNode?): ListNode? {
        if(head == null){
            return head
        }
        if(head.next == tail){
            head.next = null
            return head
        }
        var slow = head
        var fast = head
        while(fast != tail){
            slow = slow?.next
            fast = fast?.next
            if(fast != tail){
                fast = fast?.next
            }
        }
        val list1 = sortList(head,slow)
        val list2 = sortList(slow,tail)
        return mergeSort(list1,list2)
    }

    fun mergeSort(list1: ListNode?, list2: ListNode?): ListNode? {
        if(list1 == null){
            return list2
        } else if(list2 == null) {
            return list1
        } else if(list1.`val` < list2.`val`) {
            list1.next = mergeSort(list1.next, list2)
            return list1
        } else {
            list2.next = mergeSort(list1, list2.next)
            return list2
        }
    }
}
// @lc code=end

