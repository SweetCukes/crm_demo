package servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import dao.StudentDao;
import util.FileUtils;

@WebServlet(name = "/StudentServlet",urlPatterns = "/stuUpload.do")
public class StudentServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		if (uri.contains("stuUpload.do")) {
			stuUpload(request,response);
			return;
		}
	}

	private void stuUpload(HttpServletRequest request, HttpServletResponse response) {
		//把大问题拆解成一系列小问题
		// 接收上传的excel文件
		String message = "";
		try {
			String uploadpath = excelUpload(request); //将独立功能的代码提取为方法
			//读取excel中的内容--》集合
			
			if (uploadpath!=null) {
				StudentDao stuDao = new StudentDao();
			    int num =stuDao.batchSave(uploadpath);
			    System.out.println("批量添加数据"+num+"条");
			    message = "批量添加数据"+num+"条";
			    System.out.println("end");//将集合数据保存在数据库中
			}
			request.setAttribute("message", message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * Excel文件上传
	 * 
	 */
	private String excelUpload(HttpServletRequest request) {
		String filePath = "";
		try {
			  String savePath = this.getServletContext().getRealPath("/upload");
		        //上传时生成的临时文件保存目录
		        String tempPath = this.getServletContext().getRealPath("/temp");
		        File tmpFile = new File(tempPath);
		        if (!tmpFile.exists()) {
		            //创建临时目录
		            tmpFile.mkdir();
		        }
		      //1、创建一个DiskFileItemFactory工厂
		        DiskFileItemFactory factory = new DiskFileItemFactory();
		        //设置工厂的缓冲区的大小，当上传的文件大小超过缓冲区的大小时，就会生成一个临时文件存放到指定的临时目录当中。
		        factory.setSizeThreshold(1024*100);//设置缓冲区的大小为100KB，如果不指定，那么缓冲区的大小默认是10KB
		        //设置上传时生成的临时文件的保存目录
		        factory.setRepository(tmpFile);
		        //2、创建一个文件上传解析器
		        ServletFileUpload upload = new ServletFileUpload(factory);
		        //解决上传文件名的中文乱码
		        upload.setHeaderEncoding("UTF-8"); 
		        //3、判断提交上来的数据是否是上传表单的数据
		        if(!ServletFileUpload.isMultipartContent(request)){
		            //按照传统方式获取数据
		            return null;
		        }
		        
		        //设置上传单个文件的大小的最大值，目前是设置为1024*1024字节，也就是1MB
		        upload.setFileSizeMax(1024*1024);
		        //设置上传文件总量的最大值，最大值=同时上传的多个文件的大小的最大值的和，目前设置为10MB
		        upload.setSizeMax(1024*1024*10);
		         
		        //4、使用ServletFileUpload解析器解析上传数据，解析结果返回的是一个List<FileItem>集合，每一个FileItem对应一个Form表单的输入项
		        List<FileItem> list = upload.parseRequest(request);
		        if (null==list && list.size()==0) {
					return null;
				}
		        //只上传一个文件
		        FileItem item = list.get(0);
		        //得到上传的文件名称，
		        String filename = item.getName();
		        
		        System.out.println(filename+"..");
		        if(filename==null || filename.trim().equals("")){
		            return null;
		        }
		        filename = filename.substring(filename.lastIndexOf("\\")+1);
		        //得到上传文件的扩展名
		        String fileExtName = filename.substring(filename.lastIndexOf(".")+1);
		        //如果需要限制上传的文件类型，那么可以通过文件的扩展名来判断上传的文件类型是否合法
		        System.out.println("上传的文件的扩展名是："+fileExtName);
		        //获取item中的上传文件的输入流
		        InputStream in = item.getInputStream();
		        long filesize = in.available();
		        		
		        //得到文件保存的名称
		        String saveFilename = FileUtils.makeFileName(filename);
		        //得到文件的保存目录
		        String realSavePath = FileUtils.fileSave(saveFilename, savePath);
		        filePath  =realSavePath + "\\" + saveFilename;
		        //创建一个文件输出流
		        FileOutputStream out = new FileOutputStream(filePath);
		        //创建一个缓冲区
		        byte buffer[] = new byte[1024];
		        //判断输入流中的数据是否已经读完的标识
		        int len = 0;
		        StringBuffer sb = new StringBuffer();
		        //循环将输入流读入到缓冲区当中，(len=in.read(buffer))>0就表示in里面还有数据
		        while((len=in.read(buffer))>0){
		            //使用FileOutputStream输出流将缓冲区的数据写入到指定的目录(savePath + "\\" + filename)当中
		            sb.append(new String(buffer,0,len));
		        	out.write(buffer, 0, len);
		        }
		        //  System.out.println(sb.toString()+"-----");
		        //关闭输入流
		        in.close();
		        //关闭输出流
		        out.close();
		        //删除处理文件上传时生成的临时文件
		        item.delete();
		} catch (Exception e) {
			// TODO: handle exception
			
		}
		return filePath;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
