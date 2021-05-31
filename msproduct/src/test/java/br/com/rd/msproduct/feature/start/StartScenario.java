package br.com.rd.msproduct.feature.start;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StartScenario {

    @Before
    public void beforeall(Scenario scenario) {
        //Start here your scenario
    }

    @After
    public void hookToEachAfter(Scenario scenario) {
        //Start here your scenario
    }

}