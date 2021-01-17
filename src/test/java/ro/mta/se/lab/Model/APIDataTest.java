package ro.mta.se.lab.Model;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.Assert.*;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class APIDataTest {
    @Mock
    private Parser parser;

    @InjectMocks
    private APIData apiData;

    @Before
    public void setUp() throws Exception {
        parser = mock(Parser.class);
        // se ia JSON-ul asociat Baia Mare, RO
        apiData = new APIData("Baia Mare","RO");
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getThis() throws IOException {
        // testez ca in cazul in care parserul din functia getThis din APIData imi returneaza "300",
        // valoarea va fi transformata in grade Celsius
        when(parser.getParsed(anyString(),anyString())).thenReturn("300");
        assertEquals("28",apiData.getThis("temp"));
        // in cazul in care parserul returneaza "testIcon", trebuie convertit in URL
        when(parser.getParsed(anyString(),anyString())).thenReturn("\"testIcon\"");
        assertEquals("http://openweathermap.org/img/w/testIcon.png",apiData.getThis("icon"));
    }
}