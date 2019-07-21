package com.rsa.cleannewsapp.core.data.local;

import com.rsa.cleannewsapp.core.data.entity.Article;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Article.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract ArticleDao articleDao();
}
