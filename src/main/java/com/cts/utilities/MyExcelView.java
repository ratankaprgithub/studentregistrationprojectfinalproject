package com.cts.utilities;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.cts.model.CourseBean;;

@Component
public class MyExcelView extends AbstractXlsView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		
		List<CourseBean> courses=(List<CourseBean>)model.get("courses");
		
		Sheet sheet= workbook.createSheet("Enrolled Courses");
		
		Row hrow= sheet.createRow(1);
		
		hrow.createCell(0).setCellValue("CourseID");
		hrow.createCell(1).setCellValue("CourseName");
		hrow.createCell(2).setCellValue("CourseFee");
		hrow.createCell(3).setCellValue("Duration");
		hrow.createCell(4).setCellValue("StartDate");
		
		
		//to put gap between heading and rows
		int rowcount=4;
		
		
		for(CourseBean c:courses) {
			
			
			Row drow= sheet.createRow(rowcount++);
			
			drow.createCell(0).setCellValue(c.getCourseId());
			drow.createCell(1).setCellValue(c.getCourseName());
			drow.createCell(2).setCellValue(c.getFee());
			drow.createCell(3).setCellValue(c.getDuration());
			drow.createCell(4).setCellValue(c.getStartDate());
				

		}
		
		
		
		
		
		
		
		
		
		
		
	}

	

}
