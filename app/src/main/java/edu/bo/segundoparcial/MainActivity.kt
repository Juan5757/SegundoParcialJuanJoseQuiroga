package edu.bo.segundoparcial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        GlobalScope.launch {
            val bookDao = AppRoomDatabase.getDatabase(applicationContext).bookDato()
            val repository = BookRepository(bookDao)
            repository.insert(Book("the best seller: Android",22,"Editorial1","JuanJose","descripcion del libro","url"))
            repository.insert(Book("the best seller: Android2",50,"Editorial1","Pepe","descripcion del libro 2","url 2"))
            val lista = repository.getListBooks()
            lista.forEach {
                Log.d("DBTEST","Id book = ${it.id}, Title: ${it.title}, Pages: ${it.pages}, Editorial: ${it.editorial}, Author: ${it.author}, Descripcion: ${it.description}, Url: ${it.photoUrl}")
            }


            val lista1 = arrayListOf<Book>()
            lista.forEach {
                lista1.add(Book("${it.title}","${it.pages}".toInt(),"${it.editorial}","${it.author}","${it.description}","${it.photoUrl}"))
                val bookListAdapter = BookListAdapter(lista1, this@MainActivity)
                recyclerView.adapter = bookListAdapter
                val linearLayoutManager = LinearLayoutManager(this@MainActivity)
                linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
                recyclerView.layoutManager = linearLayoutManager

//                Log.d("DBTEST","Id book = ${it.id}, Title: ${it.title}, Pages: ${it.pages}, Editorial: ${it.editorial}, Author: ${it.author}, Descripcion: ${it.description}, Url: ${it.photoUrl}")
            }


//            val lista1 = arrayListOf<Book>()
//            lista1.add(Book("the best seller: Android",50,"Editorial1","JuanJose","descripcion del libro","url"))
//            lista1.add(Book("the best seller: Android 2",22,"Editorial2","Pepe","descripcion del libro 2","url 2"))
//
//            val bookListAdapter = BookListAdapter(lista1, this@MainActivity)
//            recyclerView.adapter = bookListAdapter
//            val linearLayoutManager = LinearLayoutManager(this@MainActivity)
//            linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
//            recyclerView.layoutManager = linearLayoutManager
        }


    }
}