/*
 * @lc app=leetcode.cn id=147 lang=kotlin
 *
 * [147] 对链表进行插入排序
 *
 * https://leetcode.cn/problems/insertion-sort-list/description/
 *
 * algorithms
 * Medium (69.60%)
 * Likes:    654
 * Dislikes: 0
 * Total Accepted:    162.2K
 * Total Submissions: 232.9K
 * Testcase Example:  '[4,2,1,3]'
 *
 * 给定单个链表的头 head ，使用 插入排序 对链表进行排序，并返回 排序后链表的头 。
 * 
 * 插入排序 算法的步骤:
 * 
 * 
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 * 
 * 
 * 
 * 下面是插入排序算法的一个图形示例。部分排序的列表(黑色)最初只包含列表中的第一个元素。每次迭代时，从输入数据中删除一个元素(红色)，并就地插入已排序的列表中。
 * 
 * 对链表进行插入排序。
 * 
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 
 * 
 * 输入: head = [4,2,1,3]
 * 输出: [1,2,3,4]
 * 
 * 示例 2：
 * 
 * 
 * 
 * 
 * 输入: head = [-1,5,3,4,0]
 * 输出: [-1,0,3,4,5]
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 
 * 
 * 列表中的节点数在 [1, 5000]范围内
 * -5000 <= Node.val <= 5000
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
    fun insertionSortList(head: ListNode?): ListNode? {
        val dummy = ListNode(0, head)
        var sort = head
        var cur = head?.next
        while(cur != null){
            if(sort!!.`val` < cur!!.`val`){
                sort = sort.next
            }else {
                var node = dummy
                while(node!!.next!!.`val` < cur!!.`val`){
                    node = node.next
                }
                sort.next = cur.next
                cur.next = node.next
                node.next = cur
            }
            cur = sort?.next
        }
        return dummy?.next
    }
}
// @lc code=end

