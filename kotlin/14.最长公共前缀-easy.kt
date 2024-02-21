/*
 * @lc app=leetcode.cn id=14 lang=kotlin
 *
 * [14] 最长公共前缀
 *
 * https://leetcode.cn/problems/longest-common-prefix/description/
 *
 * algorithms
 * Easy (43.69%)
 * Likes:    3062
 * Dislikes: 0
 * Total Accepted:    1.2M
 * Total Submissions: 2.8M
 * Testcase Example:  '["flower","flow","flight"]'
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 
 * 如果不存在公共前缀，返回空字符串 ""。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 * 
 * 
 */

// @lc code=start
class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty()) return ""
        val size = strs.size
        var min = Int.MAX_VALUE
        for(i in 0 until size) {
            min = Math.min(min, strs[i].length)
        }
        val buffer = StringBuffer()
        for(i in 0 until min) {
            for(j in 1 until size) {
                if(strs[j-1][i] != strs[j][i]) {
                    return strs[0].substring(0,i)
                }
            }
            buffer.append(strs[0][i])
        }
        return buffer.toString()
    }
}
// @lc code=end

