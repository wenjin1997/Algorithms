package com.jinjin.bag_queue_stack;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * @author 文进
 * @version 1.0
 */
public class Bag<Item> implements Iterable<Item> {

    //创建一个空背包
    Bag(){

    }

    //添加一个元素
    void add(Item item){

    }

    //背包是否为空
    boolean isEmpty() {
        return true;
    }

    //背包中的元素数量
    int size(){
        return 1;
    }
    @Override
    public Iterator<Item> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super Item> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<Item> spliterator() {
        return Iterable.super.spliterator();
    }
}
