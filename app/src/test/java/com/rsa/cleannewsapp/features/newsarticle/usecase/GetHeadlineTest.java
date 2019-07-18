package com.rsa.cleannewsapp.features.newsarticle.usecase;

import com.rsa.cleannewsapp.features.newsarticle.repository.NewsArticleRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import io.reactivex.schedulers.Schedulers;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@RunWith(MockitoJUnitRunner.class)
public class GetHeadlineTest {

    private GetHeadline getHeadline;

    @Mock
    private NewsArticleRepository newsArticleRepository;

    @Before
    public void setUp() throws Exception {
        getHeadline = givenHeadlineUsecase();
    }

    private GetHeadline givenHeadlineUsecase() {
        return new GetHeadline(Schedulers.trampoline(), Schedulers.trampoline(),
            newsArticleRepository);
    }

    @Test
    public void givenAConcreteUseCaseOfGetHeadline() {
        assertThat(getHeadline, instanceOf(GetHeadline.class));
    }

    @Test
    public void getHeadlineObservableFromRepository() {
        getHeadline.createObservableUseCase();
        verify(newsArticleRepository).headlines("id");
        verifyNoMoreInteractions(newsArticleRepository);
    }
}