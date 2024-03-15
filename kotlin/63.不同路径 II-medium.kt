/*
 * @lc app=leetcode.cn id=63 lang=kotlin
 *
 * [63] 不同路径 II
 *
 * https://leetcode.cn/problems/unique-paths-ii/description/
 *
 * algorithms
 * Medium (41.22%)
 * Likes:    1219
 * Dislikes: 0
 * Total Accepted:    461.1K
 * Total Submissions: 1.1M
 * Testcase Example:  '[[0,0,0],[0,1,0],[0,0,0]]'
 *
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。
 * 
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * 
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
 * 输出：2
 * 解释：3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：obstacleGrid = [[0,1],[0,0]]
 * 输出：1
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * m == obstacleGrid.length
 * n == obstacleGrid[i].length
 * 1 <= m, n <= 100
 * obstacleGrid[i][j] 为 0 或 1
 * 
 * 
 */

// @lc code=start
class Solution {
    fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
        val n = obstacleGrid.size
        val m = obstacleGrid[0].size
        val dp = Array(n) { IntArray(m) }
        dp[0][0] = if(obstacleGrid[0][0] == 1) 0 else 1
        for(i in 1 until n) {
            if(obstacleGrid[i][0] == 1) {
                break
            }
            dp[i][0] = dp[i - 1][0]
        }
        for(j in 1 until m) {
            if(obstacleGrid[0][j] == 1) {
                break
            }
            dp[0][j] = dp[0][j - 1]
        }
        for(i in 1 until n) {
            for(j in 1 until m) {
                if(obstacleGrid[i][j] != 1) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
                }
            }
        }
        return dp[n - 1][m - 1]
    }

    fun uniquePathsWithObstacles1(obstacleGrid: Array<IntArray>): Int {
        val n = obstacleGrid.size
        val m = obstacleGrid[0].size
        val dp = IntArray(m)
        dp[0] = if(obstacleGrid[0][0] == 1) 0 else 1
        for(i in 0 until n) {
            for(j in 0 until m) {
                if(obstacleGrid[i][j] == 1) {
                    dp[j] = 0
                } else {
                    if(j > 0 && obstacleGrid[i][j - 1] == 0) {
                        dp[j] += dp[j - 1]
                    }
                }
            }
        }
        return dp[m - 1]
    }
}
// @lc code=end

