/*
 * @lc app=leetcode.cn id=383 lang=kotlin
 *
 * [383] 赎金信
 *
 * https://leetcode.cn/problems/ransom-note/description/
 *
 * algorithms
 * Easy (62.94%)
 * Likes:    867
 * Dislikes: 0
 * Total Accepted:    447.5K
 * Total Submissions: 706K
 * Testcase Example:  '"a"\n"b"'
 *
 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 * 
 * 如果可以，返回 true ；否则返回 false 。
 * 
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：ransomNote = "a", magazine = "b"
 * 输出：false
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：ransomNote = "aa", magazine = "ab"
 * 输出：false
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：ransomNote = "aa", magazine = "aab"
 * 输出：true
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= ransomNote.length, magazine.length <= 10^5
 * ransomNote 和 magazine 由小写英文字母组成
 * 
 * 
 */

// @lc code=start
class Solution {
    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        if(ransomNote.length > magazine.length) return false
        val arr = IntArray(26)
        for(c in magazine) {
            arr[c - 'a']++
        }
        for(c in ransomNote) {
            arr[c - 'a']--
            if(arr[c - 'a'] < 0) return false
        }
        return true
    }
}
// @lc code=end

