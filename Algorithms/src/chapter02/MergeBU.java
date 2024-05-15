package chapter02;

/**
 * @author 文进
 * @version 1.0
 * 自底向上的归并排序(P175)
 */
public class MergeBU {
    private static Comparable[] aux; // 归并所需的辅助数组

    public static void sort(Comparable[] a) {
        // 进行logN次两两归并
        int N = a.length;
        aux = new Comparable[N];
        for (int sz = 1; sz < N; sz = sz + sz) { // sz子数组的大小
            for (int lo = 0; lo < N - sz; lo += sz + sz) { // lo:子数组索引
                merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz -1, N - 1));
            }
        }
    }
    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        // 将a[lo...mid]和a[mid+1...hi]归并
        int i = lo, j = mid + 1;
        Comparable[] aux = new Comparable[a.length];
        for (int k = lo; k <= hi; k++) {
            // 将a[lo...hi]复制到aux[lo...hi]
            aux[k] = a[k];
        }
        for (int k = lo; k <= hi; k++) {
            // 归并回到a[lo...hi]
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
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
        String[] a = {"E", "E", "G", "M", "R", "A", "C", "E", "R", "T"};
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
