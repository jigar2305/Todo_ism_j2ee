package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import bean.TaskBean;
import util.Dbconnection;
import java.sql.Date;

public class TaskDao {
	public Boolean addtask(TaskBean taskBean, int userid) {
		try (Connection con = Dbconnection.getConnection();
				PreparedStatement pstms = con.prepareStatement(
						"insert into task (name,description,f_date,priority ,userid) values (?,?,?,?,?)");) {

			pstms.setString(1, taskBean.getName());
			pstms.setString(2, taskBean.getDescription());
			pstms.setString(3, taskBean.getF_date());
			pstms.setString(4, taskBean.getPriority());
			pstms.setInt(5, userid);
			
			int record = pstms.executeUpdate();
			System.out.println(record + "task inserted");
			return true;

		} catch (SQLException e) {
			System.out.println("smw in addtask()");
			e.printStackTrace();
		}

		return false;
	}

	public ArrayList<TaskBean> listtask(int userid) {

		ArrayList<TaskBean> tasks = new ArrayList<>();

		try (Connection con = Dbconnection.getConnection();
				PreparedStatement ptsmt = con.prepareStatement("select * from task where userid=?");) {
			ptsmt.setInt(1, userid);
			ResultSet rs = ptsmt.executeQuery();
			while (rs.next()) {
				String name = rs.getString("name");
				String description = rs.getString("description");
				String fdate = rs.getString("f_date");
				String priority = rs.getString("priority");
				String status = rs.getString("status");
				String cdate = rs.getString("t_date");
				String ctime = rs.getString("t_time");
				int taskid = rs.getInt("taskid");
				

				TaskBean task = new TaskBean();
				task.setName(name);
				task.setDescription(description);
				task.setPriority(priority);
				task.setStatus(status);
				task.setF_date(fdate);
				task.setTaskid(taskid);
				task.setT_date(cdate);
				task.setT_time(ctime);
				tasks.add(task);

			}

		} catch (SQLException e) {
			System.out.println("smw in listtodo");
			e.printStackTrace();
		}

		return tasks;
	}

	public Boolean delete(int taskid) {
		try (Connection con = Dbconnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement("delete from task where taskid=?");) {
			pstmt.setInt(1, taskid);
			int record = pstmt.executeUpdate();
			if(record==1) {
				return true;				
			}
		} catch (SQLException e) {
			System.out.println("smw in delete()");
			e.printStackTrace();
		}
		return true;
	}

	public Boolean updatestatus(int taskid, String s) {

		System.out.println(s+"           "+taskid);
		try (Connection con = Dbconnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement("update task set status=? where taskid=?");) {
			pstmt.setString(1, s);
			pstmt.setInt(2, taskid);
			int record = pstmt.executeUpdate();
			if(record==1) {
				return true;				
			}
		} catch (SQLException e) {
			System.out.println("smw in update status");
			e.printStackTrace();
		}
		return false;

	}
	public Boolean updatepriority(int taskid, String p) {

		try (Connection con = Dbconnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement("update task set priority=? where taskid=?");) {
			pstmt.setString(1, p);
			pstmt.setInt(2, taskid);
			int record = pstmt.executeUpdate();
			if(record==1) {
				return true;				
			}
		} catch (SQLException e) {
			System.out.println("smw in update priority");
			e.printStackTrace();
		}
		return false;

	}

	public int persentage(int userid) {
		ArrayList<TaskBean> tasks = listtask(userid);
		try {
			
		int done = 0;
		int total = tasks.size();
		for(TaskBean task:tasks) {
			if(task.getStatus().equals("done")) {
				done+=1;
			}
		}
		int persentage = (done*100)/total;
		return persentage;
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}
}
