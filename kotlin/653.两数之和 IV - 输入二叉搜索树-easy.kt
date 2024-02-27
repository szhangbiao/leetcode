/*
 * @lc app=leetcode.cn id=653 lang=kotlin
 *
 * [653] 两数之和 IV - 输入二叉搜索树
 *
 * https://leetcode.cn/problems/two-sum-iv-input-is-a-bst/description/
 *
 * algorithms
 * Easy (63.52%)
 * Likes:    495
 * Dislikes: 0
 * Total Accepted:    119.1K
 * Total Submissions: 187.4K
 * Testcase Example:  '[5,3,6,2,4,null,7]\n9'
 *
 * 给定一个二叉搜索树 root 和一个目标结果 k，如果二叉搜索树中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入: root = [5,3,6,2,4,null,7], k = 9
 * 输出: true
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入: root = [5,3,6,2,4,null,7], k = 28
 * 输出: false
 * 
 * 
 * 
 * 
 * 提示:
 * 
 * 
 * 二叉树的节点个数的范围是  [1, 10^4].
 * -10^4 <= Node.val <= 10^4
 * 题目数据保证，输入的 root 是一棵 有效 的二叉搜索树
 * -10^5 <= k <= 10^5
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
    fun findTarget(root: TreeNode?, k: Int): Boolean {
        val set = mutableSetOf<Int>()
        val queue = LinkedList<TreeNode?>()
        queue.add(root)
        while(queue.isNotEmpty()){
            val size = queue.size
            for(i in 0 until size){
                val node = queue.poll()
                if(set.contains(k - node!!.`val`)){
                    return true
                }
                set.add(node!!.`val`)
                if(node.left != null){
                    queue.add(node.left)
                }
                if(node.right != null){
                    queue.add(node.right)
                }
            }
        }
        return false
    }

}
// @lc code=end

