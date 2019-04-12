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
    public int get(int index) {
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        return data[index];
    }

    /**
     * 修改index索引位置的元素为e
     * @param index 索引
     * @param e 要修改的元素
     */
    public void set(int index, int e) {
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        data[index] = e;
    }

    /**
     * 查找数组中是否包含元素e
     * @param e 要查找的元素
     * @return boolean
     */
    public boolean contains(int e) {
        for(int i=0; i<size; i++) {
            if(data[i] == e)
                return true;
        }
        return false;
    }

    /**
     * 查找数组中元素e所在位置的索引，不弱不存在元素e，则返回-1
     * @param e 带查找的方法
     * @return int
     */
    public int find(int e) {
        for(int i=0; i<size; i++) {
            if(data[i] == e)
                return e;
        }
        return -1;
    }

    /**
     * 删除数组中索引index位置的元素，返回删除的元素
     * @param index 索引位置
     * @return 删除的元素
     */
    public int remove(int index) {
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Remove failed. Index is illegal.");
        int ret = data[index];
        for(int i=index+1; i<size; i++) {
            data[i-1] = data[i];
        }
        size --;
        return ret;
    }

    /**
     * 删除数组中第一个元素，返回删除的元素
     * @return 删除的元素
     */
    public int removeFirst() {
        return remove(0);
    }

    /**
     * 删除数组总最后一个元素，返回删除的元素
     * @return 删除的元素
     */
    public int removeLast() {
        return remove(size - 1);
    }

    /**
     * 从数组中删除元素e
     * @param e 待删除的元素
     */
    public void removeElement(int e) {
        int index = find(e);
        if(index != -1)
            remove(index);
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
