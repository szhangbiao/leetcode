/*
 * @lc app=leetcode.cn id=1137 lang=kotlin
 *
 * [1137] 第 N 个泰波那契数
 *
 * https://leetcode.cn/problems/n-th-tribonacci-number/description/
 *
 * algorithms
 * Easy (60.97%)
 * Likes:    297
 * Dislikes: 0
 * Total Accepted:    194.2K
 * Total Submissions: 318.4K
 * Testcase Example:  '4'
 *
 * 泰波那契序列 Tn 定义如下： 
 * 
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 * 
 * 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：n = 4
 * 输出：4
 * 解释：
 * T_3 = 0 + 1 + 1 = 2
 * T_4 = 1 + 1 + 2 = 4
 * 
 * 
 * 示例 2：
 * 
 * 输入：n = 25
 * 输出：1389537
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 0 <= n <= 37
 * 答案保证是一个 32 位整数，即 answer <= 2^31 - 1。
 * 
 * 
 */

// @lc code=start
class Solution {
    fun tribonacci(n: Int): Int {
        if (n == 0) return 0
        if (n == 1) return 1
        if (n == 2) return 1
        var t0 = 0
        var t1 = 1
        var t2 = 1
        var r = 0
        for(i in 3..n){
            r = t0 + t1 + t2
            t0 = t1
            t1 = t2
            t2 = r
        }
        return r
    }
}
// @lc code=end

