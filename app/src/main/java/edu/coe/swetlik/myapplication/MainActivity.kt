package edu.coe.swetlik.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.util.Log
import android.view.View
import android.widget.TextView
import java.util.function.ToIntFunction

class MainActivity : AppCompatActivity() {

    var hotDogPrice:Int = 2
    var hotDogCount:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i("Create", "Complete")
    }

    fun greet(v:View) {
        //Toast.makeText(this, "Toasty", Toast.LENGTH_SHORT).show();
        changeTxt(v);
    }

    fun changeTxt(v:View) {
        var g = this.findViewById<TextView>(R.id.output_price_view);
        g.setText("12");
        var num = g.text.toString().toInt();
    }

    fun increaseAmount(v: View)
    {
        var g = this.findViewById<TextView>(R.id.output_price_view)
        var i = this.findViewById<TextView>(R.id.count_text)
        hotDogCount++
        g.setText((hotDogCount * hotDogPrice).toString());
        i.setText(hotDogCount.toString());
    }

    fun decreaseAmount(v: View)
    {
        var g = this.findViewById<TextView>(R.id.output_price_view)
        var i = this.findViewById<TextView>(R.id.count_text)

        hotDogCount--
        if(hotDogCount < 0)
            hotDogCount = 0
        g.setText((hotDogPrice * hotDogCount).toString());
        i.setText(hotDogCount.toString());
    }
}