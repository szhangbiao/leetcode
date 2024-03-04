/*
 * @lc app=leetcode.cn id=105 lang=kotlin
 *
 * [105] 从前序与中序遍历序列构造二叉树
 *
 * https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 *
 * algorithms
 * Medium (71.19%)
 * Likes:    2249
 * Dislikes: 0
 * Total Accepted:    605.5K
 * Total Submissions: 846.5K
 * Testcase Example:  '[3,9,20,15,7]\n[9,3,15,20,7]'
 *
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder
 * 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 
 * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * 输出: [3,9,20,null,null,15,7]
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: preorder = [-1], inorder = [-1]
 * 输出: [-1]
 * 
 * 
 * 
 * 
 * 提示:
 * 
 * 
 * 1 <= preorder.length <= 3000
 * inorder.length == preorder.length
 * -3000 <= preorder[i], inorder[i] <= 3000
 * preorder 和 inorder 均 无重复 元素
 * inorder 均出现在 preorder
 * preorder 保证 为二叉树的前序遍历序列
 * inorder 保证 为二叉树的中序遍历序列
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
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        return buildTree(preorder, inorder, 0, preorder.size - 1, 0, inorder.size - 1)
    }

    fun buildTree(preorder: IntArray, inorder: IntArray, preStart: Int, preEnd: Int, inStart: Int, inEnd: Int): TreeNode? {
       if(preStart > preEnd || inStart > inEnd) return null
       val root = TreeNode(preorder[preStart]);
       val inRoot = inorder.indexOf(preorder[preStart]);
       val leftSize = inRoot - inStart
       root.left = buildTree(preorder,inorder,preStart + 1,preStart + leftSize, inStart, inRoot - 1)
       root.right = buildTree(preorder,inorder, preStart + leftSize + 1, preEnd, inRoot + 1, inEnd)
       return root
    }
}
// @lc code=end

