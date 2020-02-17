package testCases;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.testng.annotations.Test;

import com.excel.utility.Xls_Reader;

import pageObjectModel.cica_LoginPage;

public class cica_Application {

	WiniumDriver driver;

	@Test
	public void loginPage() throws InterruptedException, MalformedURLException {
		System.out.println("Login IRIS Application");
		DesktopOptions option = new DesktopOptions();
		option.setApplicationPath("M:\\CID.SmartClient\\bin\\FHLBSF.CID.UIDevelopment.exe");
		Thread.sleep(8000);
		driver = new WiniumDriver(new URL("http://localhost:9999"), option);
		Thread.sleep(8000);
		
		cica_LoginPage iris = PageFactory.initElements(driver, cica_LoginPage.class);
		iris.irisApplication();
		Thread.sleep(8000);
	}

	@Test(dependsOnMethods = { "loginPage" })
	public void cicaApplication() throws InterruptedException {

		System.out.println("Login CICA Application");
		Thread.sleep(5000);
		/*
		 * WebElement titleBar = driver.findElement(By.id("TitleBar"));
		 * 
		 * if (titleBar.isDisplayed()) {
		 * System.out.println("Title bar pop up is display"); cica_LoginPage tb =
		 * PageFactory.initElements(driver, cica_LoginPage.class); tb.closeTitleBar();
		 * Thread.sleep(5000); WebElement titleBar2 =
		 * driver.findElement(By.id("ubtnClose")); titleBar2.click(); } else {
		 * System.out.println("Title bar pop up is not display"); }
		 */

		cica_LoginPage ca = PageFactory.initElements(driver, cica_LoginPage.class);
		ca.loginPage();
		Thread.sleep(5000);

		cica_LoginPage cicaApplication = PageFactory.initElements(driver, cica_LoginPage.class);
		cicaApplication.clickCicaApplication();
		Thread.sleep(5000);

		cica_LoginPage searchBtm = PageFactory.initElements(driver, cica_LoginPage.class);
		searchBtm.clickSearchBtm();
		Thread.sleep(2000);
	}

	@Test(dependsOnMethods = { "cicaApplication" })
	public void newApplication() throws InterruptedException {

		System.out.println("Login CICA New Application");
		cica_LoginPage newApplication = PageFactory.initElements(driver, cica_LoginPage.class);
		newApplication.clcikNewApplication();

		Thread.sleep(5000);
		cica_LoginPage memberTxt = PageFactory.initElements(driver, cica_LoginPage.class);
		memberTxt.clickMbrTxt();

		Thread.sleep(5000);
		cica_LoginPage contactPerson = PageFactory.initElements(driver, cica_LoginPage.class);
		contactPerson.contactPerson();

		Thread.sleep(5000);
		cica_LoginPage authorisedSigner = PageFactory.initElements(driver, cica_LoginPage.class);
		authorisedSigner.authorisedSignerName();
		Thread.sleep(5000);
		WebElement nxtBtm = driver.findElement(By.id("btnNext"));
		nxtBtm.click();

	}

	@Test(dependsOnMethods = { "newApplication" })
	public void creditType() throws InterruptedException {

		Xls_Reader reader = new Xls_Reader("C:\\CicaExcelSheet.xlsx");
		String creditType = reader.getCellData("Cica", "Credit Type", 2);
		System.out.println("Data from Excel Sheet : " + creditType);
		WebElement advanceRadioBtm = driver.findElement(By.name(creditType));
		advanceRadioBtm.click();
	}

	@Test(dependsOnMethods = { "creditType" })
	public void programType() throws InterruptedException {
		Xls_Reader reader1 = new Xls_Reader("C:\\CicaExcelSheet.xlsx");
		String programType = reader1.getCellData("Cica", "Program Type", 2);
		System.out.println("Data from Excel Sheet : " + programType);
		WebElement programTypeRadioBtm = driver.findElement(By.name(programType));
		programTypeRadioBtm.click();

		cica_LoginPage ca = PageFactory.initElements(driver, cica_LoginPage.class);
		ca.creditAmountRequest();

		Thread.sleep(10000);
		cica_LoginPage ct = PageFactory.initElements(driver, cica_LoginPage.class);
		ct.creditTerm();

		WebElement member = driver.findElement(By.name("Cancel"));
		member.click();
		Thread.sleep(5000);
	}

	@Test(dependsOnMethods = { "programType" })
	public void memberName() throws InterruptedException {

		Xls_Reader reader = new Xls_Reader("C:\\CicaExcelSheet.xlsx");
		String MemberName = reader.getCellData("Cica", "Member Name", 2);
		System.out.println("Data from Excel Sheet : " + MemberName);
		Thread.sleep(5000);
		WebElement element = driver.findElement(By.name(MemberName));
		element.click();

	}

	@Test(dependsOnMethods = { "memberName" })

	public void editApplication() {
		WebElement element = driver.findElement(By.name("Edit Application"));
		element.click();
	}

	@Test(dependsOnMethods = { "editApplication" })
	public void edit_ProjGenInfo() throws InterruptedException {

		System.out.println("edit application");
		Thread.sleep(2000);
		driver.findElement(By.name("Project General Info")).click();
		System.out.println("project genral info");
		Thread.sleep(4000);
		driver.quit();

	}

}
