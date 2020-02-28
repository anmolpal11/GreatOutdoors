package sprint1;

import java.util.HashMap;
import java.util.Map;

public class MasterDaoImpl implements MasterDao {
	private Map<String, ProductMaster> map;
	ProductMaster pm=null;
	public MasterDaoImpl()
	{
		map=new HashMap<String, ProductMaster>();
	}
	
	public void register(ProductMaster pm) throws MasterException {

	if(!map.containsKey(pm.getUserName()))
	{

		map.put(pm.getUserName(), pm);
		System.out.println("Registered Successfully");
	}
	else {
		throw new MasterException("Id already exists.");
	}

	
		
	
	
	}

}
