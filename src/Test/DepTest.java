package Test;

import java.util.List;

import org.junit.Test;

import com.po.Department;

import dao.DepartDao;
import dao.IDepartDao;

public class DepTest {
	
	@Test
	public void queryTest() {
		IDepartDao dao = new DepartDao();
		List<Department> depAll = dao.getDepAll();
		System.out.println(depAll);
	}
}
