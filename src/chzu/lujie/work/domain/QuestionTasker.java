package chzu.lujie.work.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;

/**
 * @author jielu
 * 
 */
public class QuestionTasker {
	private Long qtId;
	private ExamPaper examPaper;
	//private Questions question;
	private StudentQuestionRecord record;
	private String opinion;
	private String score;
	private User tasker;

	public Long getQtId() {
		return qtId;
	}

	public void setQtId(Long qtId) {
		this.qtId = qtId;
	}



	public StudentQuestionRecord getRecord() {
		return record;
	}

	public void setRecord(StudentQuestionRecord record) {
		this.record = record;
	}

	public String getOpinion() {
		return opinion;
	}

	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}


	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public ExamPaper getExamPaper() {
		return examPaper;
	}

	public void setExamPaper(ExamPaper examPaper) {
		this.examPaper = examPaper;
	}

	public User getTasker() {
		return tasker;
	}

	public void setTasker(User tasker) {
		this.tasker = tasker;
	}

}
