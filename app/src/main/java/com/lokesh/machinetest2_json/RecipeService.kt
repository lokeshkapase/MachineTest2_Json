package com.lokesh.machinetest2_json

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RecipeService {

    @GET("recipes")
    suspend fun fetchRecipes(): RecipeResponse

    companion object {
        fun getInstance(): RecipeService {
            val interceptor = HttpLoggingInterceptor().apply {
                var level = HttpLoggingInterceptor.Level.BODY
            }
            val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

            return Retrofit.Builder()
                .baseUrl("https://dummyjson.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
                .create(RecipeService::class.java)
        }
    }
}