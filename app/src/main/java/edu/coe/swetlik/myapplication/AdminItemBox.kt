package edu.coe.swetlik.myapplication

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import java.text.DecimalFormat
import java.text.NumberFormat

class AdminItemBox : LinearLayout, View.OnClickListener {

    private var mBaseObj: LinearLayout? = this
    private var mItemName: EditText? = null
    private var mItemPrice: EditText? = null
    private var mRemoveButton: Button? = null

    private var itemName: String = "Item Name"
    private var itemPrice: Float = 0f

    constructor(context: Context) : super(context)
    {
        initializeViews(context);
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        initializeViews(context)
        val ta = context.obtainStyledAttributes(attrs, R.styleable.AdminItemBox)

        itemName = ta.getString(R.styleable.AdminItemBox_adminItemName).toString()
        itemPrice = ta.getFloat(R.styleable.AdminItemBox_adminItemPrice, 0f)

        ta.recycle()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr ) {
        initializeViews(context)
        val ta = context.obtainStyledAttributes(attrs, R.styleable.AdminItemBox)

        itemName = ta.getString(R.styleable.AdminItemBox_adminItemName).toString()
        itemPrice = ta.getFloat(R.styleable.AdminItemBox_adminItemPrice, 0f)

        ta.recycle()
    }

    private fun initializeViews(context: Context) {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.updownbox, this)
        mItemName = findViewById<View>(R.id.itemNameEditText) as EditText
        mItemName!!.hint = itemName.toString()
        mItemPrice = findViewById<View>(R.id.itemPriceEditText) as EditText
        mItemPrice!!.hint = itemPrice.toString()
        mRemoveButton = findViewById<View>(R.id.removeButton) as Button

        mRemoveButton!!.setOnClickListener(this)
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
    }

    var name: String
        get() = mItemName!!.hint.toString()
        set(v) {
            mItemName!!.hint = v
        }

    var price: Float
        get() = DecimalFormat.getCurrencyInstance().parse(mItemPrice!!.hint.toString()).toFloat()
        set(v) {
            mItemPrice!!.hint = NumberFormat.getCurrencyInstance().format(v).toString()

        }

    override fun onClick(v: View?) {

    }

}