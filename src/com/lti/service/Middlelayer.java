package com.lti.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import com.lti.entity.AddCompo;

public class Middlelayer {

	AddCompo ac = new AddCompo();
	Connection conn1 = ac.getConn1();

	public Middlelayer() throws SQLException {
		super();
	}

	public int emptyOrNot(Connection conn1) throws SQLException {
		PreparedStatement pstmt = conn1.prepareStatement("select count(*) from records");
		int res = pstmt.executeUpdate();
		return res;
	}

	public void displayByYear(String year) throws SQLException {
		PreparedStatement pstmt = conn1.prepareStatement("select * from records where substr(date_recieved,-4,4)=(?)");
		pstmt.setString(1, year);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			String date_recieved = rs.getString("date_recieved");
			String products = rs.getString("products");
			String sub_products = rs.getString("sub_products");
			String issue = rs.getString("issue");
			String sub_issue = rs.getString("sub_issue");
			String company = rs.getString("company");
			String state = rs.getString("state");
			String zipcode = rs.getString("zipcode");
			String submitted_via = rs.getString("submitted_via");
			String date_sent = rs.getString("date_sent");
			String company_res = rs.getString("company_res");
			String timely_response = rs.getString("timely_response");
			String consumer_disputed = rs.getString("consumer_disputed");
			String complaint_id = rs.getString("complaint_id");
			System.out.println(date_recieved + " " + products + " " + sub_products + " " + " " + issue + " " + sub_issue
					+ " " + company + " " + state + " " + zipcode + " " + submitted_via
					+ " " + date_sent + " " + company_res + " " + timely_response
					+ " " + consumer_disputed + " " + complaint_id);
		}

	}

	public void displayBybank(String bank) throws SQLException {
		PreparedStatement pstmt = conn1.prepareStatement("select * from records where company =(?)");
		pstmt.setString(1, bank);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			String date_recieved = rs.getString("date_recieved");
			String products = rs.getString("products");
			String sub_products = rs.getString("sub_products");
			String issue = rs.getString("issue");
			String sub_issue = rs.getString("sub_issue");
			String company = rs.getString("company");
			String state = rs.getString("state");
			String zipcode = rs.getString("zipcode");
			String submitted_via = rs.getString("submitted_via");
			String date_sent = rs.getString("date_sent");
			String company_res = rs.getString("company_res");
			String timely_response = rs.getString("timely_response");
			String consumer_disputed = rs.getString("consumer_disputed");
			String complaint_id = rs.getString("complaint_id");
			System.out.println(date_recieved + " " + products + " " + sub_products + " " + " " + issue + " " + sub_issue
					+ " " + company + " " + state + " " + zipcode + " " + submitted_via
					+ " " + date_sent + " " + company_res + " " + timely_response
					+ " " + consumer_disputed + " " + complaint_id);
		}
	}

	public void displayBycustid(String custid) throws SQLException {
		PreparedStatement pstmt = conn1.prepareStatement("select * from records where complaint_id =(?)");
		pstmt.setString(1, custid);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			String date_recieved = rs.getString("date_recieved");
			String products = rs.getString("products");
			String sub_products = rs.getString("sub_products");
			String issue = rs.getString("issue");
			String sub_issue = rs.getString("sub_issue");
			String company = rs.getString("company");
			String state = rs.getString("state");
			String zipcode = rs.getString("zipcode");
			String submitted_via = rs.getString("submitted_via");
			String date_sent = rs.getString("date_sent");
			String company_res = rs.getString("company_res");
			String timely_response = rs.getString("timely_response");
			String consumer_disputed = rs.getString("consumer_disputed");
			String complaint_id = rs.getString("complaint_id");
			System.out.println(date_recieved + " " + products + " " + sub_products + " " + " " + issue + " " + sub_issue
					+ " " + company + " " + state + " " + zipcode + " " + submitted_via
					+ " " + date_sent + " " + company_res + " " + timely_response
					+ " " + consumer_disputed + " " + complaint_id);
		}
	}

	public int getDayscount(String custid) throws SQLException {
		PreparedStatement pstmt = conn1
				.prepareStatement("select date_recieved, date_sent from records where complaint_id =(?)");
		pstmt.setString(1, custid);
		ResultSet rs = pstmt.executeQuery();
		String[] strarr = new String[2];
		while (rs.next()) {
			strarr[0] = rs.getString("date_recieved");
			strarr[1] = rs.getString("date_sent");
		}
		DateTimeFormatter formatter_1 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDate local_date_1 = LocalDate.parse(strarr[0], formatter_1);

		// DateTimeFormatter formatter_1 = DateTimeFormatter.ofPattern("mm/dd/yyyy");
		LocalDate local_date_2 = LocalDate.parse(strarr[1], formatter_1);
		Period period = Period.between(local_date_1, local_date_2);
		int diff = period.getDays();
		return diff;
	}

	public void ccExplaination() throws SQLException {
		PreparedStatement pstmt = conn1.prepareStatement(
				"select * from records where company_res ='Closed' OR company_res='Closed with explanation'");
//		pstmt.setString(1,custid);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			String date_recieved = rs.getString("date_recieved");
			String products = rs.getString("products");
			String sub_products = rs.getString("sub_products");
			String issue = rs.getString("issue");
			String sub_issue = rs.getString("sub_issue");
			String company = rs.getString("company");
			String state = rs.getString("state");
			String zipcode = rs.getString("zipcode");
			String submitted_via = rs.getString("submitted_via");
			String date_sent = rs.getString("date_sent");
			String company_res = rs.getString("company_res");
			String timely_response = rs.getString("timely_response");
			String consumer_disputed = rs.getString("consumer_disputed");
			String complaint_id = rs.getString("complaint_id");
			System.out.println(date_recieved + " " + products + " " + sub_products + " " + " " + issue + " " + sub_issue
					+ " " + company + " " + state + " " + zipcode + " " + submitted_via
					+ " " + date_sent + " " + company_res + " " + timely_response
					+ " " + consumer_disputed + " " + complaint_id);
		}

	}

	public void timelyResponse() throws SQLException {
		PreparedStatement pstmt=conn1.prepareStatement("select * from records where timely_response='Yes'");
//		pstmt.setString(1,custid);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()) {
			String date_recieved=rs.getString("date_recieved");
			String products=rs.getString("products");
			String sub_products=rs.getString("sub_products");
			String issue=rs.getString("issue");
			String sub_issue=rs.getString("sub_issue");
			String company=rs.getString("company");
			String state=rs.getString("state");
			String zipcode=rs.getString("zipcode");
			String submitted_via=rs.getString("submitted_via");
			String date_sent=rs.getString("date_sent");
			String company_res=rs.getString("company_res");
			String timely_response=rs.getString("timely_response");
			String consumer_disputed=rs.getString("consumer_disputed");
			String complaint_id=rs.getString("complaint_id");
			System.out.println(date_recieved + " " + products + " " + sub_products + " " + " " + issue + " " + sub_issue
					+ " " + company + " " + state + " " + zipcode + " " + submitted_via
					+ " " + date_sent + " " + company_res + " " + timely_response
					+ " " + consumer_disputed + " " + complaint_id);
		}
		
	}
	public int insertRecord(String[] nextLine) throws SQLException {
		PreparedStatement pstmt = conn1.prepareStatement("Insert into records values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		String str1 = nextLine[0];
		String str2 = nextLine[1];
		String str3 = nextLine[2];
		String str4 = nextLine[3];
		String str5 = nextLine[4];
		String str6 = nextLine[5];
		String str7 = nextLine[6];
		String str8 = nextLine[7];
		String str9 = nextLine[8];
		String str10 = nextLine[9];
		String str11 = nextLine[10];
		String str12 = nextLine[11];
		String str13 = nextLine[12];
		String str14 = nextLine[13];

		pstmt.setString(1, str1);
		pstmt.setString(2, str2);
		pstmt.setString(3, str3);
		pstmt.setString(4, str4);
		pstmt.setString(5, str5);
		pstmt.setString(6, str6);
		pstmt.setString(7, str7);
		pstmt.setString(8, str8);
		pstmt.setString(9, str9);
		pstmt.setString(10, str10);
		pstmt.setString(11, str11);
		pstmt.setString(12, str12);
		pstmt.setString(13, str13);
		pstmt.setString(14, str14);
		int res = pstmt.executeUpdate();
		return res;
	}

}
