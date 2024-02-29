/*
 * @lc app=leetcode.cn id=242 lang=kotlin
 *
 * [242] 有效的字母异位词
 *
 * https://leetcode.cn/problems/valid-anagram/description/
 *
 * algorithms
 * Easy (66.18%)
 * Likes:    895
 * Dislikes: 0
 * Total Accepted:    729.8K
 * Total Submissions: 1.1M
 * Testcase Example:  '"anagram"\n"nagaram"'
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 
 * 
 * 
 * 提示:
 * 
 * 
 * 1 
 * s 和 t 仅包含小写字母
 * 
 * 
 * 
 * 
 * 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 * 
 */

// @lc code=start
class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        if(s.length != t.length) return false
        val count = IntArray(26)
        for(i in s.indices) {
            count[s[i] - 'a']++
        }
        for(i in t.indices) {
            count[t[i] - 'a']--
        }
        return count.all { it == 0 }
    }
}
// @lc code=end

