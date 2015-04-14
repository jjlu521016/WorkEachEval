package chzu.lujie.work.view.vo;

import java.io.Serializable;


public class AnswerVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5243458130920281375L;
	private int aid;
	private int qid ; 
	private String answer;//the answer of question
	private String isRight;//isright?
	private String sequence;//the sequence of the question
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public String getIsRight() {
		return isRight;
	}
	public void setIsRight(String isRight) {
		this.isRight = isRight;
	}
	public String getSequence() {
		return sequence;
	}
	public void setSequence(String sequence) {
		this.sequence = sequence;
	}
	
}

