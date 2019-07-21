package com.rsa.cleannewsapp.core.data.local;

import com.rsa.cleannewsapp.core.data.entity.Article;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import io.reactivex.Flowable;

@Dao
public interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Article article);

    @Query("Select * from article")
    Flowable<List<Article>> getBookmarkedArticles();

}
