package com.tag;

import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

/**
 * 自定义分页标签 1.从表单中获得全部查询条件参数,生成对应的<input type=hidden>以备下次提交查询条件参数及值.
 * 
 * 2.把当前页号(pageNo)设置成了请求参数,以便后台程序可以获得该值进行实时从数据数据库查询相应要显示的数据 3.使用举例: a) 后台程序:
 * //设置每页要显示的记录数，并保存到请求对象中(必须步骤) int pageSize = 20;
 * request.setAttribute("pageSize",
 * 
 * pageSize); //获取当前页号(必须步骤) String pageNo = request.getParameter("pageNo");
 * //利用这两参数进行数据查询... b) 页面首先导入标签库: <%@ taglib uri="http://www.qiujy.cn"
 * prefix="q"%> c) 页面使用标签:
 * <q:pageTag recordCount="每页显示的记录数" gotoURI="要跳转到的目的地"/>
 * 
 * @author qiujy
 * 
 */
public class PageControllerTag extends BodyTagSupport {
	/** 每页显示的记录数(标签的属性) */
	private int pageSize = 20;
	/** 目的地(标签的属性) */
	private String gotoURI;
	/** 总记录数名 */
	public static final String TOTAL = "rows";
	/** 当前页号名 */
	public static final String PAGNENO = "currentPage";
	/** 每页要显示的记录数名 */
	public static final String RECORDCOUNT = "pageSize";
	/** 目的地名 */
	public static final String GOTOURI = "gotoURI";

	// 标签处理程序
	public int doStartTag() throws JspException {
         /** 当前页号(从请求对象中得到) */
         int pageNo = 1;
         /** 总记录数(从请求对象中得到) */
         int total = 0;
         /** 总页数(计算得出) */
         int totalPage = 1;
         
         HttpServletRequest request = 
       (HttpServletRequest) pageContext
           .getRequest();
         // 要输出到页面的HTML文本
         StringBuffer sb = new StringBuffer();
         sb.append("<form method='post' action=' ' ").append(
           "name='pageController'>\r\n");
         // 获取所有提交的参数(包括查询条件参数)
         Enumeration enumeration =  request.getParameterNames();
         String name = null;
         String value = null;
         while (enumeration.hasMoreElements()) {
          name = (String) enumeration.nextElement();
          value = request.getParameter(name);
          
          if (name.equals(RECORDCOUNT)) {
           continue;
          }
          // 从请求对象中获取要跳转到的页号
          if (name.equals(PAGNENO)) {
           if (null != value && !"".equals(value)) {
            pageNo = Integer.parseInt(value);
            System.out.println("from request pageNo====>" 
       + pageNo);
           }
           continue;
          }
          sb.append("<input type='hidden' name='").append(name).append(
            "' value='").append(value).append("'/>\r\n");
         }
         
         //把当前页号设置成请求参数
         System.out.println("tag:pageNo=====>" + pageNo);
         sb.append("<input type='hidden' name='").append(PAGNENO).append(
         "' value='").append(pageNo).append("'/>\r\n");
         // 从请求对象中获取总记录数
         String tot = (String)request.getAttribute(TOTAL);
         if (null != tot && !"".equals(tot)) {
          total = Integer.parseInt(tot);
         }
         //计算总页数
         totalPage = getTotalPage(total);
         System.out.println("total-->" + total);
         sb.append("<hr width='97%'/>\r\n");
         
       sb.append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
         sb.append("总 ").append(totalPage).append(" 页,当前第 ").append(pageNo)
           .append(" 页\r\n");
         
       sb.append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
         if (pageNo == 1) {
          sb.append("首页");
          sb.append("&nbsp;");
          sb.append("上一页\r\n");
         } else {
          sb.append("<a href='#' onclick='turnOverPage(1)'>首页</a>\r\n");
          sb.append("&nbsp;");
          sb.append("<a href='#' onclick='turnOverPage(")
            .append((pageNo - 
       1)).append(")'>上一页</a>\r\n");
         }
         sb.append("&nbsp;");
         if (pageNo == totalPage) {
          sb.append("下一页");
          sb.append("&nbsp;");
          sb.append("尾页\r\n");
         } else {
          sb.append("<a href='#' onclick='turnOverPage(")
            .append((pageNo + 
       1)).append(")'>下一页</a>\r\n");
          sb.append("&nbsp;");
          sb.append("<a href='#' onclick='turnOverPage(")
           .append(totalPage).append(")'>尾页</a>\r\n");
         }
         sb.append("&nbsp;");
         sb.append("跳到<select  onChange='turnOverPage(this.value)'>\r\n");
         for(int i = 1; i <= totalPage; i++){
          if(i == pageNo){
           sb.append("  <option  value='").append(i).append("' selected>第")
           .append(i).append("页</option>\r\n");
          }else{
           sb.append("  <option  value='").append(i).append("'>第")
           .append(i).append("页</option>\r\n");
          }
         }
         sb.append("</select>\r\n");
         
       //  sb.append("<input type='text' name='").append(PAGNENO).append(
       //    "' size='3' maxlength='3'/>\r\n");
       //  sb.append("<input type='button'  value='GO'").append(
       //   "onclick='turnOverPage(pageNo.value)'/>\r\n");
         sb.append("&nbsp;\r\n");
         sb.append("</form>\r\n");
         // 生成提交表单的JS
         sb.append("<script language='javascript'>\r\n");
         sb.append("  function turnOverPage(no){\r\n");
         sb.append("    var form =  document.pageController;\r\n");
         sb.append("    //页号越界处理\r\n");
         sb.append(" if(no").append(">").append(totalPage).append("){\r\n");
         sb.append("no=").append(totalPage).append(";\r\n");
         sb.append("    }\r\n");
         sb.append("    if(no").append("<=0){\r\n");
         sb.append("        no=1;\r\n");
         sb.append("    }\r\n");
         sb.append(" form.").append(PAGNENO).append(".value=no;\r\n");
         sb.append(" form.action='").append(gotoURI).append("';\r\n");
         sb.append("    form.submit();\r\n");
         sb.append("  }\r\n");
         sb.append("</script>\r\n");
         try {
          pageContext.getOut().println(sb.toString());
         } catch (IOException e) {
          e.printStackTrace();
         }
         return super.doStartTag();
        }

	public String getGotoURI() {
		return gotoURI;
	}

	public void setGotoURI(String gotoURI) {
		this.gotoURI = gotoURI;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * 根据总记录数得到总页数
	 * 
	 * @return int 总页数
	 */
	private int getTotalPage(int total) {
		int totalPage = 1;
		if (total == 0) {
			totalPage = 1;
		} else {
			totalPage = (total % pageSize == 0) ? (total / pageSize) : (total / pageSize + 1);
		}
		return totalPage;
	}
}
