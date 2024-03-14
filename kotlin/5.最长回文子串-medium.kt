/*
 * @lc app=leetcode.cn id=5 lang=kotlin
 *
 * [5] 最长回文子串
 *
 * https://leetcode.cn/problems/longest-palindromic-substring/description/
 *
 * algorithms
 * Medium (37.98%)
 * Likes:    7108
 * Dislikes: 0
 * Total Accepted:    1.6M
 * Total Submissions: 4.3M
 * Testcase Example:  '"babad"'
 *
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：s = "cbbd"
 * 输出："bb"
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母组成
 * 
 * 
 */

// @lc code=start
class Solution {
    fun longestPalindrome(s: String): String {
        var left = 0
        var right = 0
        for(i in 0 until s.length){
            val len = Math.max(expandAroundCenter(s, i, i), expandAroundCenter(s, i, i + 1))
            if(len > right - left){
                left = i - (len - 1) / 2
                right = i + len / 2
            }
        }
        return s.substring(left, right + 1)
    }

    fun expandAroundCenter(s: String, left: Int, right: Int): Int {
        var start = left
        var end = right
        while(start >= 0 && end < s.length && s[start] == s[end]){
            start--
            end++
        }
        return end - start - 1
    }
}
// @lc code=end

