package finalproject.stn991523983.org

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper



class DBOpenHelper (
    context: Context?,
 //   name: String?,
    factory:SQLiteDatabase.CursorFactory?,
 //   version: Int
): SQLiteOpenHelper(context, name, factory, version) {
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }
     override fun onCreate(db: SQLiteDatabase?) {
        TODO("Not yet implemented")
    }

    companion object {
        private val version = 1
        private val name ="UserNames.db"
        val TABLE_NAME ="users1"
        val COLUMN_ID= "_id"
        val COLUMN_NAME1 = "firstname"
        val COLUMN_NAME2 = "lastname"
        val COLUMN_NAME3 = "weight"

    }

}

