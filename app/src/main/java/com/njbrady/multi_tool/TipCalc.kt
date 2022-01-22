package com.njbrady.multi_tool
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView

var TAG = "tipCalc"

class TipCalc: AppCompatActivity() {
    private lateinit var amount: EditText
    private lateinit var percent: SeekBar
    private lateinit var tip: TextView
    private lateinit var total: TextView
    private lateinit var percentTxt: TextView
    private lateinit var rating: TextView
    private var seekVal: Int = 0
    fun updateText(){
        percentTxt.text = "$seekVal%"
        var bill: Double = 0.0
        if(!amount.text.isNullOrEmpty()){
            bill = amount.text.toString().toDouble()
        }
        var temp: Double = bill * seekVal * 0.01
        var calcTip: String = "%.2f".format(temp)
        tip.text = "$$calcTip"
        bill += temp
        var calcTotal = "%.2f".format(bill)
        total.text = "$$calcTotal"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tipcalculator)
        amount = findViewById(R.id.amount)
        percent = findViewById(R.id.percent)
        tip = findViewById(R.id.tip)
        total = findViewById(R.id.total)
        percentTxt = findViewById(R.id.percentTxt)
        rating = findViewById(R.id.rating)

        amount.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                updateText()
            }

            override fun afterTextChanged(p0: Editable?) {}

        })

        percent.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                seekVal = p1
                if(seekVal > 25){
                    rating.text = "Excellent"
                    rating.setTextColor(Color.parseColor("#00ff00"))
                } else if(seekVal > 20){
                    rating.text = "Great"
                    rating.setTextColor(Color.parseColor("#00df00"))
                } else if(seekVal > 15){
                    rating.text = "Good"
                    rating.setTextColor(Color.parseColor("#adff2f"))
                } else if(seekVal > 10){
                    rating.text = "Meh"
                    rating.setTextColor(Color.parseColor("#FFF000"))
                } else if(seekVal > 5){
                    rating.text = "Bad"
                    rating.setTextColor(Color.parseColor("#ff9800"))
                } else {
                    rating.text = "Terrible"
                    rating.setTextColor(Color.parseColor("#ff0000"))
                }

                updateText()
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {}

            override fun onStopTrackingTouch(p0: SeekBar?) {}

        })
    }
}