package chapter01.stack;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Scanner;

/**
 * @author 文进
 * @version 1.0
 * 一种表示定容字符串栈的抽象数据类型
 */
public class FixedCapacityStackOfStrings {
    private String[] a; // stack entries
    private int N; // size

    public FixedCapacityStackOfStrings(int cap) {
        a = new String[cap];
    }
    public boolean isEmpty() {
        return N == 0;
    }
    public int size(){
        return N;
    }
    public void push(String item) {
        a[N++] = item;
    }
    public String pop(){
        return a[--N];
    }

    public static void main(String[] args) {
        FixedCapacityStackOfStrings s;
        s = new FixedCapacityStackOfStrings(100);
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
