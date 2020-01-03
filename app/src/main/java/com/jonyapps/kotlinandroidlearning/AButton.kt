package com.jonyapps.kotlinandroidlearning

import android.app.ProgressDialog.show
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.view.ViewCompat
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.a_button.*
import kotlinx.android.synthetic.main.a_login_dialog.view.*
import java.util.*
import kotlin.collections.ArrayList

class AButton : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.a_button)

//***Toolbar*** - a
        //style:  <style name="AppTheme" parent="Theme.AppCompat.Light.NoActionBar">
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        actionBar!!.title = "Button 1"
        actionBar.setDisplayHomeAsUpEnabled(true) //Note: Enables back Arrow Icon


//***Toast*** Method 1
        //Toast will be shown when button is clicked
        button1_1.setOnClickListener {
            Toast.makeText(applicationContext,"Showing toast! - 1",Toast.LENGTH_SHORT).show()
        }
//***Toast*** Method 2
        //Toast will be shown when button is clicked
        button1_12.setOnClickListener {
            val text = "Showing toast! - 2"
            val duration = Toast.LENGTH_LONG
            val toast = Toast.makeText(applicationContext, text, duration)
            toast.show()
        }

//***Snackbar*** > Method 1
//need to add dependencies - implementation 'com.google.android.material:material:1.0.0'
//for more: https://android--code.blogspot.com/2018/02/android-kotlin-snackbar-example.html

        button1_2.setOnClickListener {
            Snackbar.make(
                relativeLayout, // a_button.xml Layout id
                "Hello Snackbar!",
                Snackbar.LENGTH_SHORT
            ).show()
        }

//***Snackbar*** > Method 2
        button1_3.setOnClickListener {
            Snackbar.make(
                relativeLayout,
                "We changes app background color.",
                Snackbar.LENGTH_LONG
            ).setAction( // Set an action for snack bar
                "Undo" // Action button text
            ) {
                //Undo action button clicked Activity
                Toast.makeText(applicationContext,"An Action Showing!",Toast.LENGTH_SHORT).show()
                relativeLayout.setBackgroundColor(Color.parseColor("#f2f2f2")) //Color for "Undo" Button text
            }.show()
        }

//***Snackbar*** > Method 3
        button1_4.setOnClickListener {
            val snackbar = Snackbar.make(
                relativeLayout,
                "This is a snack bar.",
                Snackbar.LENGTH_INDEFINITE
            )
            /* Note: Not Working
            val snack_root_view = snackbar.view
            val snack_text_view = snack_root_view
                .findViewById<TextView>(android.support.design.R.id.snackbar_text)
            val snack_action_view = snack_root_view
                .findViewById<Button>(android.support.design.R.id.snackbar_action)

            // Change the snack bar root view background color
            snack_root_view.setBackgroundColor(Color.parseColor("#FFCFBEB4"))
            // Change the snack bar text view text color
            snack_text_view.setTextColor(Color.RED)
            // Change snack bar text view text style
            snack_text_view.setTypeface(Typeface.MONOSPACE,Typeface.BOLD_ITALIC)
            // Change the snack bar action button text color
            snack_action_view.setTextColor(Color.YELLOW)
            */

            // Set an action for snack bar
            snackbar.setAction("Back") {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)

                snackbar.dismiss()
            }
            snackbar.show()
        }

//***AlertDialog*** > Method 1

        button1_5.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("AlertDialog")
            builder.setMessage("AlertDialog Showing...")
            builder.setIcon(android.R.drawable.ic_dialog_alert)
            builder.setPositiveButton("Yes"){dialogInterface, which ->
                Toast.makeText(applicationContext,"clicked yes",Toast.LENGTH_SHORT).show()
            }
            builder.setNeutralButton("Cancel"){dialogInterface , which ->
                Toast.makeText(applicationContext,"clicked cancel\n operation cancel",Toast.LENGTH_SHORT).show()
            }
            builder.setNegativeButton("No"){dialogInterface, which ->
                Toast.makeText(applicationContext,"clicked No",Toast.LENGTH_LONG).show()
            }
            val alertDialog: AlertDialog = builder.create()
            alertDialog.setCancelable(false)
            alertDialog.show()
        }

//***AlertDialog*** > Method 2 (Custom Button)
        button1_6.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            with(builder) {
                setTitle("Icon and Button Color")
                setMessage("We have a message")
                setPositiveButton("OK"){ dialogInterface, i ->
                    Toast.makeText(applicationContext, "Clicked Ok", Toast.LENGTH_SHORT).show() }
                setNegativeButton("CANCEL", null)
                setNeutralButton("NEUTRAL", null)
                setPositiveButtonIcon(resources.getDrawable(android.R.drawable.ic_menu_call, theme))
                setIcon(resources.getDrawable(android.R.drawable.ic_dialog_alert, theme))
            }
            val alertDialog = builder.create()
            alertDialog.show()

            val button = alertDialog.getButton(DialogInterface.BUTTON_POSITIVE)
            with(button) {
                setBackgroundColor(Color.BLACK)
                setPadding(0, 0, 20, 0)
                setTextColor(Color.WHITE)
            }
        }

//***AlertDialog*** > Method 3 (Login)
//Create a_login_dialog.xml in the layout folder

        button1_7.setOnClickListener {
            val mDialogView = LayoutInflater.from(this).inflate(R.layout.a_login_dialog, null)
            val mBuilder = AlertDialog.Builder(this)
                .setView(mDialogView)
                .setTitle("Login Form")
            val  mAlertDialog = mBuilder.show()
            mDialogView.dialogLoginBtn.setOnClickListener {
                mAlertDialog.dismiss()
                //get text from EditTexts of custom layout
                val name = mDialogView.dialogNameEt.text.toString()
                val email = mDialogView.dialogEmailEt.text.toString()
                val password = mDialogView.dialogPasswEt.text.toString()
                //set the input text in TextView
                //mainInfoTv.setText("Name:"+ name +"\nEmail: "+ email +"\nPassword: "+ password)
                Toast.makeText(applicationContext,"Name:"+ name +"\nEmail: "+ email +"\nPassword: "+ password,Toast.LENGTH_SHORT).show()
            }
            mDialogView.dialogCancelBtn.setOnClickListener {
                mAlertDialog.dismiss()
            }
        }
 }







        //***Toolbar*** - b
//Note: Going to back activity when Toolbar back Button is pressed
    override fun onSupportNavigateUp(): Boolean {
    onBackPressed()
    return true
       }
      }

//***Toolbar*** - Other Way
// Link: https://developer.android.com/training/appbar/up-action

//***AlertDialog*** > Custom ListView
//https://medium.com/@makkenasrinivasarao1/android-custom-dialog-with-list-of-items-ba1ab0e78e16