package listerners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class NgListener implements ITestListener{
	public void onFinish(ITestContext arg0) {					
        // TODO Auto-generated method stub				
		System.out.println("TestEnded:"+arg0.getEndDate());	
    }		

    public void onStart(ITestContext arg0) {					
        // TODO Auto-generated method stub				
        	System.out.println("TestStarted:"+arg0.getStartDate());	
    }		
    public void onTestFailure(ITestResult arg0) {					
        // TODO Auto-generated method stub				
        		
    }		
    public void onTestStart(ITestResult result) {
    	// TODO Auto-generated method stub
    	
    }
    public void onTestSuccess(ITestResult result) {
    	// TODO Auto-generated method stub
    	System.out.println("TestSuccess:"+result.getName());	
    }

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}
}
