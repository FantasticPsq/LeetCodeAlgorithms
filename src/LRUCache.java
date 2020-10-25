import java.util.HashMap;

class LRUCache{
    private HashMap<Integer,NodeSecond> map;
    private DoubleList cache;
    private int cap;
    public LRUCache(int capacity){
        this.cap = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }
    private void makeRecently(int key){
        NodeSecond x = map.get(key);
        cache.remove(x);
        cache.addLast(x);
    }
    public void addRecently(int key,int val){
        NodeSecond NodeSecond = new NodeSecond(key,val);
        cache.addLast(NodeSecond);
        map.put(key,NodeSecond);
    }
    private void deleteKey(int key){
        NodeSecond NodeSecond = map.get(key);
        cache.remove(NodeSecond);
        map.remove(key);
    }
    public void removeLeastRecently(){
        NodeSecond deleteNodeSecond = cache.removeFirst();
        int deletekey = deleteNodeSecond.key;
        map.remove(deletekey);
    }
    public int get(int key){
        if(!map.containsKey(key)){
            return -1;
        }
        makeRecently(key);
        return map.get(key).val;
    }
    public void put(int key,int val){
        if(map.containsKey(key)){
            deleteKey(key);
            addRecently(key,val);
            return;
        }
        if(cache.size()>=cap){
            removeLeastRecently();
        }
        addRecently(key,val);
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));      // 返回  1
        cache.put(3, 3);    // 该操作会使得关键字 2 作废
        System.out.println(cache.get(2));       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得关键字 1 作废
        System.out.println(cache.get(1));      // 返回 -1 (未找到)
        System.out.println(cache.get(3));;       // 返回  3
        System.out.println(cache.get(3));;       // 返回  4
    }
}

class NodeSecond{
    NodeSecond next;
    NodeSecond pre;
    int key,val;
    public NodeSecond(int k,int v){
        this.key = k;
        this.val = v;
    }
}
// 通过NodeSecond构造双向链表
class DoubleList{
    private NodeSecond head;
    private NodeSecond tail;
    private int size;
    public DoubleList(){
        head = new NodeSecond(0,0);
        tail = new NodeSecond(0,0);
        head.next = tail;
        tail.pre = head;
        size = 0;
    }
    public void addLast(NodeSecond x){
        x.next = tail;
        x.pre = tail.pre;
        tail.pre.next = x;
        tail.pre = x;
        size++;
    }
    // 不要直接这样删除第一个，最好先写个remove函数
    // public NodeSecond removeFirst(){
    //     if(head.next.next != null){
    //         head.next = head.next.next;
    //         head.next.next.pre = head;
    //         size--;
    //         return head.next;
    //     }else{
    //         return null;
    //     }
    // }
    public void remove(NodeSecond NodeSecond){
        NodeSecond.pre.next = NodeSecond.next;
        NodeSecond.next.pre = NodeSecond.pre;
        size--;
    }
    public NodeSecond removeFirst(){
        if(head.next==tail){
            return null;
        }
        NodeSecond first = head.next;
        remove(first);
        return first;
    }
    public int size(){
        return size;
    }
}
