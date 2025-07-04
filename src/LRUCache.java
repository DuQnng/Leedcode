import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    class DLinkedNode{
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode(){}
        public DLinkedNode(int _key,int _value){key=_key;value=_value;}
    }
    private Map<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.size=0;
        this.capacity=capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node=cache.get(key);
        if(node==null)
        {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if(node==null){
            DLinkedNode dLinkedNode = new DLinkedNode(key,value);
            cache.put(key,dLinkedNode);
            addTohead(dLinkedNode);
            ++size;
            if(size>capacity)
            {
                DLinkedNode tail = removeTail();
                cache.remove(tail.key);
                --size;
            }
        }else {
            node.value=value;
            moveToHead(node);
        }
    }
    private void removeNode(DLinkedNode node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
    private void addTohead(DLinkedNode node){
        head.next.prev=node;
        node.next=head.next;
        node.prev=head;
        head.next=node;
    }
    private void moveToHead(DLinkedNode node){
        removeNode(node);
        addTohead(node);
    }
    private DLinkedNode removeTail(){
        DLinkedNode res=tail.prev;
        removeNode(res);
        return res;
    }
}
