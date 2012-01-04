package com.communispace.otto.persistence;

import java.util.List;
import org.apache.log4j.Logger;
import org.ektorp.CouchDbConnector;
import org.ektorp.support.CouchDbRepositorySupport;
import org.ektorp.support.GenerateView;
import org.ektorp.support.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TestRepository extends CouchDbRepositorySupport<Test> {

    private static org.apache.log4j.Logger logger = Logger.getLogger(TestRepository.class);  //make sure you change the class!

    @Autowired
    public TestRepository(@Qualifier("testDatabase") CouchDbConnector db) {
        super(Test.class, db);
        initStandardDesignDocument();
    }
	
	@GenerateView
	public List<Test> findByTestClass(String testClass) {
		List<Test> results = queryView("by_testClass", testClass);
		return results;
	}	
	
	@View( name="past_week_unstable",
		map=
			  "function(doc) { "
			+ " var hadSuccess = hadFailure = false; "
			+ " for(var i=Math.max(0,doc.results.length-7); i<doc.results.length; i++) { "
			+ "  var result = doc.results[i]; "
			+ "  hadSuccess = hadSuccess || result.outcome === 'SUCCESS';"
			+ "  hadFailure = hadFailure || result.outcome === 'FAILURE';"
			+ " }"
			+ " if(hadSuccess && hadFailure) emit(null, doc); "
			+ "}"
	)
	public List<Test> getPastWeekUnstable() {
		return queryView("past_week_unstable");
	}
}