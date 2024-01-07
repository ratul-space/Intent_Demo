package com.example.intentdemo

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    companion object {
        val TAG = "MainActivity"
        const val MY_MESSAGE = "com.example.intent.demo.MY_MESSAGE"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnSend).setOnClickListener(ButtonClickListener)
        findViewById<Button>(R.id.btnImplicitTelephone).setOnClickListener(ButtonClickListener)
        findViewById<Button>(R.id.btnImplicitCustom).setOnClickListener(ButtonClickListener)

//        val btnSend = findViewById<Button>(R.id.btnSend)
//        btnSend.setOnClickListener {
//            val intent = Intent(applicationContext, DisplayMessageActivity::class.java)
//            val message = findViewById<EditText>(R.id.etPhoneNumber).text.toString()
//            intent.putExtra(MY_MESSAGE, message)
//            startActivity(intent)
//        }
    }

    private val ButtonClickListener: (View) -> Unit = { view ->
        when (view.id) {
            R.id.btnSend -> {
                val displayMessageIntent =
                    Intent(applicationContext, DisplayMessageActivity::class.java)
                val message = findViewById<EditText>(R.id.editText).text.toString()
                displayMessageIntent.putExtra(MY_MESSAGE, message)
                startActivity(displayMessageIntent)
            }

            R.id.btnImplicitTelephone -> {
                val phoneNumber: Uri = Uri.parse("tel:+165738287386")
                val dialIntent: Intent = Intent(Intent.ACTION_DIAL, phoneNumber)
                startActivity(dialIntent)

                Log.d(TAG, "btnImplicitTelephone: Clicked")
            }

            R.id.btnImplicitCustom -> {
                val customIntent = Intent("dummy.intent.action.MY_ACTION")
                startActivity(customIntent)
                Log.d(TAG, "btnImplicitCustom: Clicked")
            }
        }
    }
}