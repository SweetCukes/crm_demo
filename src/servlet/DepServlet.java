package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.po.Department;

import dao.DepartDao;
import dao.DepartDaoImpl;
import dao.IDepartDao;

@WebServlet(name = "/DepServlet",
urlPatterns = {"/deplist.do","/depAdd.do",
		"/depEdit.do","/depUpdate.do",
		"/depDelete.do","/checkDep.do","/depPage.do"})
public class DepServlet extends HttpServlet {
	private IDepartDao dao = new DepartDaoImpl();//new DepartDao();
	private DepartDao dao2 = new DepartDao();
	private static final long serialVersionUID = 1L;
    public DepServlet() {
        super();
    }
    
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		
    	request.setCharacterEncoding("utf-8");
		String url = request.getRequestURL().toString();
		System.out.println("url="+url);
		
		if (url.contains("checkDep.do")) {
			//验证是否有部门名
			checkDep(request,response);
		}
		
		if (url.contains("deplist.do")) {
			query(request, response);
			return;
		}
		
		
		if (url.contains("depAdd.do")) {
			System.out.println("depAdd.do");
			addDepartment(request,response);
			return;
		}
		
		if (url.contains("depUpdate.do")) {
			System.out.println("depUpdate");
			updateDepartment(request,response);
			return;
		}
		
		if (url.contains("depEdit.do")) {
			System.out.println("depEdit");
			editDepartment(request,response);
			return;
		}
		
		if (url.contains("depPage.do")) {
			depPage(request,response);
		}
		
		if (url.contains("depDelete.do")) {
			System.out.println("depDelete");
			String id = request.getParameter("id");
			try {
				int num = dao.delDepartById(id);
				//nuM>=1，跳转到错误页
				if (num >=1) {
					query(request, response);
				}else {
					request.getRequestDispatcher("/error.jsp").forward(request, response);
				}
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
			
		}
/*
 *  分页
 */
		private void depPage(HttpServletRequest request, HttpServletResponse response) {
			int currentPage = 1;//当前页码
			int pageSize = 3;//每页总显示条数
			String pint=request.getParameter("pageIndex");
			if (null == pint) {
				currentPage = 1;
			}else {
				currentPage = Integer.parseInt(pint);
			}
			int rows = dao2.getDepCount();
			if (currentPage<=0) {
				currentPage = 1;
			}
			int pageCount = rows/pageSize +(rows%pageSize==0?0:1);
			if (currentPage>=pageCount) {
				currentPage = pageCount;
			}
			request.setAttribute("rows", rows);
			request.setAttribute("currentPage", currentPage); 
			request.setAttribute("pageCount", pageCount);//前端EL表达式取值用
			//查询分页数据
			//select count(1) from crm_department LIMIT 5,5
			int start = (currentPage-1)*pageSize;//算出起始行
			List<Department> depList = dao2.queryPageDep(start,pageSize);
			//将数据存储在作用域中
			request.setAttribute("depList", depList);
			try {
				request.getRequestDispatcher("depList.jsp").forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
			//跳转到前端显示
		}

		private void checkDep(HttpServletRequest request, HttpServletResponse response) {
			String depName = request.getParameter("depName");
			try {
				boolean flag = dao.checkDepName(depName);
				PrintWriter out = response.getWriter();
				out.print(flag);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		private void updateDepartment(HttpServletRequest request, HttpServletResponse response) {
			String depId = request.getParameter("depId");
			String depName = request.getParameter("depName");
			try {
				int num = dao.updateDepart(depId,depName);
				if (num >= 1) {
					query(request, response);
				}else {
					request.getRequestDispatcher("/error.jsp").forward(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		private void editDepartment(HttpServletRequest request, HttpServletResponse response) {
			String id = request.getParameter("id");
			try {
				Department dep = dao.getDepartmentById(id);
				//dep为空时，跳转到错误页
				request.setAttribute("dep", dep);
				request.getRequestDispatcher("depEdit.jsp").forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		private void query(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			List<Department> depList = dao.getDepAll();
		request.setAttribute("depList", depList);
		request.getRequestDispatcher("depList.jsp").
		forward(request, response);
		}
		
	/*
	 * 部门添加
	 */
	private void addDepartment(HttpServletRequest request, HttpServletResponse response) {
		String depName = request.getParameter("depName");
		try {
			int num = dao.addDepart(depName);
			if (num >= 1) {
				//query(request, response);
				//forward(request,response);携带请求数据的跳转
				response.sendRedirect("/deplist.do"); //重定向
//				游览器的行为，可以使服务期之外的任意url地址。
			}else {
				request.getRequestDispatcher("/error.jsp").
				forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
