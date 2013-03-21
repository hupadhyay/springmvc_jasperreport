package com.himtech.report;


import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.himtech.datasource.StudentDataSource;

@Controller
public class JasperBean {

	private JRDataSource jrDatasource;

	public JasperBean() throws JRException {
		StudentDataSource dsStudent =  new StudentDataSource();
		jrDatasource = dsStudent.create(null);
	}

	@RequestMapping(value = "/jrreport", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		model.addAttribute("datasource", jrDatasource);
		model.addAttribute("format", "pdf");
		return "multiViewReport";
	}
}
