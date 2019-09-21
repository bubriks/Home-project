package ControlLayer;

import ModelLayer.Tenant;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
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
            new DesignController(workbook);
            if (CreateCompanyDocument() && CreateTenantDocument(1) && CreateTenantDocument(2) && CreateTenantDocument(3) && CreateTenantDocument(4)) {
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

    private boolean CreateCompanyDocument(){
        if(InfoController.info.receiver.electricityStart<=InfoController.info.receiver.electricityEnd &&
                InfoController.info.prices.electricityStart<=InfoController.info.prices.electricityEnd &&
                InfoController.info.prices.waterStart<=InfoController.info.prices.waterEnd){
            new CompanyController(workbook);
            return true;
        }
        else{
            return false;
        }
    }

    private boolean CreateTenantDocument(int index){
        Tenant tenant = InfoController.GetTenant(index);
        if(tenant.electricityStart<=tenant.electricityEnd && tenant.waterStart<=tenant.waterEnd){
            new RentController(workbook,tenant);
            return true;
        }
        else{
            return false;
        }
    }



    static String nameNumber(Double number){
        String text;
        DecimalFormat f = new DecimalFormat("##.00");
        Double cent=number-number.intValue();
        String cents=f.format(cent).substring(1)+" centi";
        if(number>0){
            switch (number.intValue()%10) {
                case 1:  text = "viens";
                    break;
                case 2:  text = "divi";
                    break;
                case 3:  text = "trīs";
                    break;
                case 4:  text = "četri";
                    break;
                case 5:  text = "pieci";
                    break;
                case 6:  text = "seši";
                    break;
                case 7:  text = "septiņi";
                    break;
                case 8:  text = "astoņi";
                    break;
                case 9:  text = "deviņi";
                    break;
                default: text = "";
                    break;
            }
            if(number>9){
                if(number<20) {
                    switch (number.intValue()%100) {
                        case 10: text = "desmit";
                            break;
                        case 11: text = "vienpadsmit";
                            break;
                        case 12: text = "divpadsmit";
                            break;
                        case 13: text = "trīspadsmit";
                            break;
                        case 14: text = "četrpadsmit";
                            break;
                        case 15: text = "piecpadsmit";
                            break;
                        case 16: text = "sešpadsmit";
                            break;
                        case 17: text = "septiņpadsmit";
                            break;
                        case 18: text = "astoņpadsmit";
                            break;
                        case 19: text = "deviņpadsmit";
                            break;
                    }
                }
                else {
                    switch (number.intValue()%100-number.intValue()%10) {
                        case 20:  text = "divdesmit "+text;
                            break;
                        case 30:  text = "trīsdesmit "+text;
                            break;
                        case 40:  text = "četrdesmit "+text;
                            break;
                        case 50:  text = "piecdesmit "+text;
                            break;
                        case 60:  text = "sešdesmit "+text;
                            break;
                        case 70:  text = "septiņdesmit "+text;
                            break;
                        case 80:  text = "astoņdesmit "+text;
                            break;
                        case 90:  text = "deviņdesmit "+text;
                            break;
                        default: text = ""+text;
                            break;
                    }
                }
                if(number>99){
                    switch (number.intValue()%1000-number.intValue()%100) {
                        case 100:  text = "viens simts "+text;
                            break;
                        case 200:  text = "divi simti "+text;
                            break;
                        case 300:  text = "trīs simti "+text;
                            break;
                        case 400:  text = "četri simti "+text;
                            break;
                        case 500:  text = "pieci simti "+text;
                            break;
                        case 600:  text = "seši simti "+text;
                            break;
                        case 700:  text = "septiņi simti "+text;
                            break;
                        case 800:  text = "astoņi simti "+text;
                            break;
                        case 900:  text = "deviņi simti "+text;
                            break;
                        default: text = ""+text;
                            break;
                    }
                    if(number>999){
                        if(number>9999){
                            return "Pārāk liels skaitlis!";
                        }
                        else{
                            switch (number.intValue()%10000-number.intValue()%1000) {
                                case 1000:  text = "viens tūkstotis "+text;
                                    break;
                                case 2000:  text = "divi tūkstotis "+text;
                                    break;
                                case 3000:  text = "trīs tūkstotis "+text;
                                    break;
                                case 4000:  text = "četri tūkstotis "+text;
                                    break;
                                case 5000:  text = "pieci tūkstotis "+text;
                                    break;
                                case 6000:  text = "seši tūkstotis "+text;
                                    break;
                                case 7000:  text = "septiņi tūkstotis "+text;
                                    break;
                                case 8000:  text = "astoņi tūkstotis "+text;
                                    break;
                                case 9000:  text = "deviņi tūkstotis "+text;
                                    break;
                                default: text = "";
                                    break;
                            }
                        }
                    }
                    else{
                        text=text.substring(0, 1).toUpperCase() + text.substring(1)+" € "+cents;
                    }
                }
                else{
                    text=text.substring(0, 1).toUpperCase() + text.substring(1)+" € "+cents;
                }
            }
            else{
                text=text.substring(0, 1).toUpperCase() + text.substring(1)+" € "+cents;
            }
        }
        else{
            return "Negatīvi mērijumi";
        }
        return text;
    }

    static String getDate(Date date){
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        String monthString;
        switch (localDate.getMonthValue()) {
            case 1:  monthString = "janvāris";
                break;
            case 2:  monthString = "februāris";
                break;
            case 3:  monthString = "marts";
                break;
            case 4:  monthString = "aprīlis";
                break;
            case 5:  monthString = "maijs";
                break;
            case 6:  monthString = "jūnijs";
                break;
            case 7:  monthString = "jūlijs";
                break;
            case 8:  monthString = "augusts";
                break;
            case 9:  monthString = "septembris";
                break;
            case 10: monthString = "oktobris";
                break;
            case 11: monthString = "novembris";
                break;
            case 12: monthString = "decembris";
                break;
            default: monthString = " ";
                break;
        }
        return localDate.getYear()+".gada "+localDate.getDayOfMonth()+"."+monthString;
    }

    static String getDeliveryPeriod(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.DATE, -1);

        Date lastDayOfMonth = calendar.getTime();
        LocalDate localDate = lastDayOfMonth.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return "01."+localDate.getMonth()+"."+localDate.getYear()+" - "+localDate.getDayOfMonth()+"."+localDate.getMonth()+"."+localDate.getYear();
    }

    static String getDueDate(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.DATE, -1);

        Date lastDayOfMonth = calendar.getTime();
        LocalDate localDate = lastDayOfMonth.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return localDate.getDayOfMonth()+"."+localDate.getMonth()+"."+localDate.getYear();
    }
}
