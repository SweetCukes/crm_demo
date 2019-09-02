package com.handle;
interface ResultSetHandle {
	public Object handle();
}
class BeanListHandle implements ResultSetHandle{
	@Override
	public Object handle() {
		System.out.println("BeanListHandle");
		return null;
	}
}
public class QueryRunner {//query（接口【父类型】）
	//BeanListHandle ---> ResultSetHandle
	//$0 --rsh 发生了类型的多态性【向上转型 | 向上造型 | 向上树形】
	public void query(String sql,ResultSetHandle rsh) {
		rsh.handle(); //动态链接
	}
	public static void main(String[] args) {
		QueryRunner runner = new QueryRunner();
		runner.query("select * from crm_department"
				, new BeanListHandle());//里氏替换原则
	}
}
