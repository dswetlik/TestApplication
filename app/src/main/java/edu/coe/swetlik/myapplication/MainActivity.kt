package edu.coe.swetlik.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.text.NumberFormat
import java.util.function.ToIntFunction

class MainActivity : AppCompatActivity() {

    var hotDogPrice:Int = 2
    var hotDogCount:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i("Create", "Complete")

        setOnClick(R.id.hotdogInc, R.id.count_text, true)
        setOnClick(R.id.hotdogDec, R.id.count_text, false)

    }

    fun greet(v:View) {
        Toast.makeText(this, "Button Did Not Work", Toast.LENGTH_SHORT).show();
    }

    fun increaseAmount(v: View?, id:Int)
    {
        var g = this.findViewById<TextView>(R.id.output_price_view)
        var i = this.findViewById<TextView>(id)
        try {
            var j:Int = i.toString().toInt()
        }
        catch (e:NumberFormatException)
        {
            Toast.makeText(this, "Error: Incorrect Int Value", Toast.LENGTH_LONG).show()
        }
        /*j++

        g.setText(NumberFormat.getCurrencyInstance().format(hotDogPrice * j).toString());
        i.setText(j.toString()); */
    }

    fun decreaseAmount(v: View?, id:Int)
    {
        var g = this.findViewById<TextView>(R.id.output_price_view)
        var i = this.findViewById<TextView>(id)
        i.text = "0"
        var j:Int = i.toString().toInt()
        j--
        if(j < 0)
            j = 0
        g.setText(NumberFormat.getCurrencyInstance().format(hotDogPrice * j).toString());
        i.setText(j.toString());
    }

    fun setOnClick(buttonId:Int, textId:Int, isIncrease:Boolean)
    {
        var btn:Button = this.findViewById<Button>(buttonId)
        btn.setOnClickListener(object: View.OnClickListener {
            override fun onClick(v: View?) {
                if(isIncrease)
                    increaseAmount(v, textId)
                else
                    decreaseAmount(v, textId)
            }
        })
    }
}