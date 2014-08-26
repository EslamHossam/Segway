/*
 * Copyright (C) 2009 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
#include <string.h>
#include <jni.h>
#include <android/log.h>


#define  LOG_TAG    "LOG_TAG_JNI"
#define  LOGI(...)  __android_log_print(ANDROID_LOG_INFO,LOG_TAG,__VA_ARGS__)
#define  LOGE(...)  __android_log_print(ANDROID_LOG_ERROR,LOG_TAG,__VA_ARGS__)










/*
public void doSomething()
{
	this.myMemberVariable = 5;
}


*/
// in Java:
// public native String myNativeFunction();


jstring
Java_com_example_helloandroidjni_MainActivity_myNativeFunction
(JNIEnv* env, jobject thiz )
{
#if defined(__arm__)
  #if defined(__ARM_ARCH_7A__)
    #if defined(__ARM_NEON__)
      #define ABI "armeabi-v7a/NEON"
    #else
      #define ABI "armeabi-v7a"
    #endif
  #else
   #define ABI "armeabi"
  #endif
#elif defined(__i386__)
   #define ABI "x86"
#elif defined(__mips__)
   #define ABI "mips"
#else
   #define ABI "unknown"
#endif

	return (*env)->NewStringUTF(env, "Hello from JNI !  Compiled with ABI " ABI ".");
}













jstring Java_com_example_helloandroidjni_MainActivity_multiHopFunction( JNIEnv* env, jobject obj){

    jstring jstr = (*env)->NewStringUTF(env, "Hello from multiHopFunction");
    jclass clazz = (*env)->FindClass(env, "com/example/helloandroidjni/MainActivity");
    jmethodID myJavaFunction = (*env)->GetMethodID(env, clazz, "myJavaFunction", "(Ljava/lang/String;)Ljava/lang/String;");
    jobject result = (*env)->CallObjectMethod(env, obj, myJavaFunction, jstr);

    const char* str = (*env)->GetStringUTFChars(env,(jstring) result, NULL); // should be released but what a heck, it's a tutorial :)
    printf("%s\n", str);

    return (*env)->NewStringUTF(env, str);
}
