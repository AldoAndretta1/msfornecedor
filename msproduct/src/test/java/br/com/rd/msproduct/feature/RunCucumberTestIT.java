package br.com.rd.msproduct.feature;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"classpath:br/com/rd/msproduct/feature/"},
        plugin = { "pretty" },
        extraGlue = {"br.com.rd.msproduct.feature.start"}
        )
public class RunCucumberTestIT {

}