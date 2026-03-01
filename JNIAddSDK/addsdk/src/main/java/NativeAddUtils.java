package com.example.addsdk;

/**
 * 封装JNI的add方法，供App调用
 */
public class NativeAddUtils {

    // 加载C++编译生成的so库（名称必须和CMakeLists.txt中add_library的名称一致：addnative）
    static {
        try {
            System.loadLibrary("addnative");
        } catch (UnsatisfiedLinkError e) {
            // 捕获加载库失败的异常，方便调试
            throw new RuntimeException("加载addnative库失败：" + e.getMessage());
        }
    }

    // 声明native方法（和C++中的方法对应）
    // 参数：两个int，返回值：int（相加结果）
    public native int add(int a, int b);

    // 可选：封装一个静态方法，方便调用
    public static int calculateAdd(int a, int b) {
        NativeAddUtils utils = new NativeAddUtils();
        return utils.add(a, b);
    }
}