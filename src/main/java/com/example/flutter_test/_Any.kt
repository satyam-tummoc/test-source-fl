package com.example.flutter_test

import android.util.Log
import io.flutter.BuildConfig


fun Any.logError(msg: String){
    Log.e(this.toString(), msg)
}

fun logit(msg: Any? = "...") {
    if (BuildConfig.DEBUG) {
        val trace: StackTraceElement? = Thread.currentThread().stackTrace[3]
        val lineNumber = trace?.lineNumber
        val methodName = trace?.methodName
        val className = trace?.fileName?.replaceAfter(".", "")?.replace(".", "")

        if (BuildConfig.DEBUG) {
            Log.d("Line $lineNumber", "$className::$methodName() -> $msg")
        }
    }
}
