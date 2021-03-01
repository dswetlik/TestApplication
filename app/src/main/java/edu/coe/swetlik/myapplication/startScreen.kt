package edu.coe.swetlik.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class startScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_screen)

        Item.createDatabase(this)
    }

    fun loadMainActivity(v: View)
    {
        val intent = Intent(this@startScreen, MainActivity::class.java)
        startActivity(intent)
    }

    fun loadAdminActivity(v: View)
    {
        val intent = Intent(this@startScreen, AdminActivity::class.java)
        startActivity(intent)
    }

}