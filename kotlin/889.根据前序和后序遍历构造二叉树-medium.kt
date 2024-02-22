/*
 * @lc app=leetcode.cn id=889 lang=kotlin
 *
 * [889] 根据前序和后序遍历构造二叉树
 *
 * https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-postorder-traversal/description/
 *
 * algorithms
 * Medium (67.80%)
 * Likes:    350
 * Dislikes: 0
 * Total Accepted:    49.4K
 * Total Submissions: 71.5K
 * Testcase Example:  '[1,2,4,5,3,6,7]\n[4,5,2,6,7,3,1]'
 *
 * 给定两个整数数组，preorder 和 postorder ，其中 preorder 是一个具有 无重复 值的二叉树的前序遍历，postorder
 * 是同一棵树的后序遍历，重构并返回二叉树。
 * 
 * 如果存在多个答案，您可以返回其中 任何 一个。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 
 * 
 * 输入：preorder = [1,2,4,5,3,6,7], postorder = [4,5,2,6,7,3,1]
 * 输出：[1,2,3,4,5,6,7]
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: preorder = [1], postorder = [1]
 * 输出: [1]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= preorder.length <= 30
 * 1 <= preorder[i] <= preorder.length
 * preorder 中所有值都 不同
 * postorder.length == preorder.length
 * 1 <= postorder[i] <= postorder.length
 * postorder 中所有值都 不同
 * 保证 preorder 和 postorder 是同一棵二叉树的前序遍历和后序遍历
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
    lateinit var pre: IntArray
    lateinit var post: IntArray
    fun constructFromPrePost(preorder: IntArray, postorder: IntArray): TreeNode? {
        val postMap = HashMap<Int, Int>()
        for ((i, v) in postorder.withIndex()) {
            postMap[v] = i
        }
        this.pre = preorder
        this.post = postorder
        return dfs(postMap, 0, pre.size - 1, 0, post.size - 1)
    }

    fun dfs(postMap: Map<Int,Int>,preStart: Int, preEnd: Int, postStart: Int, postEnd: Int): TreeNode? {
        if(preStart > preEnd) return null
        var leftCount = 0
        if(preStart < preEnd){
            leftCount = postMap[pre[preStart + 1]]!! - postStart + 1
        }
        val root = TreeNode(pre[preStart])
        root.left = dfs(postMap, preStart + 1, preStart + leftCount, postStart, postStart + leftCount - 1)
        root.right = dfs(postMap, preStart + leftCount + 1, preEnd, postStart + leftCount, postEnd - 1)
        return root
    }
}
// @lc code=end

