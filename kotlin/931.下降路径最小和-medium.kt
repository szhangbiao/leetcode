/*
 * @lc app=leetcode.cn id=931 lang=kotlin
 *
 * [931] 下降路径最小和
 *
 * https://leetcode.cn/problems/minimum-falling-path-sum/description/
 *
 * algorithms
 * Medium (67.58%)
 * Likes:    339
 * Dislikes: 0
 * Total Accepted:    100.3K
 * Total Submissions: 148.4K
 * Testcase Example:  '[[2,1,3],[6,5,4],[7,8,9]]'
 *
 * 给你一个 n x n 的 方形 整数数组 matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。
 * 
 * 下降路径
 * 可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列（即位于正下方或者沿对角线向左或者向右的第一个元素）。具体来说，位置
 * (row, col) 的下一个元素应当是 (row + 1, col - 1)、(row + 1, col) 或者 (row + 1, col + 1)
 * 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 
 * 
 * 输入：matrix = [[2,1,3],[6,5,4],[7,8,9]]
 * 输出：13
 * 解释：如图所示，为和最小的两条下降路径
 * 
 * 
 * 示例 2：
 * 
 * 
 * 
 * 
 * 输入：matrix = [[-19,57],[-40,-5]]
 * 输出：-59
 * 解释：如图所示，为和最小的下降路径
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * n == matrix.length == matrix[i].length
 * 1 <= n <= 100
 * -100 <= matrix[i][j] <= 100
 * 
 * 
 */

// @lc code=start
class Solution {
    fun minFallingPathSum(matrix: Array<IntArray>): Int {
        val n = matrix.size
        for(i in 1 until n){
            for(j in 0 until n){
                val a = if(j > 0) matrix[i - 1][j - 1] else Int.MAX_VALUE
                val b = matrix[i - 1][j]
                val c = if(j < n - 1) matrix[i - 1][j + 1] else Int.MAX_VALUE
                matrix[i][j] += minOf(a, b, c)
            }
        }
        var min = Int.MAX_VALUE
        for(i in 0 until n){
            min = minOf(min, matrix[n - 1][i])
        }
        return min
    }
}
// @lc code=end

