package chzu.lujie.work.domain;

import java.io.Serializable;

public class Types implements Serializable{
	private Long tid;
	private String tname ;
	private String style;
//	private Set questionses = new HashSet();
	
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	
	public Long getTid() {
		return tid;
	}
	public void setTid(Long tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
//	public Set getQuestionses() {
//		return questionses;
//	}
//	public void setQuestionses(Set questionses) {
//		this.questionses = questionses;
//	} 
	
}

