package json;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;

public class MainApp {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		Weather w = new Weather();

		w.setLoc("busan");
		w.setTemp("19");
		w.setDate("20190417");
		
		Weather w4 = new Weather();

		w.setLoc("Seoul");
		w.setTemp("19");
		w.setDate("20190417");

		// 1번 자바오브젝트 -> JSON
		// {"loc" : "busan", "temp" : "10", "date" : "20190417"}
		String weatherJsonString = "{\"loc\" : " + w.getLoc() + ", \"temp\" : " + w.getTemp() + ", \"date\" : " + w.getDate() + "}";

		// StringBuilder, StringBuffer, String
		StringBuilder sb = new StringBuilder();

		sb.append("{");
		sb.append("\"loc\" : " + w.getLoc() + ", ");
		sb.append("\"temp\" : " + w.getTemp() + ", ");
		sb.append("\"date\" : " + w.getDate());
		sb.append("}");
		System.out.println(weatherJsonString);
		System.out.println(sb.toString());

		// VO -> JSON으로 첫번째 방법 - json.simple
		// 필드(전역변수, property)가 많으면 힘들다
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("loc", w.getLoc());
		jsonObject.put("temp", w.getTemp());
		jsonObject.put("date", w.getDate());
		System.out.println(jsonObject);

		// VO -> JSON으로 두번째 방법 - gson
		Gson gson = new Gson();
		String gsonString = gson.toJson(w);
		System.out.println(gsonString);

		// 2번 JSON -> 자바오브젝트(gsonString)
		// JSON -> VO 첫번째 방법 - jsonparser
		JSONParser parser = new JSONParser();
		try {
			JSONObject obj = (JSONObject)parser.parse(gsonString);
			String loc = (String)obj.get("loc");
			String temp = (String)obj.get("temp");
			String date = (String)obj.get("date");
			System.out.println(loc);
			System.out.println(temp);
			System.out.println(date);
			Weather w2 = new Weather();
			w2.setLoc(loc);
			w2.setTemp(temp);
			w2.setDate(date);
			System.out.println(w2.getLoc());
			System.out.println(w2.getTemp());
			System.out.println(w2.getDate());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		// JSON -> VO 두번째 방법 - gson
		Gson gson2 = new Gson();
		Weather w3 = gson2.fromJson(jsonObject.toString(), Weather.class);
		System.out.println(w3.getLoc());
		System.out.println(w3.getTemp());
		System.out.println(w3.getDate());
		
		
		//
		
		

	}

}
