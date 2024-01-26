/*
 * @lc app=leetcode.cn id=50 lang=kotlin
 *
 * [50] Pow(x, n)
 *
 * https://leetcode.cn/problems/powx-n/description/
 *
 * algorithms
 * Medium (38.10%)
 * Likes:    1298
 * Dislikes: 0
 * Total Accepted:    420.4K
 * Total Submissions: 1.1M
 * Testcase Example:  '2.00000\n10'
 *
 * 实现 pow(x, n) ，即计算 x 的整数 n 次幂函数（即，x^n^ ）。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2^-2 = 1/2^2 = 1/4 = 0.25
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * -100.0 < x < 100.0
 * -2^31 <= n <= 2^31-1
 * n 是一个整数
 * 要么 x 不为零，要么 n > 0 。
 * -10^4 <= x^n <= 10^4
 * 
 * 
 */

// @lc code=start
class Solution {
    fun myPow(x: Double, n: Int): Double {
        return if(n >= 0) quickPow(x, n) else 1.0 / quickPow(x, -n)
    }

    fun quickPow(x: Double, n: Int): Double {
        if(n == 0) return 1.0
        val half = quickPow(x, n / 2)
        return if(n % 2 == 0) half * half else half * half * x
    }
}
// @lc code=end

