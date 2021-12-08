package kz.sapasoft.tests;

import org.testng.annotations.Test;

import java.io.File;

import static kz.sapasoft.services.UserManager.getCustomer;

public class SubmittingAPurchaseRequisitionTest extends BasicTestConditions {

    String appNumber = "115265";
    String providerPrice = "100";
    String ruText = "testRU";
    String kzText = "testKZ";
    String workExperience = "5";
    String expTRU = "5";
    File file = new File("src/test/resources/test.xlsx");

    @Test(groups = "test")
    void SubmittingAPurchaseRequisitionTest() {
        getHomePage().logIn(getCustomer().getName(), getCustomer().getPassword());
        getPersonalCabinetPage().openPersonalCabinet();
        getSubmitPurchaseRequest().goToMainPage();
        getSubmitPurchaseRequest().searchApplicationNumber(appNumber);
        getSubmitPurchaseRequest().openApplication(appNumber);
        getSubmitPurchaseRequest().chooseLot();
        getSubmitPurchaseRequest().applyButton();
        getSubmitPurchaseRequest().openLotsRequirments();
        getSubmitPurchaseRequest().fillProviderPrice(providerPrice);
        getSubmitPurchaseRequest().fillDescriptionRu(ruText);
        getSubmitPurchaseRequest().fillDescriptionKz(kzText);
        getSubmitPurchaseRequest().uploadProvidingApplication(file);
        getSubmitPurchaseRequest().managmentSertification(file);
        getSubmitPurchaseRequest().fillWorkExperienceTRU(expTRU, file);
        getSubmitPurchaseRequest().consistsInRegistry(file);
        getSubmitPurchaseRequest().fillWorkExperience(workExperience, file);
        getSubmitPurchaseRequest().saveButton();
        getSubmitPurchaseRequest().confirmDataCheckbox();
        getSubmitPurchaseRequest().toFormDocument();
        getSubmitPurchaseRequest().reloadStatus();
        getSubmitPurchaseRequest().signDocuments();
        getSubmitPurchaseRequest().deleteApplication(appNumber);
        getPersonalCabinetPage().openPersonalCabinet();
        getPersonalCabinetPage().logOut();
    }
}
