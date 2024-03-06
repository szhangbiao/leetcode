/*
 * @lc app=leetcode.cn id=238 lang=kotlin
 *
 * [238] 除自身以外数组的乘积
 *
 * https://leetcode.cn/problems/product-of-array-except-self/description/
 *
 * algorithms
 * Medium (75.09%)
 * Likes:    1733
 * Dislikes: 0
 * Total Accepted:    387.4K
 * Total Submissions: 515.1K
 * Testcase Example:  '[1,2,3,4]'
 *
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 * 
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 * 
 * 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 
 * 输入: nums = [1,2,3,4]
 * 输出: [24,12,8,6]
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: nums = [-1,1,0,-3,3]
 * 输出: [0,0,9,0,0]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 2 <= nums.length <= 10^5
 * -30 <= nums[i] <= 30
 * 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内
 * 
 * 
 * 
 * 
 * 进阶：你可以在 O(1) 的额外空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组 不被视为 额外空间。）
 * 
 */

// @lc code=start
class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
       val answer = IntArray(nums.size)
       answer[0] = 1
       for (i in 1 until nums.size) {
           answer[i] = answer[i - 1] * nums[i - 1]
       }
       var right = 1
       for (i in nums.size - 1 downTo 0) {
           answer[i] = answer[i] * right
           right *= nums[i]
       }
       return answer
    }

    fun productExceptSelf1(nums: IntArray): IntArray {
       val answer = IntArray(nums.size)
       val left = IntArray(nums.size)
       val right = IntArray(nums.size)
       left[0] = 1
       for (i in 1 until nums.size) {
           left[i] = left[i - 1] * nums[i - 1]
       }
       right[nums.size - 1] = 1
       for(i in nums.size - 2 downTo 0) {
           right[i] = right[i + 1] * nums[i + 1]
       }
       for (i in 0 until nums.size) {
           answer[i] = left[i] * right[i]
       }
       return answer
    }
}
// @lc code=end

