package edu.bo.segundoparcial

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.book_row.view.*

class BookListAdapter(val items: ArrayList<Book>, val context: Context):
    RecyclerView.Adapter<BookListAdapter.BookListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookListViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.book_row, parent, false)
        return BookListViewHolder(v)
    }

    override fun getItemCount(): Int {
        return items.count()

    }

    override fun onBindViewHolder(holder: BookListViewHolder, position: Int) {
        val book = items.get(position)
        holder.itemView.textView.text = book.id.toString()
        holder.itemView.textView2.text = book.title
        holder.itemView.textView3.text = book.pages.toString()
        holder.itemView.textView4.text = book.editorial
        holder.itemView.textView5.text = book.author
        holder.itemView.textView6.text = book.description
        val picasso = Picasso.get()
        picasso.load(book.photoUrl).into(holder.itemView.my_image_view)
    }

    class BookListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

}