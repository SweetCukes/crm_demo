package dao;

import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import util.DBCPUtils;
import vo.Datas;

/*
 * 
 * 就业持久层
 *
 */
public class JobDao {
	private DataSource ds = DBCPUtils.getDataSource();
	private QueryRunner run = new QueryRunner(ds);
	
	/**
	 * 获取到没一个班级的就业总人数集合
	 * @return
	 */
	public List<Datas> getClassJobNum(){
		List<Datas> cvs = null;
		String sql="SELECT c.className as title,count(j.id) as num "
				+ " from crm_job j,crm_class c where j.classid = c.ID " + 
				" and j.jobState='已就业' " + 
				" GROUP BY c.className";
		try {
			cvs = run.query(sql, new BeanListHandler<>(Datas.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cvs;
	}
}
