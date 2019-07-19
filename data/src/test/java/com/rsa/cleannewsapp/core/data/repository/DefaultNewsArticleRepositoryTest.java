package com.rsa.cleannewsapp.core.data.repository;

import com.rsa.cleannewsapp.core.data.repository.datasource.NewsArticleRemoteDataStore;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@RunWith(MockitoJUnitRunner.class)
public class DefaultNewsArticleRepositoryTest {

    private DefaultNewsArticleRepository defaultNewsArticleRepository;

    @Mock
    private NewsArticleRemoteDataStore newsArticleRemoteDataStore;

    @Before
    public void setUp() throws Exception {
        defaultNewsArticleRepository = new DefaultNewsArticleRepository(newsArticleRemoteDataStore);
    }

    @Test
    public void givenAConcreteNewsArticleRepository() {
        assertThat(defaultNewsArticleRepository, instanceOf(DefaultNewsArticleRepository.class));
    }

    @Test
    public void getHeadlineObservableFromNewsService() {
        defaultNewsArticleRepository.headlines("id");
        verify(newsArticleRemoteDataStore).headlines("id");
        verifyNoMoreInteractions(newsArticleRemoteDataStore);
    }
}