package com.midprj.comm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OpenBank {
	public static String getAccessToken(String code) { //accesstoken 받는 function
		final String strUrl = "https://testapi.openbanking.or.kr/oauth/2.0/token"; // Host
		final String grant_type = "authorization_code";

		// 토큰발급을 요청하기위한 URI 요소를 설정함.
		List<Parameter> postParams = new ArrayList<Parameter>();
		postParams.add(new Parameter("code", code));
		postParams.add(new Parameter("client_id", AgencyInfo.client_id));
		postParams.add(new Parameter("client_secret", AgencyInfo.client_secret));
		postParams.add(new Parameter("redirect_uri", AgencyInfo.redirect_uri));
		postParams.add(new Parameter("grant_type", grant_type));
		
		StringBuilder sb = new StringBuilder();
		
		try {
			// url 연결함.
			URL url = new URL(strUrl);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");
			con.setDoInput(true);
			con.setDoOutput(true);
			con.addRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");

			// uri 정보를 OutputStrea으로 보냄.
			String uri = getQuery(postParams);
			
			OutputStream os = con.getOutputStream();
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
			writer.write(uri);
			writer.flush();
			writer.close();
			os.close();
			
			//JSON 형태의 반환값 처리
			if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
				String line;
				while((line = br.readLine())!=null) {
					sb.append(line);
				}
				br.close();
			}else {
				System.out.println(con.getResponseMessage());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
	
	private static String getQuery(List<Parameter> params) throws UnsupportedEncodingException {
		StringBuilder result = new StringBuilder();
		boolean first = true;
		
		for(Parameter pair : params) {
			if(first) //첫번째인 경우는 '&'제외
				first = false;
			else 
				result.append("&");
			
			result.append(URLEncoder.encode(pair.getKey(),"UTF-8"));
			result.append("=");
			result.append(URLEncoder.encode(pair.getValue(),"UTF-8"));
		}
		return result.toString();
	}
	
	public static String getAccountList(String user_seq_no, String access_token) {
		
		//전달할 Parameter 설정
		List<Parameter> postParams = new ArrayList<Parameter>();
		postParams.add(new Parameter("user_seq_no",user_seq_no));
		postParams.add(new Parameter("include_cancel_yn","N"));
		postParams.add(new Parameter("sort_order","D"));
		
		StringBuilder sb = new StringBuilder();
		try {
			String uri = getQuery(postParams);
			String strUrl =  "https://testapi.openbanking.or.kr/v2.0/account/list"+"?"+uri;
			URL url = new URL(strUrl);
			
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			//Header에 정보 추가
			con.setRequestProperty("Authorization", "Bearer "+access_token);
			
			if(con.getResponseCode() == HttpURLConnection.HTTP_OK){
				BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF-8"));
				String line;
				while((line=br.readLine())!=null){
					sb.append(line).append("\n");
				}
				br.close();
			}else {
				System.out.println(con.getResponseMessage());
			}
		}catch(Exception e) {
			
		}
		
		return sb.toString();
	}
	
	public static String checkBalance(String fintech_use_num,String access_token) {
		List<Parameter> postParams = new ArrayList<Parameter>();


		
		Random random = new Random();
		int createNum = 0;
		String ranNum = "";
		int letter = 9;
		String resultNum = "";
		
		for(int i=0; i<letter; i++) {
			createNum = random.nextInt(9);
			ranNum = Integer.toString(createNum);
			resultNum += ranNum;
		}
		
		String bank_tran_id = "M202200519U"+resultNum;
		System.out.println(bank_tran_id);
		
		postParams.add(new Parameter("bank_tran_id",bank_tran_id));
		postParams.add(new Parameter("fintech_use_num",fintech_use_num));
		postParams.add(new Parameter("tran_dtime","20201001150133"));
		
		StringBuilder sb = new StringBuilder();
		try {
			String uri = getQuery(postParams);
			String strUrl =  "https://testapi.openbanking.or.kr/v2.0/account/balance/fin_num"+"?"+uri;
			URL url = new URL(strUrl);
			
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			//Header에 정보 추가
			con.setRequestProperty("Authorization", "Bearer "+access_token);
			
			if(con.getResponseCode() == HttpURLConnection.HTTP_OK){
				BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF-8"));
				String line;
				while((line=br.readLine())!=null){
					sb.append(line).append("\n");
				}
				br.close();
			}else {
				System.out.println(con.getResponseMessage());
			}
		}catch(Exception e) {
			
		}
		
		return sb.toString();
		
		
	}
	
	public static String transactionList(String fintech_use_num, String access_token) {
		List<Parameter> postParams = new ArrayList<Parameter>();
		
		Random random = new Random();
		int createNum = 0;
		String ranNum = "";
		int letter = 9;
		String resultNum = "";
		
		for(int i=0; i<letter; i++) {
			createNum = random.nextInt(9);
			ranNum = Integer.toString(createNum);
			resultNum += ranNum;
		}
		
		String bank_tran_id = "M202200519U"+resultNum;
		
		postParams.add(new Parameter("bank_tran_id",bank_tran_id));
		postParams.add(new Parameter("fintech_use_num",fintech_use_num));
		postParams.add(new Parameter("inquiry_type","A"));
		postParams.add(new Parameter("inquiry_base","D"));
		postParams.add(new Parameter("from_date","20200101"));
		postParams.add(new Parameter("to_date","20220331"));
		postParams.add(new Parameter("sort_order","D"));
		postParams.add(new Parameter("tran_dtime","20201001150133"));
		
		StringBuilder sb = new StringBuilder();
		try {
			String uri = getQuery(postParams);
			String strUrl =  "https://testapi.openbanking.or.kr/v2.0/account/transaction_list/fin_num"+"?"+uri;
			URL url = new URL(strUrl);
			
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			//Header에 정보 추가
			con.setRequestProperty("Authorization", "Bearer "+access_token);
			
			if(con.getResponseCode() == HttpURLConnection.HTTP_OK){
				BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF-8"));
				String line;
				while((line=br.readLine())!=null){
					sb.append(line).append("\n");
				}
				br.close();
			}else {
				System.out.println(con.getResponseMessage());
			}
		}catch(Exception e) {
			
		}
		
		return sb.toString();
	}

		
}
