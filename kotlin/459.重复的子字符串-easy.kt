/*
 * @lc app=leetcode.cn id=459 lang=kotlin
 *
 * [459] 重复的子字符串
 *
 * https://leetcode.cn/problems/repeated-substring-pattern/description/
 *
 * algorithms
 * Easy (51.37%)
 * Likes:    1138
 * Dislikes: 0
 * Total Accepted:    237.3K
 * Total Submissions: 462K
 * Testcase Example:  '"abab"'
 *
 * 给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 
 * 输入: s = "abab"
 * 输出: true
 * 解释: 可由子串 "ab" 重复两次构成。
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: s = "aba"
 * 输出: false
 * 
 * 
 * 示例 3:
 * 
 * 
 * 输入: s = "abcabcabcabc"
 * 输出: true
 * 解释: 可由子串 "abc" 重复四次构成。 (或子串 "abcabc" 重复两次构成。)
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 
 * 
 * 1 <= s.length <= 10^4
 * s 由小写英文字母组成
 * 
 * 
 */

// @lc code=start
class Solution {             
    fun repeatedSubstringPattern(s: String): Boolean {
        //KMP 解法
        if(s.isEmpty()) return false
        val n = s.length
        val next = IntArray(n)
        var j = 0
        for(i in 1 until n){
            while(j > 0 && s[i] != s[j]){
                j = next[j-1]
            }
            if(s[i] == s[j]){
                j++
            }
            next[i] = j
        }
        return next[n - 1] != 0 && n % (n - next[n - 1]) == 0
    }

    fun repeatedSubstringPatternSolution1(s: String): Boolean {
        val str = s + s
        return str.substring(1, str.length - 1).contains(s)
    }
}
// @lc code=end

