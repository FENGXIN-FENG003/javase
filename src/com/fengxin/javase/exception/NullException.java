package com.fengxin.javase.exception;

/**
 * @author FENGXIN
 **/
public class NullException {
    public static void main(String[] args) {
        String name = "FENG";
        name = null;
        // 异常处理
        try {
            System.out.println(name.length());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("程序运行结束");
        }

    }
}
