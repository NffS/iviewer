package Support;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.transform.ResultTransformer;

import com.ncteam.iviewer.domain.FormInformation;

/*
 * This class is used to transform results of a query to objects of the FormInformation class.
 * The class is used in the FormDAO class.
 */
public class FormInformationTransformer implements ResultTransformer {

	@Override
	public List transformList(List collection) {
		List<FormInformation> result=new ArrayList<FormInformation>();
		 for(Object o : collection){
			 result.add((FormInformation)o);
		 }
		return result;
	}

	@Override
	public Object transformTuple(Object[] columns, String[] aliases) {
	
		return new FormInformation((String)columns[0],(String)columns[1],(String)columns[2],
				(String)columns[3],(Integer)columns[4],(Integer) columns[5], (Integer)columns[6],
				(String)columns[7]);
	}

}
