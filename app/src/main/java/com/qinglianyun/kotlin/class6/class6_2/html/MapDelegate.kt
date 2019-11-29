package com.qinglianyun.kotlin.class6.class6_2.html

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Created by gzg on 2019/11/26.
 * function:
 */
/**
 * ReadWriteProperty<R,T> R-reciver
 */
class MapDelegate(val map: MutableMap<String, String>) : ReadWriteProperty<Any, String> {
    override fun getValue(thisRef: Any, property: KProperty<*>): String {
        return map[property.name] ?: ""
    }

    override fun setValue(thisRef: Any, property: KProperty<*>, value: String) {
        map[property.name] = value
    }

}