package chzu.lujie.work.view.action;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import chzu.lujie.work.base.BaseAction;
import chzu.lujie.work.domain.AnswersUser;
import chzu.lujie.work.domain.Exam;
import chzu.lujie.work.domain.ExamPaper;
import chzu.lujie.work.domain.Questions;
import chzu.lujie.work.domain.Score;
import chzu.lujie.work.domain.StudentQuestionRecord;
import chzu.lujie.work.domain.Task;
import chzu.lujie.work.service.StudentQuestionRecordService;
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
	// 以下两个参数用于连接前端页面和后台数据库
	Long paperId;
	int index;
	List<AnswersUser> answers;
	

	/**
	 * 显示考试试卷
	 * 
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception {
		new QueryHelper(ExamPaper.class, "e").addCondition("e.student = ?", getCurrentUser())
		.addCondition(true, "e.flg = ?", "0").preparePageBean(examPaperService, pageNum, pageSize);
		return "list";
	}
	
	public String finish() throws Exception {
		new QueryHelper(ExamPaper.class, "e").addCondition("e.student = ?", getCurrentUser())
		.addCondition(true, "e.flg = ?", "1").preparePageBean(examPaperService, pageNum, pageSize);
		return "list";
	}

	public String doQuestion() throws Exception {
		ExamPaper paper = examPaperService.getById(paperId);

		showQuestionByIndex(paper, index);
		
		return "doQuestion";
	}

	public String nextQuestion() throws Exception {
		// 把答案显示在试卷上
		ExamPaper paper = recordpaper();		
		//获取总共有多少题
		int max = recordService.getCount(paper);
		System.out.println("---------------------------------------------------------------------------max="+max);
		if (index < max - 1) {
			index++;
		}		
		showQuestionByIndex(paper, index);	
		return "nextQuestion";
	}

	public String preQuestion() throws Exception {
		ExamPaper paper = recordpaper();
		if (index > 0) {
			index--;
		}
		showQuestionByIndex(paper, index);
		return "preQuestion";
	}

	// 记录试卷
	private ExamPaper recordpaper() {
		// 把答案显示在试卷上
		
		ExamPaper paper = examPaperService.getById(paperId);
		paper.getRecords().get(index).setAnswers(answers);
		// 保存试卷
		examPaperService.update(paper);
		return paper;
	}

	// 显示某张试卷上的第index题
	private void showQuestionByIndex(ExamPaper paper, int index) {
		Questions q = paper.getRecords().get(index).getQuestion();
		// 将要传入的参数放到Map中	
		ActionContext.getContext().put("q", q);
		// 保持前端和后台的关系
		ActionContext.getContext().put("index", index);
		ActionContext.getContext().put("paperId", paperId);
		//显示数据库里记录的本题答案
		this.answers = paper.getRecords().get(index).getAnswers();

	}

	
	public String submitPaper() throws Exception{
		
		//更新试卷状态
		examPaperService.updateFlg(paperId);
		ExamPaper paper = examPaperService.getById(paperId);
		
		//获取选择题和判断题的分数
		int autoScore = examPaperService.getScore(paper);
		//把这个作业交给其他几个同学互评	
		Task task = taskService.getUser(paper, getCurrentUser());
		task.setAutoscore(Integer.toString(autoScore));
		boolean iscreate = taskService.isexist(paper, getCurrentUser());
		System.out.println("---------"+iscreate);
		if(!iscreate){
		taskService.merge(task);
		}
		ActionContext.getContext().put("autoScore",autoScore );
		return "submitpaper";
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

	public String useranswer() throws Exception {
		ExamPaper paper = examPaperService.getById(model.getEpid());
		Task task = taskService.getUser(paper, getCurrentUser());

		return "";
	}

	//
	public Long getPaperId() {
		return paperId;
	}

	public void setPaperId(Long paperId) {
		this.paperId = paperId;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public void setAnswers(List<AnswersUser> answers) {
		this.answers = answers;
	}

	public List<AnswersUser> getAnswers() {
		return answers;
	}

}
