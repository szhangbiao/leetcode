/*
 * @lc app=leetcode.cn id=130 lang=kotlin
 *
 * [130] 被围绕的区域
 *
 * https://leetcode.cn/problems/surrounded-regions/description/
 *
 * algorithms
 * Medium (46.34%)
 * Likes:    1097
 * Dislikes: 0
 * Total Accepted:    268.3K
 * Total Submissions: 578.3K
 * Testcase Example:  '[["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]'
 *
 * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X'
 * 填充。
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：board =
 * [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
 * 输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
 * 解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O'
 * 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：board = [["X"]]
 * 输出：[["X"]]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * m == board.length
 * n == board[i].length
 * 1 
 * board[i][j] 为 'X' 或 'O'
 * 
 * 
 * 
 * 
 */

// @lc code=start
class Solution {
    fun solve(board: Array<CharArray>): Unit {
        val m = board.size
        val n = board[0].size
        for(i in 0 until m) {
            dfs(board, i, 0)
            dfs(board, i, n - 1)
        }
        for(j in 0 until n) {
            dfs(board, 0, j)
            dfs(board, m - 1, j)
        }
        for(i in 0 until m) {
            for(j in 0 until n) {
                if(board[i][j] == 'A'){
                    board[i][j] = 'O'
                } else if(board[i][j] == 'O') {
                    board[i][j] = 'X'
                }
            }
        }
    }

    fun dfs(board: Array<CharArray>, i: Int, j: Int) {
        if(i < 0 || i >= board.size || j < 0 || j >= board[0].size || board[i][j] != 'O') {
            return
        }
        board[i][j] = 'A'
        dfs(board, i - 1, j)
        dfs(board, i + 1, j)
        dfs(board, i, j - 1)
        dfs(board, i, j + 1)
    }
}
// @lc code=end

