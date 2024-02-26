/*
 * @lc app=leetcode.cn id=938 lang=kotlin
 *
 * [938] 二叉搜索树的范围和
 *
 * https://leetcode.cn/problems/range-sum-of-bst/description/
 *
 * algorithms
 * Easy (82.09%)
 * Likes:    352
 * Dislikes: 0
 * Total Accepted:    134.9K
 * Total Submissions: 163.5K
 * Testcase Example:  '[10,5,15,3,7,null,18]\n7\n15'
 *
 * 给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：root = [10,5,15,3,7,null,18], low = 7, high = 15
 * 输出：32
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
 * 输出：23
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 树中节点数目在范围 [1, 2 * 10^4] 内
 * 1 
 * 1 
 * 所有 Node.val 互不相同
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
    var sum: Int = 0
    fun rangeSumBST(root: TreeNode?, low: Int, high: Int): Int {
        if(root == null) return 0
        if((root?.`val` ?: 0) < low){
            return rangeSumBST(root?.right, low, high)
        }
        if((root?.`val` ?: 0) > high) {
            return rangeSumBST(root?.left, low, high)
        }
        return rangeSumBST(root?.left, low, high) + rangeSumBST(root?.right, low, high) + (root?.`val` ?: 0)
    }
}
// @lc code=end

