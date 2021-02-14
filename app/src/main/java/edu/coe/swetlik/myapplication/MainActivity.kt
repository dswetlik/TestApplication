package edu.coe.swetlik.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import java.io.File
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    var itemList:MutableList<UpDownBox> = mutableListOf()

    val textWatcher = object: TextWatcher {
        override fun afterTextChanged(s: Editable?) { }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) { }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            updatePrice()
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
        setOnClick(R.id.incHotdog, R.id.countHotdog, R.id.priceHotdog,true)
        setOnClick(R.id.decHotdog, R.id.countHotdog, R.id.priceHotdog,false)
        setOnClick(R.id.incSoda, R.id.countSoda, R.id.priceSoda,true)
        setOnClick(R.id.decSoda, R.id.countSoda, R.id.priceSoda, false)
        */

        createNewItem("Hot Dog", 1)
        createNewItem("Hamburger", 2)
        createNewItem("Soda", 1)
    }

    fun createNewItem(name:String, price:Int)
    {
        var box = UpDownBox(this)
        box.name = name
        box.price = price
        box.value = 0
        this.findViewById<LinearLayout>(R.id.ItemContainer).addView(box)
        itemList.add(box)
        box.setTextWatcher(textWatcher)
    }

    override fun onDestroy() {
        super.onDestroy()
        val file = File(this.filesDir, "saveData")

    }

    fun greet(v:View) {

        for(i in 0 until this.findViewById<LinearLayout>(R.id.ItemContainer).childCount step 1)
        {
            var item: Pair<View, UpDownBox> = this.findViewById<LinearLayout>(R.id.ItemContainer).getChildAt(i) to UpDownBox(this)
            itemList.add(item.second)
            //item.second.name = "Hamburger"

            Log.i("Variable Test", "Added ${item.second.name}")
        }

        itemList[0].name = "Hot Dog"
        itemList[0].price = 2
        itemList[1].name = "Soda"
        itemList[1].price = 1

        Log.i("Variable Test", "Name of itemList object: ${itemList[0].name}")
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

        for(x in itemList)
            totalPrice += (x.value * x.price)

        this.findViewById<TextView>(R.id.output_price_view).setText(NumberFormat.getCurrencyInstance().format(totalPrice).toString())

    }

    fun resetCart(v:View)
    {


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
    }
}