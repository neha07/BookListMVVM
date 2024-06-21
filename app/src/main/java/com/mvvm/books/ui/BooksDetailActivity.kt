package com.mvvm.books.ui

import android.os.Bundle
import android.widget.ImageView
import android.widget.ScrollView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import coil.load
import com.mvvm.books.BooksApplication
import com.blinkslabs.blinkist.android.challenge.R
import com.mvvm.books.data.model.Book
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import javax.inject.Inject

class BooksDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_detail)

        val title = intent.getStringExtra("title")
        val description = intent.getStringExtra("description")
        val author = intent.getStringExtra("author")
        val date = intent.getStringExtra("release_date")
        val image = intent.getStringExtra("image")

        findViewById<TextView>(R.id.titleTextView).text = title
        findViewById<TextView>(R.id.descriptionTextView).text = description
        findViewById<TextView>(R.id.authorTextView).text = "Author : $author"
        findViewById<ImageView>(R.id.detailImageView).load(image)
        val formattedDate = SimpleDateFormat("EEE, MMM d, ''yy", Locale.US).format(SimpleDateFormat("M/d/yyyy", Locale.US).parse(date)!!)
        findViewById<TextView>(R.id.dateTextView).text = formattedDate
    }
}
