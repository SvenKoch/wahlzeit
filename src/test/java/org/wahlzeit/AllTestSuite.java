package org.wahlzeit;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.wahlzeit.handlers.HandlersTestSuite;
import org.wahlzeit.model.KeyboardPhotoFactory;
import org.wahlzeit.model.ModelTestSuite;
import org.wahlzeit.services.ServicesTestSuite;
import org.wahlzeit.utils.UtilsTestSuite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	HandlersTestSuite.class,
	ModelTestSuite.class,
	ServicesTestSuite.class,
	UtilsTestSuite.class	
})
public class AllTestSuite {

	@BeforeClass
	public static void init(){
		KeyboardPhotoFactory.initialize();
	}
}
