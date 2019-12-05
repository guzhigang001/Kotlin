package com.qinglianyun.kotlin;

import retrofit2.http.PUT;

/**
 * Created by gzg on 2019/12/5.
 * function:
 */
public class B1<T> {
    public T key;

    public B1(T key) {
        this.key = key;
    }

    public void a(T a) {

    }
//    public static void d(T a){
//
//    }
    public static <T> void d(T a){

    }

    public <E> E getKey() {

        return null;

    }
    public <V> void show_2(V t){
        System.out.println(t.toString());
    }

    public void e(B1<? extends Number> a){
    }
    public void q(B1 a){
    }

    public static void main(String[] args){
        B1<String> b=new B1<>("1");
        b.show_2(2);
        b.a("a");
        b.e(new B1<Number>(2));
        b.q(b);
    }
}
