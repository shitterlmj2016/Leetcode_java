import java.util.HashMap;

/**
 * This is a comment!
 * 很重要!
 *
 * @class: LRUCache
 * @description: 146. LRU Cache
 * @author: Xincheng Huang - xinchenh
 * @create: 01-18-2019 10:11
 **/

/*

LRUCache cache = new LRUCache( 2  //capacity  );

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
        左边记录位置，右边记录放的数
        每次操作需要更新位置和放的数

        时间复杂度O(1)

        key value -> HashMap
        重新排序 ->double linked list
 */


public class LRUCache {

    class Node {
        int key;
        int val;
        Node next;
        Node prev;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private int capacity;
    private Node head;
    private Node tail;
    HashMap<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = null;
        tail = head;

    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null)
            return -1;

        if (node == tail)
            return node.val;

        if (node == head) {
            head = head.next;
        } else {//原先在里面得处理前后两个节点
            node.next.prev = node.prev;
            node.prev.next = node.next;
        }
        tail.next = node;
        node.prev = tail;
        node.next = null;
        tail = node;
        return node.val;
    }


    public void printMap() {

        for (Node n : map.values()
        ) {
            System.out.println(" Key: " + n.key + " val: " + n.val + "  ");
        }
    }

    public String toString() {
        Node node = head;
        StringBuilder sb = new StringBuilder();
        sb.append("Capacity: " + this.capacity + '\n');
        System.out.println("Head: " + head.key + " " + head.val);
        System.out.println("Tail: " + tail.key + " " + tail.val);
//        for (int i = 0; i < 3; i++) {
//            System.out.println("Key: " + node.key + " val: " + node.val + " | ");
//            node = node.next;
//        }

        while (node != null) {
            sb.append(" Key: " + node.key + " val: " + node.val + " | ");
            node = node.next;
        }
        return sb.toString();
    }

    /**
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        Node s = map.get(key);
        if (s == null) {
            //不存在这个节点，要加入
            if (capacity == 0) {//删除一个节点
                Node temp = head;
                map.remove(temp.key);
                head = head.next;
                capacity++;
                //tail 不需要改，永远是新加入的那一个
            }
            Node node = new Node(key, value);
            if (head == null && tail == null) //第一个结点
            {
                head = node;
                tail = node;
            } else {
                node.prev = tail;
                node.next = null;
                tail.next = node;
                tail = node;
            }
            capacity--;
            map.put(key, node);
        } else {

            //存在这个节点，要更新
            Node node = s;
            node.val = value;

            if (node == tail)
                return;
            if (node == head) {
                head = head.next;
            } else {//原先在里面得处理前后两个节点
                node.next.prev = node.prev;
                node.prev.next = node.next;
            }
            node.prev = tail;
            tail.next = node;
            node.next = null;
            tail = node;
        }
    }


    public static void main(String[] args) {
        LRUCache c = new LRUCache(3);
        c.put(1, 1);
        c.put(2, 2);
        c.put(3, 3);
        c.put(4, 4);
        System.out.println(c);
        c.get(4);
        System.out.println(c);
        c.get(3);
        System.out.println(c);
        c.get(2);

        c.get(1);
        c.put(5, 5);
        c.get(1);
        c.get(2);
        c.get(3);
        c.get(4);
        c.get(5);

        c.put(100, 3);
//        for (int i = 0; i < 100; i++) {
//            c.put(i, 200 - i);
//            System.out.println(c);
//            //c.put((int)Math.random(),(int)Math.random());
//        }


    }

}
