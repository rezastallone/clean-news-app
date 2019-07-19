package com.rsa.cleannewsapp.core.data.repository;

import com.rsa.cleannewsapp.core.data.repository.datasource.NewsArticleLocalDataStore;
import com.rsa.cleannewsapp.core.data.repository.datasource.NewsArticleRemoteDataStore;
import com.rsa.cleannewsapp.core.domain.entity.Article;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@RunWith(MockitoJUnitRunner.class)
public class DefaultNewsArticleRepositoryTest {

    private DefaultNewsArticleRepository defaultNewsArticleRepository;

    @Mock
    private NewsArticleLocalDataStore newsArticleLocalDataStore;

    @Mock
    private NewsArticleRemoteDataStore newsArticleRemoteDataStore;

    @Before
    public void setUp() throws Exception {
        defaultNewsArticleRepository = new DefaultNewsArticleRepository(newsArticleRemoteDataStore,
            newsArticleLocalDataStore);
    }

    @Test
    public void givenAConcreteNewsArticleRepository() {
        assertThat(defaultNewsArticleRepository, instanceOf(DefaultNewsArticleRepository.class));
    }

    @Test
    public void getHeadlineObservableFromRemoteStore() {
        defaultNewsArticleRepository.headlines("id");
        verify(newsArticleRemoteDataStore).headlines("id");
        verifyNoMoreInteractions(newsArticleRemoteDataStore);
    }

    @Test
    public void getBookmarkedObservableFromLocalStore() {
        defaultNewsArticleRepository.bookmarkedNews();
        verify(newsArticleLocalDataStore).getBookmarkedNews();
        verifyNoMoreInteractions(newsArticleLocalDataStore);
    }

    @Test
    public void setBookmarkedObservableToLocalStore() {
        ArrayList<Article> bookmarkedNews = new ArrayList<>();
        defaultNewsArticleRepository.setBookmarkedNews(bookmarkedNews);
        verify(newsArticleLocalDataStore).addBookmarkedNews(bookmarkedNews);
        verifyNoMoreInteractions(newsArticleLocalDataStore);
    }
}