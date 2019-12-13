package com.qinglianyun.kotlin;

/**
 * Created by gzg on 2019/12/10.
 * function:
 */
public class Pair<T> {
    private T first;

    private T second;

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }

    public void setSecond(Pair<? extends Employee> pair) {
        Manager manager = new Manager();
//        print(new Pair<Manager>());//error
        print1(new Pair<Manager>());
    }

    public static void print(Pair<Employee> pair) {

        Employee employee1 = pair.first;
        Employee employee2 = pair.second;
    }

    public static void print1(Pair<? extends Employee> pair) {

        Employee employee1 = pair.first;
        Employee employee2 = pair.second;
    }

}
