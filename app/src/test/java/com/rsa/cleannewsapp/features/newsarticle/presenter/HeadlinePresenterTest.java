package com.rsa.cleannewsapp.features.newsarticle.presenter;

import com.rsa.cleannewsapp.core.domain.usecase.GetHeadline;
import com.rsa.cleannewsapp.features.newsarticle.view.HeadlineView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import io.reactivex.observers.DisposableObserver;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class HeadlinePresenterTest {

    @Mock
    private GetHeadline getHeadline;

    private HeadlinePresenter headlinePresenter;

    @Mock
    private HeadlineView headlineView;

    @Before
    public void setUp() throws Exception {
        headlinePresenter = new HeadlinePresenter(getHeadline);
        headlinePresenter.setView(headlineView);
    }

    @Test
    public void testUserDetailsPresenterInitialize() {
        headlinePresenter.initialize();

        verify(headlineView).showLoading();
        verify(getHeadline).execute(ArgumentMatchers.any(DisposableObserver.class));
    }
}