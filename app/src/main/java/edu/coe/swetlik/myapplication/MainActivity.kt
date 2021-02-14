package edu.coe.swetlik.myapplication

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

    fun addNewItem(v: View)
    {
        var nameEdit = this.findViewById<EditText>(R.id.editItemName)
        var priceEdit = this.findViewById<EditText>(R.id.editItemPrice)

        if(nameEdit.text.toString() != "" && priceEdit.text.toString() != "") {

            for(x in itemList)
            {
                if(x.name.toString() == nameEdit.text.toString())
                    return
            }

            createNewItem(nameEdit.text.toString(), priceEdit.text.toString().toInt())
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        val file = File(this.filesDir, "saveData")

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
        for(x in itemList)
        {
            x.value = 0
        }

        updatePrice()
    }

}