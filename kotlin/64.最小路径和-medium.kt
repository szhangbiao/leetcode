/*
 * @lc app=leetcode.cn id=64 lang=kotlin
 *
 * [64] 最小路径和
 *
 * https://leetcode.cn/problems/minimum-path-sum/description/
 *
 * algorithms
 * Medium (69.92%)
 * Likes:    1650
 * Dislikes: 0
 * Total Accepted:    571.8K
 * Total Submissions: 815.7K
 * Testcase Example:  '[[1,3,1],[1,5,1],[4,2,1]]'
 *
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 
 * 说明：每次只能向下或者向右移动一步。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：grid = [[1,2,3],[4,5,6]]
 * 输出：12
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 200
 * 0 <= grid[i][j] <= 200
 * 
 * 
 */

// @lc code=start
class Solution {
    fun minPathSum(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size
        val dp = Array(m){IntArray(n)}
        dp[0][0] = grid[0][0]
        for (i in 1 until m){
            dp[i][0] += grid[i][0] + dp[i - 1][0]
        }
        for(j in 1 until n){
            dp[0][j] += grid[0][j] + dp[0][j - 1]
        }
        for(i in 1 until m){
            for(j in 1 until n){
                dp[i][j] = grid[i][j] + minOf(dp[i-1][j],dp[i][j-1])
            }
        }
        return dp[m-1][n-1]
    }
}
// @lc code=end

