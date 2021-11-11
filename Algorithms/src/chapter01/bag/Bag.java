package chapter01.bag;

import java.util.HashMap;
import java.util.Iterator;
import java.util.function.Consumer;

/**
 * @author 文进
 * @version 1.0
 */
public class Bag<Item> implements Iterable<Item>{
    private Node first; // 链表的首结点
    private class Node{
        Item item;
        Node next;
    }
    public void add(Item item){
        // 和Stack的push()方法完全相同
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
    }


    @Override
    public Iterator<Item> iterator() {
        return null;
    }

    private class ListIterator implements Iterator<Item>{
        private Node current = first;
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
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
}
