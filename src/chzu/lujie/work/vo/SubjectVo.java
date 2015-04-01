package chzu.lujie.work.vo;

import java.io.Serializable;

public class SubjectVo implements Serializable {
	
//	private static final long serialVersionUID = -891096866492482452L;
	private long sid ;
	private String sname ;
	public SubjectVo(){
		
	};
	public SubjectVo(int sid, String sname){
		this.sid = sid;
		this.sname = sname;
	}

	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public long getSid() {
		return sid;
	}
	public void setSid(long sid) {
		this.sid = sid;
	}

	
}
