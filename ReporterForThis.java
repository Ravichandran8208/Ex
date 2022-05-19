package Ex;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.cucumber.testng.AbstractTestNGCucumberTests;


	public abstract  class ReporterForThis {
		
		public  ExtentHtmlReporter reporter;
		public  ExtentReports extent;
		public ExtentTest test;
		
		public static String testCaseName;
		public static String authors;
		public static String category;
		
		
		@BeforeSuite
		public void startReport() {
			reporter = new ExtentHtmlReporter("./report/result.html");
			reporter.setAppendExisting(true); 
			extent = new ExtentReports();
			extent.attachReporter(reporter);
		}
		
	    @BeforeClass
		public void report(String testCaseName,String authors,String category ) throws IOException {
			test = extent.createTest(testCaseName);
			test.assignAuthor(authors);
			test.assignCategory(category);  
		}
	    
	    public abstract long takeSnap();
	    public void reportStep(String dec, String status,boolean bSnap ) {
	    	MediaEntityModelProvider img = null;
			if(bSnap && !status.equalsIgnoreCase("INFO")){

				long snapNumber = 100000L;
				snapNumber = takeSnap();
				try {
					img = MediaEntityBuilder.createScreenCaptureFromPath
							("./../reports/images/"+snapNumber+".jpg").build();
				} catch (IOException e) {
					
				}
			}
	    	if(status.equalsIgnoreCase("pass")) {
	    		test.pass(dec, img);
	    	} else if(status.equalsIgnoreCase("fail")) {
	    		test.fail(dec, img); 
	    	}
	    }
	    
	    public void reportStep(String desc, String status) {
			reportStep(desc, status, true);
		}

	    
	    @AfterSuite
	    public void stopReport() {
	    	extent.flush();
	    }

}

