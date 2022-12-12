package MPDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



import MPVO.MPVO;

public class MPDAO {
	private String url="jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "javaminiproject";
	private String pass = "javaminiproject";
	
	private Connection con= null;
	private PreparedStatement pst=null;
	private ResultSet rs = null;
	private MPVO vo = null;
	
	private String name = null;
	private String id = null;
	private String pw = null;
	private String phone = null;
	private String email = null;
	private int MaxScore = 0;
	
	private boolean result = false;
	
	
	
	
	
	public void connect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, user, pass);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//resultSet 해제
		public void con(ResultSet rs) {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		//Statement 객체 해제
		public void close(PreparedStatement pst) {
			if(pst != null) {
				try {
				pst.close();
				} catch (SQLException e) {
				e.printStackTrace();
				}
			}
		}
		//DB 커넥션 객체 해제
		public void close(Connection con) {
			if(con != null) {
				try {
					con.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		public boolean insertMP(String name, String id, String pw, String phone, String email, int MaxScore) {
			try {
				connect();
				String sql = "insert into USER_INFORMATION values(user_seq.nextval, ?, ?, ?, ?, ?, ?)";
				pst = con.prepareStatement(sql);
				pst.setString(1, id);
				pst.setString(2, pw);
				pst.setString(3, name);
				pst.setString(4, phone);
				pst.setString(5, email);
				pst.setInt(6, MaxScore);
				int cnt = pst.executeUpdate();
				if(cnt>0) {
					result = true;
				}else {
					result = false;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(pst);
				close(con);	
			}
			return result;
			
		}

		public boolean insertMP(String id, String pw, String name, String phone, String email) {
			try {
				connect();
				String sql = "insert into USER_INFORMATION (USER_NUM, USER_ID, USER_PASSWORD, USER_NAME, USER_PHONE, USER_EMAIL)  values(user_seq.nextval, ?, ?, ?, ?, ?)";
				pst = con.prepareStatement(sql);
				pst.setString(1, id);
				pst.setString(2, pw);
				pst.setString(3, name);
				pst.setString(4, phone);
				pst.setString(5, email);
				int cnt = pst.executeUpdate();
				if(cnt>0) {
					result = true;
				}else {
					result = false;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(pst);
				close(con);	
			}
			return result;
		}
		public ArrayList<MPVO> selectStd() {
			ArrayList<MPVO> al = new ArrayList<MPVO>();
			try {
				connect();
				String sql = "select * from USER_INFORMATION ";
				pst = con.prepareStatement(sql);
				rs = pst.executeQuery();
				while(rs.next()) {
					name = rs.getString("name");
					id = rs.getString("id");
					pw = rs.getString("pw");
					phone = rs.getString("phone");
					email = rs.getString("email");
					MaxScore = rs.getInt(MaxScore);
					vo = new MPVO(name, id, pw, phone, email, MaxScore);
					al.add(vo);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(pst);
				close(con);
			} 
			return al;
}
		public MPVO oneSelectMP(String id2, String pw2) {
			try {
				connect();
				String sql = "select * from USER_INFORMATION where USER_ID = ? and USER_PASSWORD =? ";
				pst = con.prepareStatement(sql);
				pst.setString(1, id2);
				pst.setString(2, pw2);
				boolean isList = false;
				rs = pst.executeQuery();
				while(rs.next()) {
					id2 = rs.getString("USER_ID");
					pw2 = rs.getString("USER_PASSWORD");
					name = rs.getString("USER_NAME");
					phone = rs.getString("USER_PHONE");
					email = rs.getString("USER_EMAIL");
					vo = new MPVO(name, id2, pw2, phone, email);
					isList = true;
				}
				if(isList == false) {
					vo = new MPVO();
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(pst);
				close(con);
			}	
			return vo;
}
		
}