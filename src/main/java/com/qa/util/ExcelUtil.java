package com.qa.util;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;



public class ExcelUtil {
	private static Map<String,String> OPASTestDataInMap = new TreeMap<String,String>();
	public static Map<String,String> getTestDataInMap(String testDataFile,String sheetname) throws Exception 
	{
		//Map<String,String> OPASTestDataInMap = new TreeMap<String,String>();
		String query = null;
		//query = String.format("SELECT * FROM %s WHERE USED_STATUS='NO'",sheetname);
		query = String.format("SELECT * FROM %s WHERE USED_STATUS='NO'",sheetname);
		Fillo fillo=new Fillo();
		Connection conn =null;
		Recordset recordset = null;
		
		try
		{
		conn = fillo.getConnection(testDataFile);
		recordset=conn.executeQuery(query);
		while(recordset.next())
		{
			for (String field:recordset.getFieldNames())
			{
				OPASTestDataInMap.put(field, recordset.getField(field));
				//System.out.println("Field is "+field+" "+"Value is "+recordset.getField(field));
				
			}
		}
		
		
		}
		catch(FilloException e)
		{
			e.printStackTrace();
			throw new Exception("Test Data not found");
		}
		return OPASTestDataInMap;
		
	}
	
	public static String getTestData(String Attribute)
	{
		//src/test/resources/features
		try {
			
			OPASTestDataInMap = ExcelUtil.getTestDataInMap(
					"src/main/java/testdata/OPAS_TestData.xlsx",
					"OPAS_SIT");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		//System.out.println(OPASTestDataInMap.get("FAMILYNAME"));
		return OPASTestDataInMap.get(Attribute);
		
	}
}
