package com.lambdaschool.readinglist

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.provider.SyncStateContract
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

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
    }
}
