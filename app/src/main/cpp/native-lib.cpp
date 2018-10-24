#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring

JNICALL
Java_com_example_mc_androiddemo_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    jclass clazz = env->FindClass("com/example/mc/androiddemo/MainActivity");

    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}
