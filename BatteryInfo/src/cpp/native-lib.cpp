#include <jni.h>
#include <string>

extern "C" JNIEXPORT jint JNICALL

Java_com_example_mylibrary_calculator_SumTwoInt_sumTwoValues(JNIEnv *env, jobject obj, jint a, jint b) {
    return (a + b);
}
