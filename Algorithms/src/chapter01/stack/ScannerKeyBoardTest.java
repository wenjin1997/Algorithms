package chapter01.stack;

import java.util.Scanner;

/**
 * @author 文进
 * @version 1.0
 */
public class ScannerKeyBoardTest {
    public static void main(String[] args)
    {
        System.out.println("请输入若干单词，以空格作为分隔");
        Scanner sc = new Scanner(System.in);
        while(!sc.hasNext("#"))  //匹配#返回true,然后取非运算。即以#为结束符号
        {
            System.out.println("键盘输入的内容是：" + sc.next());
        }
        System.out.println("会执行的");
    }

}
