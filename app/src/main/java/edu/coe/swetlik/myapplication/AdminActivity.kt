package edu.coe.swetlik.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout

class AdminActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)

        Item.ItemList.forEach { createNewItem(it.name, it.price) }

    }

    private fun createNewItem(name:String, price:Float)
    {
        var box = AdminItemBox(this)
        box.name = name
        box.price = price

        this.findViewById<LinearLayout>(R.id.adminItemContainer).addView(box)
    }

    fun addNewItem(v: View)
    {
        val nameEdit = this.findViewById<EditText>(R.id.editItemName)
        val priceEdit = this.findViewById<EditText>(R.id.editItemPrice)

        if(nameEdit.text.toString() != "" && priceEdit.text.toString() != "" && Item.ItemList.count() < 8) {
            for(x in Item.ItemList)
                if(x.name.toString() == nameEdit.text.toString())
                    return

            createNewItem(nameEdit.text.toString(), priceEdit.text.toString().toFloat())
            Item.addItem(Item(nameEdit.text.toString(), priceEdit.toString().toFloat()))
        }

        nameEdit.text.clear()
        priceEdit.text.clear()
    }

    fun loadMainActivity(v: View)
    {
        val intent = Intent(this@AdminActivity, MainActivity::class.java)
        startActivity(intent)
    }
}