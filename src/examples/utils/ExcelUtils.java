/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examples.utils;

import frame.UserFrame;
import examples.data.Departments;
import examples.data.User;
import examples.database.DataBaseUtils;
import examples.database.RuleDbHelper;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
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
import org.bson.Document;
import org.json.JSONException;

/**
 *https://www.codejava.net/java-se/swing/show-save-file-dialog-using-jfilechooser
 * https://stackoverflow.com/questions/356671/how-do-i-set-a-suggested-file-name-using-jfilechooser-showsavedialog
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
    private static DataBaseUtils dbHelper = DataBaseUtils.getInstance();
    private static RuleDbHelper db = RuleDbHelper.getInstance();
    private static String excelFilePath = "C:/demo/BaoCao1.xlsx";
    private static ArrayList<Departments> departmentses;
    private static int numberOfLate = 0;
    private static boolean isShowNotif = false;
    
    public static void exportData(ArrayList<User> datas, DataBaseUtils dataBaseUtils, RuleDbHelper ruleDbHelper, int month, int year) {
        ExcelUtils.month = month;
        ExcelUtils.year = year;
        ExcelUtils.mUsers = datas;
        ExcelUtils.db = ruleDbHelper;
        ExcelUtils.dbHelper = dataBaseUtils;
         departmentses = getDepartmentses();
        File file = new File(excelFilePath);
        isShowNotif = false;
        creatNewFile();
        //writeExcel( excelFilePath, "TỔNG QUAN", mUsers);
        getAnalysicOfDepartment();
    }
    
    
    private static void creatNewFile() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to save");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("MS Office Documents", "xlsx"));
        fileChooser.setSelectedFile(new File("BaoCao.xlsx"));
        int userSelection = fileChooser.showSaveDialog(null);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
        File fileToSave = fileChooser.getSelectedFile();
        System.out.println("Save as file: " + fileToSave.getAbsolutePath());
        excelFilePath = fileToSave.getAbsolutePath();
        }
    }
    
     public static void writeExcel( String excelFilePath, String sheetName, ArrayList<User> users) throws IOException {
        // Create Workbook
        Workbook workbook = getWorkbook(excelFilePath);
 
        // Create sheet
        Sheet sheet = workbook.createSheet(sheetName); // Create sheet with sheet name
 
        int rowIndex = 4;
        
        // Write header
        writeHeader(sheet, rowIndex);
        for (User user : users) {
            // Create row
            rowIndex++;
            Row row = sheet.createRow(rowIndex);
            // Write data on row
            writeUser(user, row);
            
        }
         writeTitle(sheet, 0, users);
        // Write footer
        //writeFooter(sheet, rowIndex);
 
        // Auto resize column witdth
        int numberOfColumn = sheet.getRow(0).getPhysicalNumberOfCells();
        autosizeColumn(sheet, numberOfColumn);
 
        // Create file excel
        createOutputFile(workbook, excelFilePath);
        System.out.println("Done!!!");
        if(!isShowNotif){
            JOptionPane.showMessageDialog(null, "XUẤT DỮ LIỆU THÀNH CÔNG", "", JOptionPane.INFORMATION_MESSAGE);
            isShowNotif = true;
        }

    }

    private static void writeTitle(Sheet sheet, int rowIndex, ArrayList<User> users) {
         CellStyle cellStyle = createStyleForTitle(sheet);
         
        // Create row
        Row row = sheet.createRow(rowIndex);
         
        Cell cell = row.createCell(0);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Tên");
        SimpleDateFormat fmt = new SimpleDateFormat("MM/YYYY");
        Calendar cal = Calendar.getInstance();
        cell = row.createCell(1);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Báo cáo thống kê các ngày đi muộn trong tháng " + month + "/" + year);
        
        
        row = sheet.createRow(++rowIndex);
        cell = row.createCell(0);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Ngày xuất dữ liệu");
        fmt = new SimpleDateFormat("dd/MM/YYYY");
        cell = row.createCell(1);
        cell.setCellStyle(cellStyle);
        cell.setCellValue( fmt.format(cal.getTime()));
        
        row = sheet.createRow(++rowIndex);
        cell = row.createCell(0);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Sĩ số");
        cell = row.createCell(1);
        cell.setCellStyle(cellStyle);
        cell.setCellValue(String.valueOf(users.size()));
        
        row = sheet.createRow(++rowIndex);
        cell = row.createCell(0);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Số người đi muộn");
        cell = row.createCell(1);
        cell.setCellStyle(cellStyle);
        cell.setCellValue(String.valueOf(numberOfLate));
        
        cell = row.createCell(2);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Đ");
        cell = row.createCell(3);
        //cell.setCellStyle(cellStyle);
        cell.setCellValue("Đúng giờ");
        
        cell = row.createCell(4);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("M");
        cell = row.createCell(5);
        //cell.setCellStyle(cellStyle);
        cell.setCellValue("Muộn");
        
        cell = row.createCell(7);
        //cell.setCellStyle(cellStyle);
        cell.setCellValue("Nghỉ");
        numberOfLate = 0;
        
        
    }
     
     
    // Create workbook
    private static Workbook getWorkbook(String excelFilePath) throws IOException {
        Workbook workbook = null;
 
//        if (excelFilePath.endsWith("xlsx")) {
//            workbook = new XSSFWorkbook();
//        } else if (excelFilePath.endsWith("xls")) {
//            workbook = new HSSFWorkbook();
//        } else {
//            throw new IllegalArgumentException("The specified file is not Excel file");
//        }
 
        final File file = new File(excelFilePath);
        if (file.exists() == false) {
          System.out.println("Creating a new workbook '" + file + "'");
          workbook = new XSSFWorkbook();
        } else {
          System.out.println("Appending to existing workbook '" + file + "'");
          try (InputStream is = new FileInputStream(file)) {
            workbook = new XSSFWorkbook(is);
          }
        }
        
        return workbook;
    }
 
    // Write header with format
    private static void writeHeader(Sheet sheet, int rowIndex) {
        // create CellStyle
        CellStyle cellStyle = createStyleForHeader(sheet);
         
        // Create row
        Row row = sheet.createRow(rowIndex);
         
        Cell cell ;
        // Create cells
        cell = row.createCell(COLUMN_INDEX_ID);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("ID");
 
        cell = row.createCell(COLUMN_INDEX_TITLE);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Họ Tên");
 
        cell = row.createCell(COLUMN_INDEX_PRICE);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Số lần đi muộn");
        
        cell = row.createCell(3);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Số ngày nghỉ");
 
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
        cell = row.createCell(4+i);
        cell.setCellStyle(cellStyle);
        cell.setCellValue(fmt.format(cal.getTime()));
            cal.add(Calendar.DAY_OF_MONTH, 1);
        }

    }
    
    // Write data
    private static void writeUser(User user, Row row) {
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
        //cell.setCellValue(DateUtils.getNumberLateDate(year, month, user));
        
//        for (Departments de : departmentses) {
//            if(de.getmId() == user.getId_department()) {
//                cell.setCellValue(de.getmName());
//                break;
//            }
//        }
        
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
        boolean hasLateDay = false;
        int numOfLateDate = 0;
        int numOfCheckinDate = 0;
        for (Date date : datesOfMonth) {
            LocalDate in = date.toInstant()
                                            .atZone(ZoneId.systemDefault())
                                            .toLocalDate();
            List<LocalDate> lateDate = user.getLate_date();
            List<LocalDate> checkinDate = user.getList_checkin_date();
           
            for (LocalDate ld : lateDate) {
              //  System.out.println(date.getMonth() + " :" + ld.getMonthValue());
                if(ld.getMonthValue() == in.getMonthValue() && ld.getDayOfMonth()== in.getDayOfMonth()) {
                    System.out.println(ld.toString() + ":" + in.toString());
                     cell = row.createCell(i);
                     cell.setCellValue("M");
                     numOfLateDate++;
                     hasLateDay = true;
                }
            }
            
            for (LocalDate ld : checkinDate) {
              //  System.out.println(date.getMonth() + " :" + ld.getMonthValue());
                if(ld.getMonthValue() == in.getMonthValue() && ld.getDayOfMonth()== in.getDayOfMonth()) {
                    System.out.println(ld.toString() + ":" + in.toString());
                     cell = row.getCell(i);
                     if(cell == null) {
                         cell = row.createCell(i);
                         cell.setCellValue("Đ");
                         numOfCheckinDate++;
                     }
                }
            }
            i++;
        }
        if(hasLateDay) numberOfLate++;
        cell = row.getCell(2);
        cell.setCellValue(String.valueOf(numOfLateDate));
        cell = row.createCell(3);
        cell.setCellValue(String.valueOf(datesOfMonth.size() - numOfLateDate - numOfCheckinDate));
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
     
    
     private static CellStyle createStyleForTitle(Sheet sheet) {
        // Create font
         org.apache.poi.ss.usermodel.Font font = sheet.getWorkbook().createFont();
        font.setFontName("Times New Roman"); 
        font.setBold(true);
        font.setFontHeightInPoints((short) 14); // font size
        font.setColor(IndexedColors.BLACK.getIndex()); // text color
 
        // Create CellStyle
        CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
        cellStyle.setFont(font);
        //cellStyle.setFillForegroundColor(IndexedColors.BLUE.getIndex());
        //cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
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
            os.close();
        }
    }

    private static Map<Departments, List<User>> getAnalysicOfDepartment() {
        Map<Departments, List<User>> map = new LinkedHashMap<>();
        
        
        departmentses.forEach(de -> {
            ArrayList<User> users;
            users = getUsers(de.getmId());
            System.out.println("deparment size" + de.getmId());
            try {
                writeExcel(excelFilePath, de.getmName(), users);
            } catch (IOException ex) {
                Logger.getLogger(ExcelUtils.class.getName()).log(Level.SEVERE, null, ex);
            }
            map.put(de, users);
         });
;
        
        
        return map;
    }
    
    private static ArrayList<Departments> getDepartmentses() {
        ArrayList<Departments> rerult = new ArrayList<>();
        
        db.setDepartmentCol("departments");
        List<Document> list = db.getDepartments();
        for(int i =0; i< list.size(); i++) {
            try {
                rerult.add(JsonParser.jsonToDepartments(list.get(i).toJson()));
            } catch (JSONException ex) {
                Logger.getLogger(UserFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return rerult;
    }
    
     private static ArrayList<User> getUsers(int id) {
        return db.getAllUserOfDepartment(id);
    }
    
}
