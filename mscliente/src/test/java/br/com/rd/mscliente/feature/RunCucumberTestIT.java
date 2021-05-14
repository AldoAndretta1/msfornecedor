package br.com.rd.mscliente.feature;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"classpath:br/com/rd/mscliente/feature/"},
        plugin = { "pretty" },
        extraGlue = {"br.com.rd.mscliente.feature.start"}
        )
public class RunCucumberTestIT {

}