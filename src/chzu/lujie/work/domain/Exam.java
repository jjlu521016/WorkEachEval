package chzu.lujie.work.domain;

import java.util.Date;

public class Exam {

	private Long eid;
	private String name;	
	private Date requireTime;
	private Date startTime;	
	private Date stopTime;
	private User author;
	private String num;
	private String score;
	private String flg;
	private Subject subject;
	private Charpter charpter;
	public Long getEid() {
		return eid;
	}
	public void setEid(Long eid) {
		this.eid = eid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getRequireTime() {
		return requireTime;
	}
	public void setRequireTime(Date requireTime) {
		this.requireTime = requireTime;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getStopTime() {
		return stopTime;
	}
	public void setStopTime(Date stopTime) {
		this.stopTime = stopTime;
	}
	public User getAuthor() {
		return author;
	}
	public void setAuthor(User author) {
		this.author = author;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getFlg() {
		return flg;
	}
	public void setFlg(String flg) {
		this.flg = flg;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public Charpter getCharpter() {
		return charpter;
	}
	public void setCharpter(Charpter charpter) {
		this.charpter = charpter;
	}
	
	
	
}
