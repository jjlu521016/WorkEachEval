package chzu.lujie.work.view.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import chzu.lujie.work.base.BaseAction;
import chzu.lujie.work.domain.AnswersUser;
import chzu.lujie.work.domain.ExamPaper;
import chzu.lujie.work.domain.Questions;
import chzu.lujie.work.domain.Score;
import chzu.lujie.work.domain.StudentQuestionRecord;
import chzu.lujie.work.domain.Task;
/**
 * 互评——我的任务
 * @author jielu
 * 
 */
@Controller
@Scope("prototype")
public class TaskAction extends BaseAction<Task> {
	
		Long paperId;
		int index;
		List<AnswersUser> answers;
		Long taskId;
		//接收前端传来的参数
		int manualscore;
	/**
	 * 显示任务列表课程列表
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception {
			List<Task> tasklist = taskService.findMyTask(getCurrentUser());
			ActionContext.getContext().put("tasklist", tasklist);
		return "list";
	}
	public String getQuestion() throws Exception{
		ExamPaper paper = examPaperService.getById(paperId);

		showQuestionByIndex(paper, index);
		
		return "getQuestion";
	}
	
		/**‘
		 * 获取简答题
		 * @return
		 * @throws Exception
		 */
	
	public String doQuestion() throws Exception {
		ExamPaper paper = examPaperService.getById(paperId);

		showQuestionByIndex(paper, index);
		
		return "doQuestion";
	}

	public String nextQuestion() throws Exception {
		String type="3";
		// 把答案显示在试卷上
		ExamPaper paper = recordpaper();	
		//获取总共有多少题
		List<StudentQuestionRecord> record = recordService.findSubjective(paper, type);
		int max = record.size();
		System.out.println("---------------------------------------------------------------------------max="+max);
		if (index < max - 1) {
			index++;
		}		
		showQuestionByIndex(paper, index);	
	//	return "nextQuestion";
	//}
		Task task = taskService.getById(taskId);
		
		List<Score> scorelist = scoreService.getScoreBytasker(task.getExamPaper(),task.getStudent(),getCurrentUser());
		if(scorelist.size()>0){
			Score score  = new Score();
			//从数据库获得的数据
			score.setSid(scorelist.get(0).getSid());
			score.setAutoscore(scorelist.get(0).getAutoscore());
			score.setManualscore(manualscore);
			score.setPaper(paper);
			score.setStudent(task.getStudent());
			score.setTasker(getCurrentUser());
			scoreService.merge(score);
		}
		else{
			Score score  = new Score();
			score.setAutoscore(scorelist.get(0).getAutoscore());
			score.setManualscore(manualscore);
			score.setPaper(paper);
			score.setStudent(task.getStudent());
			score.setTasker(getCurrentUser());
			scoreService.merge(score);
		}
		return "taskfinish";
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
		//ExamPaper paper = examPaperService.getsubjective(paperId);
		//paper.getRecords().get(index).setAnswers(answers);
		// 保存试卷
		//examPaperService.updatePaper(paper);
		
		return paper;
	}

	// 显示某张试卷上的第index题
	private void showQuestionByIndex(ExamPaper paper, int index) {
		
		String type = "3";
		List<StudentQuestionRecord> record = recordService.findSubjective(paper,type); 
		List<AnswersUser> answer = record.get(index).getAnswers();
		System.out.println("answer============================="+answer);
		Questions q = record.get(index).getQuestion();//getRecords().get(index).getQuestion();
		// 将要传入的参数放到Map中	
		ActionContext.getContext().put("answer", answer);
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
		//int score = getSorce(paper,getCurrentUser());
		
		//把这个作业交给其他几个同学互评
		
		Task task = taskService.getUser(paper, getCurrentUser());
		taskService.merge(task);
		return "submitpaper";
	}
///////////////////////////////////////////////////////////////////////////////
	public void setPaperId(Long paperId) {
		this.paperId = paperId;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public List<AnswersUser> getAnswers() {
		return answers;
	}
	public void setAnswers(List<AnswersUser> answers) {
		this.answers = answers;
	}
	public Long getPaperId() {
		return paperId;
	}
	public int getManualscore() {
		return manualscore;
	}
	public void setManualscore(int manualscore) {
		this.manualscore = manualscore;
	}
	public Long getTaskId() {
		return taskId;
	}
	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}



	
	
}
