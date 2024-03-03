package UtilityPackage;

import java.io.IOException;

import org.testng.annotations.DataProvider;
public class DataProviders {

	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
		String path=".\\TestData\\Testing_data.xlsx";
		
		UtilityFiles xlutil =new UtilityFiles();
		
		int totalrows= xlutil.getRowCount(path,"Sheet1");	
		int totalcols= xlutil.getCellCount(path,"Sheet1", 1);
				
		String logindata[][]=new String[totalrows][totalcols];
		
		for(int i=1;i<=totalrows;i++)  
		{		
			for(int j=0;j<totalcols;j++) 
			{
				logindata[i-1][j]= xlutil.getCellData(path,"Sheet1", i, j);  //1,0
			}
		}
	return logindata;
	}
}
