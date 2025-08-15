package com.hotrestart

import android.content.Intent
import android.util.Log

import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.module.annotations.ReactModule

@ReactModule(name = HotRestartModule.NAME)
class HotRestartModule(reactContext: ReactApplicationContext) :
  NativeHotRestartSpec(reactContext) {

  override fun getName(): String {
    return NAME
  }

  override fun restart() {
    try {
      val launchIntent = reactApplicationContext
        .packageManager
        .getLaunchIntentForPackage(reactApplicationContext.packageName)

      if (launchIntent != null) {
        val mainIntent = Intent.makeRestartActivityTask(launchIntent.component)
        reactApplicationContext.startActivity(mainIntent)
        Runtime.getRuntime().exit(0)
      } else {
        Log.e(NAME, "Launch intent not found for package: ${reactApplicationContext.packageName}")
      }
    } catch (e: Exception) {
      Log.e(NAME, "Error restarting app", e)
    }
  }

  companion object {
    const val NAME = "HotRestart"
  }
}
