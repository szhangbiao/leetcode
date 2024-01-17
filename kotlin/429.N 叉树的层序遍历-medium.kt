/*
 * @lc app=leetcode.cn id=429 lang=kotlin
 *
 * [429] N 叉树的层序遍历
 *
 * https://leetcode.cn/problems/n-ary-tree-level-order-traversal/description/
 *
 * algorithms
 * Medium (73.07%)
 * Likes:    429
 * Dislikes: 0
 * Total Accepted:    174.7K
 * Total Submissions: 239.1K
 * Testcase Example:  '[1,null,3,2,4,null,5,6]'
 *
 * 给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
 * 
 * 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 
 * 
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：[[1],[3,2,4],[5,6]]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 
 * 
 * 输入：root =
 * [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * 输出：[[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 树的高度不会超过 1000
 * 树的节点总数在 [0, 10^4] 之间
 * 
 * 
 */

// @lc code=start
/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var children: List<Node?> = listOf()
 * }
 */

class Solution {
    var result = mutableListOf<MutableList<Int>>()
    fun levelOrder(root: Node?): List<List<Int>> {
        dfs(root,0)
        return result
    }

    fun dfs(root: Node?, level: Int) {
        if(root == null) return
        if(level >= result.size) {
            val levelList = mutableListOf<Int>()
            levelList.add(root.`val`)
            result.add(levelList)
        } else {
            result[level].add(root.`val`)
        }
        root.children.forEach { dfs(it, level+1) }
    }

    fun levelOrder1(root: Node?): List<List<Int>> {
        if(root == null) return listOf()
        val result: MutableList<List<Int>> = mutableListOf()
        val queue: Queue<Node> = LinkedList()
        queue.add(root)
        while (queue.isNotEmpty()) {
            val level: MutableList<Int> = mutableListOf()
            val size = queue.size
            for(i in 0 until size) {
                val node: Node = queue.poll()
                level.add(node.`val`)
                queue.addAll(node.children)
            }
            result.add(level.toList())
        }
        return result
    }
}
// @lc code=end

