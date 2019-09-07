package ControlLayer;

import ModelLayer.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class InfoController {

    public static Info info;

    public InfoController()
    {
        Date date=new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int previousMonth = localDate.getMonthValue()-1;
        int previousYear = localDate.getYear();
        if(previousMonth == 0)
        {
            previousYear = previousYear - 1;
            previousMonth = 12;
        }
        String fileName = "Rekins"+previousYear+"."+previousMonth+".xls";

        try {
            FileInputStream file = new FileInputStream(new File(fileName));
            HSSFWorkbook workbook = new HSSFWorkbook(file);

            double electricity = Double.parseDouble(String.valueOf(workbook.getSheetAt(0).getRow(14).getCell(2)))
                    + Double.parseDouble(String.valueOf(workbook.getSheetAt(1).getRow(5).getCell(2)))
                    + Double.parseDouble(String.valueOf(workbook.getSheetAt(2).getRow(5).getCell(2)))
                    + Double.parseDouble(String.valueOf(workbook.getSheetAt(3).getRow(5).getCell(2)))
                    + Double.parseDouble(String.valueOf(workbook.getSheetAt(4).getRow(5).getCell(2)));

            double water = Double.parseDouble(String.valueOf(workbook.getSheetAt(1).getRow(6).getCell(2)))
                    + Double.parseDouble(String.valueOf(workbook.getSheetAt(2).getRow(6).getCell(2)))
                    + Double.parseDouble(String.valueOf(workbook.getSheetAt(3).getRow(6).getCell(2)))
                    + Double.parseDouble(String.valueOf(workbook.getSheetAt(4).getRow(6).getCell(2)));

            Prices prices = new Prices(
                    Double.parseDouble(String.valueOf(workbook.getSheetAt(1).getRow(9).getCell(3))),
                    electricity,
                    Double.parseDouble(String.valueOf(workbook.getSheetAt(1).getRow(10).getCell(3))),
                    Double.parseDouble(String.valueOf(workbook.getSheetAt(1).getRow(11).getCell(3))),
                    water
            );

            Owner owner = new Owner(
                    String.valueOf(workbook.getSheetAt(0).getRow(3).getCell(1)),
                    String.valueOf(workbook.getSheetAt(0).getRow(4).getCell(1)),
                    String.valueOf(workbook.getSheetAt(0).getRow(6).getCell(1)),
                    String.valueOf(workbook.getSheetAt(0).getRow(6).getCell(2)),
                    String.valueOf(workbook.getSheetAt(0).getRow(7).getCell(1)),
                    String.valueOf(workbook.getSheetAt(0).getRow(7).getCell(2))
            );

            Receiver receiver = new Receiver(
                    String.valueOf(workbook.getSheetAt(0).getRow(8).getCell(1)),
                    String.valueOf(workbook.getSheetAt(0).getRow(9).getCell(1)),
                    String.valueOf(workbook.getSheetAt(0).getRow(12).getCell(1)),
                    String.valueOf(workbook.getSheetAt(0).getRow(8).getCell(2))
            );

            Tenant tenant_1 = new Tenant(
                    String.valueOf(workbook.getSheetAt(1).getRow(3).getCell(1)),
                    Double.parseDouble(String.valueOf(workbook.getSheetAt(1).getRow(5).getCell(2))),
                    Double.parseDouble(String.valueOf(workbook.getSheetAt(1).getRow(6).getCell(2))),
                    Double.parseDouble(String.valueOf(workbook.getSheetAt(1).getRow(12).getCell(3))),
                    Double.parseDouble(String.valueOf(workbook.getSheetAt(1).getRow(13).getCell(3))),
                    Double.parseDouble(String.valueOf(workbook.getSheetAt(1).getRow(14).getCell(3))),
                    Double.parseDouble(String.valueOf(workbook.getSheetAt(1).getRow(15).getCell(3)))
            );

            Tenant tenant_2 = new Tenant(
                    String.valueOf(workbook.getSheetAt(2).getRow(3).getCell(1)),
                    Double.parseDouble(String.valueOf(workbook.getSheetAt(2).getRow(5).getCell(2))),
                    Double.parseDouble(String.valueOf(workbook.getSheetAt(2).getRow(6).getCell(2))),
                    Double.parseDouble(String.valueOf(workbook.getSheetAt(2).getRow(12).getCell(3))),
                    Double.parseDouble(String.valueOf(workbook.getSheetAt(2).getRow(13).getCell(3))),
                    Double.parseDouble(String.valueOf(workbook.getSheetAt(2).getRow(14).getCell(3))),
                    Double.parseDouble(String.valueOf(workbook.getSheetAt(2).getRow(15).getCell(3)))
            );

            Tenant tenant_3 = new Tenant(
                    String.valueOf(workbook.getSheetAt(3).getRow(3).getCell(1)),
                    Double.parseDouble(String.valueOf(workbook.getSheetAt(3).getRow(5).getCell(2))),
                    Double.parseDouble(String.valueOf(workbook.getSheetAt(3).getRow(6).getCell(2))),
                    Double.parseDouble(String.valueOf(workbook.getSheetAt(3).getRow(12).getCell(3))),
                    Double.parseDouble(String.valueOf(workbook.getSheetAt(3).getRow(13).getCell(3))),
                    Double.parseDouble(String.valueOf(workbook.getSheetAt(3).getRow(14).getCell(3))),
                    Double.parseDouble(String.valueOf(workbook.getSheetAt(3).getRow(15).getCell(3)))
            );

            Tenant tenant_4 = new Tenant(
                    String.valueOf(workbook.getSheetAt(4).getRow(3).getCell(1)),
                    Double.parseDouble(String.valueOf(workbook.getSheetAt(4).getRow(5).getCell(2))),
                    Double.parseDouble(String.valueOf(workbook.getSheetAt(4).getRow(6).getCell(2))),
                    Double.parseDouble(String.valueOf(workbook.getSheetAt(4).getRow(12).getCell(3))),
                    Double.parseDouble(String.valueOf(workbook.getSheetAt(4).getRow(13).getCell(3))),
                    Double.parseDouble(String.valueOf(workbook.getSheetAt(4).getRow(14).getCell(3))),
                    Double.parseDouble(String.valueOf(workbook.getSheetAt(4).getRow(15).getCell(3)))
            );

            info = new Info(prices,owner,receiver,tenant_1,tenant_2,tenant_3,tenant_4);
        } catch (IOException e) {
            //todo file not found
            e.printStackTrace();
        }
    }
}
