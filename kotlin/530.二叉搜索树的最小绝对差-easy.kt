/*
 * @lc app=leetcode.cn id=530 lang=kotlin
 *
 * [530] 二叉搜索树的最小绝对差
 *
 * https://leetcode.cn/problems/minimum-absolute-difference-in-bst/description/
 *
 * algorithms
 * Easy (63.05%)
 * Likes:    543
 * Dislikes: 0
 * Total Accepted:    224.8K
 * Total Submissions: 356.7K
 * Testcase Example:  '[4,2,6,1,3]'
 *
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 * 
 * 差值是一个正数，其数值等于两值之差的绝对值。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：root = [4,2,6,1,3]
 * 输出：1
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：root = [1,0,48,null,null,12,49]
 * 输出：1
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 树中节点的数目范围是 [2, 10^4]
 * 0 <= Node.val <= 10^5
 * 
 * 
 * 
 * 
 * 注意：本题与 783
 * https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/ 相同
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

    var min = Int.MAX_VALUE
    var pre = -1

    fun getMinimumDifference(root: TreeNode?): Int {
        dfs(root)
        return min
    }

    fun dfs(root: TreeNode?){
        if(root == null) return
        dfs(root.left)
        if(pre != -1) {
            min = Math.min(min, root.`val` - pre)
        }
        pre = root.`val`
        dfs(root.right)
    }

    fun getMinimumDifference1(root: TreeNode?): Int {
        if(root == null) return 0
        val list = mutableListOf<Int>()
        inorderTree(root, list)
        var min = Int.MAX_VALUE
        for(i in 1 until list.size) {
            min = Math.min(min, list[i] - list[i - 1])
        }
        return min
    }

    fun inorderTree(root: TreeNode?, list: MutableList<Int>) {
        if(root == null) return
        inorderTree(root.left, list)
        list.add(root!!.`val`)
        inorderTree(root.right, list)
    }
}
// @lc code=end

