package chzu.lujie.work.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * 章节
 * 
 * @author jielu
 * 
 */
public class Charpter {
	private Long cid;
	private String cname;
	private String description;

	private Subject subject;
	
	private Set knowledgedetail = new HashSet();
	private Set questionses = new HashSet();
//	private Set knowledges = new HashSet();
//	
	/*
	 * setter and getter
	 */
	public Long getCid() {
		return cid;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set getKnowledgedetail() {
		return knowledgedetail;
	}

	public void setKnowledgedetail(Set knowledgedetail) {
		this.knowledgedetail = knowledgedetail;
	}

	public Set getQuestionses() {
		return questionses;
	}

	public void setQuestionses(Set questionses) {
		this.questionses = questionses;
	}




}
