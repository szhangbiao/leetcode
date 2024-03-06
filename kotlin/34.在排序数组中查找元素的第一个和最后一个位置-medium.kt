/*
 * @lc app=leetcode.cn id=34 lang=kotlin
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 *
 * https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 *
 * algorithms
 * Medium (42.92%)
 * Likes:    2633
 * Dislikes: 0
 * Total Accepted:    932.3K
 * Total Submissions: 2.2M
 * Testcase Example:  '[5,7,7,8,8,10]\n8'
 *
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * 
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * 
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 
 * 示例 3：
 * 
 * 
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 0 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 * nums 是一个非递减数组
 * -10^9 <= target <= 10^9
 * 
 * 
 */

// @lc code=start
class Solution {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        if(nums.isEmpty()) return intArrayOf(-1, -1)
        if(nums.size == 1) return if(nums[0] == target) intArrayOf(0, 0) else intArrayOf(-1, -1)
        return intArrayOf(searchLeft(nums, target), searchRight(nums, target))
    }

    fun searchLeft(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size
        while(left < right){
            val mid = left + (right - left) / 2
            if(nums[mid] >= target){
                right = mid
            } else {
                left = mid + 1
            }
        }
        return if(left < nums.size && nums[left] == target) left else -1
    }

    fun searchRight(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size
        while(left < right){
            val mid = left + (right - left) / 2
            if(nums[mid] > target){
                right = mid
            } else {
                left = mid + 1
            }
        }
        return if(right > 0 && nums[right - 1] == target) right - 1 else -1
    }
}
// @lc code=end

