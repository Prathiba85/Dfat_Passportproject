package com.qa.util;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class ExcelUtil {
	private static Map<String, String> OPASTestDataInMap = new TreeMap<String, String>();
	public static String Sheetname;
	public static String FILEPATH="src/main/java/testdata/OPAS_TestData.xlsx";

	public void setTestDataSheet(String sheetname) {
		Sheetname = sheetname;
	}

	public static Map<String, String> getTestDataInMap() throws Exception {

		String query = null;

		query = String.format("SELECT * FROM %s WHERE USED_STATUS='NO'", Sheetname);
		Fillo fillo = new Fillo();
		Connection conn = null;
		Recordset recordset = null;

		try {
			conn = fillo.getConnection(FILEPATH);
			recordset = conn.executeQuery(query);
			while (recordset.next()) {
				for (String field : recordset.getFieldNames()) {
					OPASTestDataInMap.put(field, recordset.getField(field));
					// System.out.println("Field is "+field+" "+"Value is
					// "+recordset.getField(field));

				}
			}

		} catch (FilloException e) {
			e.printStackTrace();
			throw new Exception("Test Data not found");
		}
		return OPASTestDataInMap;

	}

	public static String getTestData(String Attribute) {
		// src/test/resources/features
		try {

			OPASTestDataInMap = ExcelUtil.getTestDataInMap();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// System.out.println(OPASTestDataInMap.get("FAMILYNAME"));
		return OPASTestDataInMap.get(Attribute);

	}

	public  void insertGenerateFormNumber(String Applicaitonnumber, String TestDataID) throws Exception {
		String updateStatus = null;
		String updateStatusDynamicID = null;

		String applicaitonnumber = null;
		String updateapplicationnumber=null;
		String updateapplicationnumberDynamicID = null;
		
		String testdataid = TestDataID;
		System.out.println(testdataid);
		
		
		updateStatus=String.format("Update %s set USED_STATUS='Yes' where TestDataID='number'",Sheetname);
		updateStatusDynamicID=updateStatus.replace("number",testdataid);
		
		System.out.println("Status update query is "+updateStatusDynamicID);
		
		//update_status = String.format("Update %s set (USED_STATUS,FormNumber)Values('Yes','Applicationnumber') where TestDataID='2'",Sheetname);
		//update_Status = String.format("Update %s set USED_STATUS='Yes' where TestDataID='2'",Sheetname);
		
		applicaitonnumber=String.format("Update %s set FormNumber='Appnumber' where TestDataID='number'",Sheetname);
		updateapplicationnumber= applicaitonnumber.replace("Appnumber", Applicaitonnumber);
		updateapplicationnumberDynamicID= updateapplicationnumber.replace("number",testdataid);
		System.out.println("Application number update query is "+updateapplicationnumberDynamicID);
		Fillo fillo = new Fillo();
		Connection conn = null;
		int recordset = 0;

		try {
			conn = fillo.getConnection(FILEPATH);
			recordset = conn.executeUpdate(updateStatusDynamicID);
			recordset = conn.executeUpdate(updateapplicationnumberDynamicID);

		} catch (FilloException e) {
			e.printStackTrace();
			
			throw new Exception("Excel sheet not updated");
		}

	}

}
