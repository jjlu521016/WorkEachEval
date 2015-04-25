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
public class StudentQuestionRecord {
	private Long sqrId;
	private Questions question;
	private Set<AnswersUser> answers = new HashSet<AnswersUser>();
	
	private ExamPaper examPaper;
	
	public Long getSqrId() {
		return sqrId;
	}
	public void setSqrId(Long sqrId) {
		this.sqrId = sqrId;
	}

	public Questions getQuestion() {
		return question;
	}
	public void setQuestion(Questions question) {
		this.question = question;
	}

	public ExamPaper getExamPaper() {
		return examPaper;
	}
	public void setExamPaper(ExamPaper examPaper) {
		this.examPaper = examPaper;
	}
	public Set<AnswersUser> getAnswers() {
		return answers;
	}
	public void setAnswers(Set<AnswersUser> answers) {
		this.answers = answers;
	}

	
}
