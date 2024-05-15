package chapter01.stack;

import edu.princeton.cs.algs4.StdOut;

import java.util.Scanner;

/**
 * @author 文进
 * @version 1.0
 * 一种表示泛型定容栈的抽象数据类型
 */
public class FixedCapacityStack<Item> {
    private Item[] a; // stack entries
    private int N; // size

    public FixedCapacityStack(int cap) {
        a = (Item[]) new Object[cap];
    }
    public boolean isEmpty() {
        return N == 0;
    }
    public int size() {
        return N;
    }
    public void push(Item item) {
        a[N++] = item;
    }
    public Item pop() {
        return a[--N];
    }

    public static void main(String[] args) {
        FixedCapacityStack<String> s;
        s = new FixedCapacityStack<>(100);
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNext("#")){
            String item = scanner.next();
            if (!item.equals("-")){
                s.push(item);
            }
            else if (!s.isEmpty()){
                StdOut.print(s.pop() + " ");
            }
        }
        StdOut.println("(" + s.size() + " left on stack)");
    }
}
