package edu.coe.swetlik.myapplication

import android.util.Log
import java.util.function.Predicate

class Item {

    companion object {
        var ItemList: MutableList<Item> = mutableListOf()

        fun updateItem(item: Item, name: String, price: Float) {
            val x = getIndexOfItem(item);

            ItemList[x].name = name
            ItemList[x].price = price
        }


        fun addItem(item: Item)
        {
            ItemList.add(item)
        }

        fun removeItem(item: Item)
        {
            ItemList.removeAt(getIndexOfItem(item))
        }

        private fun getIndexOfItem(item: Item): Int
        {
            for(x in ItemList)
            {
                if(x.name == item.name && x.price == item.price) {
                    Log.i("ReturnValue", "Found item at ${ItemList.indexOf(x)}")
                    return ItemList.indexOf(x)
                }
            }
            return 9
        }
    }

    private var mName: String? = null
    private var mPrice: Float = 0f

    constructor()
    {
        this.mName = ""
        this.mPrice = 0f
    }

    constructor(name:String, price:Float)
    {
        this.mName = name
        this.mPrice = price
    }

    var name: String
        get() = mName!!
        set(v) {
            mName = v
        }

    var price: Float
        get() = mPrice
        set(v) {
            mPrice = v
        }

}