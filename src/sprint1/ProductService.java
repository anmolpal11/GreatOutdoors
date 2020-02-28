package sprint1;

public class ProductService implements IProductService {
	ProductDao pd=new ProductDao();
	public void addService(String key,String productId, double price, String colour, String dimension, String specification, String manufacturer, int quantity, String productName) {
		pd.addProduct(key,productId, price, colour, dimension, specification, manufacturer, quantity, productName);
	}
	
	public void deleteService(String del) {
		pd.deleteProduct(del);
	}

	public boolean editService(String edit) {
		return pd.editProduct(edit);
		
	}

	public void updateQtt(String edit) {
		pd.updateDao(edit);
		
	}

	public void displayService() {
		pd.displayProductDao();
		
	}

}
