/*
 * @lc app=leetcode.cn id=199 lang=kotlin
 *
 * [199] 二叉树的右视图
 *
 * https://leetcode.cn/problems/binary-tree-right-side-view/description/
 *
 * algorithms
 * Medium (66.47%)
 * Likes:    1036
 * Dislikes: 0
 * Total Accepted:    372.6K
 * Total Submissions: 558.9K
 * Testcase Example:  '[1,2,3,null,5,null,4]'
 *
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 
 * 
 * 
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1,3,4]
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: [1,null,3]
 * 输出: [1,3]
 * 
 * 
 * 示例 3:
 * 
 * 
 * 输入: []
 * 输出: []
 * 
 * 
 * 
 * 
 * 提示:
 * 
 * 
 * 二叉树的节点个数的范围是 [0,100]
 * -100  
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
    fun rightSideView(root: TreeNode?): List<Int> {
        val res = mutableListOf<Int>()
        dfs(root, 0, res)
        return res
    }

    fun dfs(root: TreeNode?, depth: Int, res: MutableList<Int>) {
        if(root == null) return
        if(res.size <= depth) {
            res.add(root.`val`)
        } else {
            res[depth] = root.`val`
        }
        dfs(root.left, depth + 1, res)
        dfs(root.right, depth + 1, res)
    }

    fun rightSideView1(root: TreeNode?): List<Int> {
        if(root == null) return listOf()
        val res = mutableListOf<Int>()
        val queue = LinkedList<TreeNode>()
        queue.add(root)
        while(queue.isNotEmpty()){
            val size = queue.size
            for(i in 0 until size){
                val node = queue.poll()
                if(i == size - 1) res.add(node.`val`)
                if(node.left != null) queue.add(node.left)
                if(node.right != null) queue.add(node.right)
            }
        }
        return res
    }
}
// @lc code=end

