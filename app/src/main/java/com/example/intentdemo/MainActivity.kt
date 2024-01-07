package com.example.intentdemo

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity


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

            }

            R.id.btnImplicitCustom -> {
                val customIntent = Intent("dummy.intent.action.MY_ACTION")
                val customIntentChooser = Intent.createChooser(customIntent, "My action handler")

                if (customIntent.resolveActivity(packageManager) != null) {
                    startActivity(customIntentChooser)

                } else {
                    Toast.makeText(
                        applicationContext,
                        "No activity found to handle MY_ACTION",
                        Toast.LENGTH_LONG
                    ).show()
                }

            }
        }
    }
}