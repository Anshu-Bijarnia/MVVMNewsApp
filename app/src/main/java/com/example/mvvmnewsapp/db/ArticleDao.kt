package com.example.mvvmnewsapp.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.mvvmnewsapp.models.Article

@Dao
interface ArticleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert (article : Article) : Long

    @Query("SELECT * FROM articles")
    fun getAllArticles ():LiveData <List<Article>>

    @Delete
    fun deleteArticle (article: Article)
}