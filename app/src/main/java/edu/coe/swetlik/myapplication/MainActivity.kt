package edu.coe.swetlik.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.util.Log
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i("Create", "Complete")
    }

    fun greet(v:View) {
        Toast.makeText(this, "Toasty", Toast.LENGTH_SHORT).show();
        changeTxt(v);
    }

    fun changeTxt(v:View) {
        var g = this.findViewById<TextView>(R.id.output_price_view);
        g.text = "Button Press Boyyyyy";
    }
}