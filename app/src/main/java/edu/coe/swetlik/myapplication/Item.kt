package edu.coe.swetlik.myapplication

import android.content.Context
import android.util.Log
import java.util.function.Predicate

class Item {

    companion object {

        private lateinit var database: SQLDatabase

        var CURRENT_ID: Int = 0;

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

        fun createDatabase(c: Context) {
            database = SQLDatabase(c)
        }

        fun setDatabase() {
            database.clearData()
            for(x in ItemList) {
                database.insertData(x)
            }
        }

        fun getDatabase(): MutableList<Item> {
            ItemList = database.readData()
            return ItemList
        }

    }

    private var mName: String? = null
    private var mPrice: Float = 0f
    private var mID: Int = 0;

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