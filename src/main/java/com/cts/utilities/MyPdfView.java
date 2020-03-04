package com.cts.utilities;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.cts.model.CourseBean;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;


public class MyPdfView extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		
		List<CourseBean> courses=(List<CourseBean>)model.get("courses");
		
		Paragraph p=new Paragraph();
		
		
		p.setAlignment("center");
		
		
		document.add(p);
		
		
		Table t=new Table(5);
		
		t.addCell("CourseID");
		t.addCell("CourseName");
		t.addCell("Fee");
		t.addCell("Duration");
		t.addCell("StartDate");
		
		
		for(CourseBean c:courses) {
			
			t.addCell(c.getCourseId()+"");
			t.addCell(c.getCourseName());
			t.addCell(c.getFee()+"");
			t.addCell(c.getDuration());
			t.addCell(c.getStartDate()+"");
			
		}
		
		document.add(t);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}


	

}
