/*
 * @lc app=leetcode.cn id=117 lang=kotlin
 *
 * [117] 填充每个节点的下一个右侧节点指针 II
 *
 * https://leetcode.cn/problems/populating-next-right-pointers-in-each-node-ii/description/
 *
 * algorithms
 * Medium (68.20%)
 * Likes:    830
 * Dislikes: 0
 * Total Accepted:    239.8K
 * Total Submissions: 350.1K
 * Testcase Example:  '[1,2,3,4,5,null,7]'
 *
 * 给定一个二叉树：
 * 
 * 
 * struct Node {
 * ⁠ int val;
 * ⁠ Node *left;
 * ⁠ Node *right;
 * ⁠ Node *next;
 * }
 * 
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL 。
 * 
 * 初始状态下，所有 next 指针都被设置为 NULL 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：root = [1,2,3,4,5,null,7]
 * 输出：[1,#,2,3,#,4,5,7,#]
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化输出按层序遍历顺序（由 next
 * 指针连接），'#' 表示每层的末尾。
 * 
 * 示例 2：
 * 
 * 
 * 输入：root = []
 * 输出：[]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 树中的节点数在范围 [0, 6000] 内
 * -100 <= Node.val <= 100
 * 
 * 
 * 进阶：
 * 
 * 
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序的隐式栈空间不计入额外空间复杂度。
 * 
 * 
 * 
 * 
 * 
 */

// @lc code=start
/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var left: Node? = null
 *     var right: Node? = null
 *     var next: Node? = null
 * }
 */

class Solution {
    var levelStart: Node? = null
    var levelEnd: Node? = null
    fun connect(root: Node?): Node? {
        if(root == null) return null
        //bfs(root)
        levelByNext(root)
        return root
    }

    fun bfs(root: Node?) {
        val queue = LinkedList<Node>()
        queue.offer(root)
        while (queue.isNotEmpty()) {
            val size = queue.size
            var pre: Node? = null
            for(i in 0 until size) {
                 val node = queue.poll()
                 pre?.next = node
                 pre = node
                 if(node?.left != null) queue.offer(node.left)
                 if(node?.right != null) queue.offer(node.right)
            }
        }
    }

    fun levelByNext(root: Node?){
        var start = root
        while(start != null) {
            levelStart = null
            levelEnd = null
            var level = start
            while(level != null){
                if(level.left != null){
                    handle(level?.left)
                }
                if(level.right != null){
                    handle(level?.right)
                }
                level = level.next
            }
            start = levelStart
        }
    }

    fun handle(node: Node?){
        if(levelEnd != null) {
            levelEnd?.next = node
        }
        if(levelStart == null){
            levelStart = node
        }
        levelEnd = node
    }
}
// @lc code=end

