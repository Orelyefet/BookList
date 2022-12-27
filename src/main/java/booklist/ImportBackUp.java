package booklist;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class ImportBackUp {
    private static String name;
    private static String phoneNumber;
    private ArrayList<Contacts> list;

    public ImportBackUp(ArrayList<Contacts> list) {
        this.list = list;
    }

    /**
     * Load data from an excel table
     */
    public void loadFromExcelData() {
        StringBuffer p;
        String path = "/Users/orelyefet/Desktop/IntellijProjects/BookList/ContactList.xlsx";

        try {

            FileInputStream fis = new FileInputStream(path);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            Sheet sheet1 = workbook.getSheet("Sheet1");

            Iterator<Row> rowIterator = sheet1.iterator();

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();

                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();

                    switch (cell.getCellType()) {
                        case NUMERIC:
                            String phone = String.valueOf(cell.getNumericCellValue());
                            phone = phone.replaceAll("[^0-9]", "");
                            p = new StringBuffer(phone);
                            p.deleteCharAt(phone.length() - 1);
                            phoneNumber = p.toString();
                            break;
                        case STRING:
                            name = cell.getStringCellValue();
                            break;
                    }
                }
                Contacts contacts = new Contacts(name, phoneNumber);
                list.add(contacts);
            }
            System.out.println("Backup has been loaded to your device");

            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
