package chzu.lujie.work.view.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import chzu.lujie.work.service.AnswersService;

import com.opensymphony.xwork2.ActionSupport;
@Controller
@Scope("prototype")
public class AnswersAction extends ActionSupport {

	private AnswersService	 service;
	public void setService(AnswersService service) {
		this.service = service;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return super.execute();
	}

}