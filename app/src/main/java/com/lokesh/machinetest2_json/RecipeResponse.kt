package com.lokesh.machinetest2_json

import com.google.gson.annotations.SerializedName

data class RecipeResponse(
    @SerializedName("recipes")
    val recipes: ArrayList<Recipe>
)
data class Recipe(
    val id: Int,
    val name: String,
    val cuisine: String,
    val difficulty: String,
    @SerializedName("image")
    val imageUrl: String,
    val ingredients: ArrayList<String>,
    val instructions: ArrayList<String>
)
