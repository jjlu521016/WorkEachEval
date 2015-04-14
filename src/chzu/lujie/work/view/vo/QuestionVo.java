package chzu.lujie.work.view.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import chzu.lujie.work.domain.Charpter;
import chzu.lujie.work.domain.Subject;
import chzu.lujie.work.domain.Types;

public class QuestionVo implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3627506564895711812L;
	private Long qid;// 问题ID
	private String qtext;// 题目
	private String sortnum;// 所属批次
	private String anum;// 问题的编号
	private String qscore;// 单个问题的分数
	private Date qtime;// 时间
	private String remark;// 标记
	private Subject subject;// 所属的课程
	private Charpter charpter;// 所属的章节
	private Types types;// 问题所属类型
	// private Knowledge knowledge;//所属知识点
	private Set answerses = new HashSet<>();// 问题的答案

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

	public String getSortnum() {
		return sortnum;
	}

	public void setSortnum(String sortnum) {
		this.sortnum = sortnum;
	}

	public String getAnum() {
		return anum;
	}

	public void setAnum(String anum) {
		this.anum = anum;
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

	public Types getTypes() {
		return types;
	}

	public void setTypes(Types types) {
		this.types = types;
	}

	public Set getAnswerses() {
		return answerses;
	}

	public void setAnswerses(Set answerses) {
		this.answerses = answerses;
	}

	@Override
	protected Object clone() {
		Object o = null;
		try {
			o = (QuestionVo) super.clone();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return o;
	}

}
