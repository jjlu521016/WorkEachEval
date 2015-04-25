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
import chzu.lujie.work.domain.StudentQuestionRecord;
import chzu.lujie.work.domain.Subject;
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
public class ExamPaperAction extends BaseAction<ExamPaper> {
	
	private Long sqrId;
	
	/**
	 * 显示考试试卷
	 * 
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception {

		List<ExamPaper> paperlist = examPaperService
				.findMyPaper(getCurrentUser());
		ActionContext.getContext().put("paperlist", paperlist);
		return "list";
	}

	/**
	 * 根据试卷的id获取所有的问题
	 * 
	 * @return
	 * @throws Exception
	 */
	public String showQuestion() throws Exception {
		ExamPaper paper = examPaperService.getById(model.getEpid());

		List<StudentQuestionRecord> recordList = recordService
				.getByPaper(paper);
		ActionContext.getContext().put("recordList", recordList);
		return "showQuestion";
	}

	
	public String addAnswerUser() throws Exception {

		
		return "addAnswerUser";
	}

}
