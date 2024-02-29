/*
 * @lc app=leetcode.cn id=102 lang=kotlin
 *
 * [102] 二叉树的层序遍历
 *
 * https://leetcode.cn/problems/binary-tree-level-order-traversal/description/
 *
 * algorithms
 * Medium (66.40%)
 * Likes:    1908
 * Dislikes: 0
 * Total Accepted:    976.9K
 * Total Submissions: 1.5M
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[9,20],[15,7]]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：root = [1]
 * 输出：[[1]]
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：root = []
 * 输出：[]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 树中节点数目在范围 [0, 2000] 内
 * -1000 <= Node.val <= 1000
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
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val res = mutableListOf<MutableList<Int>>()
        // dfs(root, 0, res)
        bfs(root, res)
        return res
    }

    fun dfs(root: TreeNode?, level: Int, res: MutableList<MutableList<Int>>) {
        if(root == null) return
        if(res.size <= level) {
            res.add(mutableListOf())
        }
        res[level].add(root.`val`)
        dfs(root.left, level + 1, res)
        dfs(root.right, level + 1, res)
    }

    fun bfs(root: TreeNode?, res: MutableList<MutableList<Int>>) {
        if(root == null) return
        val queue = LinkedList<TreeNode>()
        queue.add(root)
        while(queue.isNotEmpty()) {
            val subList = mutableListOf<Int>()
            for(i in queue.indices) {
                val node = queue.poll()
                subList.add(node.`val`)
                if(node.left != null) queue.add(node.left)
                if(node.right != null) queue.add(node.right)
            }
            res.add(subList)
        }
    }
}
// @lc code=end

