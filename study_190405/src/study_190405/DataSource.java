package study_190405;

import java.util.ArrayList;
import java.util.List;

public class DataSource {
	
	public static List<User> findAll(){
		List<User> list = new ArrayList<>();
		list.add(new User(1, "ssar", "cos", "0102222"));
		list.add(new User(2, "love", "cos", "0102222"));
		list.add(new User(3, "cherry", "cos", "0102222"));
		list.add(new User(4, "apple", "cos", "0102222"));
		list.add(new User(5, "banana", "cos", "0102222"));
		
		return list;
	}

}
