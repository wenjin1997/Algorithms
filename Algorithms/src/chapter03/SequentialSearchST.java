package chapter03;

/**
 * @author 文进
 * @version 1.0
 * 算法3.1 顺序查找（基于无序链表）
 */
public class SequentialSearchST<Key, Value> {
    private Node first; // 链表首结点
    private class Node {
        // 链表结点的定义
        Key key;
        Value val;
        Node next;

        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    public Value get(Key key) {
        // 查找给定的键，返回相关联的值
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return x.val; // 命中
            }
        }
        return null; // 未命中
    }

    public void put (Key key, Value val) {
        // 查找给定的键，找到则更新其值，否则在表中新建结点
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) { // 命中，更新
                x.val = val;
                return;
            }
        }
        first = new Node(key, val, first); // 未命中，新建结点
    }

}
