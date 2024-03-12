/*
 * @lc app=leetcode.cn id=215 lang=kotlin
 *
 * [215] 数组中的第K个最大元素
 *
 * https://leetcode.cn/problems/kth-largest-element-in-an-array/description/
 *
 * algorithms
 * Medium (62.13%)
 * Likes:    2422
 * Dislikes: 0
 * Total Accepted:    1M
 * Total Submissions: 1.6M
 * Testcase Example:  '[3,2,1,5,6,4]\n2'
 *
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 
 * 输入: [3,2,1,5,6,4], k = 2
 * 输出: 5
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: [3,2,3,1,2,4,5,5,6], k = 4
 * 输出: 4
 * 
 * 
 * 
 * 提示： 
 * 
 * 
 * 1 <= k <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * 
 * 
 */

// @lc code=start
class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val bucket = IntArray(20001)
        for(num in nums) {
            bucket[num + 10000]++
        }
        var x = k
        for(i in bucket.size - 1 downTo 0) {
            x -= bucket[i]
            if(x <= 0) {
                return i - 10000
            }
        }
        return -1
    }
    
    fun findKthLargest1(nums: IntArray, k: Int): Int {
        return quickSort(nums, 0, nums.size - 1, nums.size - k)
    }

    fun quickSort(nums: IntArray, left: Int, right: Int, k: Int): Int {
        if(left == right) return nums[k]
        var x = nums[left]
        var i = left - 1
        var j = right + 1
        while(i < j) {
            do {
                i++
            }while(nums[i] < x)
            do {
                j--
            }while(nums[j] > x)
            if(i < j){
                val temp = nums[i]
                nums[i] = nums[j]
                nums[j] = temp
            }
        }
        if(k <= j){
            return quickSort(nums, left, j, k)
        }else {
            return quickSort(nums, j + 1, right, k)
        }
    }
}
// @lc code=end

