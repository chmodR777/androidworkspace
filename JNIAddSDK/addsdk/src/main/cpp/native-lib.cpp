//
// Created by tangke on 2026/3/1.
//
#include <jni.h>
#include <string>
// 可选：引入log库，用于C++打印日志
#include <android/log.h>

// 定义日志宏（方便调试）
#define LOG_TAG "JNI_Add_SDK"
#define LOGD(...) __android_log_print(ANDROID_LOG_DEBUG, LOG_TAG, __VA_ARGS__)

// JNI方法命名规则：Java_包名_类名_方法名（包名中的.替换为_）
// 参数说明：
// JNIEnv* env：JNI环境指针，用于调用JNI函数
// jobject thiz：调用该方法的Java对象（如果是静态方法则是jclass）
// jint a/jint b：Java传入的int类型参数（JNI中int对应jint）
extern "C" JNIEXPORT jint JNICALL
Java_com_example_addsdk_NativeAddUtils_add(
        JNIEnv* env,
        jobject thiz,
        jint a,
        jint b) {
    // 打印日志（可选，调试用）
    LOGD("C++接收到的参数：a=%d, b=%d", a, b);
    // 实现相加逻辑
    jint result = a + b;
    LOGD("C++计算结果：%d", result);
    return result;
}