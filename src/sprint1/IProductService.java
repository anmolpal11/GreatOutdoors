package sprint1;

public interface IProductService {

	public void addService(String key,String productId, double price, String colour, String dimension, String specification, String manufacturer, int quantity, String productName);
	
	public void deleteService(String del); 

	public boolean editService(String edi);

	public void updateQtt(String edi);

	public void displayService();

}
