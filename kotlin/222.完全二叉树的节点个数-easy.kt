/*
 * @lc app=leetcode.cn id=222 lang=kotlin
 *
 * [222] 完全二叉树的节点个数
 *
 * https://leetcode.cn/problems/count-complete-tree-nodes/description/
 *
 * algorithms
 * Easy (81.28%)
 * Likes:    1096
 * Dislikes: 0
 * Total Accepted:    359.2K
 * Total Submissions: 441.5K
 * Testcase Example:  '[1,2,3,4,5,6]'
 *
 * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 * 
 * 完全二叉树
 * 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h
 * 层，则该层包含 1~ 2^h 个节点。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：root = [1,2,3,4,5,6]
 * 输出：6
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：root = []
 * 输出：0
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：root = [1]
 * 输出：1
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 树中节点的数目范围是[0, 5 * 10^4]
 * 0 
 * 题目数据保证输入的树是 完全二叉树
 * 
 * 
 * 
 * 
 * 进阶：遍历树来统计节点是一种时间复杂度为 O(n) 的简单解决方案。你可以设计一个更快的算法吗？
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
    fun countNodes(root: TreeNode?): Int {
        if(root == null) return 0
        val left = countLevel(root?.left)
        val right = countLevel(root?.right)
        if(left == right){
            return (1 shl left) + countNodes(root?.right)
        } else {
            return (1 shl right) + countNodes(root?.left)
        }
    }
    fun countLevel(root: TreeNode?): Int {
        var level = 0
        var node = root
        while(node != null){
            level++
            node = node?.left
        }
        return level
    }
    fun countNodes1(root: TreeNode?): Int {
        if(root == null) return 0
        var count = 0
        val queue = LinkedList<TreeNode>()
        queue.add(root)
        while(queue.isNotEmpty()){
            val size = queue.size
            for(i in 0 until size){
                val node = queue.poll()
                if(node.left != null) queue.add(node.left)
                if(node.right != null) queue.add(node.right)
            }
            count += size
        }
        return count
    }
}
// @lc code=end

