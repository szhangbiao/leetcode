/*
 * @lc app=leetcode.cn id=104 lang=kotlin
 *
 * [104] 二叉树的最大深度
 *
 * https://leetcode.cn/problems/maximum-depth-of-binary-tree/description/
 *
 * algorithms
 * Easy (77.27%)
 * Likes:    1780
 * Dislikes: 0
 * Total Accepted:    1.2M
 * Total Submissions: 1.6M
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 给定一个二叉树 root ，返回其最大深度。
 * 
 * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 
 * 
 * 
 * 
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：3
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：root = [1,null,2]
 * 输出：2
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 树中节点的数量在 [0, 10^4] 区间内。
 * -100 <= Node.val <= 100
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

    fun maxDepth(root: TreeNode?): Int {
        if(root == null) return 0
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1
    }

    var depth = 0
    fun maxDepth1(root: TreeNode?): Int {
        dfs(root, 1)
        return depth
    }

    fun dfs(root: TreeNode?, level: Int) {
        if(root == null) return
        dfs(root.left, level + 1)
        dfs(root.right, level + 1)
        depth = maxOf(depth, level)
    }
}
// @lc code=end

