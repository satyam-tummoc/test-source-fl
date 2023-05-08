#include <jni.h>
#include <string>

extern "C" {
/*jstring
Java_com_AppModule_baseUrlFromJNI(
        JNIEnv *env, jclass clazz) {
    std::string baseURL = "https://dev-api.tummoc.in/";
    return env->NewStringUTF(baseURL.c_str());
}*/
// Attributes to prevent 'unused' function from being removed and to make it visible
__attribute__((visibility("default"))) __attribute__((used))
const char* bmtcPassUrl() {
    return "https://stage-dev-api.tummoc.in/";
}

int32_t native_add(int32_t x, int32_t y) {
    return x + y;
}
}