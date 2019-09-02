package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.po.Student;

import util.JDBCUtil;

public class StuDao {
	public List<Student> getStuAll(){
		List<Student> stus = null;
		String sql = "SELECT id,stuName,stuCode,stuSex FROM crm_student";
		ResultSet rs = JDBCUtil.getQueryData(sql);
		try {
			if (rs!=null) {
				stus = new ArrayList<>();
				while (rs.next()) {
					Student stu = new Student();
					stu.setId(rs.getInt("id"));
					stu.setStuName(rs.getString("stuName"));
					stu.setStuCode(rs.getString("stuCode"));
					stu.setStuSex(rs.getString("stuSex"));
					stus.add(stu);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		JDBCUtil.free(rs, null, null);
		return stus;
	}
}
