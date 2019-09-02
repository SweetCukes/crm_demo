package dao;

import java.util.List;

import com.po.Department;

public interface IDepartDao {

	List<Department> getDepAll();

	int addDepart(String depName);

	int updateDepart(String depId, String depName);

	Department getDepartmentById(String id);

	int delDepartById(String id);

	boolean checkDepName(String depName);

}