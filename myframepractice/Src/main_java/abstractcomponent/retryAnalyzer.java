package abstractcomponent;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class retryAnalyzer implements IRetryAnalyzer{

	int count=0;
	int maxtry=3;
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if (count<maxtry) {
			count++;
			return true;
		}
		return false;
	}

}
