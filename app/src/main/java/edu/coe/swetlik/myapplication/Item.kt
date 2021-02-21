package edu.coe.swetlik.myapplication

class Item {

    companion object {
        var ItemList: MutableList<Item> = mutableListOf()
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

    fun addItem(item: Item) {
        Item.ItemList.add(item)
    }

    fun removeItem(item: Item) {
        Item.ItemList.remove(item)
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