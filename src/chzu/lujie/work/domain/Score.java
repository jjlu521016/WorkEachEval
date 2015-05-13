package chzu.lujie.work.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 分数表
 * 
 * @author jielu
 * 
 */
public class Score {

	private Long sid;
	private User student;
	private ExamPaper paper;
	//批改人
	private User tasker;
	//选择和判断题分数
	private int autoscore;
	//简答题分数
	private int manualscore;
	private int totalscore;
	//试卷总分
	private int paperscore;
	//得分与总分的比之
	private double rate;
	
	public Long getSid() {
		return sid;
	}
	public void setSid(Long sid) {
		this.sid = sid;
	}
	public User getStudent() {
		return student;
	}
	public void setStudent(User student) {
		this.student = student;
	}
	public ExamPaper getPaper() {
		return paper;
	}
	public void setPaper(ExamPaper paper) {
		this.paper = paper;
	}
	
	public User getTasker() {
		return tasker;
	}
	public int getAutoscore() {
		return autoscore;
	}
	public void setAutoscore(int autoscore) {
		this.autoscore = autoscore;
	}
	public int getManualscore() {
		return manualscore;
	}
	public void setManualscore(int manualscore) {
		this.manualscore = manualscore;
	}
	public int getTotalscore() {
		return totalscore;
	}
	public void setTotalscore(int totalscore) {
		this.totalscore = totalscore;
	}
	public void setTasker(User tasker) {
		this.tasker = tasker;
	}
	public int getPaperscore() {
		return paperscore;
	}
	public void setPaperscore(int paperscore) {
		this.paperscore = paperscore;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	
	
}
