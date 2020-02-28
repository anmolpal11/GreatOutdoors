package sprint1;

public class MasterServiceImpl implements MasterService{
	private MasterDao masterDao;
	public MasterServiceImpl()
	{
		masterDao = new MasterDaoImpl();
	}

	@Override
	public boolean  validateUserName(String username) {
	
	  boolean	flag=username.matches("[a-zA-Z0-9]+");
	 
		return flag;
	}

	@Override  
	public boolean validatePassWord(String passWord) {
	
	boolean	flag=passWord.matches("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%!]).{6,15})");
		
		return flag;
	}

	@Override
  public boolean validateReenterPassword(String reenterPassword) 
	{
     boolean flag=reenterPassword.matches("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%!]).{6,15})");
		
		return flag;
	}	
    
	@Override
	public boolean validateEMail(String eMail) {
		
		boolean flag=eMail.matches("^([1-zA-Z0-1@.\\s]{1,255})$");
		return flag;
	}

	@Override
	public boolean validatePhoneNumber(String phoneNumber) {
	boolean	flag=false;
	flag=phoneNumber.matches("[0-9]{10}+");
		return flag;
	}

	@Override
	public void register(ProductMaster pm) throws MasterException 
	{
		String userName=pm.getUserName();
		boolean flag1=validateUserName(userName);
		if(!flag1)
		{
			throw new MasterException("User name should contain alphabets and numbers");
		}
		
	
		String passWord=pm.getPassWord();
		
		boolean flag2=validatePassWord(passWord);
		if(!flag2)
		{
			throw new MasterException("password should contain atleast one uppercase character, lowercase character, one digit, and one special character");
		}
		
		
      String reenterpassword=pm.getReenterPassword();
       boolean flag5=validateReenterPassword(reenterpassword);
		if(!flag5)
		{
	     throw new MasterException("password not matched");
		}
		
		
		
		
		String phoneNumber=pm.getPhoneNum();
		boolean flag3=validatePhoneNumber(phoneNumber);
		if(!flag3)
		{
			throw new MasterException("Phone number should contain 10 digits");
		}
		String emailId=pm.getEmail();
		boolean flag4=validateEMail(emailId);
		if(!flag4)
		{
			throw new MasterException("email id should be in correct format");
		}
		masterDao.register(pm);
	}


}
