package dao;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.poi.hssf.usermodel.*;
import com.po.Student;

import util.DBCPUtils;

public class StudentDao {
	private DataSource ds = DBCPUtils.getDataSource();
	private QueryRunner run = new QueryRunner(ds);
	/*
	 * 根据上传的excel文件路径，
	 * 读取excel内容
	 * 并且批量保存excel数据
	 */
	public int batchSave(String uploadpath) {
		int num = 0;
		try {
			// 读取excel内容===》集合
			List<Student> students = readXls(uploadpath);
			/*for (int i = 0; i < students.size(); i++) {
				num+=run.update(sql,param);
			}*/ 
			if (null!=students && students.size()!=0) {
				//批处理执行
			Object[][] params = new Object[students.size()][];
			String sql = "INSERT INTO crm_student(stuName,stuCode,stuSex,"
					+"referid,classid,beginTime,jobTime,stuState,checkLevel,"
					+"remark) VALUES(?,?,?,?,?,?,?,?,?,?);";
			Student stuTemp = null;
			for (int i = 0; i < students.size(); i++) {
				 stuTemp = students.get(i);
				 params[i] = new Object[]{stuTemp.getStuName(),stuTemp.getStuCode(),
						 stuTemp.getStuSex(),stuTemp.getReferid(),stuTemp.getClassid(),
						 stuTemp.getBeginTime(),stuTemp.getJobTime(),stuTemp.getStuState(),
						 stuTemp.getCheckLevel(),stuTemp.getRemark()
				 };
			}
			int[] batch = run.batch(sql, params);
			for (int i = 0; null!=batch && i < batch.length; i++) {
				num +=batch[i];
			}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}
	public static void main(String[] args) {
		String uploadpath="/Users/ashikotakeshi/Downloads/crm_student.xls";
		int num = new StudentDao().batchSave(uploadpath);
		System.out.println("批量添加"+num+"数据");
	}
	
	private List<Student> readXls(String uploadpath) {
		List<Student> list = null;
		try {
			InputStream is = new FileInputStream(uploadpath);
			HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
			Student student = null;
			list = new ArrayList<Student>();
			// 循环工作表Sheet
			for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
			    HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
			    if (hssfSheet == null) {
			        continue;
			    }
			    // 循环行Row
			    for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
			        HSSFRow hssfRow = hssfSheet.getRow(rowNum);
			        
			        if (hssfRow != null) {
			            student = new Student();
			            HSSFCell id = hssfRow.getCell(0);
			            HSSFCell name = hssfRow.getCell(1);
			            HSSFCell code = hssfRow.getCell(2);
			            HSSFCell sex = hssfRow.getCell(3);
			            HSSFCell rid = hssfRow.getCell(4);
			            HSSFCell cid = hssfRow.getCell(5);
			            HSSFCell bt = hssfRow.getCell(6);
			            HSSFCell jt = hssfRow.getCell(7);
			            HSSFCell ss = hssfRow.getCell(8);
			            HSSFCell cl = hssfRow.getCell(9);
			            HSSFCell rm = hssfRow.getCell(10);
			            //student.setId(getValue(id));
			            student.setStuName(getValue(name));
			            student.setStuCode(getValue(code));
			            student.setStuSex(getValue(sex));
			            //外键的处理 TODO
			            if(rid!=null && !"".equals(rid)) {
			            	student.setReferid(Integer.parseInt(getValue(rid)));
			            }
			            if(cid!=null && !"".equals(cid)) {
			                student.setClassid(Integer.parseInt(getValue(cid)));
			            }
			            student.setBeginTime(getValue(bt));
			            student.setJobTime(getValue(jt));
			            student.setStuState(getValue(ss));
			            student.setCheckLevel(getValue(cl));
			            student.setRemark(getValue(rm));
			            list.add(student);
			        }
			    }
			}
		} catch (NumberFormatException e) { 
			e.printStackTrace();
		} catch (FileNotFoundException e) { 
			e.printStackTrace();
		} catch (IOException e) { 
			e.printStackTrace();
		}
        return list;
    }
    
     @SuppressWarnings("static-access")
     private String getValue(HSSFCell hssfCell) {
    	 if(null!=hssfCell) {
	        if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
	            // 返回布尔类型的值
	            return String.valueOf(hssfCell.getBooleanCellValue());
	        } else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
	            // 返回数值类型的值
	            return String.valueOf(hssfCell.getNumericCellValue());
	        } else {
	            // 返回字符串类型的值
	            return String.valueOf(hssfCell.getStringCellValue());
	        }
    	 }else {
    		 return "";
    	 }
     }
}
