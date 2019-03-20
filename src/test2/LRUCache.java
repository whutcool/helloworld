/**
 * 基于HashMap和双链表实现LRU
 */
import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> {
	class Node<K, V> {
		Node pre;
		Node next;
		private final K key;
		V val;
		
		Node(K k, V v) {
			key = k;
			val = v;
		}
	}
	Map<K, Node> map = new HashMap<K, Node>();
	// the head(the eldest) of the doubly linked list.
	Node head;
	// the tail(the youngest) of the doubly linked list.
	Node tail;
	
	int cap;
	
	public LRUCache(int capacity) {
		cap = capacity;
		head = new Node(null, null);
		tail = new Node(null, null);
		head.next = tail;
		tail.pre = head;
	}
	
	public V get(K key) {
		Node n = map.get(key);
		if (n != null) {
			removeNode(n);
			appendTail(n);
			return (V) n.val;
		}
		return null;
	}
	
	public void set(K key, V value) {
		Node n = map.get(key);
		if (n != null) {
			n.val = value;
			map.put(key, n);
			removeNode(n);
			appendTail(n);
			return;
		}
	}
	
	// 移除最近最少使用的节点，此节点就是head.next指向的节点
	public void removeLast(){
		Node temp = head.next;
		removeNode(temp);
		map.remove(temp.key);
	}
	
	// 移除某个节点，并将此节点的前后节点连接起来
	private void removeNode(Node n) {
		n.pre.next = n.next;
		n.next.pre = n.pre;
	}
	// 将节点移到队列的尾部，队列的尾部代表最近使用的节点
	private void appendTail(Node n) {
		n.next = tail;
		n.pre = tail.pre;
		tail.pre.next = n ;
		tail.pre = n;
	}
	
	public static void main(String[] args) {
		LRUCache<Integer, Integer> cache = new LRUCache<>(3);
		cache.set(1, 1);
		cache.set(2, 2);
		cache.set(3, 3);
		cache.set(4, 4);
		cache.set(5, 5);
		System.out.println(cache.head.val);
	}
}
