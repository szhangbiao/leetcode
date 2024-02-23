/*
 * @lc app=leetcode.cn id=28 lang=kotlin
 *
 * [28] 找出字符串中第一个匹配项的下标
 *
 * https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/description/
 *
 * algorithms
 * Easy (43.18%)
 * Likes:    2149
 * Dislikes: 0
 * Total Accepted:    1M
 * Total Submissions: 2.3M
 * Testcase Example:  '"sadbutsad"\n"sad"'
 *
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0
 * 开始）。如果 needle 不是 haystack 的一部分，则返回  -1 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：haystack = "sadbutsad", needle = "sad"
 * 输出：0
 * 解释："sad" 在下标 0 和 6 处匹配。
 * 第一个匹配项的下标是 0 ，所以返回 0 。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：haystack = "leetcode", needle = "leeto"
 * 输出：-1
 * 解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= haystack.length, needle.length <= 10^4
 * haystack 和 needle 仅由小写英文字符组成
 * 
 * 
 */

// @lc code=start
class Solution {
    fun strStr(haystack: String, needle: String): Int {
        if(needle.isEmpty()) return 0
        val next = getNextIntArray(needle)
        var i = 0
        var j = 0
        while(i < haystack.length){
            while(j > 0 && haystack[i] != needle[j]){
                j = next[j-1]
            }
            if(haystack[i] == needle[j]){
                j++;
            }
            if(j == needle.length){
                return i - j + 1
            }
            i++
        }
        return -1
    }

    fun getNextIntArray(needle: String): IntArray {
        val next = IntArray(needle.length)
        var i = 1
        var j = 0
        while(i < needle.length){
            while(j > 0 && needle[i] != needle[j]){
                j = next[j-1]
            }
            if(needle[i] == needle[j]){
                j++
            }
            next[i] = j
            i++
        }
        return next
    }

    // 解法一
    fun strStrSolution1(haystack: String, needle: String): Int {
        if(needle.length > haystack.length) return -1
        val len = haystack.length
        var i = 0
        var j = 0
        while(i < len){
            if(haystack[i] == needle[j]) {
                if(j == needle.length - 1) 
                    return i - j
                j++
            } else {
                if(j != 0){
                    i = i - j
                }
                j = 0
            }
            i++
        }
        return -1
    }
}
// @lc code=end

