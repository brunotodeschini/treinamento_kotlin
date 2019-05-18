package com.example.brunooliveira.extratorca;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static junit.framework.TestCase.assertTrue;

@RunWith(JUnit4.class)
public class MainActivityTeste {

    private MainActivity mainActivity = new MainActivity();

    @Test //Teste para ver se a mainActivity carregou.
    public void testLoadActivity() {
        assertTrue(mainActivity != null);
    }

}