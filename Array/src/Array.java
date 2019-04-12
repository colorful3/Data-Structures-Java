public class Array {

    private int[] data;
    private int size;

    public Array() {
        this(10);
    }

    /**
     * 构造函数，传入数组容量capacity构造Array
     * @param capacity 数组容量
     */
    public Array(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    /**
     * 获取数组中的元素个数
     * @return 数组元素个数
     */
    public int getSize() {
        return size;
    }

    /**
     * 获取数组的容量
     * @return 数组容量
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 向所有元素后添加一个新元素
     * @param e 要添加的额元素
     */
    public void addFirst(int e) {
        add(0, e);
    }

    /**
     * 想所有元素的后面添加一个新元素
     * @param e 要添加的元素
     */
    public void addLast(int e) {
        add(size, e);
    }

    public void add(int index, int e) {

        if(size == data.length)
            throw new IllegalArgumentException("AddLst failed. Array is full");

        if(index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. index is illegal");

        for(int i=size - 1; i >= index; i --) {
            data[i] = data[i-1];
            data[i + 1] = data[i];
        }

        data[index] = e;
        size ++;

    }

    /**
     * 判断数组是否为空
     * @return boolean
     */
    public boolean isEmpty() {
        return size == 0;
    }

}
