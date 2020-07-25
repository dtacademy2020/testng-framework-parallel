package utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVUtility {
	
	
	
	public static Object[][] extractData (String filePath) throws IOException{
		
		
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		String line = "";
		
		List <String[]> list = new ArrayList<>();
		int colCount = 0;
		while( (line = reader.readLine()) != null ) {
			
			String[] split = line.split(",");
			colCount = split.length;
			list.add(split);
			
		}
		
		int rowCount = list.size();
		
		Object [][] data = new Object[rowCount][colCount];
		
		for (int i = 0; i < data.length; i++) {
			data [i] = list.get(i);
		}
		
		return data;
		
	}
	
	
	public static void main(String[] args) throws IOException {
		Object[][] extractData = extractData("data.csv");
		
		System.out.println(Arrays.deepToString(extractData));
	}
	

}
