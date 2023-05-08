package com.example.flutter_test

import android.content.Context
import androidx.annotation.Keep
import androidx.core.content.ContextCompat.startActivity
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine

@Keep
open class EntryFlutterActivity : FlutterActivity(), FlutterInitializer by FlutterInitializerImpl {
    override fun onDestroy() {
        super.onDestroy()
        cleanup()
    }

    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        initialize(this, flutterEngine)
        super.configureFlutterEngine(flutterEngine)
    }

    @Keep
    companion object {

        /**
         * Flutter main entry point
         * closes engine after removed from screen
         *
         * [FlutterActivity.CachedEngineIntentBuilder] - custom engine
         * [FlutterActivity.NewEngineIntentBuilder] - default engine
         */

        @JvmStatic
        @Keep
        fun start(context: Context, key: String?) {
            context.apply {
                startActivity(
                    NewEngineIntentBuilder(
                        EntryFlutterActivity::class.java,
                    ).build(this).apply {
                        putExtra("token", key)
                    }
                )
            }
        }
    }
}