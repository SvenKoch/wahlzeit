package org.wahlzeit.services;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.wahlzeit.services.mailing.ServicesMailingTestSuite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	EmailAddressTest.class,
	LogBuilderTest.class,
	ServicesMailingTestSuite.class
})
public class ServicesTestSuite {

}
