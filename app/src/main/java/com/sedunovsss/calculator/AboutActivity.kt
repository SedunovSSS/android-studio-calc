package com.sedunovsss.calculator

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageButton
import android.widget.TextView

class AboutActivity : AppCompatActivity() {
    lateinit var back: ImageButton
    lateinit var textAbout: TextView
    var jokes = arrayListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        jokes.add("-Спал вчера в бетономешалке.\n-И как?\n-Бетон мешает.")
        jokes.add("Когда милицию \nпеременовали в полицию\n медики заволновались.")
        jokes.add("Решил мужик отдохнуть\nна Кубе. Ошибся \nи сел на конус.")
        jokes.add("Один городской тип купил\nпоселок. Теперь это\nпоселок городского типа.")
        jokes.add("Зачем гитарист играет на\nэлектро-гитаре? Чтобы\nбросить играть на обычной.")

        val joke = jokes.random().toString()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        textAbout = findViewById(R.id.textAbout)
        textAbout.setText(joke)
        back = findViewById(R.id.back)
        back.setOnClickListener(View.OnClickListener {
            finish()
        })
    }
    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        savedInstanceState.putString("joke", textAbout.text.toString())
        super.onSaveInstanceState(savedInstanceState)
    }
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val myString = savedInstanceState.getString("joke")
        textAbout.setText(myString)
    }
}