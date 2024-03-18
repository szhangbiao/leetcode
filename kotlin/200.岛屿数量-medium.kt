/*
 * @lc app=leetcode.cn id=200 lang=kotlin
 *
 * [200] 岛屿数量
 *
 * https://leetcode.cn/problems/number-of-islands/description/
 *
 * algorithms
 * Medium (59.99%)
 * Likes:    2446
 * Dislikes: 0
 * Total Accepted:    789.5K
 * Total Submissions: 1.3M
 * Testcase Example:  '[["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]'
 *
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 
 * 此外，你可以假设该网格的四条边均被水包围。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：grid = [
 * ⁠ ["1","1","1","1","0"],
 * ⁠ ["1","1","0","1","0"],
 * ⁠ ["1","1","0","0","0"],
 * ⁠ ["0","0","0","0","0"]
 * ]
 * 输出：1
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：grid = [
 * ⁠ ["1","1","0","0","0"],
 * ⁠ ["1","1","0","0","0"],
 * ⁠ ["0","0","1","0","0"],
 * ⁠ ["0","0","0","1","1"]
 * ]
 * 输出：3
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * m == grid.length
 * n == grid[i].length
 * 1 
 * grid[i][j] 的值为 '0' 或 '1'
 * 
 * 
 */

// @lc code=start
class Solution {
    fun numIslands(grid: Array<CharArray>): Int {
        var max = 0
        for(i in grid.indices) {
            for(j in grid[0].indices) {
                if(grid[i][j] == '1') {
                    dfs(grid, i, j)
                    max += 1
                }
            }
        }
        return max
    }

    fun dfs(grid: Array<CharArray>, i: Int, j: Int) {
        if(i < 0 || i >= grid.size || j < 0 || j >= grid[0].size || grid[i][j] == '0') {
            return
        }
        grid[i][j] = '0'
        dfs(grid, i - 1, j)
        dfs(grid, i + 1, j)
        dfs(grid, i, j - 1)
        dfs(grid, i, j + 1)
    }
}
// @lc code=end

