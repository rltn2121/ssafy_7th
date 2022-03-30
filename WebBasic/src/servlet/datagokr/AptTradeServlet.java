package servlet.datagokr;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import com.google.gson.Gson;

@WebServlet("/apttrade")
public class AptTradeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private final String SERVICE_URL = "http://openapi.molit.go.kr/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTradeDev";
	private final String SERVICE_KEY = "UlGleAUx7sMLaGohCZAOATL6lO%2Fn6RA1unu7rP7PlqsfPVi6yPbeTlDSi1qXLllEabyZ4JxQfqvQbLyb4seg8A%3D%3D";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pageNo = request.getParameter("pageNo");
		String numOfRows = request.getParameter("numOfRows");
		String DEAL_YMD = request.getParameter("DEAL_YMD");
		String LAWD_CD = request.getParameter("LAWD_CD");
		
		if(pageNo == null)		pageNo = "1";
		if(numOfRows == null)	numOfRows = "10";
		if(DEAL_YMD == null)	DEAL_YMD = "202112";
		if(LAWD_CD == null)		LAWD_CD = "11110";
		
		String clsf = request.getParameter("clsf");
		if(clsf == null)		clsf = "json";
		
		StringBuilder sb = new StringBuilder();
		sb.append(SERVICE_URL)
		.append("?serviceKey=").append(SERVICE_KEY)
		.append("&pageNo=").append(pageNo)
		.append("&numOfRows=").append(numOfRows)
		.append("&DEAL_YMD=").append(DEAL_YMD)
		.append("&LAWD_CD=").append(LAWD_CD)
		.append("&clsf=").append(clsf);
		
		System.out.println(sb.toString());
		
		// HTTP Request 보내기
		URL url = new URL(sb.toString());
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		int responseCode = con.getResponseCode();
		System.out.println("Response Code : " + responseCode);
		
		// HTTP Response 받기
		BufferedReader br = null;
		if(responseCode == 200) {
			br = new BufferedReader(new InputStreamReader(con.getInputStream()));

			StringBuilder result = new StringBuilder();
			String line = null;
			while((line = br.readLine()) != null) {
				result.append(line);
			}
			// 연결 종료
			br.close();
			con.disconnect();
			System.out.println(result.toString());

			
			if("raw".equals(clsf)) {
				sendRaw(response, result.toString());
			} else if("json".equals(clsf) ) {
				sendJson(response, result.toString());
			}
		}
	}
	protected void sendRaw(HttpServletResponse response, String result) throws IOException {
		response.setContentType("application/xml; charset=utf-8");
		response.getWriter().write(result.toString());
	}
	
    protected void sendJson(HttpServletResponse response, String result) throws ServletException, IOException  {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            HouseSAXHandler handler = new HouseSAXHandler();
            InputStream is = new ByteArrayInputStream( result.getBytes(StandardCharsets.UTF_8));
            parser.parse(is, handler);
            List<HouseDeal> houseDealList = handler.getHouseDealList();

            Gson gson = new Gson();
            String jsonStr = gson.toJson(houseDealList);

            System.out.println("JSON -----------------");
            System.out.println(jsonStr);
            response.setContentType("application/json; charset=utf-8");
            response.getWriter().write(jsonStr);

        }catch(Exception e) {
            e.printStackTrace();
        }

    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
