package chzu.lujie.work.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ExamPaper {

	private Long epid;
	
	private User student;
	private Exam exam;
	private String flg;
	private Date stopTime;
	
	private List<StudentQuestionRecord> records ;
	///////////////////////////////////////////////////////////////////////////
	
	public Long getEpid() {
		return epid;
	}
	public void setEpid(Long epid) {
		this.epid = epid;
	}
	public User getStudent() {
		return student;
	}
	public void setStudent(User student) {
		this.student = student;
	}
	public Exam getExam() {
		return exam;
	}
	public void setExam(Exam exam) {
		this.exam = exam;
	}
	public String getFlg() {
		return flg;
	}
	public void setFlg(String flg) {
		this.flg = flg;
	}
	public Date getStopTime() {
		return stopTime;
	}
	public void setStopTime(Date stopTime) {
		this.stopTime = stopTime;
	}
	public List<StudentQuestionRecord> getRecords() {
		return records;
	}
	public void setRecords(List<StudentQuestionRecord> records) {
		this.records = records;
	}


	
	
	
}
