/*
 * @lc app=leetcode.cn id=2476 lang=kotlin
 *
 * [2476] 二叉搜索树最近节点查询
 *
 * https://leetcode.cn/problems/closest-nodes-queries-in-a-binary-search-tree/description/
 *
 * algorithms
 * Medium (42.12%)
 * Likes:    52
 * Dislikes: 0
 * Total Accepted:    13.1K
 * Total Submissions: 27K
 * Testcase Example:  '[6,2,13,1,4,9,15,null,null,null,null,null,null,14]\n[2,5,16]'
 *
 * 给你一个 二叉搜索树 的根节点 root ，和一个由正整数组成、长度为 n 的数组 queries 。
 * 
 * 请你找出一个长度为 n 的 二维 答案数组 answer ，其中 answer[i] = [mini, maxi] ：
 * 
 * 
 * mini 是树中小于等于 queries[i] 的 最大值 。如果不存在这样的值，则使用 -1 代替。
 * maxi 是树中大于等于 queries[i] 的 最小值 。如果不存在这样的值，则使用 -1 代替。
 * 
 * 
 * 返回数组 answer 。
 * 
 * 
 * 
 * 示例 1 ：
 * 
 * 
 * 
 * 
 * 输入：root = [6,2,13,1,4,9,15,null,null,null,null,null,null,14], queries =
 * [2,5,16]
 * 输出：[[2,2],[4,6],[15,-1]]
 * 解释：按下面的描述找出并返回查询的答案：
 * - 树中小于等于 2 的最大值是 2 ，且大于等于 2 的最小值也是 2 。所以第一个查询的答案是 [2,2] 。
 * - 树中小于等于 5 的最大值是 4 ，且大于等于 5 的最小值是 6 。所以第二个查询的答案是 [4,6] 。
 * - 树中小于等于 16 的最大值是 15 ，且大于等于 16 的最小值不存在。所以第三个查询的答案是 [15,-1] 。
 * 
 * 
 * 示例 2 ：
 * 
 * 
 * 
 * 
 * 输入：root = [4,null,9], queries = [3]
 * 输出：[[-1,4]]
 * 解释：树中不存在小于等于 3 的最大值，且大于等于 3 的最小值是 4 。所以查询的答案是 [-1,4] 。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 树中节点的数目在范围 [2, 10^5] 内
 * 1 <= Node.val <= 10^6
 * n == queries.length
 * 1 <= n <= 10^5
 * 1 <= queries[i] <= 10^6
 * 
 * 
 */

// @lc code=start
/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun closestNodes(root: TreeNode?, queries: List<Int>): List<List<Int>> {
        val order = mutableListOf<Int>()
        inorder(root,order)
        val result = mutableListOf<List<Int>>()
        queries.forEach {
            val index = binarySearch(it,order)
            val cur = order.getOrNull(index) ?: -1
            val min = if(cur == it) cur else (if(index > 0) order[index - 1] else -1)
            val max = if(index != order.size) cur else -1
            result.add(listOf(min,max))
        }
        return result
    }

    fun inorder(root: TreeNode?, order: MutableList<Int>) {
        if(root == null) return
        inorder(root.left,order)
        order.add(root.`val`)
        inorder(root.right,order)
    }

    fun binarySearch(target: Int, order: MutableList<Int>): Int {
        var left = 0
        var right = order.size - 1
        while(left <= right){
            val mid = left + (right - left)/2
            if(order[mid] == target) return mid
            if(order[mid] < target){
                left = mid + 1
            }
            if(order[mid] > target){
                right = mid - 1
            }
        }
        return left
    }
}
// @lc code=end

