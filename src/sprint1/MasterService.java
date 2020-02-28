package sprint1;

public interface MasterService {
	 public boolean validateUserName(String userName);
     public boolean validatePassWord(String passWord);
     public boolean validateEMail(String eMail);
     public boolean validateReenterPassword(String reenterpassword);
     public boolean validatePhoneNumber(String phoneNumber);
     public  void register(ProductMaster pm) throws MasterException;

}
