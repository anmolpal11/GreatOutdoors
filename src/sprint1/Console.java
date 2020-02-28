package sprint1;

import java.util.Scanner;

public class Console {
	public static void main(String[]args) {
		MasterService masterService=new MasterServiceImpl();
		ProductService ps = new ProductService();
		ProductDTO pd = new ProductDTO();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		ProductMaster pm=null;
		int choice;
		while(true) {
			System.out.println("===============================");
			System.out.println("1.Register Product Master"+"\n"+"2.Add a new product"+"\n"+"3.Edit an existing product"+"\n"+"4.Delete a product"+"\n"+"5.Display"+"\n"+"6.Exit");
			System.out.println("===============================");
			choice=sc.nextInt();
			switch(choice) {
			case 1:
				try {
				System.out.print("Enter the user name");
		        sc.nextLine();
		        String username=sc.nextLine();
		        System.out.print("Enter the password");
		        String password=sc.nextLine();
		        System.out.print("Confirm password");
		        String reenterpassword=sc.nextLine();
		        System.out.print("Enter the emailid");
		        String emailid=sc.nextLine();
		        System.out.print("Enter the phonenumber");
		        String phonenumber=sc.nextLine();
		        
		        pm = new ProductMaster();
		        pm.setUserName(username);
		        pm.setPassWord(password);
		        pm.setReenterPassword(reenterpassword);
		        pm.setEmail(emailid);
		        pm.setPhoneNum(phonenumber);
		        if(password.equals(reenterpassword)) {
				masterService.register(pm);
		        }
		        else {
		        	throw new MasterException("Password should be same.");
		        }
				}
				catch(Exception e) {
					System.out.println(e);
				}
				
				
				break;
			case 2:
				System.out.println("Enter product ID");
				String p_c;
				while(true) {
					String productId=sc.next();
					boolean b1 = Validation.validatedata(productId,Validation.productIdpattern);
					if(b1 == true) {
						try 
						{
							p_c = productId;
							break;
						}
						catch(Exception e)
						{
							System.out.println("Wrong Values !!!");
						}
					}
					else {
						System.out.println("--Please Enter Again The Product ID in AlphaNumeric Form!!!--");
					}
				}
				
				pd.setProductId(p_c);
				System.out.println("Enter Price:");
				pd.setPrice(sc.nextDouble());
				System.out.println("Enter Colour: ");
				pd.setColour(sc.next());
				System.out.println("Enter Dimensions String type: ");
				pd.setDimension(sc.next());
				System.out.println("Enter Specification: ");
				pd.setDimension(sc.next());
				System.out.println("Enter Manufacturer: ");
				pd.setManufacturer(sc.next());
				System.out.println("Enter quantity: ");
				pd.setQuantity(sc.nextInt());
				System.out.println("Enter product name");
				pd.setProductName(sc.next());
				ps.addService(pd.getProductId(),pd.getProductId(),pd.getPrice(),pd.getColour(),pd.getDimension(),pd.getSpecification(),pd.getManufacturer(),pd.getQuantity(),pd.getProductName());
				System.out.println("Values Entered Successfully");
				
				break;
				
				
			case 3:
				System.out.println("Enter the key whose value you want to edit :");
				String edit=sc.next();
				if(ps.editService(edit)) {
					System.out.println("----Now Enter ur choice----");
					System.out.println("1.Updtate quantity");
					System.out.println("2.Update all Values");
					int choice2=sc.nextInt();
					switch(choice2) {
					case 1:
						ps.updateQtt(edit);
						break;
						
					case 2:
						System.out.println("Enter product ID");
						String p_c1;
						while(true) {
							String productId=sc.next();
							boolean b1 = Validation.validatedata(productId,Validation.productIdpattern);
							if(b1) {
								try 
								{
									p_c1 = productId;
									break;
								}
								catch(Exception e)
								{
									System.out.println("Enter Again!!!");
								}
							}
							else {
								System.out.println("Wrong details Enter Again!!!");
							}
						}
						
						pd.setProductId(p_c1);
						System.out.println("Enter Price:");
						pd.setPrice(sc.nextDouble());
						System.out.println("Enter COLOUR");
						pd.setColour(sc.next());
						System.out.println("Enter Dimensions String type");
						pd.setDimension(sc.next());
						System.out.println("Enter Specification");
						pd.setDimension(sc.next());
						System.out.println("Enter Manufacturer");
						pd.setManufacturer(sc.next());
						System.out.println("Enter quantity");
						pd.setQuantity(sc.nextInt());
						System.out.println("Enter product name");
						pd.setProductName(sc.next());
						ps.addService(edit,pd.getProductId(),pd.getPrice(),pd.getColour(),pd.getDimension(),pd.getSpecification(),pd.getManufacturer(),pd.getQuantity(),pd.getProductName());
						System.out.println("-----Values Entered Successfully------");
						break;
						
					default:
						System.out.println("-----Wrong Choice Entered-----");
						break;
					}
				}
				else {
					System.out.println("-----Product is not present-----");
				}
				break;
				
				
				
				
			case 4:
				System.out.println("Enter Hashmap Key to delete the product :");
				String del=sc.next();
				ps.deleteService(del);
				
				break;
				
			
				
			/*case 5:
				System.out.println("Enter Product Name");
				
				break;
				
			case 6:
				System.out.println();
				break;*/
			case 5:
				System.out.println("-----------------WHOLE DATABASE-----------------");
				ps.displayService();
				
				break;
			default:
				System.out.println("----Wrong Choice Entered----");
				break;

			}
		}
	}

}
