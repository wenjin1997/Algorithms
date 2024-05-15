package chapter02;

import edu.princeton.cs.algs4.In;

/**
 * @author 文进
 * @version 1.0
 * 排序算法类的模板(P153)
 */
public class Example {
    public static void sort(Comparable[] a) {
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i]; // 临时变量
        a[i] = a[j];
        a[j] = t;
    }
    private static void show(Comparable[] a) { // 在单行中打印数组
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
    public static boolean isSorted(Comparable[] a) { // 测试数组元素是否有序
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i-1])) return false;
        }
        return true;
    }

    public static void main(String[] args) { // 从标准输入读取字符串，将它们排序并输出
//        String[] a = In.readStrings();
        String[] a = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
