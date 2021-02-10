package edu.coe.swetlik.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import org.w3c.dom.Text
import java.io.File
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    var itemList:MutableList<UpDownBox> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
        setOnClick(R.id.incHotdog, R.id.countHotdog, R.id.priceHotdog,true)
        setOnClick(R.id.decHotdog, R.id.countHotdog, R.id.priceHotdog,false)
        setOnClick(R.id.incSoda, R.id.countSoda, R.id.priceSoda,true)
        setOnClick(R.id.decSoda, R.id.countSoda, R.id.priceSoda, false)
        */

        for(i in 0 until this.findViewById<LinearLayout>(R.id.ItemContainer).childCount step 1)
        {
            var item: Pair<View, UpDownBox> = this.findViewById<LinearLayout>(R.id.ItemContainer).getChildAt(i) to UpDownBox(this)
            itemList.add(item.second)
            Log.i("ListItem", "Added upDownBox$i to list.")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        val file = File(this.filesDir, "saveData")

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