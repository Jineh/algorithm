//class Node {
//    public int data;
//    public Node next;
//
//    public Node(int data) {
//        this.data = data;
//        this.next = null;
//    }
//}

public class UserSolution {

    private final static int MAX_NODE = 10000;

    private Node[] node = new Node[MAX_NODE];
    private int nodeCnt = 0;
    private Node head;

    public Node getNode(int data) {
        node[nodeCnt] = new Node(data);
        return node[nodeCnt++];
    }

    public void init() {
        head = new Node(-1);
        nodeCnt=0;
    }

    public void addNode2Head(int data) {
        Node node = getNode(data);
        node.next = head.next;
        head.next = node;
    }

    public void addNode2Tail(int data) {
        Node node = getNode(data);
        Node pre = head;
        while(pre.next!=null){
            pre=pre.next;
        }
        pre.next = node;
    }

    public void addNode2Num(int data, int num) {
        Node node = getNode(data);
        Node pre = head;
        Node current = head.next;
        int i=1;
        while(i<num){
            pre = current;
            current= current.next;
            i++;
        }
        node.next  = pre.next;
        pre.next = node;
    }

    public void removeNode(int data) {
        Node pre = head;
        Node current = head.next;
        while(current.next!=null && current.data !=data){
            pre = current;
            current = current.next;
        }
        if(current.data ==data) pre.next = current.next;
    }

    public int getList(int[] output) {
        int cnt=0;
        Node cur = head.next;
        while(cur.next!=null){
            output[cnt++] = cur.data;
            cur = cur.next;
        }
        output[cnt++] = cur.data;
        return cnt;
    }
}
