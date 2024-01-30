/*
 * @lc app=leetcode.cn id=263 lang=kotlin
 *
 * [263] 丑数
 *
 * https://leetcode.cn/problems/ugly-number/description/
 *
 * algorithms
 * Easy (50.33%)
 * Likes:    426
 * Dislikes: 0
 * Total Accepted:    173.1K
 * Total Submissions: 343.9K
 * Testcase Example:  '6'
 *
 * 丑数 就是只包含质因数 2、3 和 5 的正整数。
 * 
 * 给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；否则，返回 false 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：n = 6
 * 输出：true
 * 解释：6 = 2 × 3
 * 
 * 示例 2：
 * 
 * 
 * 输入：n = 1
 * 输出：true
 * 解释：1 没有质因数，因此它的全部质因数是 {2, 3, 5} 的空集。习惯上将其视作第一个丑数。
 * 
 * 示例 3：
 * 
 * 
 * 输入：n = 14
 * 输出：false
 * 解释：14 不是丑数，因为它包含了另外一个质因数 7 。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * -2^31 <= n <= 2^31 - 1
 * 
 * 
 */

// @lc code=start
class Solution {
    fun isUgly(n: Int): Boolean {
        if(n <= 0) return false
        var cur = n
        while(cur % 2 == 0) cur /= 2
        while(cur % 3 == 0) cur /= 3
        while(cur % 5 == 0) cur /= 5
        return cur == 1
    }
}
// @lc code=end

