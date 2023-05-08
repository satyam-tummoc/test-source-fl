package com.example.flutter_test

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.annotation.Keep
import io.flutter.embedding.android.FlutterActivity
@Keep
object FlutterConfig {
    private var key: String? = null

    @Keep
    fun setKey(string: String) {
        key = string
    }

    @Keep
    fun open(activity: Activity) {
        EntryFlutterActivity.start(activity, key)
    }
}