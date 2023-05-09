package com.test.automation.uiAutomation.excelReader;
            import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.test.automation.uiAutomation.testBase.Testbase;

    public class ExcelUtils {
                private static XSSFSheet ExcelWSheet;
                private static XSSFWorkbook ExcelWBook;
                private static XSSFCell Cell;
                private static XSSFRow Row;
            	public static final Logger log = Logger.getLogger(Testbase.class.getName());

            //This method is to set the File path and to open the Excel file, Pass Excel Path and Sheetname as Arguments to this method
            public static void setExcelFile(String Path,String SheetName) throws Exception {
                   try {
                       // Open the Excel file
                    FileInputStream ExcelFile = new FileInputStream(Path);
                    // Access the required test data sheet
                    ExcelWBook = new XSSFWorkbook(ExcelFile);
                    ExcelWSheet = ExcelWBook.getSheet(SheetName);
                    log.info("Excel sheet opened");
                    } catch (Exception e){
                        throw (e);
                    }
            }
            //This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num
            public static String getCellData(int RowNum, int ColNum) throws Exception{
                   try{
                	   String CellData;
                	  Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
                	  
                      //String CellData = Cell.getStringCellValue();
                	  if (Cell.getCellType() == Cell.CELL_TYPE_STRING) {
                		  CellData = Cell.getStringCellValue();
            		}
                	  else if(Cell.getCellType() != Cell.CELL_TYPE_STRING) {
                		   CellData = Cell.getRawValue().toString();
            		}
                	  else {
                           CellData = Cell.getRawValue().toString();
            		}

                      return CellData;
                      }catch (Exception e){
                        return"";
                      }
            }
            //This method is to write in the Excel cell, Row num and Col num are the parameters
           /* @SuppressWarnings("static-access")
			public static void setCellData(String Result,  int RowNum, int ColNum) throws Exception    {
                   try{
                      Row  = ExcelWSheet.getRow(RowNum);
                    Cell = Row.getCell(ColNum);
                    if (Cell == null) {
                        Cell = Row.createCell(ColNum);
                        Cell.setCellValue(Result);
                        } else {
                           Cell.setCellValue(Result);
                        }
          // Constant variables Test Data path and Test Data file name
                          FileOutputStream fileOut = new FileOutputStream(Constant.Path_TestData + Constant.File_TestData);
                          ExcelWBook.write(fileOut);
                          fileOut.flush();
                        fileOut.close();
                        }catch(Exception e){
                            throw (e);
                    }
                }
            */
        	public static int getRowContains1(String sTestCaseName, int colNum) throws Exception{
        		int i;
        		try {
        			int rowCount = ExcelUtils.getRowUsed();
        			for ( i=0 ; i<rowCount; i++){
        				if  (ExcelUtils.getCellData(i,colNum).equalsIgnoreCase(sTestCaseName)){
        					break;
        				}
        			}
        			return i;
        				}catch (Exception e){
        			log.error("Class ExcelUtil | Method getRowContains | Exception desc : " + e.getMessage());
        			throw(e);
        			}
        		}
        	
        	public static int getRowUsed() throws Exception {
        		try{
        			int RowCount = ExcelWSheet.getLastRowNum();
        			log.info("Total number of Row used return as < " + RowCount + " >.");		
        			return RowCount;
        		}catch (Exception e){
        			log.error("Class ExcelUtil | Method getRowUsed | Exception desc : "+e.getMessage());
        			System.out.println(e.getMessage());
        			throw (e);
        		}

        	}
        	
        	public static Object[] getTableArray(String FilePath, String SheetName) throws Exception {   
        		 
     		   String[] tabArray = new String[2];;
      
     		   try {
      
     			   FileInputStream ExcelFile = new FileInputStream(FilePath);
      
     			   // Access the required test data sheet
      
     			   ExcelWBook = new XSSFWorkbook(ExcelFile);
      
     			   ExcelWSheet = ExcelWBook.getSheet(SheetName);
      		   // you can write a function as well to get Column count
     			   tabArray[1]= getCellData(2,0).toString();
     			  tabArray[2]=   getCellData(2,1).toString();
     			   System.out.println(tabArray[1]);
    			   System.out.println(tabArray[2]);

     					}
      
     			catch (FileNotFoundException e){
      
     				System.out.println("Could not read the Excel sheet");
      
     				e.printStackTrace();
      
     				}
      
     			catch (IOException e){
      
     				System.out.println("Could not read the Excel sheet");
      
     				e.printStackTrace();
      
     				}
      
     			return(tabArray);
      
     			}
        	public static String getTestCaseName(String sTestCase)throws Exception{
        		 
    			String value = sTestCase;
     
    			try{
     
    				int posi = value.indexOf("@");
     
    				value = value.substring(0, posi);
     
    				posi = value.lastIndexOf(".");	
     
    				value = value.substring(posi + 1);
     
    				return value;
     
    					}catch (Exception e){
     
    				throw (e);
     
    						}
     
    			}
     
    		public static int getRowContains(String sTestCaseName, int colNum) throws Exception{
     
    			int i;
     
    			try {
     
    				int rowCount = ExcelUtils.getRowUsed();
     
    				for ( i=0 ; i<rowCount; i++){
     
    					if  (ExcelUtils.getCellData(i,colNum).equalsIgnoreCase(sTestCaseName)){
     
    						break;
     
    					}
     
    				}
     
    				return i;
     
    					}catch (Exception e){
     
    				throw(e);
     
    				}
     
    			}
    		
    		
    		public static Object[][] getTableArray(String FilePath, String SheetName, int iTestCaseRow)    throws Exception
    		 
    		{   
     
    		   String[][] tabArray = null;
     
    		   try{
     
    			   FileInputStream ExcelFile = new FileInputStream(FilePath);
     
    			   // Access the required test data sheet
     
    			   ExcelWBook = new XSSFWorkbook(ExcelFile);
     
    			   ExcelWSheet = ExcelWBook.getSheet(SheetName);
     
    			   int startCol = 0;
     
    			   int ci=0,cj=0;
     
    			   int totalRows = 1;
     
    			   int totalCols = 2;
     
    			   tabArray=new String[totalRows][totalCols];
     
    				   for (int j=startCol;j<=totalCols;j++, cj++)
     
    				   {
     
    					   tabArray[ci][cj]=getCellData(iTestCaseRow,j);
     
    					   System.out.println(tabArray[ci][cj]);
     
    				   }
     
    			}
     
    			catch (FileNotFoundException e)
     
    			{
     
    				System.out.println("Could not read the Excel sheet");
     
    				e.printStackTrace();
     
    			}
     
    			catch (IOException e)
     
    			{
     
    				System.out.println("Could not read the Excel sheet");
     
    				e.printStackTrace();
     
    			}
     
    			return(tabArray);
     
    		}
    }