package chapter01;

public class Counter {
    private final String name;
    private int count;
    public Counter(String id) {
        name = id;
    }
    public void increment() {
        count++;
    }
    public int tally() {
        return count;
    }

    public String toString() { //重载默认实现
        return count + " " + name;
    }

    public static void main(String[] args) {
        Counter heads = new Counter("heads");
        Counter tails = new Counter("tails");

        heads.increment();
        heads.increment();
        tails.increment();

        System.out.println(heads + " " + tails); //自动调用toString()方法
        System.out.println(heads.tally() + tails.tally());
    }
}

