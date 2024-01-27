/*
 * @lc app=leetcode.cn id=866 lang=kotlin
 *
 * [866] 回文素数
 *
 * https://leetcode.cn/problems/prime-palindrome/description/
 *
 * algorithms
 * Medium (24.01%)
 * Likes:    102
 * Dislikes: 0
 * Total Accepted:    12K
 * Total Submissions: 50K
 * Testcase Example:  '6'
 *
 * 求出大于或等于 N 的最小回文素数。
 * 
 * 回顾一下，如果一个数大于 1，且其因数只有 1 和它自身，那么这个数是素数。
 * 
 * 例如，2，3，5，7，11 以及 13 是素数。
 * 
 * 回顾一下，如果一个数从左往右读与从右往左读是一样的，那么这个数是回文数。
 * 
 * 例如，12321 是回文数。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：6
 * 输出：7
 * 
 * 
 * 示例 2：
 * 
 * 输入：8
 * 输出：11
 * 
 * 
 * 示例 3：
 * 
 * 输入：13
 * 输出：101
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= N <= 10^8
 * 答案肯定存在，且小于 2 * 10^8。
 * 
 * 
 * 
 * 
 * 
 * 
 */

// @lc code=start
class Solution {
    fun primePalindrome(n: Int): Int {
        if(n <= 2){
            return 2
        }
        var N = n
        while(true){
            N = getNextPalindrome(N)
            if(isPrime(N)) return N
            N++
        }
    }

    fun isPrime(n: Int): Boolean {
        if(n < 2) return false
        val sqrtN = sqrt(n.toDouble()).toInt()
        for(i: Int in 2..sqrtN) {
            if(n % i == 0) return false
        }
        return true
    }

    fun getNextPalindrome(n : Int): Int {
        val nArr: CharArray = n.toString().toCharArray()
        val mid = nArr.size / 2
        while(true) {
            for(i in 0..mid) {
                nArr[nArr.size - 1 - i] = nArr[i]
            }
            val N = nArr.joinToString("").toInt()
            if(N >= n){
                return N
            } else {
                var j = if(nArr.size % 2 == 1) mid else mid -1
                while(nArr[j] == '9') {
                    nArr[j--] = '0'
                }
                nArr[j]++
            }
        }
    }
}
// @lc code=end

