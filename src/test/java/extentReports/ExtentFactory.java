package extentReports;

import com.aventstack.extentreports.ExtentReports;

public class ExtentFactory {

    public static ExtentReports getInstance() {
        ExtentReports extentReports;
        extentReports = new ExtentReports();
        extentReports.setSystemInfo("Selenium Version", "4.0.0");
        extentReports.setSystemInfo("Platform", "Windows");

        return extentReports;
    }

}
