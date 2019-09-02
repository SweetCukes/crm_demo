package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.po.Post;
import com.po.Staff;
import util.DBCPUtils;
import vo.StaffVo;

public class StaffDao {
	
	private DataSource ds = DBCPUtils.getDataSource();
	private QueryRunner run = new QueryRunner(ds);
	
	public List<StaffVo> queryListAll(){
		List<StaffVo> staffVos = new ArrayList<>(20);
		String sql = "SELECT s.staffID,s.staffName,s.gender,s.onDutyDate,p.postName,d.depName FROM " +
				 "crm_staff s,crm_post p,crm_department d "	 + 
				 " WHERE s.postID = p.postID and d.id = p.depID";
		try {
			return run.query(sql,new BeanListHandler<>(StaffVo.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<Staff> getStafAll(String sql){
		List<Staff> staffs = new ArrayList<>(20);
		try {
			return run.query(sql,new BeanListHandler<>(Staff.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return staffs;
	}
	public List<StaffVo> queryStaff(String depId, String postId, String sename) {
		String sql = "SELECT s.staffID,s.staffName,s.gender,s.onDutyDate,p.postName,d.depName FROM " +
				 "crm_staff s,crm_post p,crm_department d "	 + 
				 " WHERE s.postID = p.postID and d.id = p.depID";
		if (depId!=null && !depId.equals("-1")) {
			sql += " and d.id ="+depId;
		}
		if (depId!=null && !postId.equals("-1")) {
			sql += " and p.postID ="+postId;
		}
		if (sename!=null && !sename.equals("")) {
			sql += " and s.staffName like '%"+sename+"%' ";
		}
		try {
			return run.query(sql,new BeanListHandler<>(StaffVo.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public int getStaffCount() {
		int count = 0;
		String sql = "SELECT count(1) from crm_staff";
		try {
			Object obj = run.query(sql, new ScalarHandler());
			if (null!=obj) { //防御性编程
				count = Integer.parseInt(obj.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
/*
 *	分页查询方法 
 *
 */
	public List<StaffVo> queryPageStaff(int start, int pageSize) {
		String sql  = "SELECT s.staffID,s.staffName,s.gender,s.onDutyDate,p.postName,d.depName FROM " +
				 "crm_staff s,crm_post p,crm_department d "	 + 
				 " WHERE s.postID = p.postID and d.id = p.depID limit "+start+","+pageSize;
		try {
			return run.query(sql,new BeanListHandler<>(StaffVo.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<Post> getPostByDepId(String depid) {
		String sql = "SELECT postID,postName FROM crm_post WHERE depID="+depid;
		try {
			return run.query(sql,new BeanListHandler<>(Post.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public boolean login(String userName, String userPwd) {
		//常规逻辑
		String sql = "SELECT * FROM crm_staff WHERE loginName=? and loginPwd=?";
		try {
			List<Staff> sList = run.query(sql,new BeanListHandler<>(Staff.class),userName,userPwd);
			if (sList!=null && sList.size()>=1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//推荐的逻辑 
		//只用登录名查询并且只查询单个bean
		//然后用查询到的bean对象对比传递进来的密码
		return false; 
	}
}
