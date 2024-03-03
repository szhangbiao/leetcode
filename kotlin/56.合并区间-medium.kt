/*
 * @lc app=leetcode.cn id=56 lang=kotlin
 *
 * [56] 合并区间
 *
 * https://leetcode.cn/problems/merge-intervals/description/
 *
 * algorithms
 * Medium (49.72%)
 * Likes:    2250
 * Dislikes: 0
 * Total Accepted:    795.5K
 * Total Submissions: 1.6M
 * Testcase Example:  '[[1,3],[2,6],[8,10],[15,18]]'
 *
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi]
 * 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= intervals.length <= 10^4
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 10^4
 * 
 * 
 */

// @lc code=start
class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        if(intervals.size == 1) return intervals
        val sorted = intervals.sortedBy { it[0] }
        val result = mutableListOf<IntArray>()
        var start = sorted[0][0]
        var end = sorted[0][1]
        for(i in 1 until sorted.size) {
            if(sorted[i][0] <= end) {
                end = Math.max(sorted[i][1], end)
            } else {
                result.add(intArrayOf(start, end))
                start = sorted[i][0]
                end = sorted[i][1]
            }
        }
        result.add(intArrayOf(start, end))
        return result.toTypedArray()
    }
}

// @lc code=end

