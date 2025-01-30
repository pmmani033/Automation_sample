package com.step_definitions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import drivermanage.Drivermanagers;

public class Screenshot {

	public void takescreenshot(String testName) throws IOException {
		File screenshotFile = ((TakesScreenshot) Drivermanagers.getDriver()).getScreenshotAs(OutputType.FILE);
		String timestamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		String filePath = System.getProperty("user.dir") + "/Screenshots/" + testName + "_screenshot_" + timestamp + ".png";
		try {
			FileUtils.copyFile(screenshotFile, new File(filePath));
			System.out.println("Screenshot saved at: " + filePath);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}



