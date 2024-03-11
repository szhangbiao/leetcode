/*
 * @lc app=leetcode.cn id=322 lang=kotlin
 *
 * [322] 零钱兑换
 *
 * https://leetcode.cn/problems/coin-change/description/
 *
 * algorithms
 * Medium (47.23%)
 * Likes:    2727
 * Dislikes: 0
 * Total Accepted:    754.5K
 * Total Submissions: 1.6M
 * Testcase Example:  '[1,2,5]\n11'
 *
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * 
 * 你可以认为每种硬币的数量是无限的。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3 
 * 解释：11 = 5 + 5 + 1
 * 
 * 示例 2：
 * 
 * 
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 
 * 示例 3：
 * 
 * 
 * 输入：coins = [1], amount = 0
 * 输出：0
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 2^31 - 1
 * 0 <= amount <= 10^4
 * 
 * 
 */

// @lc code=start
class Solution {

    fun coinChange(coins: IntArray, amount: Int): Int {
        if(coins.size == 0) return -1
        val dp = IntArray(amount + 1)
        dp[0] = 0
        for(i in 1..amount) {
            var min = Int.MAX_VALUE
            for(coin in coins) {
                if(i >= coin && dp[i - coin] < min){
                    min = dp[i - coin] + 1
                }
            }
            dp[i] = min
        }
        return if(dp[amount] == Int.MAX_VALUE) -1 else dp[amount]
    }

    private lateinit var array: IntArray
    fun coinChange1(coins: IntArray, amount: Int): Int {
        if(coins.size == 0) {
            return -1
        }
        array = IntArray(amount)
        return findWay(coins, amount)
    }

    private fun findWay(coins: IntArray, amount: Int): Int {
        if(amount < 0) {
            return -1
        }
        if(amount == 0) {
            return 0
        }
        if(array[amount - 1] != 0) {
            return array[amount - 1]
        }
        var min = Int.MAX_VALUE
        for(coin in coins) {
            val result = findWay(coins, amount - coin)
            if(result >= 0 && result < min) {
                min = result + 1
            }
        }
        array[amount - 1] = if(min == Int.MAX_VALUE) -1 else min
        return array[amount - 1]
    }
}
// @lc code=end

