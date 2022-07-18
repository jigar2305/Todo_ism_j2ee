package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.UserBean;
import util.Dbconnection;

public class UserDao {
	public Boolean adduser(UserBean userBean) {
		try (Connection con = Dbconnection.getConnection();
				PreparedStatement pstms = con.prepareStatement(
						"insert into users (firstname,lastname,email,password,gender,answer,question) values (?,?,?,?,?,?,?)");) {

			pstms.setString(1, userBean.getFirstname());
			pstms.setString(2, userBean.getLastname());
			pstms.setString(3, userBean.getEmail());
			pstms.setString(4, userBean.getPassword());
			pstms.setString(5, userBean.getGender());
			pstms.setString(6, userBean.getAnswer());
			pstms.setString(7, userBean.getQuestion());

			int record = pstms.executeUpdate();

			if (record == 1) {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("SMW in addUser()");
			e.printStackTrace();
		}
		return false;
	}

	public UserBean loginuser(String email, String password) {
		UserBean user = null;
		try (Connection con = Dbconnection.getConnection();
				PreparedStatement pstms = con
						.prepareStatement("select * from users  where email=? and password=?");) {

			pstms.setString(1, email);
			pstms.setString(2, password);
			ResultSet rs = pstms.executeQuery();
			if (rs.next()) {
				user = new UserBean();
				user.setUserid(rs.getInt("userid"));
				user.setEmail(rs.getString("email"));
				user.setFirstname(rs.getString("firstname"));
				user.setLastname(rs.getString("lastname"));
				user.setQuestion(rs.getString("question"));
				user.setAnswer(rs.getString("answer"));
				user.setGender(rs.getString("gender"));
				user.setActivate(rs.getString("active"));

			}
		} catch (SQLException e) {
			System.out.println("SMW in loginUser()");
			e.printStackTrace();
		}
		return user;
	}

	public UserBean searchemail(String email, String answer) {

		UserBean user = null;
		try (Connection con = Dbconnection.getConnection();
				PreparedStatement pstms = con.prepareStatement("select * from users  where email=? and answer=?");) {

			pstms.setString(1, email);
			pstms.setString(2, answer);
			ResultSet rs = pstms.executeQuery();
			if (rs.next()) {
				user = new UserBean();
				user.setUserid(rs.getInt("userid"));
				user.setEmail(rs.getString("email"));
			}
		} catch (SQLException e) {
			System.out.println("SMW in searchemail()");
			e.printStackTrace();
		}
		return user;
	}

	public boolean forgotpassword(String email, String password) {
		try (Connection con = Dbconnection.getConnection();
				PreparedStatement ptsmt = con.prepareStatement("update users set password=? where email=?");) {
			ptsmt.setString(1, password);
			ptsmt.setString(2, email);
			int record = ptsmt.executeUpdate();
			if(record==1) {
				return true;				
			}
		} catch (SQLException e) {
			System.out.println("smw in forgotpassword()");
			e.printStackTrace();
		}
		return false;
	}

	public boolean duplicate(String email) {
		try (Connection con = Dbconnection.getConnection();
				PreparedStatement pstms = con.prepareStatement("select * from users  where email=?");) {
			System.out.println("email" + email);
			pstms.setString(1, email);
			ResultSet rs = pstms.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("SMW in duplicate()");
			e.printStackTrace();
		}
		return false;
	}

	public int statususer(int userid) {
		try (Connection con = Dbconnection.getConnection();
				PreparedStatement ptsmt = con
						.prepareStatement("update users set active='deactivate' where userid=?");) {
			ptsmt.setInt(1, userid);
			int record = ptsmt.executeUpdate();
			return record;
		} catch (SQLException e) {
			System.out.println("smw in forgotpassword()");
			e.printStackTrace();
		}
		return 0;

	}

	public String getQuestion(String email) {
		String question = null;
		try (Connection con = Dbconnection.getConnection();
				PreparedStatement pstms = con.prepareStatement("select question from users  where email=?");) {

			pstms.setString(1, email);
			ResultSet rs = pstms.executeQuery();
			if (rs.next()) {
				 question = rs.getString("question");
			}
			return question;
		} catch (SQLException e) {
			System.out.println("SMW in searchemail()");
			e.printStackTrace();
		}
	return null;
	}
	
}
