package UtilityPackage;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtil 
{
	public static String empName()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return ("Akash"+generatedString);
	}
	
	public static String empSalary()
	{
		String generatedString = RandomStringUtils.randomNumeric(5);
		return generatedString;
	}
	
	public static String empAge()
	{
		String generatedString = RandomStringUtils.randomNumeric(2);
		return generatedString;
	}
}
