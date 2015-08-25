package com.zcmng.commons;

public class ValidationUtil
{
	public static boolean validateRequired(String o)
	{

		String property = (String)o;
		if (property == null || property.equals(Constants.EMPTY_STRING))
		{
			return false;
		}			
		
		return true;
	}
	
	public static boolean validateMaxLength(String property, int maxLength)
	{
		return property.length() <= maxLength ;
	}
	
	public static boolean validateEqualsForString(String st1, String st2)
	{
		return st1.equals(st2);
	}
	
}
