package org.wahlzeit.model;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.wahlzeit.model.coordinate.CoordinateTestSuite;
import org.wahlzeit.model.persistence.ModelPersistenceTestSuite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	AccessRightsTest.class,
	CoordinateTestSuite.class,
	FlagReasonTest.class,
	GenderTest.class,
	GuestTest.class,
	KeyboardPhotoFactoryTest.class,
	KeyboardPhotoTest.class,
	LocationTest.class,
	PhotoFilterTest.class,
	TagsTest.class,
	UserStatusTest.class,
	ValueTest.class,
	ModelPersistenceTestSuite.class
})
public class ModelTestSuite {

}
