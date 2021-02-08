package edu.coe.swetlik.myapplication

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TableRow
import android.widget.TextView

class UpDownBox : TableRow, View.OnClickListener {

    private var mItemName: TextView? = null
    private var mItemPrice: TextView? = null
    private var mDownButton: Button? = null
    private var mUpButton: Button? = null
    private var mValue: TextView? = null
    private var startVal = 0

    constructor(context: Context) : super(context)
    {
        initializeViews(context);
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        initializeViews(context)
        val ta = context.obtainStyledAttributes(attrs, R.styleable.UpDownBox)
        startVal = ta.getInt(R.styleable.UpDownBox_startVal, 0)
        ta.recycle()
    }


    private fun initializeViews(context: Context) {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.updownbox, this)
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        mItemName = findViewById<View>(R.id.itemNameText) as TextView
        mItemPrice = findViewById<View>(R.id.itemPriceText) as TextView
        mDownButton = findViewById<View>(R.id.downButton) as Button
        mUpButton = findViewById<View>(R.id.upButton) as Button
        mValue = findViewById<View>(R.id.txtValue) as TextView
        mValue!!.text = startVal.toString()
        mDownButton!!.setOnClickListener(this)
        mUpButton!!.setOnClickListener(this)
    }

    var value: Int
        get() = mValue!!.text.toString().toInt()
        set(v) {
            mValue!!.text = v.toString()
        }

    override fun onClick(v: View) {
        var `val` = mValue!!.text.toString().toInt()
        when (v.id) {
            R.id.downButton -> `val`--
            R.id.upButton -> `val`++
        }
        mValue!!.text = `val`.toString()
    }
}