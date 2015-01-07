package chzu.lujie.work.view.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.sun.org.glassfish.gmbal.Description;

import chzu.lujie.work.domain.Role;
import chzu.lujie.work.service.RoleService;

@Controller
@Scope("prototype")
public class RoleAction
{
	@Resource
	private RoleService roleService;
	
	private Long id;
	private String name;
	private String description;
	//
//	private Role model = new Role();
	
public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	//	public Role getModel(){
//		return model;
//	}
	public String list() throws Exception{
		//
		List<Role> roleList = roleService.findAll();
		//
		ActionContext.getContext().put("roleList", roleList);
		return "list";
	}
	
	public String delete() throws Exception{
		roleService.delete(id);
		return "tolist";
	}
	
	public String add() throws Exception{
		return "addUI";
	}
	public String addUI() throws Exception{
		//封装到对象中
		Role role = new Role();
		role.setName(name);
		role.setDescription(description);
		
		roleService.save(role);
		
		return "tolist";
	}
	
	public String edit() throws Exception{
		return "editUI";
	}
	public String editUI() throws Exception{
		return "tolist";
	}
	

}
