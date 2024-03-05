/*
 * @lc app=leetcode.cn id=155 lang=kotlin
 *
 * [155] 最小栈
 *
 * https://leetcode.cn/problems/min-stack/description/
 *
 * algorithms
 * Medium (59.38%)
 * Likes:    1734
 * Dislikes: 0
 * Total Accepted:    551.1K
 * Total Submissions: 926K
 * Testcase Example:  '["MinStack","push","push","push","getMin","pop","top","getMin"]\n' +
  '[[],[-2],[0],[-3],[],[],[],[]]'
 *
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * 
 * 实现 MinStack 类:
 * 
 * 
 * MinStack() 初始化堆栈对象。
 * void push(int val) 将元素val推入堆栈。
 * void pop() 删除堆栈顶部的元素。
 * int top() 获取堆栈顶部的元素。
 * int getMin() 获取堆栈中的最小元素。
 * 
 * 
 * 
 * 
 * 示例 1:
 * 
 * 
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 * 
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 * 
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * -2^31 <= val <= 2^31 - 1
 * pop、top 和 getMin 操作总是在 非空栈 上调用
 * push, pop, top, and getMin最多被调用 3 * 10^4 次
 * 
 * 
 */

// @lc code=start
class MinStack() {
    // 解法1.辅助栈，用于存储当前最小值或存储最小值在当前栈中类
    // 解法2.用链表模拟栈，每个节点存储当前栈中最小值
    private val stack: Stack<Node> = Stack()

    fun push(`val`: Int) {
        if(stack.isEmpty()){
            stack.push(Node(`val`, `val`))
        } else {
            stack.push(Node(`val`, Math.min(`val`, stack.peek().min)))
        }
    }

    fun pop() {
        stack.pop()
    }

    fun top(): Int {
        return stack.peek().`val`
    }

    fun getMin(): Int {
        return stack.peek().min
    }
}

data class Node(val `val`: Int, val min: Int)

class MinStack1() {
    // 解法1.辅助栈，用于存储当前最小值或存储最小值在当前栈中类
    // 解法2.用链表模拟栈，每个节点存储当前栈中最小值
    private var head: StackNode? = null

    fun push(`val`: Int) {
        if(head == null){
            head = StackNode(`val`, `val`)
        } else {
            val node: StackNode? = StackNode(`val`, Math.min(`val`, head!!.min))
            node?.next = head
            head = node
        }
    }

    fun pop() {
        head = head?.next
    }

    fun top(): Int {
        return head?.`val` ?: -1
    }

    fun getMin(): Int {
        return head?.min ?: -1
    }

}

class StackNode(val `val`: Int, val min: Int){
    var next: StackNode? = null
}

/**
 * Your MinStack object will be instantiated and called as such:
 * var obj = MinStack()
 * obj.push(`val`)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */
// @lc code=end

