package chzu.lujie.work.domain;

import java.io.Serializable;

public class Taskerpaper implements Serializable{
	private int tpid;
	private User tasker;
	private  ExamPaper paper;
	private User student;
	public int getTpid() {
		return tpid;
	}
	public void setTpid(int tpid) {
		this.tpid = tpid;
	}
	public User getTasker() {
		return tasker;
	}
	public void setTasker(User tasker) {
		this.tasker = tasker;
	}
	public ExamPaper getPaper() {
		return paper;
	}
	public void setPaper(ExamPaper paper) {
		this.paper = paper;
	}
	public User getStudent() {
		return student;
	}
	public void setStudent(User student) {
		this.student = student;
	}
	
	
}

