package ro.mta.se.lab.Controller;

import javafx.collections.FXCollections;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class InputDataTest {
    private InputData inputData;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        inputData = new InputData("src/test/java/ro/mta/se/lab/Controller/testfile.txt");
    }

    @Test
    public void getCountryList() {
        // elementele listei vor fi totusi returnate pana la intampinarea exceptiei respective
        // si ne asteptam sa fie aratat mesajul unei exceptii

        String s = "SO";
        ArrayList<String> expectedResult = new ArrayList<>();
        expectedResult.add("SO");
        assertEquals(FXCollections.observableArrayList(expectedResult), inputData.getCountryList());
    }

    @Test
    public void getCityList() {
        // din implementarea functiei getCityList, putem forta aruncarea unei exceptii, in scopul testarii
        expectedException.expect(ArrayIndexOutOfBoundsException.class);
        inputData.getCityList("M");
    }
}