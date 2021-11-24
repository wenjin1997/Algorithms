package chapter03;

import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author 文进
 * @version 1.0
 * 简单的符号表测试用例(P233)
 */
public class STTest {
    public static void main(String[] args) {
        ST<String, Integer> st;
        st = new ST<>();

        String example1 = "SEARCHEXAMPLE";

        for (int i = 0; i < example1.length(); i++) {
            String key = example1.substring(i, i + 1);
            st.put(key, i);
        }

        for (String s : st.keys()) {
            StdOut.println(s + " " + st.get(s));
        }
    }
}
