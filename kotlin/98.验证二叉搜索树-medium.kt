/*
 * @lc app=leetcode.cn id=98 lang=kotlin
 *
 * [98] 验证二叉搜索树
 *
 * https://leetcode.cn/problems/validate-binary-search-tree/description/
 *
 * algorithms
 * Medium (37.49%)
 * Likes:    2279
 * Dislikes: 0
 * Total Accepted:    849.1K
 * Total Submissions: 2.3M
 * Testcase Example:  '[2,1,3]'
 *
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * 
 * 有效 二叉搜索树定义如下：
 * 
 * 
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：root = [2,1,3]
 * 输出：true
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：root = [5,1,4,null,null,3,6]
 * 输出：false
 * 解释：根节点的值是 5 ，但是右子节点的值是 4 。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 树中节点数目范围在[1, 10^4] 内
 * -2^31 <= Node.val <= 2^31 - 1
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
    fun isValidBST(root: TreeNode?): Boolean {
        return isValidBST(root, null, null)
    }

    fun isValidBST(root: TreeNode?, min: Int?, max: Int?): Boolean {
        if(root == null) return true
        if(min != null && root.`val` <= min) return false
        if(max != null && root.`val` >= max) return false
        return isValidBST(root?.left, min, root.`val`) && isValidBST(root?.right, root.`val`, max)
    }

    fun isValidBST1(root: TreeNode?): Boolean {
        val list = mutableListOf<Int>()
        inorder(root, list)
        if(list.size <= 1) return true
        for(i in 1 until list.size) {
            if(list[i - 1] >= list[i]) {
                return false
            }
        }
        return true
    }

    fun inorder(root: TreeNode?, list: MutableList<Int>) {
        if(root == null) return
        inorder(root.left, list)
        list.add(root.`val`)
        inorder(root.right, list)
    }
}

// @lc code=end

