package com.qinglianyun.kotlin.class4;

/**
 * Created by gzg on 2019/11/19.
 * function：对应kotlin object对象单例实现
 */
public class MusicPlayerJava {

    public static MusicPlayerJava INSTANCE;

    static {
        INSTANCE = new MusicPlayerJava();
    }

    private MusicPlayerJava() {

    }


}
