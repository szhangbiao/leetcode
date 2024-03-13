/*
 * @lc app=leetcode.cn id=22 lang=kotlin
 *
 * [22] 括号生成
 *
 * https://leetcode.cn/problems/generate-parentheses/description/
 *
 * algorithms
 * Medium (77.56%)
 * Likes:    3532
 * Dislikes: 0
 * Total Accepted:    805.7K
 * Total Submissions: 1M
 * Testcase Example:  '3'
 *
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：n = 1
 * 输出：["()"]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= n <= 8
 * 
 * 
 */

// @lc code=start
class Solution {

    val res = mutableListOf<String>()
    val builder = StringBuilder()

    fun generateParenthesis(n: Int): List<String> {
        backtracking(n, 0, 0)
        return res
    }

    fun backtracking(n: Int, left: Int, right: Int) {
        if(builder.length == n * 2) {
            res.add(builder.toString())
            return
        }
        if(left < n) {
            builder.append("(")
            backtracking(n, left + 1, right)
            builder.deleteCharAt(builder.length - 1)
        }
        if(right < left) {
            builder.append(")")
            backtracking(n, left, right + 1)
            builder.deleteCharAt(builder.length - 1)
        }
    }
}
// @lc code=end

