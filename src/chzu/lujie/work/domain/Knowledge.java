package chzu.lujie.work.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * 知识点 PO
 * @author jielu
 *
 */
public class Knowledge {
	private Long kid;
	private String kname;

	private Charpter charpter;
	private Set questionses = new HashSet();
	
	/**
	 * setter and getter
	 */
	public Long getKid() {
		return kid;
	}
	public void setKid(Long kid) {
		this.kid = kid;
	}
	public String getKname() {
		return kname;
	}
	public void setKname(String kname) {
		this.kname = kname;
	}
	public Charpter getCharpter() {
		return charpter;
	}
	public void setCharpter(Charpter charpter) {
		this.charpter = charpter;
	}
	public Set getQuestionses() {
		return questionses;
	}
	public void setQuestionses(Set questionses) {
		this.questionses = questionses;
	}

	
	
}
