package chzu.lujie.work.service;

import java.util.List;

import chzu.lujie.work.vo.AnswerVo;

public interface AnswersService {
	public int insertAnswer(AnswerVo vo );

	public int deleteByAid(String aid);

	public int modifyAnswer(AnswerVo vo );

	public List<AnswerVo > selectByQuestion(String qid);
}
