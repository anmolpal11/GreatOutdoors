package sprint1;

public interface Validation {
String productIdpattern="[a-z][a-z]*[0-9][0-9]*";
	
	public static boolean validatedata(String data,String pattern)
	{
		return data.matches(pattern);
	}

}
