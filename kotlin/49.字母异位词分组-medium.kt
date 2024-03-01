/*
 * @lc app=leetcode.cn id=49 lang=kotlin
 *
 * [49] 字母异位词分组
 *
 * https://leetcode.cn/problems/group-anagrams/description/
 *
 * algorithms
 * Medium (67.79%)
 * Likes:    1830
 * Dislikes: 0
 * Total Accepted:    626.3K
 * Total Submissions: 922.4K
 * Testcase Example:  '["eat","tea","tan","ate","nat","bat"]'
 *
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * 
 * 示例 2:
 * 
 * 
 * 输入: strs = [""]
 * 输出: [[""]]
 * 
 * 
 * 示例 3:
 * 
 * 
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= strs.length <= 10^4
 * 0 <= strs[i].length <= 100
 * strs[i] 仅包含小写字母
 * 
 * 
 */

// @lc code=start
class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val map = mutableMapOf<String, MutableList<String>>()
        //solution1(strs, map)
        solution2(strs, map)
        return map.values.toList()
    }

    fun solution1(strs: Array<String>, map: MutableMap<String, MutableList<String>>){
        for(str in strs){
            val count = IntArray(26)
            for(c in str){
                count[c - 'a']++
            }
            val buffer = StringBuffer()
            for(i in 0..25){
                if(count[i] != 0){
                    var c: Char = 'a' + i
                    buffer.append(count[i]).append(c)
                }
            }
            val key = buffer.toString()
            map[key] = map.getOrDefault(key, mutableListOf()).apply{ add(str) }
        }
    }

    fun solution2(strs: Array<String>, map: MutableMap<String, MutableList<String>>){
        for(str in strs){
            val key = str.toCharArray().sorted().joinToString("")
            map[key] = map.getOrDefault(key, mutableListOf()).apply{ add(str) }
        }
    }
}
// @lc code=end

