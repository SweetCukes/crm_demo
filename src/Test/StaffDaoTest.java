package Test;

import java.util.List;

import org.junit.Test;

import com.po.Staff;

import dao.StaffDao;
import vo.StaffVo;

public class StaffDaoTest {
	
	@Test
	public void test1() {
		StaffDao staffDao = new StaffDao()	;
		List<StaffVo> querListAll = staffDao.queryListAll();
		System.out.println(querListAll);
	}
}
