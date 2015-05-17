package chzu.lujie.work.view.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import chzu.lujie.work.base.BaseAction;
import chzu.lujie.work.domain.AnswersUser;
import chzu.lujie.work.domain.ExamPaper;
import chzu.lujie.work.domain.QuestionTasker;
import chzu.lujie.work.domain.Questions;
import chzu.lujie.work.domain.Score;
import chzu.lujie.work.domain.Task;
import chzu.lujie.work.domain.Taskerpaper;
import chzu.lujie.work.domain.User;
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
		QuestionTasker record;
		Long taskId;
		
		Long stuid;
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
	
	public String finish() throws Exception {		
		List<Task> tasklist = taskService.findMyfinishTask(getCurrentUser());
		ActionContext.getContext().put("tasklist", tasklist);
		
	return "finish";
	}
	/*
	 * 点击批改作业
	 */
	public String getQuestion() throws Exception{
		ExamPaper paper = examPaperService.getById(paperId);
		String type="3";
		//TODO
		recordService.findSubject(paper,type,getCurrentUser());
		showQuestionByIndex(paper, index);
		
		return "getQuestion";
	}
	
		/**
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
		//String type="3";
		// 把答案显示在试卷上
		ExamPaper paper = recordpaper();	
		//获取总共有多少题
		List<QuestionTasker> record = questiontaskerService.findrecord(paper,getCurrentUser());
		
		int max = record.size();
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
		List<QuestionTasker> record1 = questiontaskerService.findrecord(paper,getCurrentUser());

		record1.get(index).setOpinion(record.getOpinion());
		record1.get(index).setScore(record.getScore());
		questiontaskerService.update(record1.get(index));
		return paper;
	}

	// 显示某张试卷上的第index题
	private void showQuestionByIndex(ExamPaper paper, int index) {
		
		List<QuestionTasker> record = questiontaskerService.findrecord(paper,getCurrentUser());

		List<AnswersUser> answer = record.get(index).getRecord().getAnswers();
		Questions q = record.get(index).getRecord().getQuestion();
		// 将要传入的参数放到Map中	
		ActionContext.getContext().put("answer", answer);
		ActionContext.getContext().put("q", q);
		// 保持前端和后台的关系
		ActionContext.getContext().put("index", index);
		ActionContext.getContext().put("paperId", paperId);
		ActionContext.getContext().put("stuid", stuid);
		ActionContext.getContext().put("taskId", taskId);
		ActionContext.getContext().put("record", record.get(index));
		//显示数据库里记录的本题答案
		this.answers = paper.getRecords().get(index).getAnswers();
		this.record = record.get(index);

	}

	
	public String submitPaper() throws Exception{
		
		//更新试卷状态
		ExamPaper paper = recordpaper();
		User student = userService.getById(stuid);
		Task task = taskService.getScore(paper,student);
		String subscore = questiontaskerService.getByPaperUser(paper,getCurrentUser());
		//转换类型
		int subScore = (Integer.parseInt(subscore)/3);
		//计算总得分
		int totalscore = Integer.parseInt(task.getAutoscore())+subScore;
		//计算当前试卷的总分
		int paperScore = recordService.getStudentSorce(paper);
		//计算得分与总分的比之
		double rate = (double)totalscore /(double)paperScore;
		
		//将数据插入到分数表
		
		//将试卷和批改人添加到中间表里，用于判断批改人时候是否已经批改过。
		Taskerpaper tpaper= new Taskerpaper();
		tpaper.setPaper(paper);
		tpaper.setTasker(getCurrentUser());
		tpaper.setStudent(student);
		taskerpaperService.merge(tpaper);
		//根据学生试卷查询在分数表中是否已经存在记录
		List<Score> scorelist = scoreService.getScoreByPaper(paper);

		Score score = new Score();
		//判断数据库中是否有该试卷的数据，没有则插入数据，否则更新数据
		if(scorelist.size()<=0){
			score.setAutoscore(Integer.parseInt(task.getAutoscore()));
			score.setManualscore(subScore);
			score.setPaper(paper);
			score.setStudent(student);
			//score.setTasker(getCurrentUser());
			score.setTotalscore(totalscore);
			score.setPaperscore(paperScore);
			score.setRate(rate);
			scoreService.merge(score);
		}
		else{
			scoreService.updateScoreInfo(scorelist.get(0).getSid(),Integer.parseInt(subscore)/3,totalscore,rate);
		}
		return "taskfinfish";
	}
///////////////////////////////////////////////////////////////////////////////
	public void setPaperId(Long paperId) {
		this.paperId = paperId;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	public void setAnswers(List<AnswersUser> answers) {
		this.answers = answers;
	}
	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}
	
	public void setRecord(QuestionTasker record) {
		this.record = record;
	}
	public void setStuid(Long stuid) {
		this.stuid = stuid;
	}
	public Long getPaperId() {
		return paperId;
	}
	public int getIndex() {
		return index;
	}
	public List<AnswersUser> getAnswers() {
		return answers;
	}
	public QuestionTasker getRecord() {
		return record;
	}
	public Long getTaskId() {
		return taskId;
	}
	public Long getStuid() {
		return stuid;
	}



}
