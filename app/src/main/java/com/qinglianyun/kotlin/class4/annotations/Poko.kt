package com.qinglianyun.kotlin.class4.annotations

/**
 * Created by gzg on 2019/11/19.
 * function:
 */

annotation class Poko


annotation class Poko2

@Target(AnnotationTarget.FIELD)
annotation class Poko3

@Target(AnnotationTarget.FIELD)
annotation class Poko4

@Target(AnnotationTarget.PROPERTY)
annotation class Poko5

