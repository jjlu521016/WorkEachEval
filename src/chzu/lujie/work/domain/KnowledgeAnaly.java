package chzu.lujie.work.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * 知识点分析
 * @author jielu
 *
 */
public class KnowledgeAnaly {

	private Long id;
	private String title;
	private String description;
	private int position; // 排序用的位置号
	
	private Set<KnowledgeDetail> knowledgeDetails = new HashSet<KnowledgeDetail>();
	
	///////////////////////////////////////////////////////////////////////////
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Set<KnowledgeDetail> getKnowledgeDetails() {
		return knowledgeDetails;
	}
	public void setKnowledgeDetails(Set<KnowledgeDetail> knowledgeDetails) {
		this.knowledgeDetails = knowledgeDetails;
	}
	
	
}
