package com.example.intentdemo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    companion object {
        const val MY_MESSAGE = "com.example.intent.demo.MY_MESSAGE"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSend = findViewById<Button>(R.id.btnSend)
        btnSend.setOnClickListener {
            val intent = Intent(applicationContext, DisplayMessageActivity::class.java)
            val message = findViewById<EditText>(R.id.etPhoneNumber).text.toString()
            intent.putExtra(MY_MESSAGE, message)
            startActivity(intent)
        }
    }

    /*private val ButtonClickListener: (View) -> Unit = { view ->
        when (view.id) {
            R.id.btn_sent -> {
                val displayMessageIntent =
                    Intent(applicationContext, DisplayMessageActivity::class.java)
                val massege = findViewById<EditText>(R.id.etPhoneNumber).text.toString()
                displayMessageIntent.putExtra(MY_massage, massege)
                startActivity(displayMessageIntent)
            }

            R.id.btn_implicit_telephone -> {
                val phoneNumber: Uri.parse("tel:+165738287386")
                val dialIntent: Intent = Intent(Intent.ACTION_DIAL, phoneNumber)


                Log(TAG: )
            }
        }
    }*/
}