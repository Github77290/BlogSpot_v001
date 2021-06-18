package com.Blogspot.pages;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.Blogspot.Utilities.Log;
import com.Blogspot.globalPage.BasePage;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;


public class Testautomationpage1 extends BasePage{
	
	public Testautomationpage1(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//div[@id='draggable']")
	WebElement drag;
	
	@FindBy(xpath="//div[@id='droppable']")
	WebElement drop;
	
	@FindBy(xpath="//*[@id='gallery']/li[1]/img")
	WebElement img1;
	
	@FindBy(xpath="//*[@id='gallery']/li[2]/img")
	WebElement img2;
	
	@FindBy(xpath="//*[@id='trash']")
	WebElement trash;
	
	@FindBy(xpath="//*[@id='trash']/h4/span")
	WebElement deleteimages;
	
	@FindBy(xpath="//*[@id='slider']/span")
	WebElement slider;
	
	@FindBy(xpath="//*[@id='resizable']/div[3]")
	WebElement resizable;
	
	@FindBy(xpath="//*[@class='widget-content']/img[1]")
	WebElement barcode1;
	
	@FindBy(xpath="//*[@class='widget-content']/img[2]")
	WebElement barcode2;
	
	@FindBy(xpath="//*[@id='HTML4']/div[1]/img")
	WebElement qrcode;
	
	@FindBy(xpath="//div[@id='HTML1']/div[1]/table/tbody/tr")
	List<WebElement> tablerow;
	
	@FindBy(xpath="//div[@id='HTML1']/div[1]/table/tbody/tr[2]/td")
	List<WebElement> tablecol;
	
	
	public void verifyDragandDrop() {
		try {
		Actions act=new Actions(getDriver());
		act.dragAndDrop(drag,drop).build().perform();
		Log.info("Succesfully verify Drag and Drop");
	}catch (Exception e){
		Log.error("Failed to Verify  Drag and Drop");
	}
	}
	
	public void verifyDraganddropimages() {
		try {
		Actions act=new Actions(getDriver());
		act.dragAndDrop(img1, trash).build().perform();
		act.dragAndDrop(img2, trash).build().perform();
		Log.info("Succesfully verify Drag and Drop images");
	}catch (Exception e){
		Log.error("Failed to Verify  Drag and Drop images");
	}
	
	}
	public void verifySlider() {
		try {
		Actions act=new Actions(getDriver());
		act.moveToElement(slider).dragAndDropBy(slider,300, 0).build().perform();
		Log.info("Succesfully verify slider");
		}catch (Exception e){
			Log.error("Failed to Verify slider");
		}
		}
	
	public void verifyResizable() {
		try {
		Actions act=new Actions(getDriver());
		act.moveToElement(resizable).dragAndDropBy(slider,150,200).build().perform();
		Log.info("Succesfully verify Resizable");
		}catch (Exception e){
			Log.error("Failed to Verify Resizable");
		}
	}
	
	public void verifyBasrcode() throws IOException, NotFoundException {
		try {
		String barcode=barcode1.getAttribute("src");
		URL url=new URL(barcode);
		BufferedImage bufferedimage=ImageIO.read(url);
		
		LuminanceSource luminanceSource =new BufferedImageLuminanceSource(bufferedimage);
		
		BinaryBitmap binarybitmap=new BinaryBitmap(new HybridBinarizer(luminanceSource));
		
		Result result=new MultiFormatReader().decode(binarybitmap);
		
		String barcodetext=result.getText();
		
		System.out.println(barcodetext);
		
		

		String barcode1=barcode2.getAttribute("src");
		URL url1=new URL(barcode1);
		BufferedImage bufferedimage1=ImageIO.read(url1);
		
		LuminanceSource luminanceSource1 =new BufferedImageLuminanceSource(bufferedimage1);
		
		BinaryBitmap binarybitmap1=new BinaryBitmap(new HybridBinarizer(luminanceSource1));
		
		Result result1=new MultiFormatReader().decode(binarybitmap1);
		
		String barcodetext1=result1.getText();
		
		System.out.println(barcodetext1);
		Log.info("Succesfully verify Barcode");
		}catch (Exception e){
			Log.error("Failed to Verify Barcode");
		}
		

	}
	public void verifyQRcode() throws IOException, NotFoundException {
		try {
		String barcode=qrcode.getAttribute("src");
		URL url=new URL(barcode);
		BufferedImage bufferedimage=ImageIO.read(url);
		
		LuminanceSource luminanceSource =new BufferedImageLuminanceSource(bufferedimage);
		
		BinaryBitmap binarybitmap=new BinaryBitmap(new HybridBinarizer(luminanceSource));
		
		Result result=new MultiFormatReader().decode(binarybitmap);
		
		String barcodetext=result.getText();
		
		System.out.println(barcodetext);
		Log.info("Succesfully verify QRcode");
		}catch (Exception e){
			Log.error("Failed to Verify QRcode");
		}
	}
	public void verifyTable() {
		try {
		int r=tablerow.size();
		System.out.println(r);
		int c=tablecol.size();
		System.out.println(c);
		
		String tabledata=getDriver().findElement(By.xpath("//div[@id='HTML1']/div[1]/table/tbody/tr/th")).getText();
		
		System.out.print("  " +tabledata);
	
		for(int i=2;i<r;i++) {
			
			for(int j=1;j<c;j++) {
				String tabledata1=getDriver().findElement(By.xpath("//div[@id='HTML1']/div[1]/table/tbody/tr["+i+"]/td["+j+"]")).getText();
			
			System.out.print("  " +tabledata1);
	
			}
			System.out.println();
		}
		Log.info("Succesfully verify Table");
		}catch (Exception e){
			Log.error("Failed to Verify Table");
		}
	}
	
	
	
}
