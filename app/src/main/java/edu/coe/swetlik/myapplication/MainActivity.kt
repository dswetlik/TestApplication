package edu.coe.swetlik.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    var priceList:MutableList<Int> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setOnClick(R.id.incHotdog, R.id.countHotdog, R.id.priceHotdog,true)
        setOnClick(R.id.decHotdog, R.id.countHotdog, R.id.priceHotdog,false)
        setOnClick(R.id.incSoda, R.id.countSoda, R.id.priceSoda,true)
        setOnClick(R.id.decSoda, R.id.countSoda, R.id.priceSoda, false)

        for(i in priceList)
            Log.i("intTest", i.toString())
        if(priceList.count() == 0)
            Log.i("intText", "priceList is empty")
    }

    fun greet(v:View) {
        Toast.makeText(this, "Button Did Not Work", Toast.LENGTH_SHORT).show()
    }

    fun increaseAmount(v: View?, countId:Int, priceId:Int)
    {
        val g = this.findViewById<TextView>(R.id.output_price_view)
        val h = this.findViewById<TextView>(countId)
        val i:Int = Integer.valueOf(this.findViewById<TextView>(priceId).text.toString())
        var j:Int = Integer.valueOf(this.findViewById<TextView>(countId).text.toString())

        j++

        h.setText(j.toString())
        updatePrice()
    }

    fun decreaseAmount(v: View?, countId:Int, priceId: Int)
    {
        val g = this.findViewById<TextView>(R.id.output_price_view)
        val h = this.findViewById<TextView>(countId)
        val i:Int = Integer.valueOf(this.findViewById<TextView>(priceId).text.toString())
        var j:Int = Integer.valueOf(this.findViewById<TextView>(countId).text.toString())

        j--
        if(j < 0)
            j = 0

        h.setText(j.toString())
        updatePrice()
    }

    fun updatePrice()
    {
        var totalPrice:Int = 0

        for(i in 0 until priceList.count() step 2 )
        {
            var x = Integer.valueOf(this.findViewById<TextView>(priceList[i]).text.toString())
            var y = Integer.valueOf(this.findViewById<TextView>(priceList[i + 1]).text.toString())

            totalPrice += x * y
        }

        this.findViewById<TextView>(R.id.output_price_view).setText(NumberFormat.getCurrencyInstance().format(totalPrice).toString())

    }

    fun resetCart(v:View)
    {
        for(i in 0 until priceList.count() step 2)
        {
            this.findViewById<TextView>(priceList[i]).text = "0"
        }

        updatePrice()
    }

    fun setOnClick(buttonId:Int, textId:Int, priceId: Int, isIncrease:Boolean)
    {
        val btn:Button = this.findViewById<Button>(buttonId)
        btn.setOnClickListener(object: View.OnClickListener {
            override fun onClick(v: View?) {
                if (isIncrease)
                    increaseAmount(v, textId, priceId)
                else
                    decreaseAmount(v, textId, priceId)
            }
        })
        if(!priceList.contains(textId))
            priceList.add(textId)
        if(!priceList.contains(priceId))
            priceList.add(priceId)
    }
}