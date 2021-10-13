package chapter01.bag;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * @author 文进
 * @version 1.0
 */
public class Bag<Item> implements Iterable<Item>{
    Bag(){

    }
    void add(Item item) {

    }

    boolean isEmpty(){
        return true;
    }

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
}
