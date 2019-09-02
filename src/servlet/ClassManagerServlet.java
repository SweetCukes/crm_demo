package servlet;

import java.io.*;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import util.FileUtils;

@WebServlet(name = "/ClassManagerServlet",
urlPatterns = {"/cls/classUpload.do"})
@MultipartConfig
public class ClassManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ClassManagerServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String url = request.getRequestURL().toString();
		System.out.println(url);
		System.out.println("ContextPath:"+request.getContextPath());
		//...
		//request.getRequestDispatcher("cls/clsList.jsp");
		//response.sendRedirect("cls/clsList.jsp");
		if (url.contains("classUpload.do")) {
			classUpload1(request, response);
			//classUpload2(request, response);
			//classFileUpload(request,response);
		}
	}
	private void classFileUpload(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTf-8");
			// 获取项目的路径
			String path = getServletContext().getRealPath("/upload");
			// 第一步声明diskfileitemfactory工厂类，用于在指的磁盘上设置一个临时目录
			DiskFileItemFactory disk = new DiskFileItemFactory(1024 * 10, new File("d:/temp"));
			// 第二步：声明ServletFileUpoload，接收上面的临时目录
			ServletFileUpload up = new ServletFileUpload(disk);
			// 第三步：解析request 
			List<FileItem> list = up.parseRequest((RequestContext) request);
			// 如果就一个文件
			FileItem file = list.get(0);
			// 获取文件名,带路径
			String fileName = file.getName();
			fileName = fileName.substring(fileName.lastIndexOf("\\") + 1);
			// 获取文件的类型
			String fileType = file.getContentType();
			// 获取文件的字节码
			InputStream in = file.getInputStream();
			// 声明输出字节流
			OutputStream out = new FileOutputStream(path + "/" + fileName);
			// 文件copy
			byte[] b = new byte[1024];
			int len = 0;
			while ((len = in.read(b)) != -1) {
				out.write(b, 0, len);
			}
			out.close();

			long size = file.getInputStream().available();

			// 删除上传的临时文件
			file.delete();
			// 显示数据
			response.setContentType("text/html;charset=UTf-8");
			PrintWriter op = response.getWriter();
			op.print("文件上传成功<br/>文件名:" + fileName);
			op.print("<br/>文件类型:" + fileType);
			op.print("<br/>文件大小（bytes）" + size);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void classUpload2(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			String kbfile = request.getParameter("kbfile");
			System.out.println("kbfile="+kbfile);

			String savePathRoot = this.getServletContext().getRealPath("/upload");
			System.out.println("savePathRoot="+savePathRoot);

			Collection<Part> parts = request.getParts();
			
			for (Part part : parts) {
				/*
				 * Collection<String> headerNames = part.getHeaderNames(); 
				 * for (String name :
				 * headerNames) { System.out.println(name); }
				 */
				// 获得提交的名字
				String filename = part.getSubmittedFileName();
				System.out.println("filename="+filename);
				// 对于不是上传文件的input会传来空值，或者你没有指定上传的文件也是null，这里过滤一下
				if (filename == null) {
					continue;
				}
				String fileUUIDName = FileUtils.makeFileName(filename);
				String saveDir = FileUtils.fileSave(fileUUIDName, savePathRoot);
				/* long size = part.getSize(); */
				// File.separator是自适应的windows和linux分隔符就是\\和/
				part.write(saveDir + File.separator + fileUUIDName);
				// 删除临时文件
				part.delete();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void classUpload1(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			// 从request当中获取流信息
			InputStream fileSource = request.getInputStream();
			String tempFileName = "tempFile.txt";
			String realPath = getServletContext().getRealPath("/upload");// 为文件保存的绝对路径
			// tempFile指向临时文件
			File tempFile = new File(realPath, tempFileName);
			// outputStram文件输出流指向这个临时文件
			FileOutputStream outputStream = new FileOutputStream(tempFile);
			byte b[] = new byte[1024];
			int n;
			while ((n = fileSource.read(b)) != -1) {
				outputStream.write(b, 0, n);
			}
			// 关闭输出流、输入流
			outputStream.close();
			fileSource.close();

			request.setAttribute("result", "上传成功！");
			PrintWriter out = response.getWriter();
			out.print("<h2>上传成功！</h2>");
			//RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
			//dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
