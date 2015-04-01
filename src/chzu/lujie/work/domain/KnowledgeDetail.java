package chzu.lujie.work.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 知识点
 * 
 * @author jielu
 * 
 */
public class KnowledgeDetail extends Article {

	private Long kid;
	private String title; // 标题
	private String content;// 内容
	private User author;// 作者
	private Date postTime;// 时间
	// 知识点的状态
	private String status;
	// 所属的章节
	private Charpter charpter;

	/**
	 * setter and getter
	 */
	public Long getKid() {
		return kid;
	}

	public void setKid(Long kid) {
		this.kid = kid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public Date getPostTime() {
		return postTime;
	}

	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Charpter getCharpter() {
		return charpter;
	}

	public void setCharpter(Charpter charpter) {
		this.charpter = charpter;
	}

}
