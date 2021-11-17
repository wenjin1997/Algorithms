package chapter02;

import edu.princeton.cs.algs4.StdRandom;

/**
 * @author 文进
 * @version 1.0
 * 三向切分的快速排序(P189)
 */
public class Quick3way {
    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);  // 消除对输入的依赖
        sort(a, 0, a.length - 1);
    }

    // 三向切分的关键代码
    public static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int lt = lo, i = lo + 1, gt = hi;
        Comparable v = a[lo];
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0) exch(a, lt++, i++);
            else if (cmp > 0) exch(a, i, gt--);
            else i++;
        } // 现在 a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi]成立
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
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
            if (less(a[i], a[i - 1])) return false;
        }
        return true;
    }

    public static void main(String[] args) { // 从标准输入读取字符串，将它们排序并输出
        String[] a = {"R", "B", "W", "W", "R", "W", "B", "R", "R", "W", "B", "R"};
        sort(a);
        assert isSorted(a);
        show(a);
    }

}
