/*
 * @lc app=leetcode.cn id=198 lang=kotlin
 *
 * [198] 打家劫舍
 *
 * https://leetcode.cn/problems/house-robber/description/
 *
 * algorithms
 * Medium (54.84%)
 * Likes:    2937
 * Dislikes: 0
 * Total Accepted:    921.8K
 * Total Submissions: 1.7M
 * Testcase Example:  '[1,2,3,1]'
 *
 * 
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 * 
 * 示例 2：
 * 
 * 
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 * 偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * 0 
 * 
 * 
 */

// @lc code=start
class Solution {
    fun rob(nums: IntArray): Int {
        if(nums.isEmpty()) return 0
        if(nums.size == 1) return nums[0]
        if(nums.size == 2) return Math.max(nums[0], nums[1])
        val dp = IntArray(nums.size)
        dp[0] = nums[0]
        dp[1] = Math.max(nums[0], nums[1])
        for(i in 2 until nums.size){
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1])
        }
        return dp[nums.size - 1]
    }

    fun rob1(nums: IntArray): Int {
        if(nums.size ==0) return 0
        val n = nums.size
        if(n == 1) return nums[0]
        var dp0 = nums[0]
        var dp1 = maxOf(nums[0], nums[1])
        var temp = dp1
        for(i in 2 until n){
            temp = dp1
            dp1 = maxOf(dp0 + nums[i], dp1)
            dp0 = temp
        }
        return dp1
    }
}
// @lc code=end

