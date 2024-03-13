/*
 * @lc app=leetcode.cn id=46 lang=kotlin
 *
 * [46] 全排列
 *
 * https://leetcode.cn/problems/permutations/description/
 *
 * algorithms
 * Medium (79.01%)
 * Likes:    2830
 * Dislikes: 0
 * Total Accepted:    1M
 * Total Submissions: 1.3M
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：nums = [1]
 * 输出：[[1]]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * nums 中的所有整数 互不相同
 * 
 * 
 */

// @lc code=start
class Solution {
    val res = mutableListOf<List<Int>>()
    val temp = mutableListOf<Int>()
    fun permute(nums: IntArray): List<List<Int>> {
        val flags = BooleanArray(nums.size)
        backtrack(nums, 0, flags)
        return res
    }

    fun backtrack(nums: IntArray, index: Int, flags: BooleanArray) {
        if(index == nums.size) {
            res.add(temp.toList())
        }
        for(i in 0 until nums.size) {
            if(!flags[i]) {
                temp.add(nums[i])
                flags[i] = true
                backtrack(nums, index + 1, flags)
                flags[i] = false
                temp.removeAt(temp.size - 1)
            }
        }
    }
}
// @lc code=end

