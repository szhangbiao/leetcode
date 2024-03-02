/*
 * @lc app=leetcode.cn id=114 lang=kotlin
 *
 * [114] 二叉树展开为链表
 *
 * https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/description/
 *
 * algorithms
 * Medium (73.33%)
 * Likes:    1633
 * Dislikes: 0
 * Total Accepted:    430.2K
 * Total Submissions: 585.5K
 * Testcase Example:  '[1,2,5,3,4,null,6]'
 *
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * 
 * 
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：root = [1,2,5,3,4,null,6]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6]
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
 * 输入：root = [0]
 * 输出：[0]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 树中结点数在范围 [0, 2000] 内
 * -100 
 * 
 * 
 * 
 * 
 * 进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？
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
    var pre: TreeNode? = null
    fun flatten(root: TreeNode?): Unit {
        bfs(root)
    }

    fun bfs(root: TreeNode?) {
        if (root == null) return
        val stack = Stack<TreeNode>()
        stack.push(root)
        var pre: TreeNode? = null
        while(stack.isNotEmpty()) {
            val node = stack.pop()
            pre?.left = null
            pre?.right = node
            if(node.right != null) {
                stack.push(node.right)
            }
            if(node.left != null) {
                stack.push(node.left)
            }
            pre = node
        }
    }

    fun dfs(root: TreeNode?) {
        if (root == null) return
        dfs(root.right)
        dfs(root.left)
        root.left = null
        root.right = pre
        pre = root
    }
}
// @lc code=end

