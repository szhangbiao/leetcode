/*
 * @lc app=leetcode.cn id=77 lang=kotlin
 *
 * [77] 组合
 *
 * https://leetcode.cn/problems/combinations/description/
 *
 * algorithms
 * Medium (77.07%)
 * Likes:    1597
 * Dislikes: 0
 * Total Accepted:    669.2K
 * Total Submissions: 869.3K
 * Testcase Example:  '4\n2'
 *
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 
 * 你可以按 任何顺序 返回答案。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：n = 4, k = 2
 * 输出：
 * [
 * ⁠ [2,4],
 * ⁠ [3,4],
 * ⁠ [2,3],
 * ⁠ [1,2],
 * ⁠ [1,3],
 * ⁠ [1,4],
 * ]
 * 
 * 示例 2：
 * 
 * 
 * 输入：n = 1, k = 1
 * 输出：[[1]]
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * 1 
 * 
 * 
 */

// @lc code=start
class Solution {

    val res = mutableListOf<List<Int>>()
    val temp = mutableListOf<Int>()
    fun combine(n: Int, k: Int): List<List<Int>> {
        backtrack(1, n, k)
        return res
    }

    fun backtrack(start: Int, end: Int, k: Int) {
        if(temp.size == k){
            res.add(temp.toMutableList())
            return
        }
        for(i in start..end){
            temp.add(i)
            backtrack(i + 1, end, k)
            temp.remove(i)
        }
    }

}
// @lc code=end

