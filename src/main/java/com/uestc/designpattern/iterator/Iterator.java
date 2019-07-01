package com.uestc.designpattern.iterator;

public interface Iterator<E> {
    /**
     * 是否还存在下一个元素， 存在返回true, 否则返回false
     * @return
     */
    boolean hasNext();

    /**
     * 返回下一个元素，且更新索引指向下下个元素。
     * @return
     */
    E next();

    default void remove() {
        throw new UnsupportedOperationException("remove");
    }

}
