package ControlLayer;

import ModelLayer.Tenant;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DocumentController {

    private HSSFWorkbook workbook;

    public boolean CreateDocument(){
        try {
            Date date = new Date();
            LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            String file = "Rekins" + localDate.getYear() + "." + localDate.getMonthValue() + ".xls";

            workbook = new HSSFWorkbook();
            FileOutputStream out = new FileOutputStream(new File(file));
            Design design = new Design(workbook);
            if (CreateCompanyDocument(design) && CreateTenantDocument(design, 1) && CreateTenantDocument(design, 2) && CreateTenantDocument(design, 3) && CreateTenantDocument(design, 4)) {
                workbook.write(out);
                out.close();
                workbook.close();
                Desktop.getDesktop().open(new File(file));
                return true;
            } else {
                return false;
            }
        }
        catch (Exception e){
            return false;
        }
    }

    private boolean CreateCompanyDocument(Design design){
        if(InfoController.info.receiver.electricityStart<=InfoController.info.receiver.electricityEnd){
            new CompanyController(workbook, design);
            return true;
        }
        else{
            return false;
        }
    }

    private boolean CreateTenantDocument(Design design, int index){
        Tenant tenant = GetTenant(index);
        if(tenant.electricityStart<=tenant.electricityEnd && tenant.waterStart<=tenant.waterEnd){
            new RentController(workbook,tenant,design);
            return true;
        }
        else{
            return false;
        }
    }

    public Tenant GetTenant(int index){
        switch (index){
            case 1:
                return InfoController.info.tenant_1;
            case 2:
                return InfoController.info.tenant_2;
            case 3:
                return InfoController.info.tenant_3;
            case 4:
                return InfoController.info.tenant_4;
            default:
                return null;
        }
    }//todo place in the right location

}
