/*
 * @lc app=leetcode.cn id=101 lang=kotlin
 *
 * [101] 对称二叉树
 *
 * https://leetcode.cn/problems/symmetric-tree/description/
 *
 * algorithms
 * Easy (59.58%)
 * Likes:    2654
 * Dislikes: 0
 * Total Accepted:    981.7K
 * Total Submissions: 1.6M
 * Testcase Example:  '[1,2,2,3,4,4,3]'
 *
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 树中节点数目在范围 [1, 1000] 内
 * -100 <= Node.val <= 100
 * 
 * 
 * 
 * 
 * 进阶：你可以运用递归和迭代两种方法解决这个问题吗？
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
    fun isSymmetric(root: TreeNode?): Boolean {
        return check(root,root)
    }

    fun check(left: TreeNode?, right: TreeNode?): Boolean {
        if(left == null && right == null) return true
        if(left == null || right == null) return false
        return left?.`val` == right?.`val` && check(left?.left, right?.right) && check(left?.right, right?.left)
    }

    fun isSymmetric1(root: TreeNode?): Boolean {
        val invert = invertTree(root)
        return isSameRoot(root, invert)
    }

    fun invertTree(root: TreeNode?): TreeNode? {
        if(root ==  null) return null
        val temp = invertTree(root?.left)
        root?.left = invertTree(root?.right)
        root?.right = temp
        return root 
    }

    fun isSameRoot(left: TreeNode?, right: TreeNode?): Boolean {
        if(left == null && right == null) return true
        if(left?.`val` != right?.`val`) return false
        return isSameRoot(left?.left, right?.left) && isSameRoot(left?.right, right?.right)
    }
}
// @lc code=end

