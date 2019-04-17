package json;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class SubApp {

	public static void main(String[] args) {

		Weather w1 = new Weather();
		w1.setLoc("Busan");
		w1.setTemp("5");
		w1.setDate("20190417");
		
		Weather w2 = new Weather();
		w2.setLoc("Seoul");
		w2.setTemp("2");
		w2.setDate("20190417");
		
		// VO -> JSONObject으로 변경 -> GSON
		List<Weather> list = new ArrayList<Weather>();
		list.add(w1);
		list.add(w2);
		// List -> JSONArray로 변경
		Gson gson1 = new Gson();
		String gson1String = gson1.toJson(list);
		System.out.println(gson1String);
		

		
		// 선생님 답안
		Gson gson2 = new Gson();
		TypeToken<List<Weather>> typeToken = new TypeToken<List<Weather>>() {};
		List<Weather> list2 = gson2.fromJson(gson1String, typeToken.getType());
		for (Weather weather : list2) {
			System.out.println(weather.getLoc());
		}
		

		Weather[] array = gson1.fromJson(gson1String, Weather[].class);
		List<Weather> list3 = Arrays.asList(array);
		
		System.out.print("{\"weather\" : ");		
		System.out.print(list3);
		System.out.println("}");
		
		// JSONArray -> List로 변경
		List<Weather> list4 = gson1.fromJson(gson1String, new TypeToken<List<Weather>>(){}.getType());
		
		System.out.print("{\"weather\" : ");		
		System.out.print(list4);
		System.out.println("}");

	}

}
