/*
 * @lc app=leetcode.cn id=17 lang=kotlin
 *
 * [17] 电话号码的字母组合
 *
 * https://leetcode.cn/problems/letter-combinations-of-a-phone-number/description/
 *
 * algorithms
 * Medium (58.92%)
 * Likes:    2776
 * Dislikes: 0
 * Total Accepted:    831.1K
 * Total Submissions: 1.4M
 * Testcase Example:  '"23"'
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：digits = ""
 * 输出：[]
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 * 
 * 
 */

// @lc code=start
class Solution {
    val map = mapOf('2' to "abc", '3' to "def", '4' to "ghi", '5' to "jkl", '6' to "mno", '7' to "pqrs", '8' to "tuv", '9' to "wxyz")
    val builder: StringBuilder = StringBuilder()
    fun letterCombinations(digits: String): List<String> {
        if(digits.isEmpty()) return emptyList()
        val res = mutableListOf<String>()
        backTracking(digits, 0, res)
        return res
    }

    fun backTracking(digits: String, index: Int, res: MutableList<String>) {
        if(index == digits.length) {
            res.add(builder.toString())
            return 
        }
        val str = map[digits[index]]
        for(i in 0 until str!!.length) {
            val c = str[i]
            builder.append(c)
            backTracking(digits, index + 1, res)
            builder.deleteCharAt(builder.length - 1)
        }
    }
}
// @lc code=end

