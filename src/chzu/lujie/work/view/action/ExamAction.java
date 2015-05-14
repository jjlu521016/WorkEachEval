package chzu.lujie.work.view.action;

import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import chzu.lujie.work.base.BaseAction;
import chzu.lujie.work.domain.Charpter;
import chzu.lujie.work.domain.Exam;
import chzu.lujie.work.domain.ExamPaper;
import chzu.lujie.work.domain.Exercise;
import chzu.lujie.work.domain.Subject;
import chzu.lujie.work.domain.User;
import chzu.lujie.work.util.QueryHelper;

import com.opensymphony.xwork2.ActionContext;

/**
 * 作业发布管理
 * 
 * @author jielu
 * 
 */
@Controller
@Scope("prototype")
public class ExamAction extends BaseAction<Exam> {
	private Long subjectId;

	private Long charpterId;

	/**
	 * 显示课程
	 * 
	 * @return
	 * @throws Exception
	 */
	public String showSubject() throws Exception {
		List<Subject> subjectlist = subjectService.findAll();
		ActionContext.getContext().put("subjectlist", subjectlist);
		return "showSubject";
	}

	public String list() throws Exception {

		new QueryHelper(Exam.class, "e").addCondition("e.flg = ?", "1").preparePageBean(examService, pageNum, pageSize);
		return "list";
	}

	/**
	 * 删除
	 * 
	 * @return
	 * @throws Exception
	 */
	public String delete() throws Exception {
		examService.delete(model.getEid());
		return "toshow";
	}

	/**
	 * 添加页面准备数据
	 * 
	 * @return
	 * @throws Exception
	 */
	public String addUI() throws Exception {

		Subject subject = subjectService.getById(subjectId);

		List<Charpter> charpterList = charpterService.findBySubject(subject);
		ActionContext.getContext().put("charpterList", charpterList);
		return "saveUI";
	}

	/**
	 * 将页面的数据添加到数据库
	 * 
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception {

		Exam exam = new Exam();
		exam.setAuthor(getCurrentUser());
		exam.setSubject(subjectService.getById(subjectId));
		exam.setCharpter(charpterService.getById(charpterId));
		exam.setName(model.getName());
		exam.setFlg("0");
		exam.setStartTime(model.getStartTime());
		exam.setStopTime(model.getStopTime());
		examService.save(exam);

		return "toshow";
	}

	/**
	 * 修改数据显示页面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String editUI() throws Exception {

		Subject subject = subjectService.getById(subjectId);

		List<Charpter> charpterList = charpterService.findBySubject(subject);
		 
		ActionContext.getContext().put("charpterList", charpterList);

		Exam exam = examService.getById(model.getEid());

		ActionContext.getContext().getValueStack().push(exam);
		if (exam.getCharpter() != null) {
			charpterId = exam.getCharpter().getCid();
		}
		return "saveUI";
	}

	/**
	 * 修改
	 * 
	 * @return
	 * @throws Exception
	 */
	public String edit() throws Exception {

		Exam exam = new Exam();
		exam.setEid(model.getEid());
		exam.setAuthor(getCurrentUser());
		exam.setSubject(subjectService.getById(subjectId));
		exam.setCharpter(charpterService.getById(charpterId));
		exam.setName(model.getName());
		exam.setFlg("0");
		exam.setStartTime(model.getStartTime());
		exam.setStopTime(model.getStopTime());
		examService.update(exam);

		return "toshow";
	}

	public String createPaper() throws Exception {
		Exam exam = examService.getById(model.getEid());
		//判断试卷是否已经生成
		
		try{
		
		ExamPaper paper = examPaperService.createPaper(exam, getCurrentUser());
		examPaperService.save(paper);
		}
		catch(Exception e){
			e.printStackTrace();
			ActionContext.getContext().put("error", "你的作业已经生成了，请到“未完成的作业”里面查看！");
			return "error";
		}
		// 生成作业
		return "createPaper";
	}
	public String publish() throws Exception{
		examService.updateFlg(model.getEid());
		return "toshow";
	}
	/**
	 * setter and getter
	 * 
	 * @return
	 */
	public Long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}

	public Long getCharpterId() {
		return charpterId;
	}

	public void setCharpterId(Long charpterId) {
		this.charpterId = charpterId;
	}

}
