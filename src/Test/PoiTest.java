package Test;

import java.io.FileOutputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.*;
import org.junit.Test;
import util.MyConnection;

public class PoiTest {
	
	@Test
	public void createXls() throws Exception{
		//声明一个工作薄
		HSSFWorkbook wb = new HSSFWorkbook();
	   //声明表
		HSSFSheet sheet = wb.createSheet("第一个表");
		//声明行
		HSSFRow row = sheet.createRow(7);
		//声明列
		HSSFCell cel = row.createCell(3);
		//写入数据
		cel.setCellValue("你也好");
		
		FileOutputStream fileOut = new FileOutputStream
				("/Users/ashikotakeshi/Desktop/t1.xls");
	    wb.write(fileOut);
	    fileOut.close();
	}
	
	@Test
		public void export() throws Exception{
			//声明需要导出的数据库
			String dbName = "crm";
			//声明book
			HSSFWorkbook book = new HSSFWorkbook();
			//获取Connection,获取db的元数据
			Connection con = MyConnection.getConnection();
			//声明statemen
			Statement st = con.createStatement();
			//st.execute("use "+dbName);
			DatabaseMetaData dmd = con.getMetaData();
			//获取数据库有多少表
			ResultSet rs = dmd.getTables(dbName,dbName,null,new String[]{"TABLE"});
			//获取所有表名　－　就是一个sheet
			List<String> tables = new ArrayList<String>();
			while(rs.next()){
				String tableName = rs.getString("TABLE_NAME");
				tables.add(tableName);
			}
			for(String tableName:tables){
				HSSFSheet sheet = book.createSheet(tableName);
				//声明sql
				String sql = "select * from "+dbName+"."+tableName;
				//查询数据
				rs = st.executeQuery(sql);
				//根据查询的结果，分析结果集的元数据
				ResultSetMetaData rsmd = rs.getMetaData();
				//获取这个查询有多少行
				int cols = rsmd.getColumnCount();
				//获取所有列名
				//创建第一行
				HSSFRow row = sheet.createRow(0);
				for(int i=0;i<cols;i++){
					String colName = rsmd.getColumnName(i+1);
					//创建一个新的列
					HSSFCell cell = row.createCell(i);
					//写入列名
					cell.setCellValue(colName);
				}
				//遍历数据
				int index = 1;
				while(rs.next()){
					row = sheet.createRow(index++);
					//声明列
					for(int i=0;i<cols;i++){
						String val = rs.getString(i+1);
						//声明列
						HSSFCell cel = row.createCell(i);
						//放数据
						cel.setCellValue(val);
					}
				}
			}
			con.close();
			book.write(new FileOutputStream("/Users/ashikotakeshi/Desktop/"+dbName+".xls"));
		}

	}
