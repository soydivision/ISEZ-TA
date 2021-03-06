package kz.sapasoft.tests.sanity.logged_in;

import com.codeborne.selenide.Condition;
import kz.sapasoft.tests.BasicTestConditions;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.element;
import static kz.sapasoft.services.UserManager.getCustomerTwo;

public class BankWarranty extends BasicTestConditions {
    @Test(groups = "smoke", description = "smoke testing of bank warranty section display")
    void bankWarranty() {
        getHomePage().logIn(getCustomerTwo().getName(), getCustomerTwo().getPassword());
        getPersonalCabinetPage().openPersonalCabinet();
        getPersonalCabinetPage().openBankWarranty();
        checkIfNoErrorIsDisplayed();

        getPersonalCabinetPage().openBankWarrantyList();
        getPersonalCabinetPage().warrantyTitle.shouldHave(Condition.visible);
        checkIfNoErrorIsDisplayed();
        checkIfPageBodyHasTable();

        getPersonalCabinetPage().openBankWarrantyReport();
        getPersonalCabinetPage().warrantyReportTitle.shouldHave(Condition.visible);
        checkIfNoErrorIsDisplayed();
        checkIfPageBodyHasTable();
    }
}
