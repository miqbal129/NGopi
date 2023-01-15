package com.example.ngopi.model

import com.google.gson.annotations.SerializedName

data class Photo(
    @SerializedName("id")
    val id: String?,
    @SerializedName("gambar")
   val thumbnail: String?,
   @SerializedName("desc")
   val desc: String?,
    @SerializedName("gambar1")
   val thumbnail1: String?,
)
