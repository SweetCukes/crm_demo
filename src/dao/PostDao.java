package dao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.po.Post;

import util.DBCPUtils;

public class PostDao {
	public List<Post> getAll(String querySql){
		try {
			DataSource ds = DBCPUtils.getDataSource();
		QueryRunner runner = new QueryRunner(ds);
		runner.query(querySql, new BeanListHandler<>(Post.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Post> getPostData(){
		String sql = "SELECT p.postID,p.postName,dep.depName FROM crm_post p,crm_department dep where p.depID = dep.id";
		return this.getAll(sql);
	}
	
	public static void main(String[] args) {
		List<Post> postData = new PostDao().getPostData();
		System.out.println(postData);
	}
}
