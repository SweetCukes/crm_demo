package Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.Test;

import com.po.Post;

import util.DBCPUtils;

public class DBUtilsTest {
	
	//@Test //将该注解相关的方法代码拷贝到main方法中执行。
	public void inserTest() {
		DataSource ds = DBCPUtils.getDataSource();
		QueryRunner runner = new QueryRunner(ds);
		String sql = "insert into crm_post(postName,depid)values('测试部',1005)";
		try {
			int update = runner.update(sql); //生产返回值相关代码
			System.out.println(update);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//@Test
	public void query1Test() {
		DataSource ds = DBCPUtils.getDataSource();
		QueryRunner runner = new QueryRunner(ds);
		String sql = "select * from crm_post";
		//ResultSetHandler<T>
		try {
			 List<Object[]> list =  runner.query(sql, new ArrayListHandler()	);
			for (Object[] object : list) {
				for (Object obj : object) {
					System.out.println(obj);
				}
				
				System.out.println("-------");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//@Test
	public void query3() {
		DataSource ds = DBCPUtils.getDataSource();
		QueryRunner runner = new QueryRunner(ds);
		try {
			String sql = "select * from crm_post";
			Post query = runner.query(sql, new BeanHandler<>(Post.class));
			System.out.println(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void query4() {
		DataSource ds = DBCPUtils.getDataSource();
		QueryRunner runner = new QueryRunner(ds);
		try {
			String sql = "select * from crm_post";
			List<Post> query = (List<Post>) runner.query(sql, new BeanHandler<>(Post.class) );
			System.out.println(query); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
