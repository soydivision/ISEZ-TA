package kz.sapasoft.tests.microservices.global;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selectors;
import kz.sapasoft.tests.BasicTestConditions;
import org.testng.annotations.Test;

import java.util.Random;

import static com.codeborne.selenide.Selenide.elements;
import static kz.sapasoft.services.UserManager.getCustomerTwo;

public class BankWarrantySearchTest extends BasicTestConditions {
    @Test(groups = "this")
    void bankSearchTest() {
        getHomePage().logIn(getCustomerTwo().getName(), getCustomerTwo().getPassword());
        getPersonalCabinetPage().openPersonalCabinet();
        getPersonalCabinetPage().openBankWarranty();
        getPersonalCabinetPage().openBankWarrantyList();
        checkIfNoErrorIsDisplayed();
        ElementsCollection warrantyReportStatusDropdownElements = elements(Selectors.byXpath("//*[@jhitranslate='components.select.selectItem']/../*"));
        logger.info("warrantyReportStatusDropdownElements:" + warrantyReportStatusDropdownElements.size());
        Random random = new Random();
        warrantyReportStatusDropdownElements.get(random.nextInt(warrantyReportStatusDropdownElements.size())).click();
        getPersonalCabinetPage().clickSearchInBankWarranty();
        checkIfPageBodyHasTable();
        checkIfNoErrorIsDisplayed();
    }
}
