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