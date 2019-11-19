package com.qinglianyun.kotlin.class4

import java.lang.IllegalArgumentException

/**
 * Created by gzg on 2019/11/18.
 * function: 面向对象-抽象类和接口
 */
interface InputDevice {
    fun input(event: Any)
}

interface USBInputDevice : InputDevice

interface BLEInputDevice : InputDevice

class USBMouse(val name: String) : USBInputDevice, OpticalDevice {
    override fun input(event: Any) {

    }

    override fun toString(): String {
        return name
    }
}

interface OpticalDevice

class Computer {
    fun addUSBInputDevice(inputDevice: USBInputDevice) {
        println("use usb input device $inputDevice")
    }

    fun addBLEInputDevice(inputDevice: BLEInputDevice) {
        print("use ble input device $inputDevice")
    }

    fun addInputDevice(inputDevice: InputDevice) {
        when (inputDevice) {
            is USBInputDevice -> {
                addUSBInputDevice(inputDevice)
            }
            is BLEInputDevice -> {
                addBLEInputDevice(inputDevice)
            }
            else -> {
                throw IllegalArgumentException("输入的参数类型不支持")
            }
        }
    }
}

fun main(args: Array<String>) {

    val computer = Computer()
    val useUSBMouse = USBMouse("逻辑的鼠标")
    computer.addUSBInputDevice(useUSBMouse)
}