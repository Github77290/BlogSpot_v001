package com.Blogspot.Tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.Blogspot.Utilities.ScreenRecorderUtil;
import com.Blogspot.globalTest.BaseTest;
import com.Blogspot.pages.Testautomationpage;
import com.Blogspot.pages.Testautomationpage1;
import com.google.zxing.NotFoundException;

public class Testautomation extends BaseTest {
	@Test
	public void verifyTestAutomation() throws Exception {
		 ScreenRecorderUtil.startRecord("testAutomation");
		Testautomationpage TAP=new Testautomationpage(getDriver());
		TAP.verifyheadertitle();
		TAP.verifyNewWindows();
		TAP.verifyAlert();
		TAP.verifyDatepicker();
		TAP.verifySelectmenu();
		//ta_VolunteerSignup VSU=new ta_VolunteerSignup(getDriver());
		//VSU.verifyVolunteerSignup();
		Testautomationpage1 TAP1=new Testautomationpage1(getDriver());
		TAP1.verifyDragandDrop();
		TAP1.verifyDraganddropimages();
		TAP1.verifySlider();
		TAP1.verifyResizable();
		TAP1.verifyBasrcode();
		TAP1.verifyQRcode();
		TAP1.verifyTable();
		ScreenRecorderUtil.stopRecord();
		
	}
}




