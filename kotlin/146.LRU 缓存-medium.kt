/*
 * @lc app=leetcode.cn id=146 lang=kotlin
 *
 * [146] LRU 缓存
 *
 * https://leetcode.cn/problems/lru-cache/description/
 *
 * algorithms
 * Medium (53.74%)
 * Likes:    3087
 * Dislikes: 0
 * Total Accepted:    591.9K
 * Total Submissions: 1.1M
 * Testcase Example:  '["LRUCache","put","put","get","put","get","put","get","get","get"]\n' +
  '[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]'
 *
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 
 * 实现 LRUCache 类：
 * 
 * 
 * 
 * 
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组
 * key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 
 * 
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 * 
 * 
 * 
 * 
 * 
 * 示例：
 * 
 * 
 * 输入
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * 输出
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 * 
 * 解释
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // 缓存是 {1=1}
 * lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
 * lRUCache.get(1);    // 返回 1
 * lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
 * lRUCache.get(2);    // 返回 -1 (未找到)
 * lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
 * lRUCache.get(1);    // 返回 -1 (未找到)
 * lRUCache.get(3);    // 返回 3
 * lRUCache.get(4);    // 返回 4
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= capacity <= 3000
 * 0 <= key <= 10000
 * 0 <= value <= 10^5
 * 最多调用 2 * 10^5 次 get 和 put
 * 
 * 
 */

// @lc code=start
class LRUCache(private val capacity: Int) {

    private var size: Int = 0
    private val map = HashMap<Int, Node>()
    private val head = Node()
    private val tail = Node()

    init {
        head.next = tail
        tail.prev = head
    }


    fun get(key: Int): Int {
        val node = map[key]
        if (node == null) {
            return -1
        } else {
            moveToHead(node)
            return node.value
        }
    }

    fun put(key: Int, value: Int) {
        val node = map[key]
        if (node == null) {
            val newNode = Node(key, value)
            map[key] = newNode
            addToHead(newNode)
            size++
            if(size > capacity){
                val tailNode = removeFromTail()
                map.remove(tailNode.key)
                size--
            }
        } else {
            node.value = value
            moveToHead(node)
        }
    }

    private fun addToHead(node: Node?) {
        node?.next = head.next
        head?.next = node
        node?.prev = head
        node?.next?.prev = node
    }

    private fun removeNode(node: Node?) {
        node?.prev?.next = node?.next
        node?.next?.prev = node?.prev
    }

    private fun moveToHead(node: Node?) {
        removeNode(node)
        addToHead(node)
    }

    private fun removeFromTail(): Node {
        val node = tail.prev!!
        removeNode(node)
        return node
    }

}

class Node(val key: Int = -1, var value: Int = -1){
    var prev: Node? = null
    var next: Node? = null
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * var obj = LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */
// @lc code=end

