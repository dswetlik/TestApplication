package edu.coe.swetlik.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text
import java.text.NumberFormat
import java.util.function.ToIntFunction

class MainActivity : AppCompatActivity() {

    var priceList:List<Int> = emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setOnClick(R.id.incHotdog, R.id.countHotdog, R.id.priceHotdog,true)
        setOnClick(R.id.decHotdog, R.id.countHotdog, R.id.priceHotdog,false)
        setOnClick(R.id.incSoda, R.id.countSoda, R.id.priceSoda,true)
        setOnClick(R.id.decSoda, R.id.countSoda, R.id.priceSoda, false
        )
    }

    fun greet(v:View) {
        Toast.makeText(this, "Button Did Not Work", Toast.LENGTH_SHORT).show();
    }

    fun increaseAmount(v: View?, countId:Int, priceId:Int)
    {
        var g = this.findViewById<TextView>(R.id.output_price_view)
        var h = this.findViewById<TextView>(countId)
        var i:Int = Integer.valueOf(this.findViewById<TextView>(priceId).text.toString())
        var j:Int = Integer.valueOf(this.findViewById<TextView>(countId).text.toString())

        j++

        g.setText(NumberFormat.getCurrencyInstance().format(i * j).toString());
        h.setText(j.toString());
    }

    fun decreaseAmount(v: View?, countId:Int, priceId: Int)
    {
        var g = this.findViewById<TextView>(R.id.output_price_view)
        var h = this.findViewById<TextView>(countId)
        var i:Int = Integer.valueOf(this.findViewById<TextView>(priceId).text.toString())
        var j:Int = Integer.valueOf(this.findViewById<TextView>(countId).text.toString())

        j--
        if(j < 0)
            j = 0
        g.setText(NumberFormat.getCurrencyInstance().format(i * j).toString());
        h.setText(j.toString());
    }

    fun updatePrice()
    {

    }

    fun setOnClick(buttonId:Int, textId:Int, priceId: Int, isIncrease:Boolean)
    {
        var btn:Button = this.findViewById<Button>(buttonId)
        btn.setOnClickListener(object: View.OnClickListener {
            override fun onClick(v: View?) {
                if(isIncrease)
                    increaseAmount(v, textId, priceId)
                else
                    decreaseAmount(v, textId, priceId)
            }
        })
    }
}