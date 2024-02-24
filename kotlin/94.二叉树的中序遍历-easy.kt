/*
 * @lc app=leetcode.cn id=94 lang=kotlin
 *
 * [94] 二叉树的中序遍历
 *
 * https://leetcode.cn/problems/binary-tree-inorder-traversal/description/
 *
 * algorithms
 * Easy (76.40%)
 * Likes:    2040
 * Dislikes: 0
 * Total Accepted:    1.4M
 * Total Submissions: 1.8M
 * Testcase Example:  '[1,null,2,3]'
 *
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：root = []
 * 输出：[]
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：root = [1]
 * 输出：[1]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 * 
 * 
 * 
 * 
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
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

    fun inorderTraversal(root: TreeNode?): List<Int> {
        val res = mutableListOf<Int>()
        val stack = Stack<TreeNode>()
        var node = root
        while(node != null || stack.isNotEmpty()){
            while(node != null){
                stack.push(node)
                node = node.left
            }
            node = stack.pop()
            res.add(node.`val`)
            node = node.right
        }
        return res
    }

    val res = mutableListOf<Int>()
    fun inorderTraversal1(root: TreeNode?): List<Int> {
        dfs(root)
        return res
    }

    fun dfs(node: TreeNode?) {
        if(node == null) return
        if(node.left != null){
            dfs(node.left)
        }
        res.add(node.`val`)
        if(node.right != null){
            dfs(node.right)
        }
    }
}
// @lc code=end

