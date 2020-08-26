package core;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	
	// executado antes de cada cenario
	@Before
	public void setUpCenario(Scenario cenario) {
	}

	// executado depois de cada cenario
	@After
	public void tearDownCenario(Scenario cenario) {
	}
	
}
