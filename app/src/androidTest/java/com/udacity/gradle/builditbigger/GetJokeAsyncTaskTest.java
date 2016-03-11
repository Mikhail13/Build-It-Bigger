package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.support.test.runner.AndroidJUnit4;
import android.test.InstrumentationTestCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class GetJokeAsyncTaskTest extends InstrumentationTestCase {

    private GetJokeAsyncTask asyncTask;
    private String baseUrl;

    @Before
    public void setUp() {
        Context context = getInstrumentation().getTargetContext();
        asyncTask = new GetJokeAsyncTask(null);
        baseUrl = context.getResources().getString(R.string.backend_base_url);
    }

    @Test
    public void testAsyncTaskRetrievesNonEmptyString() {
        String result = asyncTask.doInBackground(baseUrl);

        assertNotNull(result);

        assertFalse(result.isEmpty());
    }
}
