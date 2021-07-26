package com.lti.entity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

import com.opencsv.CSVReader;


public class AddCompo {

	public AddCompo() throws SQLException{
		super();
		// TODO Auto-generated constructor stub
	}


	private Connection conn1=connectToDatabase();
	
	public void readAndAdd(String link) {
		CSVReader reader = null;
		try {
			// parsing a CSV file into CSVReader class constructor
			reader = new CSVReader(new FileReader(link));
			String[] nextLine;
			// reads one line at a time
			while ((nextLine = reader.readNext()) != null) {
				// String query="Insert into records values("+nextLine+")";
				System.out.println(Arrays.toString(nextLine) + " nextline\n");
				// System.out.println(nextLine.length+" len");

				// PreparedStatement pstmt=conn.prepareStatement("Insert into
				// records(products,sub_products,issue,sub_issue,company,state,zipcode,submitted_via)
				// values (?,?,?,?,?,?,?,?)");

				PreparedStatement pstmt = conn1.prepareStatement("Insert into records values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				Statement stmt = conn1.createStatement();

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
				if (res > 0) {
					System.out.println("1 record inserted");
				}
				pstmt.close();

//				for (String token : nextLine) {
//					System.out.print(token);
//				
//					
//					//PreparedStatement pstmt=conn.prepareStatement("Insert into records values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
////					pstmt.setDate(1,)
//				}
				System.out.print("\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
	public Connection connectToDatabase() throws SQLException {
		String url = "jdbc:oracle:thin:@localhost:1520/XE"; // orcl or XE or OSE
		Connection conn = DriverManager.getConnection(url, "HR", "hr");
		if (conn != null) {
			System.out.println("Connected");
			// conn.close();
		}
		return conn;
	}


	public Connection getConn1() {
		return conn1;
	}

}
