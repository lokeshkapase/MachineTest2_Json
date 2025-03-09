package com.lokesh.machinetest2_json

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fetchRecipes()
    }

    private fun fetchRecipes() {
        val recipeService = RecipeService.getInstance()

        CoroutineScope(Dispatchers.IO).launch {

                val response = recipeService.fetchRecipes()

                for (recipe in response.recipes) {
                    Log.e("Recipe", "Name: ${recipe.name}, Cuisine: ${recipe.cuisine}")
                }

        }
    }
}