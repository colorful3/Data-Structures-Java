public class LinkedList<E> {

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead;
    int size;

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    /**
     * 获取链表中的元素个数
     * @return 链表中的元素个数
     */
    public int getSize() {
        return size;
    }

    /**
     * 链表是否为空
     * @return boolean
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在链表的index（0-based）位置添加新的元素e
     * @param index int 索引位置
     * @param e E 待添加的元素
     */
    public void add(int index, E e) {
        if(index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Illegal index.");

        Node prev = dummyHead;
        for(int i=0; i<index; i++)
            prev = prev.next;

//            Node node = new Node(e);
//            node.next = prev.next;
//            prev.next = node;
        prev.next = new Node(e, prev.next);
        size ++;
    }

    /**
     * 在链表头添加新元素e
     * @param e E 待添加的元素
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 在链表末尾添加新的元素e
     * @param e E 待添加的元素
     */
    public void addLast(E e) {
        add(size, e);
    }
}
