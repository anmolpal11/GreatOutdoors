package sprint1;

import java.util.HashMap;
import java.util.Map;

public class Collection {
	public static Map<String,ProductDTO> stockMap = new HashMap<String,ProductDTO>();
	
	public void addproduct(String key,String productid,double price,String color,String dimension,String specification,String manufacturer,int quantity,String productname ) {
		
		stockMap.put(key,new ProductDTO(productid,price,color,dimension,specification,manufacturer,quantity,productname));
		
		System.out.println("Product ID : "+stockMap.get(key).getProductId());
		System.out.println("Price : "+stockMap.get(key).getPrice());
		System.out.println("Color : "+stockMap.get(key).getColour());
		System.out.println("DIMENSIONS : "+stockMap.get(key).getDimension());
		System.out.println("SPECIFICATION : "+stockMap.get(key).getSpecification());
		System.out.println("MANUFACTURER :  "+stockMap.get(key).getManufacturer());
		System.out.println("QUANTITY : "+stockMap.get(key).getQuantity());
		System.out.println("PRODUCT NAME "+stockMap.get(key).getProductName());
		System.out.println("---------------------------------");
	}

	public void deleteproduct(String del) {
		if(stockMap.containsKey(del)) {
			stockMap.remove(del);
			System.out.println("Product Deleted");
		}
		else {
			System.out.println("No Such Product Exists");
		}
	}
	
	public boolean editproduct(String edit) {
		if(stockMap.containsKey(edit)) {
			System.out.println("Quantity of "+edit+" which is Already Present is: "+stockMap.get(edit).getQuantity());
		}
		return stockMap.containsKey(edit);
	}
	
	public ProductDTO updateCollection(String edi) {
		return stockMap.get(edi);
}

	public void displayCollection() {
		for (Map.Entry<String, ProductDTO> entry : stockMap.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue().toString());
		}
	}
}