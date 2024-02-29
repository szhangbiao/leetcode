/*
 * @lc app=leetcode.cn id=3 lang=kotlin
 *
 * [3] 无重复字符的最长子串
 *
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/
 *
 * algorithms
 * Medium (39.44%)
 * Likes:    10001
 * Dislikes: 0
 * Total Accepted:    2.7M
 * Total Submissions: 6.8M
 * Testcase Example:  '"abcabcbb"'
 *
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 
 * 输入: s = "abcabcbb"
 * 输出: 3 
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 
 * 
 * 示例 3:
 * 
 * 
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 0 <= s.length <= 5 * 10^4
 * s 由英文字母、数字、符号和空格组成
 * 
 * 
 */

// @lc code=start
class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        if(s.isEmpty()) return 0
        val set = mutableSetOf<Char>()
        var max = 0
        var left = 0
        var right = 0
        while(right < s.length) {
            while(set.contains(s[right]) && left <= right) {
                set.remove(s[left++])
            }
            while(right < s.length && !set.contains(s[right])) {
                set.add(s[right])
                max = Math.max(max, right - left + 1)
                right++
            }
        }
        return max
    }
}
// @lc code=end

