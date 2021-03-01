package edu.coe.swetlik.myapplication

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

val DATABASE_NAME = "ITEMS"
val TABLE_CURRENT_NAME = "Items"
val COL_CURRENT_NAME = "name"
val COL_CURRENT_PRICE = "price"
val COL_CURRENT_ID = "id"

class SQLDatabase(var context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, 1) {

    override fun onCreate(db: SQLiteDatabase?) {
        createTable(db)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

    private fun createTable(db: SQLiteDatabase?) {
        val createTable =
                "CREATE TABLE " + TABLE_CURRENT_NAME + " (" + COL_CURRENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+ COL_CURRENT_NAME + " VARCHAR(256)," + COL_CURRENT_PRICE + " INTEGER)"
        db?.execSQL(createTable)
    }

    fun insertData(item: Item)
    {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(COL_CURRENT_NAME, item.name)
        cv.put(COL_CURRENT_PRICE, item.price)
        db.insert(TABLE_CURRENT_NAME, null, cv)
    }

    fun readData(): MutableList<Item> {
        val list: MutableList<Item> = mutableListOf()
        val db = this.readableDatabase
        val query = "Select * from $TABLE_CURRENT_NAME"
        val result = db.rawQuery(query, null)
        if(result.moveToFirst()) {
            do {
                val item = Item()
                item.name = result.getString(result.getColumnIndex(COL_CURRENT_NAME)).toString()
                item.price = result.getString(result.getColumnIndex(COL_CURRENT_PRICE)).toFloat()
                list.add(item)
            } while(result.moveToNext())
        }
        return list
    }

    fun clearData() {
        val db = this.readableDatabase
        val dropTable = "DROP TABLE IF EXISTS " + TABLE_CURRENT_NAME
        db.execSQL(dropTable)
        createTable(db)
    }
}