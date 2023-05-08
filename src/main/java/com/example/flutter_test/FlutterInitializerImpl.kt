package com.example.flutter_test

import android.app.Activity
import android.content.Intent
import com.example.flutter_test.constants.ErrorConstants
import com.example.flutter_test.constants.MethodConstants
import com.example.flutter_test.constants.ResultConstants
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import java.lang.ref.WeakReference

object FlutterInitializerImpl : FlutterInitializer, MethodChannel.MethodCallHandler {

    private const val TAG = "FlutterInitializer"
    private const val CHANNEL = "com.example.modulefl"

    // var
    private var mActivityRef: WeakReference<Activity>? = null

    override fun initialize(activity: Activity?, flutterEngine: FlutterEngine) {

        activity?.also {
            if (mActivityRef?.get() != it) {
                mActivityRef?.clear()
                mActivityRef = WeakReference(it)
            }
            flutterEngine.apply {
                MethodChannel(
                    dartExecutor.binaryMessenger,
                    CHANNEL
                ).setMethodCallHandler(this@FlutterInitializerImpl)
            }
        } ?: logError("Unable to acquire activity")
    }

    override fun cleanup() {
        mActivityRef?.clear()
    }

    override fun onMethodCall(call: MethodCall, result: MethodChannel.Result) {
        logit("Method ${call.method}")

        val activity = mActivityRef?.get() ?: run {
            ErrorConstants.ACTIVITY_DIED.apply {
                pushErrorToFlutter(call, result)
                logErrorToAndroid()
            }
            return
        }

        when (call.method) {
            MethodConstants.token -> {
                result.success(activity.intent.getStringExtra("token"))
            }
            MethodConstants.coreFlutterAuthFailed -> {
                ErrorConstants.SDK_AUTH_ERROR.logErrorToAndroid()
            }


            else -> result.notImplemented()
        }
    }
}