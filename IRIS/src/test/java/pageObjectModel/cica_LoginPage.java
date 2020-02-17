package pageObjectModel;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.excel.utility.Xls_Reader;

public class cica_LoginPage {

	WebDriver driver;

	@FindBy(name = "FHLBSF.CID.UIDevelopment.exe - 1 running window")
	private WebElement irisApplication;

	@FindBy(name = "Close")
	private WebElement closeBtm;

	@FindBy(name = "CICA (CIP, ACE)")
	private WebElement cicaApplication;

	@FindBy(name = "Application")
	private WebElement clickApplication;

	@FindBy(name = "Search")
	private WebElement clickSearchBtm;

	@FindBy(name = "New Application")
	private WebElement clcikNewApplication;

	@FindBy(id = "ulcmb_MemberName")
	private WebElement clickMbrTxt;

	@FindBy(id = "ulcmb_MemberContact")
	private WebElement contactPerson;

	@FindBy(id = "ultraCombo_Authorized_Signers")
	private WebElement authorisedSignerName;

	@FindBy(name = "Advance")
	private WebElement advanceRadioBtm;

	@FindBy(id = "ultxtCrAmtRequest")
	private WebElement creditAmountRequest;

	@FindBy(id = "ultxtCrTerm")
	private WebElement creditTerm;

	public void irisApplication() {
		irisApplication.click();
	}

	public void closeTitleBar() {
		closeBtm.click();
	}

	public void loginPage() {
		cicaApplication.click();
	}

	public void clickCicaApplication() {
		clickApplication.click();
	}

	public void clickSearchBtm() {
		clickSearchBtm.click();
	}

	public void clcikNewApplication() {
		clcikNewApplication.click();
	}

	public void clickMbrTxt() {
		clickMbrTxt.click();
		Xls_Reader reader = new Xls_Reader("C:\\CicaExcelSheet.xlsx");
		String data = reader.getCellData("Cica", "MemberName", 2);
		System.out.println("Data from Excel Sheet : " + data);
		clickMbrTxt.sendKeys(data);
	}

	public void contactPerson() {
		contactPerson.click();
		Xls_Reader reader = new Xls_Reader("C:\\CicaExcelSheet.xlsx");
		String cp = reader.getCellData("Cica", "ContactPerson", 2);
		System.out.println("Data from Excel Sheet : " + cp);
		contactPerson.sendKeys(cp);
	}
	

	public void authorisedSignerName() {
		authorisedSignerName.click();
		Xls_Reader reader = new Xls_Reader("C:\\CicaExcelSheet.xlsx");
		String as = reader.getCellData("Cica", "AuthorisedName", 2);
		System.out.println("Data from Excel Sheet : " + as);
		authorisedSignerName.sendKeys(as);

	}

	public void creditAmountRequest() {
		creditAmountRequest.click();
		Xls_Reader reader = new Xls_Reader("C:\\CicaExcelSheet.xlsx");
		String cr = reader.getCellData("Cica", "Credit Amount", 2);
		System.out.println("Data from Excel Sheet : " + cr);

		creditAmountRequest.sendKeys(Keys.DELETE);
		creditAmountRequest.sendKeys(cr);

	}

	public void creditTerm() {

		creditTerm.click();
		Xls_Reader reader = new Xls_Reader("C:\\CicaExcelSheet.xlsx");
		String ct = reader.getCellData("Cica", "Credit Term", 2);
		System.out.println("Data from Excel Sheet : " + ct);
		creditTerm.sendKeys(Keys.DELETE);
		creditTerm.sendKeys(ct);

	}

}
