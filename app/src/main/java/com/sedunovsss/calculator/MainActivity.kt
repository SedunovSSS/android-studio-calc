package com.sedunovsss.calculator

import android.content.Intent
import android.os.Bundle
import android.os.Vibrator
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.mozilla.javascript.Context
import org.mozilla.javascript.Scriptable

class MainActivity : AppCompatActivity() {
    lateinit var button0 : Button
    lateinit var button1 : Button
    lateinit var button2 : Button
    lateinit var button3 : Button
    lateinit var button4 : Button
    lateinit var button5 : Button
    lateinit var button6 : Button
    lateinit var button7 : Button
    lateinit var button8 : Button
    lateinit var button9 : Button
    lateinit var buttondot : Button
    lateinit var buttonplus : Button
    lateinit var buttonminus : Button
    lateinit var buttonmulti : Button
    lateinit var buttondiv : Button
    lateinit var buttonsolve : Button
    lateinit var buttonc : Button
    lateinit var buttond : Button
    lateinit var buttonskobka1 : Button
    lateinit var buttonskobka2 : Button
    lateinit var about: ImageButton
    lateinit var vibro : Vibrator
    lateinit var calc : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        buttondot = findViewById(R.id.buttondot);
        buttonmulti = findViewById(R.id.buttonmulti);
        buttondiv = findViewById(R.id.buttondiv);
        buttonplus = findViewById(R.id.buttonplus);
        buttonminus = findViewById(R.id.buttonminus);
        buttonsolve = findViewById(R.id.buttonsolve);
        buttonc = findViewById(R.id.buttonc);
        buttond = findViewById(R.id.buttond);
        buttonskobka1 = findViewById(R.id.buttonskobka1);
        buttonskobka2 = findViewById(R.id.buttonskobka2);
        calc = findViewById(R.id.calc);
        about = findViewById(R.id.about)

        val vibro = getSystemService(VIBRATOR_SERVICE) as Vibrator

        fun ifZeroClear(){
            if (calc.text.toString() == "0") {
                calc.setText("")
            }
        }
        fun ifDivbyZero(): Boolean{
            return calc.text.toString() != "Деление на 0!" && calc.text.toString() != "Ошибка!"
        }
        fun eval(string: String): String{
            try {
                val context = Context.enter()
                context.optimizationLevel = -1
                val scope: Scriptable = context.initStandardObjects()
                val result = context.evaluateString(scope, string, "<cmd>", 1, null).toString().toDouble()
                if (result.toString() == "Infinity" || result.toString() == "-Infinity" || result.toString() == "NaN"){
                    return "Деление на 0!"
                }
                if (result.toInt().toDouble() == result){
                    val newResult = result.toInt()
                    return newResult.toString()
                }
                else{
                    val newResult = result
                    return newResult.toString()
                }
            } catch (e: Exception) {
                return "Ошибка!"
            }
        }
        fun vibrate(){
            vibro.vibrate(100)
        }
        about.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, AboutActivity::class.java)
            startActivity(intent)
        })
        buttonc.setOnClickListener(View.OnClickListener {
            calc.setText("0")
            vibrate()
        })
        buttond.setOnClickListener(View.OnClickListener {
            if (ifDivbyZero()) {
                val str = calc.text.toString()
                calc.setText(str.substring(0, str.length - 1))
                if (calc.text.toString() == "") {
                    calc.setText("0")
                }
            }
            vibrate()
        })
        buttonskobka1.setOnClickListener(View.OnClickListener {
            if (ifDivbyZero()) {
                ifZeroClear()
                calc.setText(calc.text.toString().plus("("))
            }
            vibrate()
        })
        buttonskobka2.setOnClickListener(View.OnClickListener {
            if (ifDivbyZero()) {
                ifZeroClear()
                calc.setText(calc.text.toString().plus(")"))
            }
            vibrate()
        })
        button0.setOnClickListener(View.OnClickListener {
            if (ifDivbyZero()) {
                ifZeroClear()
                calc.setText(calc.text.toString().plus("0"))
            }
            vibrate()
        })
        button1.setOnClickListener(View.OnClickListener {
            if (ifDivbyZero()) {
                ifZeroClear()
                calc.setText(calc.text.toString().plus("1"))
            }
            vibrate()
        })
        button2.setOnClickListener(View.OnClickListener {
            if (ifDivbyZero()) {
                ifZeroClear()
                calc.setText(calc.text.toString().plus("2"))
            }
            vibrate()
        })
        button3.setOnClickListener(View.OnClickListener {
            if (ifDivbyZero()) {
                ifZeroClear()
                calc.setText(calc.text.toString().plus("3"))
            }
            vibrate()
        })
        button4.setOnClickListener(View.OnClickListener {
            if (ifDivbyZero()) {
                ifZeroClear()
                calc.setText(calc.text.toString().plus("4"))
            }
            vibrate()
        })
        button5.setOnClickListener(View.OnClickListener {
            if (ifDivbyZero()) {
                ifZeroClear()
                calc.setText(calc.text.toString().plus("5"))
            }
            vibrate()
        })
        button6.setOnClickListener(View.OnClickListener {
            if (ifDivbyZero()) {
                ifZeroClear()
                calc.setText(calc.text.toString().plus("6"))
            }
            vibrate()
        })
        button7.setOnClickListener(View.OnClickListener {
            if (ifDivbyZero()) {
                ifZeroClear()
                calc.setText(calc.text.toString().plus("7"))
            }
            vibrate()
        })
        button8.setOnClickListener(View.OnClickListener {
            if (ifDivbyZero()) {
                ifZeroClear()
                calc.setText(calc.text.toString().plus("8"))
            }
            vibrate()
        })
        button9.setOnClickListener(View.OnClickListener {
            if (ifDivbyZero()) {
                ifZeroClear()
                calc.setText(calc.text.toString().plus("9"))
            }
            vibrate()
        })
        buttondot.setOnClickListener(View.OnClickListener {
            if (ifDivbyZero()) {
                calc.setText(calc.text.toString().plus("."))
            }
            vibrate()
        })
        buttonplus.setOnClickListener(View.OnClickListener {
            if (ifDivbyZero()) {
                calc.setText(calc.text.toString().plus("+"))
            }
            vibrate()
        })
        buttonminus.setOnClickListener(View.OnClickListener {
            if (ifDivbyZero()) {
                calc.setText(calc.text.toString().plus("-"))
            }
            vibrate()
        })
        buttonmulti.setOnClickListener(View.OnClickListener {
            if (ifDivbyZero()) {
                calc.setText(calc.text.toString().plus("×"))
            }
            vibrate()
        })
        buttondiv.setOnClickListener(View.OnClickListener {
            if (ifDivbyZero()) {
                calc.setText(calc.text.toString().plus("÷"))
            }
            vibrate()
        })
        buttonsolve.setOnClickListener(View.OnClickListener {
            if (ifDivbyZero()) {
                var str = calc.text.toString()
                str = str.replace("×", "*")
                str = str.replace("÷", "/")
                str = str.replace("++", "+")
                str = str.replace("--", "+")
                calc.setText(eval(str))
            }
            else{
                calc.setText("0")
            }
            vibrate()
        })
    }
    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        savedInstanceState.putString("calc", calc.text.toString())
        super.onSaveInstanceState(savedInstanceState)
    }
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val myString = savedInstanceState.getString("calc")
        calc.setText(myString)
    }
}
