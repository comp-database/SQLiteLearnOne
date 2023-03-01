package com.example.sqlitelearnone

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns
import com.example.sqlitelearnone.DataBaseHelper.DataBaseEntryContract.DataEntry.CUSTOMER_TABLE


// databaseHelper class created by us
// QLiteOpenHelper is system super class
// shown below is standard SQLite Primary Syntax
class DataBaseHelper(context: Context) : SQLiteOpenHelper(context,"customer.db",null,1) {




    object DataBaseEntryContract {
        // Table contents are grouped together in an anonymous object.
        object DataEntry : BaseColumns {
            const val CUSTOMER_TABLE = "CUSTOMER_TABLE"
            const val COLUMN_CUSTOMER_NAME = "CUSTOMER_NAME"
            const val COLUMN_CUSTOMER_AGE = "CUSTOMER_AGE"
            const val COLUMN_ID = "ID"
        }
    }

    //this is called when database is first time accessed
    //there should code inside here to create new database
    override fun onCreate(p0: SQLiteDatabase?) {
        // this method Automatically called when app requests or inputs the data
        // need to create new table inside this method

        //here p0 is db instance variable

        //val createTableStatement : String  = "CREATE TABLE CUSTOMER_TABLE (ID INTEGER PRIMARY KEY AUTOINCREMENT ,CUSTOMER_NAME TEXT,CUSTOMER_AGE INT)"

        p0?.execSQL(SQL_CREATE_ENTRIES)
    }

    //this is called when version of your database changes
    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }


    // CONST VAL is not allowed so need to create companion object
    // companion object works as static in kotlin

    companion object {
        private const val SQL_CREATE_ENTRIES =
            "CREATE TABLE ${DataBaseEntryContract.DataEntry.CUSTOMER_TABLE} (${DataBaseEntryContract.DataEntry.COLUMN_ID} INTEGER PRIMARY KEY AUTOINCREMENT,${DataBaseEntryContract.DataEntry.COLUMN_CUSTOMER_NAME} TEXT,${DataBaseEntryContract.DataEntry.COLUMN_CUSTOMER_AGE} INT)"
    }

    public fun addOne(customerModel: CustomerModel):Boolean{
        val db : SQLiteDatabase = this.writableDatabase

        //ContentValues is similar to putExtra in Intent
        // Create a new map of values, where column names are the keys
        val Column_name  = ContentValues().apply {
            put(DataBaseEntryContract.DataEntry.COLUMN_CUSTOMER_NAME, customerModel.name)
        }
//        val Column_age = ContentValues().apply {
//            put(DataBaseEntryContract.DataEntry.COLUMN_CUSTOMER_AGE, customerModel.age)
//        }
        val insert = db.insert(CUSTOMER_TABLE, null, Column_name)

        return true
    }
}