package edu.bo.segundoparcial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_create_book.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.book_row.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        GlobalScope.launch {
            val bookDao = AppRoomDatabase.getDatabase(applicationContext).bookDato()
            val repository = BookRepository(bookDao)


//            repository.insert(Book("the best seller: Android",22,"Editorial1","JuanJose","descripcion del libro","https://i.pinimg.com/474x/a8/6e/26/a86e26dffbcd0f8ffd0b7a6a4809ec68.jpg"))
            val lista = repository.getListBooks()
            lista.forEach {
                Log.d("DBTEST","Id book = ${it.id}, Title: ${it.title}, Pages: ${it.pages}, Editorial: ${it.editorial}, Author: ${it.author}, Descripcion: ${it.description}, Url: ${it.photoUrl}")
            }

            recyclerView.adapter = BookListAdapter(lista as ArrayList<Book>, applicationContext)

            var linearLayoutManager = LinearLayoutManager(applicationContext)
            linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
            recyclerView.layoutManager = linearLayoutManager

        }


    }



    fun openCreateBookActivity(view: View) {
        startActivity(Intent(this, CreateBookActivity::class.java))
    }

}