package com.notepadtest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.windows.WindowsDriver;

public class NotepadPlus {
	
	
	public WindowsDriver driver = null;
	
	@BeforeClass
	public void setUp()
	{
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("app", "C:\\Program Files\\Notepad++\\notepad.exe");
		cap.setCapability("platformName", "windows");
		cap.setCapability("deviceName", "windowsPC");
		
		try {
			driver=new WindowsDriver(new URL("http://127.0.0.1:4723/"),cap);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void cleanUp()
	{
		driver.quit();
		setUp();
	}

}
