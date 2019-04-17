
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;

public class MyUtils {
	public static void connectionData(int nx, int ny) throws IOException{
		//base_date = 20190412
		//base_time = 1200
		
		StringBuilder urlBuilder = new StringBuilder("http://newsky2.kma.go.kr/service/SecndSrtpdFrcstInfoService2/ForecastGrib"); /* URL */
		urlBuilder.append("?" + URLEncoder.encode("ServiceKey", "UTF-8") + "=" + URLEncoder.encode("ZA1cO2IVjORQ6YQv0m4+BhJ+xsVVJLvi2BE0MHkgCvPpvRA7FR/9F8nlEiI0mqYoulPccxV6XFcCZ1t7ybZCZA==", "UTF-8")); /* 서비스 인증 */
		urlBuilder.append("&" + URLEncoder.encode("base_date", "UTF-8") + "=" + URLEncoder.encode("20190416", "UTF-8")); /* ‘15년 12월 1일 발표 */
		urlBuilder.append("&" + URLEncoder.encode("base_time", "UTF-8") + "=" + URLEncoder.encode("1200", "UTF-8")); /* 06시 발표(정시단위) -매시각 40분 이후 호출 */
		urlBuilder.append("&" + URLEncoder.encode("nx", "UTF-8") + "=" + URLEncoder.encode(nx + "", "UTF-8")); /* 예보지점의 X 좌표값 */
		urlBuilder.append("&" + URLEncoder.encode("ny", "UTF-8") + "=" + URLEncoder.encode(ny + "", "UTF-8")); /* 예보지점의 Y 좌표값 */
		urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /* 한 페이지 결과 수 */
		urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /* 페이지 번호 */
		urlBuilder.append("&" + URLEncoder.encode("_type", "UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /* xml(기본값), json */
		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		System.out.println("Response code: " + conn.getResponseCode());
		BufferedReader rd;
		if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		rd.close();
		conn.disconnect();

		// json 심플라이브러리
		// {key=value}형식을 담을 수 있는 클래스
		JSONObject json = new JSONObject();

		// json 처럼 생긴 String 문자열을 json object로 변경해주는 클래스
		JSONParser parser = new JSONParser();
		try {
			json = (JSONObject) parser.parse(sb.toString());
			JSONObject response = (JSONObject) json.get("response");
			
			System.out.println(response);
			
			JSONObject body = (JSONObject) response.get("body");
			
			System.out.println(body);
			
			JSONObject items = (JSONObject) body.get("items");
			JSONArray itemArray = (JSONArray) items.get("item");
			JSONObject item = (JSONObject) itemArray.get(3);
			double obsrValue = (double) item.get("obsrValue");
			System.out.println(obsrValue);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
