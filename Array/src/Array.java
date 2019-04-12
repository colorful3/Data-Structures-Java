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

    void add(int index, int e) {

        if(size == data.length)
            throw new IllegalArgumentException("AddLst failed. Array is full");

        if(index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Require index >=0 and <=size");

        for(int i=size - 1; i >= index; i --) {
            data[i + 1] = data[i];
        }

        data[index] = e;
        size ++;

    }

    /**
     * 获取index索引位置的元素
     * @param index 索引
     * @return index索引位置的元素
     */
    int get(int index) {
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        return data[index];
    }

    /**
     * 修改index索引位置的元素为e
     * @param index 索引
     * @param e 要修改的元素
     */
    void set(int index, int e) {
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        data[index] = e;
    }

    /**
     * 判断数组是否为空
     * @return boolean
     */
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
        res.append('[');
        for(int i=0; i<size; i++) {
            res.append(data[i]);
            if(i != size - 1) {
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }

}
