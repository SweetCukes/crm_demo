package servlet;

import java.awt.Font;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jfree.chart.*;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.data.general.DefaultPieDataset;

import dao.JobDao;
import vo.Datas;

@WebServlet(name = "/jobservlet",urlPatterns = {"/classJobNum.do"})
public class JobServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//步骤1准备数据集
		DefaultPieDataset dataset = new DefaultPieDataset();
		JobDao jobDao = new JobDao();
		List<Datas	> jobnums = jobDao.getClassJobNum();
		if (null!=jobnums) {
			Datas datas = null;
			for (int i = 0; i < jobnums.size(); i++) {
				 datas = jobnums.get(i);
				 dataset.setValue(datas.getTitle(), datas.getNum());
			}
		//设置图表的主题
		StandardChartTheme standardChartTheme=new StandardChartTheme("CN"); //创建主题样式
		standardChartTheme.setExtraLargeFont(new Font("隶书",Font.BOLD,20)); //设置标题字体
		standardChartTheme.setRegularFont(new Font("宋体",Font.PLAIN,15)); //设置图例的字体
		standardChartTheme.setLargeFont(new Font("宋体", Font.PLAIN, 15));//设置轴向的字体
		ChartFactory.setChartTheme(standardChartTheme);
		//创建图标对象
		JFreeChart chart = ChartFactory.createPieChart(
				"每个班的就业人数", 
				dataset,
				true, 
				false, 
				false);
		//获取图表的保存路径并存储到作用域中
		HttpSession session = req.getSession();
		String fileName = ServletUtilities.saveChartAsJPEG(chart, 644, 460, session);
		//要的是完整的图片路径
		String clsurl = req.getContextPath() + "/DisplayChart?filename=" + fileName;
		System.out.println("clsurl:"+clsurl);
		req.setAttribute("clsurl", clsurl);
		req.getRequestDispatcher("/jobReport.jsp").forward(req, resp);
		}else {
			//req.getRequestDispatcher("error.jsp");
		}
	}
}
