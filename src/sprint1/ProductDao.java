package sprint1;

import java.util.Scanner;

public class ProductDao implements IProductDao {
	Scanner sc=new Scanner(System.in);
	Collection pc=new Collection();
	
	ProductDTO pdt=new ProductDTO();
	
	public void addProduct(String key,String productId, double price, String colour, String dimension, String specification, String manufacturer, int quantity, String productName) 
	{
		
		pc.addproduct(key,productId, price, colour, dimension, specification, manufacturer, quantity, productName);
	}
	
	public void deleteProduct(String del) {
		pc.deleteproduct(del);
	}

	public boolean editProduct(String edit) {
		return pc.editproduct(edit);
	}
	
	public void updateDao(String edit) {
		int oldQtt=pc.updateCollection(edit).getQuantity();
		System.out.println("Quantity of "+edit+" is "+oldQtt);
		System.out.println("Now Enter new Quantity");
		int newQtt=sc.nextInt();
		System.out.println("-----Updated Values-----");
		pc.addproduct(edit,pc.updateCollection(edit).getProductId(),pc.updateCollection(edit).getPrice(), pc.updateCollection(edit).getColour(), pc.updateCollection(edit).getDimension(), 
				pc.updateCollection(edit).getSpecification(),pc.updateCollection(edit).getManufacturer(), newQtt, pc.updateCollection(edit).getProductName());
	}
	
	public void displayProductDao() {
		pc.displayCollection();
	}
}