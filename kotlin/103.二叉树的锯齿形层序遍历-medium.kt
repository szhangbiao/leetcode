/*
 * @lc app=leetcode.cn id=103 lang=kotlin
 *
 * [103] 二叉树的锯齿形层序遍历
 *
 * https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/description/
 *
 * algorithms
 * Medium (57.98%)
 * Likes:    862
 * Dislikes: 0
 * Total Accepted:    357.5K
 * Total Submissions: 609.7K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[20,9],[15,7]]
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
    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
        val res = mutableListOf<MutableList<Int>>()
        //dfs(root, 0, res)
        bfs(root, res)
        return res
    }

    fun dfs(root: TreeNode?, level: Int, res: MutableList<MutableList<Int>>) {
        if(root == null) return
        if(res.size <= level) {
            res.add(mutableListOf())
        }
        if(level % 2 == 0) {
            res[level].add(root.`val`)
        } else {
            res[level].add(0, root.`val`)
        }
        dfs(root.left, level + 1, res)
        dfs(root.right, level + 1, res)
    }

    fun bfs(root: TreeNode?, res: MutableList<MutableList<Int>>) {
        if(root == null) return
        val queue = LinkedList<TreeNode>()
        queue.add(root)
        var level = 0
        while(queue.isNotEmpty()) {
            val subList = mutableListOf<Int>()
            for(i in queue.indices) {
                val node = queue.poll()
                if(level % 2 == 0) {
                    subList.add(node.`val`)
                } else {
                    subList.add(0, node.`val`)
                }
                if(node.left != null) queue.add(node.left)
                if(node.right != null) queue.add(node.right)
            }
            level++
            res.add(subList)
        }
    }
}
// @lc code=end

