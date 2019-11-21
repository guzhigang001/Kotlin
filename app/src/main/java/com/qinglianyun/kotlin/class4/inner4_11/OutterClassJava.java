package com.qinglianyun.kotlin.class4.inner4_11;

/**
 * Created by gzg on 2019/11/20.
 * function:
 */
public class OutterClassJava {
    private int a;

    class InnerClass {
        private int a;

        public void hello() {
            System.out.println(OutterClassJava.this.a);
            System.out.println(this.a);
        }
    }

    public static void main(String[] args) {
        OutterClassJava outterClassJava = new OutterClassJava();
        InnerClass innerClass = outterClassJava.new InnerClass();//通过外部类的引用创建
    }
}

class OutterClassJava1 {
    private int a;

    static class InnerClass {
        private int a;

        public void hello() {
//            System.out.println(OutterClassJava1.this.a);//访问不到
            System.out.println(this.a);
            OutterClassJava1 outterClassJava = new OutterClassJava1();
            System.out.println(outterClassJava.a);
        }
    }

    public static void main(String[] args) {

        InnerClass innerClass = new InnerClass();//通过不需要外部类的引用创建
    }
}

