package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.po.Department;

import util.DBCPUtils;
import util.JDBCUtil;

public class DepartDao implements IDepartDao {

	private DataSource ds = DBCPUtils.getDataSource();
	private QueryRunner run = new QueryRunner(ds);
	@Override
	public List<Department> getDepAll(){
		String sql  = "SELECT id,depName,isCancel FROM crm_department";
		 	return query( sql);
	}

	private List<Department> query(String sql) {

		List<Department> deps = null;
		ResultSet rs = JDBCUtil.getQueryData(sql);
		//对象实现类的包名，类名。
		System.out.println(rs);
		try {
			if (rs!=null) {
				//deps = new ArrayList<>(); //查询速度快 添加删除慢
				//deps = new Vector<>();  //线程安全类
				deps = new LinkedList<>(); //添加删除慢
				while (rs.next()) {
					Department dep = new Department();
					dep.setId(rs.getInt("id"));
					dep.setDepName(rs.getString("depName"));
					dep.setIsCancel(rs.getInt("isCancel"));
					deps.add(dep);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		JDBCUtil.free(rs,null,null);
		return deps;
	}

	/**
 * @author ashikotakeshi
 **/
	@Override
	public int addDepart(String depName) {
		String sql = "insert into crm_department(depName)values(' "+depName+" ') ";
		return JDBCUtil.executeUpdate(sql);
	}

	@Override
	public int updateDepart(String depId, String depName) {
		String sql = "update crm_department set depName =' "+depName+" ' where id="+depId;
		return JDBCUtil.executeUpdate(sql);
	}

	@Override
	public Department getDepartmentById(String id) {
		String sql = "SELECT id,depName,isCancel FROM crm_department where id ="+id;
		List<Department> query = this.query(sql);
		if (query.size()>=1) {
			return query.get(0);
		}
		return null;
	}

	@Override
	public int delDepartById(String id) {
		String sql = "delete from crm_department where id="+id;;
		return JDBCUtil.executeUpdate(sql);
	}


	@Override
	public boolean checkDepName(String depName) {
		String sql = "SELECT id,depName,isCancel FROM "
				+ "crm_department where depName=' "+depName+"'";
		return (Boolean) null;
	}

	public int getDepCount() {
		int count = 0;
		String sql = "select count(1) from crm_department";
		try {
			Object obj = run.query(sql, new ScalarHandler());
			if (null!=obj) {
				count = Integer.parseInt(obj.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
 /*
  * 分页查询方法
  */
	public List<Department> queryPageDep(int start, int pageSize) {
		String sql = "SELECT id,depName,"
				+ "isCancel FROM crm_department limit "+start+","+pageSize;
		try {
			return run.query(sql, new BeanListHandler<>(Department.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	
	
}
