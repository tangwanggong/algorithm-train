package day9;


import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/lru-cache/
 * @date 2022/2/18
 */
public class LRUCache {
    private int max;
    private DoubleList doubleList;
    private Map<Integer,Node> map;
    public LRUCache(int capacity) {
        max = capacity;
        doubleList = new DoubleList();
        map = new HashMap<>();
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        // 因为get了,所以维持key为最新
        makeRecently(key);
        return map.get(key).v;
    }

    public void put(int key, int value) {
        // 当存在key时
        if(map.containsKey(key)){
            // 删除key
            deleteKey(key);
            // 并添加到最新，保持key为最新使用
            addRecently(key,value);
            return;
        }
        // 超过限制，删除最久未使用的节点
        if(doubleList.getSize()==max){
            removeLeastRecently();
        }
        // 添加到最新，保持key为最新使用
        addRecently(key,value);
    }

    // 维持key为最新
    private void makeRecently(int key){
        Node node = map.get(key);
        doubleList.remove(node);
        doubleList.addLast(node);
    }

    // 删除
    private void deleteKey(int k){
        Node node = map.get(k);
        doubleList.remove(node);
        map.remove(node.k);
    }

    // 添加到最新
    private void addRecently(int k,int v){
        Node newNode = new Node(k, v);
        doubleList.addLast(newNode);
        map.put(k,newNode);
    }

    // 删除最久未使用
    private void removeLeastRecently(){
        Node node = doubleList.removeFirst();
        map.remove(node.k);
    }

    class Node{
        private int k,v;
        private Node next, prev;
        public Node(int k, int v) {
            this.k = k;
            this.v = v;
        }
    }

    class DoubleList{
        // head,tail 两个虚节点
        Node head,tail;
        int size;
        public DoubleList() {
            head = new Node(0,0);
            tail = new Node(0,0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        // 添加到最后
        private void addLast(Node x){
            x.prev = tail.prev;
            x.next = tail;
            tail.prev.next = x;
            tail.prev = x;
            size++;
        }
        // 删除节点
        private void remove(Node x){
            x.prev.next = x.next;
            x.next.prev = x.prev;
            size--;
        }
        // 删除第一个节点
        private Node removeFirst(){
            if(head.next == tail){
                return null;
            }
            Node remove = head.next;
            remove(remove);
            return remove;
        }
        public int getSize(){
            return size;
        }
    }
}
