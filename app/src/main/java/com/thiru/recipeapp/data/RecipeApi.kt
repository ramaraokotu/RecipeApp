package com.thiru.recipeapp.data

import com.thiru.recipeapp.data.dto.RecipeList
import com.thiru.recipeapp.data.dto.RecipeSummary
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RecipeApi {

    @GET("complexSearch")
    suspend fun getRecipes(
        @Query("number") number: Int,
        @Query("apiKey") apiKey: String = API_KEY,
    ): RecipeList?

    @GET("complexSearch")
    suspend fun searchRecipes(
        @Query("query") query: String,
        @Query("apiKey") apiKey: String = API_KEY,
    ): RecipeList


    @GET("{id}/summary")
    suspend fun recipeSummary(
        @Path("id") id: Int,
        @Query("apiKey") apiKey: String = API_KEY,
    ): RecipeSummary

    companion object {
        const val BASE_URL = "https://api.spoonacular.com/recipes/"
        const val API_KEY = "ab0b2f8d36d94e0a94b1e9ae8db8cbe4"
    }
}
