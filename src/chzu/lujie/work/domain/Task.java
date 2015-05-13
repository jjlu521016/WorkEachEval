package chzu.lujie.work.domain;

public class Task {

	private Long tid;
	private User student;
	
	private ExamPaper examPaper;
	//批改作业的人员
	private User Tasker1;
	private User Tasker2;
	private User Tasker3;
	private String flg;
	private String autoscore;
	
	public Long getTid() {
		return tid;
	}
	public void setTid(Long tid) {
		this.tid = tid;
	}
	public User getStudent() {
		return student;
	}
	public void setStudent(User student) {
		this.student = student;
	}
	public ExamPaper getExamPaper() {
		return examPaper;
	}
	public void setExamPaper(ExamPaper examPaper) {
		this.examPaper = examPaper;
	}

	public User getTasker1() {
		return Tasker1;
	}
	public void setTasker1(User tasker1) {
		Tasker1 = tasker1;
	}
	public User getTasker2() {
		return Tasker2;
	}
	public void setTasker2(User tasker2) {
		Tasker2 = tasker2;
	}
	public User getTasker3() {
		return Tasker3;
	}
	public void setTasker3(User tasker3) {
		Tasker3 = tasker3;
	}
	public String getFlg() {
		return flg;
	}
	public void setFlg(String flg) {
		this.flg = flg;
	}
	public String getAutoscore() {
		return autoscore;
	}
	public void setAutoscore(String autoscore) {
		this.autoscore = autoscore;
	}

	
}
