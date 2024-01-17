/*
 * @lc app=leetcode.cn id=7 lang=kotlin
 *
 * [7] 整数反转
 *
 * https://leetcode.cn/problems/reverse-integer/description/
 *
 * algorithms
 * Medium (35.44%)
 * Likes:    3953
 * Dislikes: 0
 * Total Accepted:    1.3M
 * Total Submissions: 3.6M
 * Testcase Example:  '123'
 *
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 
 * 如果反转后整数超过 32 位的有符号整数的范围 [−2^31,  2^31 − 1] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：x = 123
 * 输出：321
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：x = -123
 * 输出：-321
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：x = 120
 * 输出：21
 * 
 * 
 * 示例 4：
 * 
 * 
 * 输入：x = 0
 * 输出：0
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * -2^31 
 * 
 * 
 */

// @lc code=start
class Solution {
    fun reverse(x: Int): Int {
        var target = x
        var rev = 0
        while(target != 0) {
            if (rev > Int.MAX_VALUE / 10 || rev < Int.MIN_VALUE / 10) {
                return 0
            }
            val digit = target % 10
            target /= 10
            rev = rev * 10 + digit
        }
        return rev
    }
}
// @lc code=end

