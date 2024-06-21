package com.mvvm.books.ui

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.blinkslabs.blinkist.android.challenge.R
import com.mvvm.books.data.model.Book

class BookListRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val items = ArrayList<Book>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.book_list_item, parent, false)
        return BookViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val bookHolder = holder as BookViewHolder
        val book = items[position]

        bookHolder.titleTextView.text = book.title
        val firstLine = book.description?.split("\n")?.firstOrNull() ?: ""
        bookHolder.descriptionTextView.text = firstLine
        bookHolder.coverImageView.load(book.image)

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, BooksDetailActivity::class.java).apply {
                putExtra("title", book.title)
                putExtra("description", book.description)
                putExtra("author", book.author)
                putExtra("release_date",book.release_date)
                putExtra("image",book.image)
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount() = items.size

    fun setItems(items: List<Book>) {
        this.items.clear()
        this.items.addAll(items)
    }

    private class BookViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var descriptionTextView: TextView = v.findViewById(R.id.descTextView)
        var titleTextView: TextView = v.findViewById(R.id.titleTextView)
        var coverImageView: ImageView = v.findViewById(R.id.coverImageView)
    }
}
