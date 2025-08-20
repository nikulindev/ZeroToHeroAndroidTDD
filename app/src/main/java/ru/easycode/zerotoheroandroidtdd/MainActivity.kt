package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var titleTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        titleTextView = findViewById(R.id.titleTextView)
        val changeButton: Button = findViewById(R.id.hideButton)

        // Восстанавливаем текст, если Activity пересоздалась
        if (savedInstanceState != null) {
            titleTextView.visibility = savedInstanceState.getInt("key")
        }

        changeButton.setOnClickListener { titleTextView.visibility = View.INVISIBLE }
    }
    // Сохраняем текущий текст в Bundle
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("key", titleTextView.visibility)
    }
}