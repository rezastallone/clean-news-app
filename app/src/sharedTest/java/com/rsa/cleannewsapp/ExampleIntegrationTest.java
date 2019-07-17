package com.rsa.cleannewsapp;

import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class ExampleIntegrationTest {

    @Test
    public void useAppContext() {

        assertEquals("com.rsa.cleannews", "com.rsa.cleannews");
    }
}
