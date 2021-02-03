#include <jni.h>
#include <string>
#define  UTILS_H
#include <unistd.h>


extern "C" JNIEXPORT jdouble JNICALL
Java_com_example_teste2_MainActivity_precoJNI(JNIEnv *env, jobject thiz, jdouble a ) {



    return  (a * 3.5);


}
