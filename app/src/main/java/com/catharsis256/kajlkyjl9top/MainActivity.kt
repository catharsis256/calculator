package com.catharsis256.kajlkyjl9top

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {

    val numPadIdArray = arrayOf(
            R.id.button_0, R.id.button_1, R.id.button_2, R.id.button_3,
            R.id.button_4, R.id.button_5, R.id.button_6, R.id.button_7,
            R.id.button_8, R.id.button_9)

    private lateinit var viewScreen : Button
    private lateinit var buttonPlus : Button
    private lateinit var buttonMinus : Button
    private lateinit var buttonMultiply : Button
    private lateinit var buttonDivide : Button
    private lateinit var buttonEquals : Button
    private lateinit var buttonPercent : Button
    private lateinit var buttonClear : Button
    private lateinit var buttonBullet : Button
    private lateinit var buttonPlusMinus : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        installManageButtons()

        numPadIdArray
                .mapNotNull { i -> (findViewById(i) as? Button) }
                .forEach { it.setOnClickListener(this::onClick) }

    }

    private fun installManageButtons() {
        viewScreen = findViewById(R.id.screen)
        buttonPlus = findViewById(R.id.button_plus)
        buttonMinus = findViewById(R.id.button_minus)
        buttonMultiply = findViewById(R.id.button_multiply)
        buttonDivide = findViewById(R.id.button_divide)
        buttonEquals = findViewById(R.id.button_equals)
        buttonPercent = findViewById(R.id.percent)
        buttonClear = findViewById(R.id.clear_button)
        buttonBullet = findViewById(R.id.button_bullet)
        buttonPlusMinus = findViewById(R.id.button_plus_minus)
    }

    override fun onClick(v: View?) {
        v?.run {
            when (id) {
                in numPadIdArray -> {
                    with(viewScreen.text) {
                        val currentText = toString() +  (this as Button).text.toString()
                        text = currentText
                    }
                }
            }
        }
    }
}
