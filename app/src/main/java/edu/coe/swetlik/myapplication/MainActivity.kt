package edu.coe.swetlik.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.*
import java.io.File
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    var itemList:MutableList<UpDownBox> = mutableListOf()

    private val textWatcher = object: TextWatcher {
        override fun afterTextChanged(s: Editable?) { }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) { }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            updatePrice()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        for(box in itemList) {
            box.removeAllViews()
        }

        itemList.clear()

        Item.getDatabase().forEach { createNewItem(it.name, it.price) }

    }

    private fun createNewItem(name:String, price:Float)
    {
        var box = UpDownBox(this)
        box.name = name
        box.price = price
        box.value = 0
        this.findViewById<LinearLayout>(R.id.ItemContainer).addView(box)
        itemList.add(box)
        box.setTextWatcher(textWatcher)
    }

    fun updatePrice()
    {
        var totalPrice:Float = 0f

        for(x in itemList)
            totalPrice += (x.value * x.price)

        this.findViewById<TextView>(R.id.output_price_view).setText(NumberFormat.getCurrencyInstance().format(totalPrice).toString())

    }

    fun resetCart(v:View)
    {
        for(x in itemList)
        {
            x.value = 0
        }

        updatePrice()
    }

    fun loadAdminActivity(v: View)
    {
        val intent = Intent(this@MainActivity, AdminActivity::class.java)
        startActivity(intent)
    }

}