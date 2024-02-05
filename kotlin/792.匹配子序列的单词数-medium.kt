/*
 * @lc app=leetcode.cn id=792 lang=kotlin
 *
 * [792] 匹配子序列的单词数
 *
 * https://leetcode.cn/problems/number-of-matching-subsequences/description/
 *
 * algorithms
 * Medium (50.95%)
 * Likes:    400
 * Dislikes: 0
 * Total Accepted:    42.8K
 * Total Submissions: 84.1K
 * Testcase Example:  '"abcde"\n["a","bb","acd","ace"]'
 *
 * 给定字符串 s 和字符串数组 words, 返回  words[i] 中是s的子序列的单词个数 。
 * 
 * 字符串的 子序列 是从原始字符串中生成的新字符串，可以从中删去一些字符(可以是none)，而不改变其余字符的相对顺序。
 * 
 * 
 * 例如， “ace” 是 “abcde” 的子序列。
 * 
 * 
 * 
 * 
 * 示例 1:
 * 
 * 
 * 输入: s = "abcde", words = ["a","bb","acd","ace"]
 * 输出: 3
 * 解释: 有三个是 s 的子序列的单词: "a", "acd", "ace"。
 * 
 * 
 * Example 2:
 * 
 * 
 * 输入: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
 * 输出: 2
 * 
 * 
 * 
 * 
 * 提示:
 * 
 * 
 * 1 <= s.length <= 5 * 10^4
 * 1 <= words.length <= 5000
 * 1 <= words[i].length <= 50
 * words[i]和 s 都只由小写字母组成。
 * 
 * ​​​​
 */

// @lc code=start
class Solution {
    fun numMatchingSubseq(s: String, words: Array<String>): Int {
        var indexes = mutableMapOf<Char, LinkedList<IntArray>>()
        var ans = 0
        words.forEachIndexed { index, word ->
            if(word.length == 0){
                ans++
            }else{
                indexes.getOrPut(word[0]) { LinkedList() }.add(intArrayOf(index, 0))
            }
        }
        s.forEach { c ->
            indexes[c]?.apply {
                for(i in 0 until size){
                    var cur = poll()
                    if(cur[1] == words[cur[0]].length - 1){
                        ans++
                    }else{
                        cur[1]++
                        indexes.getOrPut(words[cur[0]][cur[1]]) { LinkedList() }.add(cur)
                    }
                }
            }
        }
        return ans
    }
}
// @lc code=end

