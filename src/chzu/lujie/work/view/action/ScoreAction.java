package chzu.lujie.work.view.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import chzu.lujie.work.base.BaseAction;
import chzu.lujie.work.domain.Charpter;
import chzu.lujie.work.domain.KnowledgeDetail;
import chzu.lujie.work.domain.Questions;
import chzu.lujie.work.domain.Score;
import chzu.lujie.work.domain.Subject;
import chzu.lujie.work.domain.User;
import chzu.lujie.work.util.QueryHelper;

/**
 * 分数管理
 * 
 * @author jielu
 * 
 */
@Controller
@Scope("prototype")
public class ScoreAction extends BaseAction<Charpter> {
	
	String name;
	String paper;
	/**
	 * 显示所有学生成绩信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception {
		// 查询所有的学生成绩
		new QueryHelper(Score.class, "s").preparePageBean(userService, pageNum,
				pageSize);
		
		return "list";
	}

	/**
	 * 查询个人成绩信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String studentlist() throws Exception {
		// 根据学生查询成绩
		new QueryHelper(Score.class, "s").addCondition("s.student =?",
				getCurrentUser()).preparePageBean(userService, pageNum,
				pageSize);
		return "studentlist";
	}
	
	public String querylistUI() throws Exception{
			return "querylistUI";
		}
	
	public String querylist() throws Exception{
		System.out.println("_____=="+name);
		new QueryHelper(Score.class, "s").addCondition("s.student.name like ?",
				"%"+name+"%").addCondition(true, "s.paper.exam.name like ?", "%"+paper+"%").preparePageBean(userService, pageNum,
				pageSize);
		return "list";
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPaper(String paper) {
		this.paper = paper;
	}

	
}
