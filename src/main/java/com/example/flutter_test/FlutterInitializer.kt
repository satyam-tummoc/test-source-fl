package com.example.flutter_test

import android.app.Activity
import io.flutter.embedding.engine.FlutterEngine

/**
 *  [initialize] - Calls
 * 1. First start of Activity
 * 2. Recreate of Activity by IPC or LMKD
 *
 * [cleanup] - Calls
 * 1. Only if activity cleared from stack
 */
interface FlutterInitializer {

    fun initialize(activity: Activity?, flutterEngine: FlutterEngine)

    fun cleanup()
}