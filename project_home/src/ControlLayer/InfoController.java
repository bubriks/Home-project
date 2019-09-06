package ControlLayer;

import ModelLayer.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class InfoController {

    public Info info;
    public static void main(String[] args) throws IOException {
        try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("info.txt"), StandardCharsets.UTF_8))
        {
            writer.write("\nElectricity- 0.0;");//0
            writer.write("\nWater- 0.0;");//1
        }

        new InfoController();
    }

    public InfoController() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("info.txt"), StandardCharsets.UTF_8));
        String line;
        double electricity = 0, water = 0;
        in.readLine();
        while ((line = in.readLine()) != null) {
            switch (line.substring(0, line.indexOf("-"))) {
                case "Electricity":
                    electricity = Double.parseDouble(line.substring(line.lastIndexOf("-")+2 , line.indexOf(";")));
                    break;
                case "Water":
                    water = Double.parseDouble(line.substring(line.lastIndexOf("-")+2 , line.indexOf(";")));
                    break;
                default:
                    break;
            }
        }
        in.close();

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
        FileInputStream file = null;
        try {
            file = new FileInputStream(new File(fileName));
        }
        catch (Exception e){
            //todo no file found
        }
        HSSFWorkbook workbook = new HSSFWorkbook(file);

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
    }
}
