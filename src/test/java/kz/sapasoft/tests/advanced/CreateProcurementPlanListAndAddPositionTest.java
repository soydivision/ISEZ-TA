package kz.sapasoft.tests.advanced;

import kz.sapasoft.tests.BasicTestConditions;
import org.testng.annotations.Test;

import static kz.sapasoft.services.ProcurementPlanManager.getProcurementList;
import static kz.sapasoft.services.TenderManager.getOpenTender;
import static kz.sapasoft.services.UserManager.getCustomerOne;

/*Проверка создания перечня и позиции*/
public class CreateProcurementPlanListAndAddPositionTest extends BasicTestConditions {

    @Test(groups = "this1", description = "User can create procurement plan ~ list and procurement position")
    void createProcurementPlanListAndPositionTest() {
        getHomePage().logIn(getCustomerOne().getName(), getCustomerOne().getPassword());
        getPersonalCabinetPage().openPersonalCabinet();
        getPersonalCabinetPage().openProcurementPlan();
        getProcurementPlanPage().createNewPlan();
        getProcurementPlanPage().setYear(getProcurementList().getYear());
        getProcurementPlanPage().setProcurementPlanType(getProcurementList().getPlanType());
        getProcurementPlanPage().setProcurementPlanTimeFrame(getProcurementList().getTimeFrame());
        getProcurementPlanPage().savePlan();
        getProcurementPlanPage().pressActions(getProcurementList().getPlanType());
        getProcurementPlanPage().reviewProcurementPositions(getProcurementList().getPlanType());
        getProcurementPlanPositionsPage().createProcurementPlanPosition();
        getProcurementPlanPositionsPage().createNewProcurementPlanPosition();
        getProcurementPlanPositionsPage().attemptClickGWS();
        getProcurementPlanPositionsPage().attemptInputGWS(getOpenTender().getProcurementCode());
        getProcurementPlanPositionPage().chooseProcurementMethod(getOpenTender().getProcurementMethod());
        getProcurementPlanPositionPage().setProcurementPriority(getOpenTender().getProcurementPriority());
        getProcurementPlanPositionPage().setLocalContentRatio(getOpenTender().getLocalContentRatio());
        getProcurementPlanPositionPage().setProcurementDate(getOpenTender().getDate());
        getProcurementPlanPositionPage().setProcurementAddress(getOpenTender().getProcurementAddress());
        getProcurementPlanPositionPage().setTenderAddress(getOpenTender().getTenderAddress());
        getProcurementPlanPositionPage().setCountry(getOpenTender().getDeliveryCountry());
        getProcurementPlanPositionPage().setDeliveryAddress(getOpenTender().getDeliveryAddress());
        getProcurementPlanPositionPage().setINCOTERMS(getOpenTender().getIncoterms());
        getProcurementPlanPositionPage().setSchedulePeriod(getOpenTender().getSchedulePeriod());
        getProcurementPlanPositionPage().setEndDate(getOpenTender().getEndDate());
        getProcurementPlanPositionPage().setPrepay(getOpenTender().getPrepay());
        getProcurementPlanPositionPage().setVolumeMeasurementAsKG();
        getProcurementPlanPositionPage().selectVAT("Без НДС");
        getProcurementPlanPositionPage().setVolumeForYear("2022", "1");
        getProcurementPlanPositionPage().setVolumeForYear("2023", "2");
        getProcurementPlanPositionPage().setPriceForYear("2022", "1");
        getProcurementPlanPositionPage().setPriceForYear("2023", "1");
        getProcurementPlanPositionPage().save();
        getPersonalCabinetPage().logOut();
    }
}
