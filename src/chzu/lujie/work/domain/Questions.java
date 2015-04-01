package chzu.lujie.work.domain;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 问题 PO
 * 
 * @author jielu
 * 
 */
public class Questions {
	private Long qid;
	private String qtext;
	private String anum;// 问题的编号
	private String qdifficult;// 问题的难易程度
	private String qscore;
	private Date qtime;
	private String remark;

	private Subject subject;
	private Charpter charpter;
	private Knowledge knowledge;
	private Set answerses = new HashSet<>();

	// TODO
	/**
	 * setter and getter
	 */

	public Long getQid() {
		return qid;
	}

	public void setQid(Long qid) {
		this.qid = qid;
	}

	public String getQtext() {
		return qtext;
	}

	public void setQtext(String qtext) {
		this.qtext = qtext;
	}

	public String getAnum() {
		return anum;
	}

	public void setAnum(String anum) {
		this.anum = anum;
	}

	public String getQdifficult() {
		return qdifficult;
	}

	public void setQdifficult(String qdifficult) {
		this.qdifficult = qdifficult;
	}

	public String getQscore() {
		return qscore;
	}

	public void setQscore(String qscore) {
		this.qscore = qscore;
	}

	public Date getQtime() {
		return qtime;
	}

	public void setQtime(Date qtime) {
		this.qtime = qtime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	public Knowledge getKnowledge() {
		return knowledge;
	}

	public void setKnowledge(Knowledge knowledge) {
		this.knowledge = knowledge;
	}

	public Set getAnswerses() {
		return answerses;
	}

	public void setAnswerses(Set answerses) {
		this.answerses = answerses;
	}

}
