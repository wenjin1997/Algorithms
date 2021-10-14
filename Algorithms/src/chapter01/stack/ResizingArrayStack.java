package chapter01.stack;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * @author 文进
 * @version 1.0
 * 下压栈(LIFO)
 * 能够动态调整数组大小的实现
 */
public class ResizingArrayStack<Item> implements Iterable<Item>{
    private Item[] a = (Item[]) new Object[1]; // 栈元素
    public int N = 0; // 元素数量
    public boolean isEmpty() {
        return N == 0;
    }
    public int size() {
        return N;
    }
    public void resize(int max) {
        // 将栈移动到一个大小为max的新数组
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }
    public void push(Item item){
        // 将元素添加到栈项
        if (N == a.length) resize(a.length * 2);
        a[N++] = item;
    }
    public Item pop(){
        // 从栈顶删除元素
        Item item = a[--N];
        a[N] = null; // 避免对象游离
        if (N > 0 && N == a.length/4) resize(a.length / 2);
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    // 内部类
    private class ReverseArrayIterator implements Iterator<Item>{
        // 支持后进先出的迭代
        private int i = N;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            return a[--i];
        }

        @Override
        public void remove() {
            Iterator.super.remove();
        }

        @Override
        public void forEachRemaining(Consumer<? super Item> action) {
            Iterator.super.forEachRemaining(action);
        }
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
