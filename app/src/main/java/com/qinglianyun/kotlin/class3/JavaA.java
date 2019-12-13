package com.qinglianyun.kotlin.class3;

import android.support.annotation.Nullable;

import java.util.List;
import java.util.concurrent.locks.Lock;

/**
 * Created by gzg on 2019/11/14.
 * function:
 */
public class JavaA<T extends Object> {

    public JavaA() {

    }

    public JavaA(int a) {

    }

    public JavaA(int a, String b) {

    }

    private T a;

    private int b;

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public void aVoid(List<? extends Integer> a) {


    }

    public <T extends Number> Object aVoid1(List<T> a) {

        short s = 0;
        int i = 0;
        long l = 0;
        i = s;
        l = i;
        l = s;
        return "";
    }

    public <T extends Number> void aVoid3(List<T> a) {

    }

    public String getName() {
        return null;
    }


}
