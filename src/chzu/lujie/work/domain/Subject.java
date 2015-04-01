package chzu.lujie.work.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 科目--PO
 * 
 * @author jielu
 */
public class Subject {
	private Long sid;
	private String sname;
	private String description;
	
	private String subject_code;

//	private Set testbases = new HashSet();
	private Set charpters = new HashSet();
//	private Set questionses = new HashSet(); //题库
	

	/*
	 * setter and getter
	 */


	public String getSname() {
		return sname;
	}

	public Long getSid() {
		return sid;
	}

	public void setSid(Long sid) {
		this.sid = sid;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set getCharpters() {
		return charpters;
	}

	public void setCharpters(Set charpters) {
		this.charpters = charpters;
	}

	public String getSubject_code() {
		return subject_code;
	}

	public void setSubject_code(String subject_code) {
		this.subject_code = subject_code;
	}


}
