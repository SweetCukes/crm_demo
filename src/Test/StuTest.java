package Test;

import java.util.List;

import org.junit.Test;

import com.po.Student;

import dao.StuDao;

public class StuTest {
	
	@Test
	public void queryTest() {
		StuDao stu = new StuDao();
		List<Student> stus = stu.getStuAll();
		System.out.println(stus);
	}
}
