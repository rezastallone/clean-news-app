package com.rsa.cleannewsapp.core.data.repository;

import com.rsa.cleannewsapp.core.data.remote.NewsService;

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
    private NewsService newsService;

    @Before
    public void setUp() throws Exception {
        defaultNewsArticleRepository = new DefaultNewsArticleRepository(newsService);
    }

    @Test
    public void givenAConcreteNewsArticleRepository() {
        assertThat(defaultNewsArticleRepository, instanceOf(DefaultNewsArticleRepository.class));
    }

    @Test
    public void getHeadlineObservableFromNewsService() {
        defaultNewsArticleRepository.headlines("id");
        verify(newsService).headlines("id");
        verifyNoMoreInteractions(newsService);
    }
}