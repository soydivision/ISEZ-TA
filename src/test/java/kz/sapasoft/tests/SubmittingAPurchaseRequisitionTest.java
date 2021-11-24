package kz.sapasoft.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.element;
import static kz.sapasoft.services.UserManager.getCustomer;

public class SubmittingAPurchaseRequisitionTest extends BasicTestConditions{


    @Test(groups = "this")
    void SubmittingAPurchaseRequisitionTest() {
        getHomePage().logIn(getCustomer().getName(), getCustomer().getPassword());
        getPersonalCabinetPage().openPersonalCabinet();
        getSubmitPurchaseRequest().goToMainPage();
        getSubmitPurchaseRequest().searchApplicationNumber();
        getSubmitPurchaseRequest().openApplication();
        getSubmitPurchaseRequest().chooseLot();
        getSubmitPurchaseRequest().applyButton();
        getSubmitPurchaseRequest().confirmDataCheckbox();
        getSubmitPurchaseRequest().openLotsRequirments();
        getSubmitPurchaseRequest().fillProviderPrice();
        getSubmitPurchaseRequest().fillDescriptionRu();
        getSubmitPurchaseRequest().fillDescriptionKz();
        //getSubmitPurchaseRequest().uploadProvidingApplication();





        Configuration.holdBrowserOpen = true;
    }
}
