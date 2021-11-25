package pkg;

import java.util.ArrayList;
import java.util.List;

public class columlist {
	static List<String> list= new ArrayList<String>();
	
	public static void colname(List<String> colname)
	{
	for(int i=0;i<colname.size();i++)
	{
		list.add(colname.get(i));
	}
	/*for(int i=0;i<colname.size();i++)
	{
		System.out.println(list.get(i));
	}*/
	}
public static List<String> getlist()
{
	return list;
}

}
