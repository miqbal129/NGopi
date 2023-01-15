package com.example.ngopi.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.ngopi.R
import com.example.ngopi.model.Photo
import kotlinx.android.synthetic.main.activity_menu.view.plus
import kotlinx.android.synthetic.main.activity_menu2.view.*
import kotlinx.android.synthetic.main.menu3.view.*


class PhotoListAdapter(var photos: ArrayList<Photo>):
    RecyclerView.Adapter<PhotoListAdapter.ViewHolder>() {
    fun updatePhotos(newPhotos: List<Photo>){
        photos.clear()
        photos.addAll(newPhotos)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder (parent: ViewGroup, p1: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.activity_menu2, parent, false)
    )

    override fun getItemCount() = photos.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(photos[position])
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        fun bind(photos: Photo){
            val detail :ImageView = itemView.esp
            val requestOp = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
            itemView.textesp.text = photos.desc
//            itemView.tvTitle.text = photos.merk
//            itemView.plat.text = photos.plat
//            itemView.rating.text = photos.rating
//            itemView.harga.text = photos.harga
            // itemView.hargabrio.text = photos.harga


            val urGambar=photos.thumbnail1
            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOp)
                .load("$urGambar.png")
                .into(detail)
//            val urGambar1=photos.thumbnail1
//            Glide.with(itemView.context)
//                .applyDefaultRequestOptions(requestOp)
//                .load("$urGambar1.png")
//                .into(detail)
        }
    }
}





