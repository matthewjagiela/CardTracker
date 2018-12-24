import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import javax.swing.*;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelHandler
{
    DataHandler data = new DataHandler();
    InputStream inp;
    Workbook wb;
    Sheet sheet;
    Row row;
    Cell cell;
    boolean isNull = false;
    String directory = "";

    public ExcelHandler(JLabel label) {
        label.setText("Reading and Searching... This may take some time...");
        // We need to actually point the software to the file because it will not export....
        findFile();
        try { InputStream inputStream = this.inp = new FileInputStream(directory);Throwable localThrowable3 = null;
            try { wb = WorkbookFactory.create(inp);
                sheet = wb.getSheetAt(0);
                label.setText("Phase 1... Overall Completion: 0%");
                readQuantity();
                label.setText("Phase 2... Overall Completion: 10%");
                readFirstName();
                label.setText("Phase 3... Overall Completion: 20%");
                readLastName();
                label.setText("Phase 4... Overall Completion: 30%");
                readYear();
                label.setText("Phase 5... Overall Completion: 40%");
                readBrand();
                label.setText("Phase 6... Overall Completion: 50%");
                readProduct();
                label.setText("Phase 7... Overall Completion: 60%");
                readCardType();
                label.setText("Phase 8... Overall Completion: 70%");
                readExtraAttributes();
                label.setText("Phase 9... Overall Completion: 80%");
                readCardNumber();
                label.setText("Phase 10... Overall Completion: 90%");
                readGraded();
                label.setText("Reading complete... Moving to phase 3...");
                CardTrackerGUI cards = new CardTrackerGUI();
                cards.stageThree(label,data);
            }
            catch (Throwable localThrowable1)
            {
                localThrowable3 = localThrowable1;throw localThrowable1;
            }
            finally {
                if (inputStream != null) if (localThrowable3 != null) try { inputStream.close(); } catch (Throwable localThrowable2) { localThrowable3.addSuppressed(localThrowable2); } else inputStream.close();
            }
        }
        catch (IOException | ClassNotFoundException | UnsupportedLookAndFeelException | InstantiationException | IllegalAccessException localIOException) {
            label.setText("Wrong File Selected...");
            findFile();
        }

    }
    private void findFile(){
        JFileChooser chooser = new JFileChooser(); //The file chooser
        chooser.setCurrentDirectory(new java.io.File(".")); //This is the directory where the JAR file is
        chooser.setDialogTitle("Choose the excel file"); //Yup
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY); //We only want ONE file
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) { //If they select the document
            System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
            System.out.println("getSelectedFile() : " + chooser.getSelectedFile());
            directory = String.valueOf(chooser.getSelectedFile());
            System.out.println("DIRECTORY = " + directory );

        } else {
            System.out.println("No Selection ");

        }
    }

    private void readQuantity() {
        int ctr = 2;
        do {
            try {
                row = sheet.getRow(ctr);
                int numberOfRows = sheet.getPhysicalNumberOfRows();
                cell = row.getCell(0);
                data.addToQuantity((int)cell.getNumericCellValue());
                ctr++;
                if (ctr == numberOfRows) {
                    isNull = true;
                }

            }
            catch (Exception localException) {}
        } while (!isNull);
        isNull = false;
    }

    private void readFirstName() { int ctr = 2;
        do {
            try {
                row = sheet.getRow(ctr);
                int numberOfRows = sheet.getPhysicalNumberOfRows();
                cell = row.getCell(1);
                data.addToFirstName(String.valueOf(cell));
                ctr++;
                if (ctr == numberOfRows) {
                    isNull = true;
                }

            }
            catch (Exception localException) {}
        } while (!isNull);
        isNull = false;
    }

    private void readLastName() { int ctr = 2;
        do {
            try {
                row = sheet.getRow(ctr);
                int numberOfRows = sheet.getPhysicalNumberOfRows();
                cell = row.getCell(2);
                if (String.valueOf(cell) != "") {
                    data.addToLastName(String.valueOf(cell));
                }
                else {
                    data.addToLastName("");
                }
                ctr++;
                if (ctr == numberOfRows) {
                    isNull = true;
                }

            }
            catch (Exception localException) {}
        } while (!isNull);
        isNull = false;
    }

    private void readYear() { int ctr = 2;
        do {
            try {
                row = sheet.getRow(ctr);
                int numberOfRows = sheet.getPhysicalNumberOfRows();
                cell = row.getCell(3);
                if (String.valueOf(cell) != "") {
                    data.addToYear(String.format("%.0f", cell.getNumericCellValue()));
                }
                else {
                    data.addToYear("");
                }
                ctr++;
                if (ctr == numberOfRows) {
                    isNull = true;
                }

            }
            catch (Exception localException) {}
        } while (!isNull);
        isNull = false;
    }

    private void readBrand() { int ctr = 2;
        do {
            try {
                row = sheet.getRow(ctr);
                int numberOfRows = sheet.getPhysicalNumberOfRows();
                cell = row.getCell(4);
                if (String.valueOf(cell) != "") {
                    data.addToBrand(String.valueOf(cell));
                }
                else {
                    data.addToBrand("");
                }
                ctr++;
                if (ctr == numberOfRows) {
                    isNull = true;
                }

            }
            catch (Exception localException) {}
        } while (!isNull);
        isNull = false;
    }

    private void readProduct() { int ctr = 2;
        do {
            try {
                row = sheet.getRow(ctr);
                int numberOfRows = sheet.getPhysicalNumberOfRows();
                cell = row.getCell(5);
                if (String.valueOf(cell) != "") {
                    data.addToProduct(String.valueOf(cell));
                }
                else {
                    data.addToProduct("");
                }
                ctr++;
                if (ctr == numberOfRows) {
                    isNull = true;
                }

            }
            catch (Exception localException) {}
        } while (!isNull);
        isNull = false;
    }

    private void readCardType() { int ctr = 2;
        do {
            try {
                row = sheet.getRow(ctr);
                int numberOfRows = sheet.getPhysicalNumberOfRows();
                cell = row.getCell(6);
                if (String.valueOf(cell) != "") {
                    data.addToCardType(String.valueOf(cell));
                }
                else {
                    data.addToCardType("");
                }
                ctr++;
                if (ctr == numberOfRows) {
                    isNull = true;
                }

            }
            catch (Exception localException) {}
        } while (!isNull);
        isNull = false;
    }

    private void readExtraAttributes() { int ctr = 2;
        do {
            try {
                row = sheet.getRow(ctr);
                int numberOfRows = sheet.getPhysicalNumberOfRows();
                cell = row.getCell(7);
                if (String.valueOf(cell) != "") {
                    data.addExtraAttributes(String.valueOf(cell));
                }
                else {
                    data.addExtraAttributes("");
                }
                ctr++;
                if (ctr == numberOfRows) {
                    isNull = true;
                }

            }
            catch (Exception localException) {}
        } while (!isNull);
        isNull = false;
    }

    private void readCardNumber() { int ctr = 2;
        do {
            try {
                row = sheet.getRow(ctr);
                int numberOfRows = sheet.getPhysicalNumberOfRows();
                cell = row.getCell(8);
                if (String.valueOf(cell) != "") {
                    data.addToCardNumber(String.valueOf(cell));
                }
                else {
                    data.addToCardNumber("");
                }
                ctr++;
                if (ctr == numberOfRows) {
                    isNull = true;
                }

            }
            catch (Exception localException) {}
        } while (!isNull);
        isNull = false;
    }

    private void readGraded() { int ctr = 2;
        do {
            try {
                row = sheet.getRow(ctr);
                int numberOfRows = sheet.getPhysicalNumberOfRows();
                cell = row.getCell(9);
                if (String.valueOf(cell) != "") {
                    data.addGraded(String.valueOf(cell));
                }
                else {
                    data.addGraded("");
                }
                ctr++;
                if (ctr == numberOfRows) {
                    isNull = true;
                }

            }
            catch (Exception localException) {}
        } while (!isNull);
        isNull = false;
    }

    private void test()
    {
        int ctr = 2;
        do
        {
            try {
                System.out.println("Row number " + ctr);
                row = sheet.getRow(ctr);
                int numberOfRows = sheet.getPhysicalNumberOfRows();
                cell = row.getCell(0);
                System.out.println((int)cell.getNumericCellValue());
                ctr++;
                if (ctr == numberOfRows) {
                    isNull = true;
                }


            }
            catch (Exception localException) {}
        } while (isNull != true);
        System.out.println("Done with test now the boolean has to be reset");
        isNull = false;
    }
}