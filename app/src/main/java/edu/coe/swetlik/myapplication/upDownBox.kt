package edu.coe.swetlik.myapplication

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TableRow
import android.widget.TextView

class UpDownBox : LinearLayout, View.OnClickListener {

    private var mItemName: TextView? = null
    private var mItemPrice: TextView? = null
    private var mDownButton: Button? = null
    private var mUpButton: Button? = null
    private var mValue: TextView? = null
    private var startVal = 0
    private var itemName = "Item Name"
    private var itemPrice = 0

    constructor(context: Context) : super(context)
    {
        initializeViews(context);
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        initializeViews(context)
        val ta = context.obtainStyledAttributes(attrs, R.styleable.UpDownBox)
        //startVal = ta.getInt(R.styleable.UpDownBox_startVal, 0)
        //itemName = " "
        //itemPrice = ta.getInt(R.styleable.UpDownBox_itemPrice, 0)
        ta.recycle()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr ) {
        initializeViews(context)
        val ta = context.obtainStyledAttributes(attrs, R.styleable.UpDownBox)
        //startVal = ta.getInt(R.styleable.UpDownBox_startVal, 0)
        //itemName = " "
        //itemPrice = ta.getInt(R.styleable.UpDownBox_itemPrice, 0)

        ta.recycle()
    }

    private fun initializeViews(context: Context) {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.updownbox, this)
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        mItemName = findViewById<View>(R.id.itemNameText) as TextView
        mItemName!!.text = itemName.toString()
        Log.i("NullValue?", "mItemName is ${mItemName!!.text.toString()}")
        mItemPrice = findViewById<View>(R.id.itemPriceText) as TextView
        mItemPrice!!.text = itemPrice.toString()
        mDownButton = findViewById<View>(R.id.downButton) as Button
        mUpButton = findViewById<View>(R.id.upButton) as Button
        mValue = findViewById<View>(R.id.txtValue) as TextView
        mValue!!.text = startVal.toString()
        var x: String = mValue!!.text.toString()
        Log.i("NullValue?", "mValue is $x")
        mDownButton!!.setOnClickListener(this)
        mUpButton!!.setOnClickListener(this)
    }

    public var value: Int
        get() = Integer.valueOf(mValue?.text.toString())
        set(v) {
            mValue?.text = v.toString()
        }

    public var name: String
        get() = mItemName?.text.toString()
        set(v) {
            mItemName?.text = v.toString()
        }

    public var price: Int
        get() = Integer.valueOf(mItemPrice?.text.toString())
        set(v) {
            mItemPrice?.text = v.toString()
        }

    override fun onClick(v: View) {
        var `val` = mValue!!.text.toString().toInt()
        when (v.id) {
            R.id.downButton -> `val`--
            R.id.upButton -> `val`++
        }
        if(`val` < 0)
            `val` = 0
        mValue!!.text = `val`.toString()
    }


}