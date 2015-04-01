package chzu.lujie.work.vo;

import java.io.Serializable;

public class CharpterVo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5210843664054125591L;
	private int cid;
	private String cname;
	private String sname;
	private int sid = -1;

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

}

