package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import com.po.Department;
import com.po.Post;

import dao.DepartDao;
import dao.IDepartDao;
import dao.StaffDao;
import vo.StaffVo;

@WebServlet(name = "/StaffServlet",
urlPatterns = {"/staffList.do","/queryStaffList.do",
		"/staffPage.do","/showPost.do","/userLogin.do"})
public class StaffServlet extends HttpServlet {
	private StaffDao staffDao = new StaffDao();
	private IDepartDao departDao = new DepartDao(); 
	private static final long serialVersionUID = 1L;
    public StaffServlet() {
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getRequestURL().toString()	;
		request.setCharacterEncoding("utf-8");
		//showPost.do
		if (url.contains("userLogin.do")) {
			userLogin(request,response);
			return;
		}
		if (url.contains("showPost.do")) {
			showList(request,response);
			return;
		}
		if (url.contains("staffList.do")) {
			query(request,response);
			return;
		}
		
		if (url.contains("queryStaffList.do")) {
			queryList(request,response);
			return;
		}
		
		if (url.contains("staffPage.do")) {
			staffPage(request,response);
			return;
		}
	}
	private void userLogin(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			String userName = request.getParameter("userName");
			String userPwd = request.getParameter("userPwd");
			String autologin = request.getParameter("autologin");
			//调用dao的登录方法返回登录成功与否
			boolean isOk = staffDao.login(userName,userPwd);
			if (isOk) {
				//存储用户凭证 将用户信息存储到cookie和session
				HttpSession session = request.getSession();
				session.setAttribute("USER_LOGIN", userName);
				Cookie cookie =  new Cookie("loginUser", userName+"-"+userPwd);
				cookie.setMaxAge(Integer.parseInt(autologin));//存储时间
				cookie.setPath("/");
				response.addCookie(cookie);
				response.sendRedirect("/crm/index.jsp");
				return;
			}else {
				request.setAttribute("errerMsg", "用户名或密码错误，请重新登陆");
				request.getRequestDispatcher("/login.jsp")
				.forward(request,response);
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void showList(HttpServletRequest request, HttpServletResponse response) {
		try {
			String depid = request.getParameter("depId");
			//在职务表通过部门ID查询职务信息
			List<Post> posts = staffDao.getPostByDepId(depid);
			System.out.println(posts);
			//将POST集合转换成json格式的字符串
			String jsonString = JSON.toJSONString(posts);
			System.out.println(jsonString);
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			out.print(jsonString);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void staffPage(HttpServletRequest request, HttpServletResponse response) {
		int currentPage = 1; //当前页码
		int pageSize = 5;	//每页显示条目数
		String pint = request.getParameter("pageIndex");
		if (null == pint) {
			currentPage = 1;
		}else {
			currentPage = Integer.parseInt(pint);
		}
		//取得数据总行数
		int rows = staffDao.getStaffCount();
		//计算页码
		if(currentPage <=1) {
			currentPage = 1;
		}
		int pageCount = rows/pageSize + (rows%pageSize==0?0:1);
		if (currentPage>=pageCount) {
			currentPage = pageCount;
			}
		request.setAttribute("rows", rows+"");
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("pageCount", pageCount	);//给前端EL表达式取值用的
		//查询分页数据
		int start = (currentPage-1)*pageSize; //算出原始航 
		List<StaffVo> StaffList  =  staffDao.queryPageStaff(start,pageSize);
		//数据存储在作用域中
		request.setAttribute("StaffList", StaffList);
		//跳转到前端显示
		try {
			HttpSession session = request.getSession();
			List<Department> depAll = departDao.getDepAll();
			session.setAttribute("depList", depAll);
			request.getRequestDispatcher("staffList.jsp").forward(request, response);
		}catch (ServletException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	private void queryList(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();	
		//接收参数
		String depId = request.getParameter("dep");
		String postId = request.getParameter("post");
		String sename = request.getParameter("sename");
		//控制器层不要出现sql语句
		try {
			List<Department> depAll = departDao.getDepAll();
			session.setAttribute("depList", depAll);
			List<StaffVo> list = staffDao.queryStaff(depId,postId,sename);
			session.setAttribute("StaffList", list); 
			response.sendRedirect("staffList.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private void query(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();	
		try {
				List<Department> depAll = departDao.getDepAll();
				session.setAttribute("depList", depAll);
				List<StaffVo> list = staffDao.queryListAll();
				session.setAttribute("StaffList", list); //request,sessions
				response.sendRedirect("staffList.jsp");
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
