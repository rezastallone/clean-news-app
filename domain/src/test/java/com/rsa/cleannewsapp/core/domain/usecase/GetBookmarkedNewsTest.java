package com.rsa.cleannewsapp.core.domain.usecase;

import com.rsa.cleannewsapp.core.domain.repository.NewsArticleRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import io.reactivex.schedulers.Schedulers;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@RunWith(MockitoJUnitRunner.class)
public class GetBookmarkedNewsTest {

    private GetBookmarkedNews getBookmarkedNews;

    @Mock
    private NewsArticleRepository newsArticleRepository;

    @Before
    public void setUp() throws Exception {
        getBookmarkedNews = givenGetBookmarkedNews();
    }

    private GetBookmarkedNews givenGetBookmarkedNews() {
        return new GetBookmarkedNews(Schedulers.trampoline(), Schedulers.trampoline(),
            newsArticleRepository);
    }

    @Test
    public void givenAConcreteUseCaseOfGetBookmarkedNews() {
        assertThat(getBookmarkedNews, instanceOf(GetBookmarkedNews.class));
    }

    @Test
    public void getBookmarkedNewsObservableFromRepository() {
        getBookmarkedNews.createObservableUseCase();
        verify(newsArticleRepository).bookmarkedNews();
        verifyNoMoreInteractions(newsArticleRepository);
    }
}