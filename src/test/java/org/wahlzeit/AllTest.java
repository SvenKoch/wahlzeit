package org.wahlzeit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.wahlzeit.handlers.HandlersTest;
import org.wahlzeit.model.ModelTest;
import org.wahlzeit.model.persistence.ModelPersistenceTest;
import org.wahlzeit.services.ServicesTest;
import org.wahlzeit.services.mailing.ServicesMailingTest;
import org.wahlzeit.utils.UtilsTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	HandlersTest.class,
	ModelTest.class,
	ModelPersistenceTest.class,
	ServicesTest.class,
	ServicesMailingTest.class,
	UtilsTest.class	
})
public class AllTest {

}
