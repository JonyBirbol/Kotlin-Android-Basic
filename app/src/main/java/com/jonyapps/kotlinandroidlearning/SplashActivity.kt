package com.jonyapps.kotlinandroidlearning

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {

    // This is the loading time of the splash screen
    private val SPLASH_TIME_OUT:Long = 1000 // 1 sec = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.z_activity_splash)


        Handler().postDelayed({
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }, SPLASH_TIME_OUT)
    }
}

// Notes:
//Credit: https://levelup.gitconnected.com/a-tutorial-on-building-a-splash-screen-with-kotlin-in-android-studio-dc647cd52f9b
// 1. Created style for the splash screen - values folder>styles.xml
//2. Designed the Splash Screen > see here layout folder> z_activity_splash.xml
//3. added below lines to AndroidManifest.xml
      //  <activity android:name=".SplashActivity"
      //  android:theme="@style/AppTheme.NoActionBar">
       // <intent-filter>
       // <action android:name="android.intent.action.MAIN" />
       // <category android:name="android.intent.category.LAUNCHER" />
       // </intent-filter>
       // </activity>
//4. keep MainActivity in AndroidManifest.xml as below
// <activity android:name=".MainActivity"/>




