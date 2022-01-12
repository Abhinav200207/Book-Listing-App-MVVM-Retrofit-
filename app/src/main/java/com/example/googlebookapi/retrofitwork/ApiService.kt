package com.example.googlebookapi.retrofitwork

import com.example.googlebookapi.api.Books
import com.example.googlebookapi.apisingle.Info
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("v1/volumes")
    suspend fun getBooks(@Query("q") q : String) : Response<Books>

//    @GET("v1/volumes/{id}")
//    suspend fun getInfo(@Path("id") id : String) : Response<Info>

}