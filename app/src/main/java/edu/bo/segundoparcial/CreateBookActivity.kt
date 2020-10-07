package edu.bo.segundoparcial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_create_book.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CreateBookActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_book)


        button_create.setOnClickListener {
            GlobalScope.launch {
                val bookDao = AppRoomDatabase.getDatabase(applicationContext).bookDato()
                val repository = BookRepository(bookDao)

                val editTextTitle = findViewById<EditText>(R.id.editTextTextTitle)
                val editTextTitleValue = editTextTitle.text
                val editTextPages = findViewById<EditText>(R.id.editTextTextPages)
                val editTextPagesValue = editTextPages.text
                val editTextEditorial = findViewById<EditText>(R.id.editTextTextEditorial)
                val editTextEditorialValue = editTextEditorial.text
                val editTextTextAuthor = findViewById<EditText>(R.id.editTextTextAuthor)
                val editTextTextAuthorValue = editTextTextAuthor.text
                val editTextTextDescription = findViewById<EditText>(R.id.editTextTextDescription)
                val editTextTextDescriptionValue = editTextTextDescription.text
                val editTextTextPhotoUrl = findViewById<EditText>(R.id.editTextTextPhotoUrl)
                val editTextTextPhotoUrlValue = editTextTextPhotoUrl.text

//                Log.d("Prueba","title = ${editTextValue}")

                repository.insert(
                    Book(
                        editTextTitleValue.toString(),
                        editTextPagesValue.toString().toInt(),
                        editTextEditorialValue.toString(),
                        editTextTextAuthorValue.toString(),
                        editTextTextDescriptionValue.toString(),
                        editTextTextPhotoUrlValue.toString()
                    )
                )

            }

        }
    }
}