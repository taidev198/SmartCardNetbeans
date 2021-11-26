/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examples.utils;

import examples.data.User;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.BuiltinFormats;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author traig
 */
public abstract class ExcelUtils {
    
     public static final int COLUMN_INDEX_ID        = 0;
    public static final int COLUMN_INDEX_TITLE      = 1;
    public static final int COLUMN_INDEX_PRICE      = 2;
    public static final int COLUMN_INDEX_QUANTITY   = 3;
    public static final int COLUMN_INDEX_TOTAL      = 4;
    private static CellStyle cellStyleFormatNumber = null;
    private static int month;
    private static int year;
    private static ArrayList<User> mUsers = new ArrayList<>();
    
    public static void exportData(ArrayList<User> datas, int month, int year) {
        ExcelUtils.month = month;
        ExcelUtils.year = year;
        ExcelUtils.mUsers = datas;
        final List<Book> books = getBooks();
        final String excelFilePath = "C:/demo/users.xlsx";
         try {         
             writeExcel(books, excelFilePath);
         } catch (IOException ex) {
             Logger.getLogger(ExcelUtils.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    
     public static void writeExcel(List<Book> books, String excelFilePath) throws IOException {
        // Create Workbook
        Workbook workbook = getWorkbook(excelFilePath);
 
        // Create sheet
        Sheet sheet = workbook.createSheet("Users"); // Create sheet with sheet name
 
        int rowIndex = 0;
         
        // Write header
        writeHeader(sheet, rowIndex);
 
        // Write data
        rowIndex++;
        for (User user : mUsers) {
            // Create row
            Row row = sheet.createRow(rowIndex);
            // Write data on row
            writeBook(user, row);
            rowIndex++;
        }
         
        // Write footer
        //writeFooter(sheet, rowIndex);
 
        // Auto resize column witdth
        int numberOfColumn = sheet.getRow(0).getPhysicalNumberOfCells();
        autosizeColumn(sheet, numberOfColumn);
 
        // Create file excel
        createOutputFile(workbook, excelFilePath);
        System.out.println("Done!!!");
    }
 
    // Create dummy data
    private static List<Book> getBooks() {
        List<Book> listBook = new ArrayList<>();
        Book book;
        for (int i = 1; i <= 5; i++) {
            book = new Book(i, "Book " + i, i * 2, i * 1000);
            listBook.add(book);
        }
        return listBook;
    }
 
    // Create workbook
    private static Workbook getWorkbook(String excelFilePath) throws IOException {
        Workbook workbook = null;
 
        if (excelFilePath.endsWith("xlsx")) {
            workbook = new XSSFWorkbook();
        } else if (excelFilePath.endsWith("xls")) {
            workbook = new HSSFWorkbook();
        } else {
            throw new IllegalArgumentException("The specified file is not Excel file");
        }
 
        return workbook;
    }
 
    // Write header with format
    private static void writeHeader(Sheet sheet, int rowIndex) {
        // create CellStyle
        CellStyle cellStyle = createStyleForHeader(sheet);
         
        // Create row
        Row row = sheet.createRow(rowIndex);
         
        // Create cells
        Cell cell = row.createCell(COLUMN_INDEX_ID);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("ID");
 
        cell = row.createCell(COLUMN_INDEX_TITLE);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Họ Tên");
 
        cell = row.createCell(COLUMN_INDEX_PRICE);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Phòng Ban");
 
        writeDateInHeader(cell, row, cellStyle);
    }
 
    
    private static void writeDateInHeader(Cell cell, Row row, CellStyle cellStyle) {
        
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM");
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.set(year, month - 1, 1);
        int daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        for (int i = 0; i < daysInMonth; i++) {
            System.out.println(fmt.format(cal.getTime()));
        cell = row.createCell(3+i);
        cell.setCellStyle(cellStyle);
        cell.setCellValue(fmt.format(cal.getTime()));
            cal.add(Calendar.DAY_OF_MONTH, 1);
        }

    }
    
    // Write data
    private static void writeBook(User user, Row row) {
        if (cellStyleFormatNumber == null) {
            // Format number
            short format = (short)BuiltinFormats.getBuiltinFormat("#,##0");
            // DataFormat df = workbook.createDataFormat();
            // short format = df.getFormat("#,##0");
             
            //Create CellStyle
            Workbook workbook = row.getSheet().getWorkbook();
            cellStyleFormatNumber = workbook.createCellStyle();
            cellStyleFormatNumber.setDataFormat(format);
        }
         
        Cell cell = row.createCell(COLUMN_INDEX_ID);
        cell.setCellValue(user.getId());
 
        cell = row.createCell(COLUMN_INDEX_TITLE);
        cell.setCellValue(user.getFullname());
 
        cell = row.createCell(COLUMN_INDEX_PRICE);
        cell.setCellValue(user.getId_department());
       // cell.setCellStyle(cellStyleFormatNumber);
 
        
         fillLateDate(user, cell, row);
        // Create cell formula
        // totalMoney = price * quantity
//        cell = row.createCell(COLUMN_INDEX_TOTAL, CellType.FORMULA);
//        cell.setCellStyle(cellStyleFormatNumber);
//        int currentRow = row.getRowNum() + 1;
//        String columnPrice = CellReference.convertNumToColString(COLUMN_INDEX_PRICE);
//        String columnQuantity = CellReference.convertNumToColString(COLUMN_INDEX_QUANTITY);
//        cell.setCellFormula(columnPrice + currentRow + "*" + columnQuantity + currentRow);
    }
 
    
    private static void fillLateDate(User user, Cell cell, Row row) {
        ArrayList<Date> datesOfMonth = DateUtils.printDatesInMonth(year, month, "yyyy-MM-dd");
        int i = 3;
        for (Date date : datesOfMonth) {
            LocalDate in = date.toInstant()
      .atZone(ZoneId.systemDefault())
      .toLocalDate();
            List<LocalDate> lateDate = user.getLate_date();
            for (LocalDate ld : lateDate) {
              //  System.out.println(date.getMonth() + " :" + ld.getMonthValue());
                if(ld.getMonthValue() == in.getMonthValue() && ld.getDayOfMonth()== in.getDayOfMonth()) {
                    System.out.println("added");
                     cell = row.createCell(i);
                     cell.setCellValue("X");
                }
            }
            i++;
        }
    }
    
    // Create CellStyle for header
    private static CellStyle createStyleForHeader(Sheet sheet) {
        // Create font
         org.apache.poi.ss.usermodel.Font font = sheet.getWorkbook().createFont();
        font.setFontName("Times New Roman"); 
        font.setBold(true);
        font.setFontHeightInPoints((short) 14); // font size
        font.setColor(IndexedColors.WHITE.getIndex()); // text color
 
        // Create CellStyle
        CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
        cellStyle.setFont(font);
        cellStyle.setFillForegroundColor(IndexedColors.BLUE.getIndex());
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        return cellStyle;
    }
     
    // Write footer
    private static void writeFooter(Sheet sheet, int rowIndex) {
        // Create row
        Row row = sheet.createRow(rowIndex);
        Cell cell = row.createCell(COLUMN_INDEX_TOTAL, CellType.FORMULA);
        cell.setCellFormula("SUM(E2:E6)");
    }
     
    // Auto resize column width
    private static void autosizeColumn(Sheet sheet, int lastColumn) {
        for (int columnIndex = 0; columnIndex < lastColumn; columnIndex++) {
            sheet.autoSizeColumn(columnIndex);
        }
    }
     
    // Create output file
    private static void createOutputFile(Workbook workbook, String excelFilePath) throws IOException {
        try (OutputStream os = new FileOutputStream(excelFilePath)) {
            workbook.write(os);
        }
    }

    private static class Book {

        public Book() {
        }
        
         private Integer id;
        private String title;
        private Integer quantity;
        private Double price;
        private Double totalMoney;

        private Book(int i, String string, int i0, int i1) {
            id = i;
            title = string;
            quantity = i0;
            price = 10.1;
            totalMoney = 10.2;
            
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }

        public Double getTotalMoney() {
            return totalMoney;
        }

        public void setTotalMoney(Double totalMoney) {
            this.totalMoney = totalMoney;
        }
        
        
    }
    
}
