package com.midprj.exchangerate;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.midprj.comm.Command;

public class ExchangeRate implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		try {

			String mResult = ""; // 저장변수
			String line = "";
			LocalDate now = LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

			String key = "https://www.koreaexim.go.kr/site/program/financial/exchangeJSON?authkey=qfm2LElyI0r7em2lKMskzeiW76fiBlD6&"; // 인증키
			
			String searchdate = now.format(formatter);
			
			String data = "AP01"; // 검색요청API타입

			List<ExchangeRateVO> list = new ArrayList<ExchangeRateVO>();
			// searchdate=20220328&data=AP01

			URL url = new URL(
					"https://www.koreaexim.go.kr/site/program/financial/exchangeJSON?authkey=qfm2LElyI0r7em2lKMskzeiW76fiBlD6&searchdate="
							+ searchdate +"&data="+data);

			BufferedReader bf;
			bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));

			while ((line = bf.readLine()) != null) {
				mResult = mResult.concat(line);
			}

			JSONParser parser = new JSONParser();

			JSONArray listArr = (JSONArray) parser.parse(mResult);

			for (int i = 0; i < listArr.size(); i++) {
				ExchangeRateVO vo = new ExchangeRateVO();

				JSONObject exchange = (JSONObject) listArr.get(i);
				String eCurNm = (String) exchange.get("cur_nm"); // 통화명 : 한국 원
				String eDealBasR = (String) exchange.get("deal_bas_r"); // 매매기준율

				StringBuffer sb = new StringBuffer();
				sb.append("국가/통화명: " + eCurNm + ", 매매 기준율 : " + eDealBasR);

				String nation = "";
				String currency = "";
				String[] sNation = eCurNm.split("\\s+");

				if (sNation.length == 1) {
					nation = "중국";
					currency = "위안화";
				} else {
					nation = sNation[0];
					currency = sNation[1];
				}
				if(eDealBasR.contains(",")==true) {
					eDealBasR = eDealBasR.replace(",", "");
				}
				vo.setNation(nation);
				vo.setCurrency(currency);
				vo.setExchangeRate(eDealBasR);

				list.add(vo);

			}

			request.setAttribute("eList", list);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "exchangerate/exchangeRate";
	}

}