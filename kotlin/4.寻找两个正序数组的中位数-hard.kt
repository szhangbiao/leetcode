/*
 * @lc app=leetcode.cn id=4 lang=kotlin
 *
 * [4] 寻找两个正序数组的中位数
 *
 * https://leetcode.cn/problems/median-of-two-sorted-arrays/description/
 *
 * algorithms
 * Hard (41.89%)
 * Likes:    7035
 * Dislikes: 0
 * Total Accepted:    1.1M
 * Total Submissions: 2.6M
 * Testcase Example:  '[1,3]\n[2]'
 *
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * 
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * 
 * 
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -10^6 <= nums1[i], nums2[i] <= 10^6
 * 
 * 
 */

// @lc code=start
class Solution {
    // TODO 有点难，需要进一步理解
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val total = nums1.size + nums2.size
        if(total % 2 == 1) {
            return findKth(nums1, 0, nums2, 0, total / 2 + 1)
        } else {
            val a = findKth(nums1, 0, nums2, 0, total / 2)
            val b = findKth(nums1, 0, nums2, 0, total / 2 + 1)
            return (a + b) / 2.0
        }
    }

    fun findKth(nums1: IntArray,i:Int,nums2: IntArray,j:Int,k:Int): Double {
        if(nums1.size - i > nums2.size - j) {
            return findKth(nums2, j, nums1, i, k)
        }
        if(nums1.size == i) {
            return nums2[j+k-1].toDouble()
        }
        if(k == 1){
            return min(nums1[i], nums2[j]).toDouble()
        }
        val s1 = Math.min(i + k/2, nums1.size)
        val s2 = j + k/2
        if(nums1[s1-1] > nums2[s2-1]) {
            return findKth(nums1, i, nums2, s2, k - k/2)
        } else {
            return findKth(nums1, s1, nums2, j, k - (s1 - i))
        }
    }
}
// @lc code=end

