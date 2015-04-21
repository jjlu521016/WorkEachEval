package chzu.lujie.work.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("serial")
public class Exercise implements Serializable {
	private Long eid;
	private String name;
	private Date currentDate;
	private String statu;
	private String flg;

	private User author;
	private Charpter charpter;
	private Subject subject;
	private Set qustions = new HashSet<>();

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

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public Date getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}

	public Charpter getCharpter() {
		return charpter;
	}

	public void setCharpter(Charpter charpter) {
		this.charpter = charpter;
	}

	public Set getQustions() {
		return qustions;
	}

	public void setQustions(Set qustions) {
		this.qustions = qustions;
	}

	

	public String getStatu() {
		return statu;
	}

	public void setStatu(String statu) {
		this.statu = statu;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public String getFlg() {
		return flg;
	}

	public void setFlg(String flg) {
		this.flg = flg;
	}

}
