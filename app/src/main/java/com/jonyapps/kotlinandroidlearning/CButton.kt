package com.jonyapps.kotlinandroidlearning

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.jonyapps.kotlinandroidlearning.Adapter.CMyBroadcastReceiver
import kotlinx.android.synthetic.main.c_button.*


class CButton : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.c_button)

//Credit: https://developer.android.com/training/notify-user/build-notification

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = getString(R.string.channel_name)
            val descriptionText = getString(R.string.channel_description)
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(
                "kotlinandroidlearning" /* This is CHANNEL_ID */,
                name,
                importance
            )
                .apply {
                    description = descriptionText
                }
            // Register the channel with the system
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }

//Notification: Simple Notification 1
        button1_1.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            }
            val pendingIntent: PendingIntent = PendingIntent.getActivity(this, 0, intent, 0)

            val builder =
                NotificationCompat.Builder(this, "kotlinandroidlearning" /* This is CHANNEL_ID */)
                    .setSmallIcon(R.mipmap.ic_launcher_round)
                    .setContentTitle("My notification")
                    .setContentText("Simple Notification")
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                    .setContentIntent(pendingIntent)
                    .setAutoCancel(true)
            with(NotificationManagerCompat.from(this)) {
                // notificationId is a unique int for each notification that you must define
                notify(0/* This is notificationId */, builder.build())
            }


//Notification: Simple Notification With Button 2

//Note: 1. Create CMyBroadcastReceiver.kt file (see in the Adapter folder)
//2. Add this line to Manifest.xml file  <receiver android:name=".Adapter.CMyBroadcastReceiver"/>

            button1_12.setOnClickListener {
                val snoozeIntent = Intent(this, CMyBroadcastReceiver::class.java).apply {
                    // action = ACTION_SNOOZE
                    //putExtra("EXTRA_NOTIFICATION_ID", "Button Pressed")//EXTRA_NOTIFICATION_ID
                    action = "Do Pending Task"
                    putExtra("My Favorite Color", "RED Color")
                }
                val snoozePendingIntent: PendingIntent =
                    PendingIntent.getBroadcast(this, 0, snoozeIntent, 0)
                val builder = NotificationCompat.Builder(
                    this,
                    "kotlinandroidlearning" /* This is CHANNEL_ID */
                )
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle("My notification")
                    .setContentText("Notification With Button")
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                    .setContentIntent(pendingIntent)
                    .setAutoCancel(true)
                    .addAction(
                        R.mipmap.ic_launcher_round, getString(R.string.snooze),
                        snoozePendingIntent
                    )

                with(NotificationManagerCompat.from(this)) {
                    // notificationId is a unique int for each notification that you must define
                    notify(0/* This is notificationId */, builder.build())
                }


//Notification: Simple Notification with Image 3
//https://developer.android.com/training/notify-user/expanded

                val myBitmap = (getDrawable(R.drawable.smartphone) as BitmapDrawable).bitmap

                button1_13.setOnClickListener {


                    val intent = Intent(this, MainActivity::class.java).apply {
                        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    }
                    val pendingIntent: PendingIntent = PendingIntent.getActivity(this, 0, intent, 0)

                    val builder =
                        NotificationCompat.Builder(
                            this,
                            "kotlinandroidlearning" /* This is CHANNEL_ID */
                        )
                            .setSmallIcon(R.mipmap.ic_launcher_round)
                            .setContentTitle("My notification")
                            .setContentText("Notification With ImageView")
                            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                            .setContentIntent(pendingIntent)
                            .setAutoCancel(true)
                            .setLargeIcon(myBitmap)
                            .setStyle(
                                NotificationCompat.BigPictureStyle()
                                    .bigPicture(myBitmap)
                                    .bigLargeIcon(null)
                            )
                    with(NotificationManagerCompat.from(this)) {
                        // notificationId is a unique int for each notification that you must define
                        notify(0/* This is notificationId */, builder.build())

                    }

                }


//Notification: Simple Notification with Progressbar 4

                button1_14.setOnClickListener {
                    val builder = NotificationCompat
                        .Builder(this, "kotlinandroidlearning" /* This is CHANNEL_ID */)
                        .apply {
                            setContentTitle("Picture Download")
                            setContentText("Download in progress")
                            setSmallIcon(R.mipmap.ic_launcher)
                            setPriority(NotificationCompat.PRIORITY_LOW)
                        }
                    val PROGRESS_MAX = 100
                    val PROGRESS_CURRENT = 0
                    NotificationManagerCompat.from(this).apply {
                        // Issue the initial notification with zero progress
                        builder.setProgress(PROGRESS_MAX, PROGRESS_CURRENT, true)//false
                        notify(0/* This is notificationId */, builder.build())
                        // Do the job here that tracks the progress.
                        // Usually, this should be in a
                        // worker thread
                        // To show progress, update PROGRESS_CURRENT and update the notification with:
                        // builder.setProgress(PROGRESS_MAX, PROGRESS_CURRENT, false);
                        // notificationManager.notify(notificationId, builder.build());

//Timer Reference: https://developer.android.com/reference/kotlin/android/os/CountDownTimer.html?hl=en
//After 10 seconds it will show "Download is Completed"
                        object : CountDownTimer(10000, 1000) {
                            override fun onTick(millisUntilFinished: Long) {
                                //mTextField.setText("seconds remaining: " + millisUntilFinished / 1000)
                            }

                            override fun onFinish() {
                                //mTextField.setText("done!")
                                // When done, update the notification one more time to remove the progress bar
                                builder.setContentText("Download complete")
                                    .setProgress(0, 0, false)
                                notify(0/* This is notificationId */, builder.build())
                            }
                        }.start()


                    }
                }


//Notification: Simple Notification- Open Browser from link 5
                button1_15.setOnClickListener {

                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://jonyapps.com/")).apply {
                        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    }
                    val pendingIntent: PendingIntent = PendingIntent.getActivity(this, 0, intent, 0)

                    val builder =
                        NotificationCompat.Builder(this, "kotlinandroidlearning" /* This is CHANNEL_ID */)
                            .setSmallIcon(R.mipmap.ic_launcher_round)
                            .setContentTitle("My notification")
                            .setContentText("Click here to Open Link...")
                            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                            .setContentIntent(pendingIntent)
                            .setAutoCancel(true)
                    with(NotificationManagerCompat.from(this)) {
                        // notificationId is a unique int for each notification that you must define
                        notify(0/* This is notificationId */, builder.build())
                    }
                    }


                }
            }
        }
    }

//Note: To set Notification badge add .setNumber(10)