package edu.coe.swetlik.myapplication

class Item {

    companion object {
        var ItemList: MutableList<Item> = mutableListOf()

        fun addItem(item: Item)
        {
            ItemList.add(item)
        }

        fun removeItem(item: Item)
        {
            ItemList.remove(item)
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