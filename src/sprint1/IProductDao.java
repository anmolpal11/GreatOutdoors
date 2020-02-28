package sprint1;

public interface IProductDao {
	public void addProduct(String key,String productId, double price, String colour, String dimension, String specification, String manufacturer, int quantity, String productName); 
	
	
	public void deleteProduct(String del); 
	
	public boolean editProduct(String edi); 
	public void updateDao(String edi);  

	
	public void displayProductDao();

}
