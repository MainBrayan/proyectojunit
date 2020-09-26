package com.example.proyectojunit.simpleassert;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Se usa junit4 para poder trabajar con powermock
@RunWith(PowerMockRunner.class)
@PrepareForTest(Bazinga.class)
public class BazingaTestJUnit4 {

    Bazinga bazinga;

    @Before
    public void setUp() {
        bazinga = new Bazinga();
    }

    @Test
    public void bazinagaPrivadoTest() throws Exception {
        Map<String, String> reglasLocales =
                Whitebox.invokeMethod(bazinga, "buildElements");

        Assert.assertTrue(reglasLocales.get("tijeras").equals(buildElements().get("tijeras")));
    }

    @Test
    public void bazinagaPrivadoTest2() throws Exception {
        Bazinga mock = PowerMockito.spy(new Bazinga());
        PowerMockito.doReturn(this.buildElements())
                .when(mock, "buildElements");

        mock.recargarReglas();

        PowerMockito.verifyPrivate(mock).invoke("buildElements");
    }

    @Test(timeout = 10000)
    public void checkPerformance() {
        int[] array = {34, 56, 1, 44};
        for (int i = 0; i < 1000000; i++) {
            array[0] = i;
            Arrays.sort(array);
        }
    }

    private Map<String, String> buildElements() {
        Map<String, String> elements = new HashMap<>();
        elements.put("tijeras", "papel lagarto");
        elements.put("papel", "piedra Spock");
        return elements;
    }
}
