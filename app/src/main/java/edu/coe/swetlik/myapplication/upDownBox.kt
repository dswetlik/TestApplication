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
import android.text.TextWatcher

class UpDownBox : LinearLayout, View.OnClickListener {

    private var mItemName: TextView? = null
    private var mItemPrice: TextView? = null
    private var mDownButton: Button? = null
    private var mUpButton: Button? = null
    private var mValue: TextView? = null
    private var startVal: Int = 0
    private var itemName: String = "Item Name"
    private var itemPrice: Int = 0

    constructor(context: Context) : super(context)
    {
        initializeViews(context);
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        initializeViews(context)
        val ta = context.obtainStyledAttributes(attrs, R.styleable.UpDownBox)
        startVal = ta.getInt(R.styleable.UpDownBox_startVal, 0)
        itemName = ta.getString(R.styleable.UpDownBox_itemName).toString()
        itemPrice = ta.getInt(R.styleable.UpDownBox_itemPrice, 0)
        ta.recycle()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr ) {
        initializeViews(context)
        val ta = context.obtainStyledAttributes(attrs, R.styleable.UpDownBox)
        startVal = ta.getInt(R.styleable.UpDownBox_startVal, 0)
        itemName = ta.getString(R.styleable.UpDownBox_itemName).toString()
        itemPrice = ta.getInt(R.styleable.UpDownBox_itemPrice, 0)

        ta.recycle()
    }

    private fun initializeViews(context: Context) {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.updownbox, this)
        mItemName = findViewById<View>(R.id.itemNameText) as TextView
        mItemName!!.text = itemName.toString()
        mItemPrice = findViewById<View>(R.id.itemPriceText) as TextView
        mItemPrice!!.text = itemPrice.toString()
        mDownButton = findViewById<View>(R.id.downButton) as Button
        mUpButton = findViewById<View>(R.id.upButton) as Button
        mValue = findViewById<View>(R.id.txtValue) as TextView
        mValue!!.text = startVal.toString()
        mDownButton!!.setOnClickListener(this)
        mUpButton!!.setOnClickListener(this)
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
    }

    public fun setTextWatcher(watcher: TextWatcher) {
        mValue!!.addTextChangedListener(watcher)
    }

    public var value: Int
        get() = mValue!!.text.toString().toInt()
        set(v) {
            mValue!!.text = v.toString()
        }

    public var name: String
        get() = mItemName!!.text.toString()
        set(v) {
            mItemName!!.text = v.toString()
        }

    public var price: Int
        get() = Integer.valueOf(mItemPrice!!.text.toString())
        set(v) {
            mItemPrice!!.text = v.toString()
        }

    override fun onClick(v: View) {
        var x = mValue!!.text.toString().toInt()
        when (v.id) {
            R.id.downButton -> x--
            R.id.upButton -> x++
        }
        if(x < 0)
            x = 0
        mValue!!.text = x.toString()
    }


}