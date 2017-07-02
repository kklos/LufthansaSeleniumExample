package com.pack.tools;

import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Tools {

	public static boolean stringContainsItemFromList(String inputStr, List<String> items)
	{
	    for(int i =0; i < items.size(); i++)
	    {
	        if(inputStr.contains(items.get(i)))
	        {
	            return true;
	        }
	    }
	    return false;
	}
	
	public void datePickerGetSpecifyDate(String date, WebElement dateWidgetFrom)
	{
        //Get Today's number
		String today = getCurrentDay();

        //This are the columns of the from date picker table
        List<WebElement> columns = dateWidgetFrom.findElements(By.tagName("td"));
 
        //DatePicker is a table. Thus we can navigate to each cell
        //and if a cell matches with the current date then we will click it.
        for (WebElement cell: columns) {
            /*
            //If you want to click 18th Date
            if (cell.getText().equals("18")) {
            */
            //Select Today's Date
            if (cell.getText().equals(today)) {
                cell.click();
                break;
            }
        }
 
        //Wait for 4 Seconds to see Today's date selected.
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	}
	
	 private String getCurrentDay (){
	        //Create a Calendar Object
	        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
	 
	        //Get Current Day as a number
	        int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
	        System.out.println("Today Int: " + todayInt +"\n");
	 
	        //Integer to String Conversion
	        String todayStr = Integer.toString(todayInt);
	        System.out.println("Today Str: " + todayStr + "\n");
	 
	        return todayStr;
	    }
}
