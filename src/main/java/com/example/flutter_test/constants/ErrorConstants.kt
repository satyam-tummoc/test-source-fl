package com.example.flutter_test.constants

import com.example.flutter_test.logError
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel

enum class ErrorConstants(private val code: String, private val msg: String) {
    ACTIVITY_DIED("101", "Unable to find active flutter activity"),
    SDK_AUTH_ERROR("105", "Unable to authenticate token");

    fun pushErrorToFlutter(call: MethodCall, result: MethodChannel.Result) {
        result.error(code, msg, "method ${call.method}")
    }

    fun logErrorToAndroid(): Unit = logError(msg)

    override fun toString(): String {
        return "error_code=$code, message=$msg"
    }
}