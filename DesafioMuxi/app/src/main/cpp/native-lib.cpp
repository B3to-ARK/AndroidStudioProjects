#include <jni.h>
#include <string>

extern "C" JNIEXPORT jdouble JNICALL
Java_com_example_desafiomuxi_MainActivity_precoJNI(JNIEnv *env, jobject thiz, jdouble a ) {
    return (a * 3.5);
}