package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var titleTextView: TextView
    private lateinit var rootLayout: LinearLayout

    private var isRemoved = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        titleTextView = findViewById(R.id.titleTextView)
        val removeButton: Button = findViewById(R.id.removeButton)
        rootLayout = findViewById(R.id.rootLayout)

        // Восстанавливаем текст, если Activity пересоздалась
        if (savedInstanceState != null) {
            isRemoved = savedInstanceState.getBoolean("isRemoved")
            if (isRemoved) {
                rootLayout.removeView(titleTextView)
            }
        }

        removeButton.setOnClickListener {
            rootLayout.removeView(titleTextView)
            isRemoved = true
        }
    }

    // Сохраняем текущий текст в Bundle
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean("isRemoved", isRemoved)
    }
}
