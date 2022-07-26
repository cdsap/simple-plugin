package com.example;


import org.junit.Test;

import static junit.framework.TestCase.assertFalse;

public class HelloExampleTest {

    @Test
    public void testApiKeyIsNotDebug() {
        HelloExample example = new HelloExample();
        assertFalse(example.getApiKey().equals("DEPLOYMENT_KEY"));
    }
}
