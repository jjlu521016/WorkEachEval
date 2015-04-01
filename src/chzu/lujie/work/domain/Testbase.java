package chzu.lujie.work.domain;

import java.sql.Date;

/**
 * 测试表
 * @author jielu
 *
 */
public class Testbase {

	private long tpId;
	private Subject subject;
	private String tpName;
	private Date tpTime;
	private String tpScore;
	
	/**
	 * setter and getter
	 * @return
	 */
	public long getTpId() {
		return tpId;
	}
	public void setTpId(long tpId) {
		this.tpId = tpId;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public String getTpName() {
		return tpName;
	}
	public void setTpName(String tpName) {
		this.tpName = tpName;
	}
	
	public Date getTpTime() {
		return tpTime;
	}
	public void setTpTime(Date tpTime) {
		this.tpTime = tpTime;
	}
	public String getTpScore() {
		return tpScore;
	}
	public void setTpScore(String tpScore) {
		this.tpScore = tpScore;
	}
	
	
}
