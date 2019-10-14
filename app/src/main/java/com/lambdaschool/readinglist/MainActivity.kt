package com.lambdaschool.readinglist

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.provider.SyncStateContract
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.absoluteValue

class MainActivity : AppCompatActivity() {

    internal var context: Context? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        context = this

        preferences = getSharedPreferences(BOOK_PREFERENCES, Context.MODE_PRIVATE)

        add_book_button.setOnClickListener {
            val intent = Intent(context, EditBookActivity::class.java)
            val nextId = BookRepo.nextId().toString()
            intent.putExtra(NEW_BOOK_TAG, nextId)
            startActivityForResult(intent, NEW_BOOK_REQUEST_CODE)
        }

    }

    override fun onResume() {
        super.onResume()
        book_scroll_view.removeAllViews()
        book_scroll_view.addView(BooksController.getBooksView(context!!))

    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == NEW_BOOK_REQUEST_CODE && resultCode == RESULT_OK) {
            if (data != null) {
                BooksController.handleEditActivityResult(data)
            }
        }
        if (requestCode == EDIT_BOOK_REQUEST_CODE && resultCode == RESULT_OK) {
            if (data != null) {
                BooksController.handleEditActivityResult(data)
            }
        }
    }


    companion object {
         var preferences: SharedPreferences? = null
        fun diagonalDifference(arr: Array<Array<Int>>): Int {
            var a:Int =0
            var b:Int = 0
            val size = arr.size

            for (i in arr.indices) {
                for (j in arr.indices) {
                    if (i==j) {a += arr[i][j]}
                    if (i==size-j){b+= arr[i][j]}

                }
            }

/*

            val final =  if (Math.abs(a)>Math.abs(b)) {
                Math.abs(a)-Math.abs(b)
            }
            else {
                Math.abs(b)-Math.abs(a)
            }*/val final =Math.abs(a-b)

                        return final
        }
    }
}
