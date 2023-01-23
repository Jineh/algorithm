class Node {
    public int data;
    public Node prev;
    public Node next;

    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class S12304 {

    private final static int MAX_NODE = 10000;

    private Node[] node = new Node[MAX_NODE];
    private int nodeCnt = 0;
    private Node head;
    private Node tail;

    public Node getNode(int data) {
        node[nodeCnt] = new Node(data);
        return node[nodeCnt++];
    }

    public void init() {
        nodeCnt=0;
        head = new Node(-1);
        tail = new Node(-1);

        head.next = tail;
        tail.prev = head;
    }

    public void addNode2Head(int data) {
        Node node = getNode(data);
        Node cur = head.next;
        cur.prev = node;
        node.next = cur;
        head.next = node;
        node.prev = head;

    }

    public void addNode2Tail(int data) {
        Node node = getNode(data);
        Node cur = tail.prev;
        cur.next = node;
        node.prev = cur;
        tail.prev = node;
        node.next = tail;
    }

    public void addNode2Num(int data, int num) {
        Node node = getNode(data);
        Node pre = head;
        Node cur = head.next;

        while(num-->1){
            pre = cur;
            cur = cur.next;
        }

        cur.prev = node;
        node.next = cur;
        pre.next = node;
        node.prev = pre;
    }

    public int findNode(int data) {
        Node head = this.head;
        int i=0;
        while(head.next!=tail){
            head = head.next;
            ++i;
            if(head.data==data) break;
        }
        return i;
    }

    public void removeNode(int data) {
        Node pre = head;
        Node cur = head.next;
        while(cur!=tail){
            if(cur.data==data){
                cur=cur.next;
                pre.next = cur;
                cur.prev = pre;
                break;
            }
            pre = cur;
            cur = cur.next;
        }
    }

    public int getList(int[] output) {
        int cnt=0;
        Node cur = head;
        while(cur.next!=tail){
            cur = cur.next;
            output[cnt++] = cur.data;
        }
        return cnt;
    }

    public int getReversedList(int[] output) {
        int cnt=0;
        Node cur = tail;
        while(cur.prev!=head){
            cur = cur.prev;
            output[cnt++] = cur.data;
        }
        return cnt;
    }
}
