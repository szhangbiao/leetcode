/*
 * @lc app=leetcode.cn id=168 lang=kotlin
 *
 * [168] Excel表列名称
 *
 * https://leetcode.cn/problems/excel-sheet-column-title/description/
 *
 * algorithms
 * Easy (44.32%)
 * Likes:    668
 * Dislikes: 0
 * Total Accepted:    149.9K
 * Total Submissions: 337.8K
 * Testcase Example:  '1'
 *
 * 给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。
 * 
 * 例如：
 * 
 * 
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28 
 * ...
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：columnNumber = 1
 * 输出："A"
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：columnNumber = 28
 * 输出："AB"
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：columnNumber = 701
 * 输出："ZY"
 * 
 * 
 * 示例 4：
 * 
 * 
 * 输入：columnNumber = 2147483647
 * 输出："FXSHRXW"
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * 
 * 
 */

// @lc code=start
class Solution {
    fun convertToTitle(columnNumber: Int): String {
        val columnMap = mutableMapOf<Int, Char>()
        for (i in 0..25) {
            columnMap[i] = 'A' + i
        }
        var sum = columnNumber
        val buffer = StringBuffer()
        while (sum > 0) {
            sum -= 1
            val mod = sum % 26
            buffer.append(columnMap[mod])
            sum /= 26
        }
        return buffer.reverse().toString()
    }
}
// @lc code=end

