package dao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.po.Department;

import util.DBCPUtils;

public class DepartDaoImpl implements IDepartDao {
	private DataSource ds = DBCPUtils.getDataSource();
	private QueryRunner run = new QueryRunner(ds);

	@Override
	public List<Department> getDepAll() {
		String sql  = "SELECT id,depName,isCancel FROM "
				+ "crm_department where isCancel=0";
		return query(sql);
		
	}

	private List<Department> query(String sql) {
		try {  //ResultSetHandler
			//public Object handle(ResultSet arg0) ;
			return run.query(sql, new BeanListHandler<>(Department.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int addDepart(String depName) {
		String sql = "insert into crm_department(depName)values(' "+depName+" ') ";
		return execute(sql);
	}

	@Override
	public int updateDepart(String depId, String depName) {
		String sql = "update crm_department set depName =' "+depName+" ' where id="+depId;
		return execute(sql);
	}

	private int execute(String sql) {
		try {
			return run.update(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Department getDepartmentById(String id) {
		String sql = "SELECT id,depName,isCancel FROM "
				+ "crm_department where isCancel=0 and id ="+id;
		List<Department> query = this.query(sql);
		if (query.size()>=1) {
			return query.get(0);
		}
		return null;
	}

	@Override
	public int delDepartById(String id) {
		String sql = "update crm_department set isCancel = -1 where id = "+id;
		return execute(sql);
	}

	@Override
	public boolean checkDepName(String depName) {
		String sql  = "SELECT id,depName,isCancel FROM "
				+ "crm_department where depName='"  +depName+"'";
		List<Department> deps = query(sql);
		System.out.println(sql);
		if (null != deps && deps.size()>=1) {
		
			return true;
		}
		return false;
		
	}

	


}
