package com.android.tipcalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    //Declaring variable
    var char = "$";
    var amount = 0.0;
    var tipPercent = 0.15;
    var tip = 0.0;
    var total = 0.0;



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextAmount.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (editTextAmount.text.isNotEmpty()) {
                    amount = editTextAmount.text.toString().toDouble()
                    calculate();
                } else {
                    amount = 0.0
                    calculate()

                }
            }
        })

        seekBarTip.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                //make sure amount is not empty
                if (editTextAmount.text.isEmpty()) {
                    return
                }
                else{


                    //display current tip percent
                    textViewSeek.setText(p1.toString() + '%' )
                    tipPercent = (p1 / 100.0)
                    calculate()
                }
            }


        })
    }






    fun calculate(){
       //calculate values
        tip = amount*tipPercent;
        total = tip + amount;


        // enable currency format
        val currencyFormat = NumberFormat.getCurrencyInstance()

        //display
        textViewTipAmount.setText(currencyFormat.format(tip).toString())
        textViewTotalAmount.setText(currencyFormat.format(total).toString())


    }

        }

