package chzu.lujie.work.view.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import chzu.lujie.work.base.BaseAction;
import chzu.lujie.work.domain.Forum;
import chzu.lujie.work.domain.Types;

@Controller
@Scope("prototype")
public class TypesAction extends BaseAction<Types> {

	public String list() throws Exception {
		List<Types> TypesList = typesService.findAll();

		ActionContext.getContext().put("TypesList", TypesList);

		return "list";
	}

	public String delete() throws Exception {
		typesService.delete(model.getTid());
		return "tolist";
	}

	public String add() throws Exception {
		typesService.save(model);
		return "tolist";

	}

	public String addUI() throws Exception {

		return "saveUI";
	}

	public String edit() throws Exception {
		// 从数据库中取对象
		Types types = typesService.getById(model.getTid());

		types.setStyle(model.getStyle());
		types.setTid(model.getTid());
		types.setTname(model.getTname());
		
		typesService.save(types);
		return "tolist";
	}

	public String editUI() throws Exception {
		Types types = typesService.getById(model.getTid());
		ActionContext.getContext().getValueStack().push(types);
		return "saveUI";
	}
}
