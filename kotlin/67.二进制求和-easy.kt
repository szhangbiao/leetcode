/*
 * @lc app=leetcode.cn id=67 lang=kotlin
 *
 * [67] 二进制求和
 *
 * https://leetcode.cn/problems/add-binary/description/
 *
 * algorithms
 * Easy (52.95%)
 * Likes:    1157
 * Dislikes: 0
 * Total Accepted:    369.5K
 * Total Submissions: 697.7K
 * Testcase Example:  '"11"\n"1"'
 *
 * 给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入:a = "11", b = "1"
 * 输出："100"
 * 
 * 示例 2：
 * 
 * 
 * 输入：a = "1010", b = "1011"
 * 输出："10101"
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= a.length, b.length <= 10^4
 * a 和 b 仅由字符 '0' 或 '1' 组成
 * 字符串如果不是 "0" ，就不含前导零
 * 
 * 
 */

// @lc code=start
class Solution {
    fun addBinary(a: String, b: String): String {
        if(a == "0" || b == "0") {
            return if(a == "0") b else a
        }
        var i = a.length - 1
        var j = b.length - 1
        val buffer = StringBuffer()
        var sum = 0
        while(i >=0 || j >= 0) {
            val aSum = if(i >= 0) a.get(i) - '0' else 0
            val bSum = if(j >= 0) b.get(j) - '0' else 0
            sum = sum + aSum + bSum
            buffer.append(sum % 2)
            sum /= 2
            i--
            j--
        }
        if(sum != 0) {
            buffer.append(1)
        }
        return buffer.toString().reversed()
    }
}
// @lc code=end

