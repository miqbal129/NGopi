package com.example.ngopi

//import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ngopi.R
import com.example.ngopi.view.PhotoListAdapter
import com.example.ngopi.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.activity_main.*


class Menu : AppCompatActivity() {

    lateinit var viewModel: ListViewModel
    private val photoListAdapter = PhotoListAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(ListViewModel::class.java)
        viewModel.fetchData()

        rv_list.apply{
            layoutManager = LinearLayoutManager(context)
            adapter = photoListAdapter
        }
        observeViewModel()
    }

    fun observeViewModel(){
        viewModel.photos.observe(this, Observer{ photos ->
            photos?.let{
                photoListAdapter.updatePhotos(it)
            }
        })
    }
    fun home (view: View?) {
        val i = Intent(applicationContext, com.example.ngopi.home::class.java)
        startActivity(i)

    }
}