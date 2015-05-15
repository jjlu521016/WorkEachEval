package chzu.lujie.work.view.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import chzu.lujie.work.base.BaseAction;
import chzu.lujie.work.domain.Charpter;
import chzu.lujie.work.domain.Department;
import chzu.lujie.work.domain.Role;
import chzu.lujie.work.domain.Score;
import chzu.lujie.work.domain.User;
import chzu.lujie.work.util.DepartmentUtils;
import chzu.lujie.work.util.MD5Utils;
import chzu.lujie.work.util.QueryHelper;

import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User> {

	private Long departmentId;
	private Long[] roleIds;
	
	private String responseText;   //返回的结果
	private boolean flag;          //主要是为了效果好看点
	User u;

	private InputStream inputStream;
	public InputStream getInputStream() {
		return inputStream;
	}
	//查询条件的参数
	String username;
	// 查询所有数据

	public String list() throws Exception {
		//分页显示
		new QueryHelper(User.class, "u").preparePageBean(userService, pageNum, pageSize);
		return "list";
	}

	public String delete() throws Exception {

		userService.delete(model.getId());
		return "tolist";
	}

	public String add() throws Exception {
		// 封装到对象中
		// >> 设置所属部门
		model.setDepartment(departmentService.getById(departmentId));
		// >> 设置关联的岗位
		List<Role> roleList = roleService.getByIds(roleIds);
		model.setRoles(new HashSet<Role>(roleList));
		// 保存到数据库
		userService.save(model);
		return "tolist";

	}

	public String addUI() throws Exception {
		// 准备数据, departmentList
		List<Department> topList = departmentService.findTopList();
		List<Department> departmentList = DepartmentUtils
				.getAllDepartments(topList);
		ActionContext.getContext().put("departmentList", departmentList);

		// 准备数据, roleList
		List<Role> roleList = roleService.findAll();
		ActionContext.getContext().put("roleList", roleList);
		return "addUI";
	}

	public String edit() throws Exception {
		User user = userService.getById(model.getId());

		user.setLoginName(model.getLoginName());
		user.setName(model.getName());
		user.setEmail(model.getEmail());
		user.setGender(model.getGender());
		user.setPassword(model.getPassword());
		user.setPhoneNumber(model.getPhoneNumber());

		// >> 设置所属部门
		user.setDepartment(departmentService.getById(departmentId));
		// >> 设置关联的岗位
		List<Role> roleList = roleService.getByIds(roleIds);
		user.setRoles(new HashSet<Role>(roleList));

		userService.update(user);
		return "tolist";
	}
///////////////////////////////////////////////////////////////////////////////	
//	个人信息更改
	public String editInfoUI() throws Exception {
		

		// 准备回显的数据
		User user = userService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(user);
		
		return "editInfoUI";
	}
	
	public String editInfo() throws Exception {
		User user = userService.getById(model.getId());

		userService.update(model);
		return "editInfo";
	}
///////////////////////////////////////////////////////////////////////////////	
	public String editUI() throws Exception {
		// 准备数据, departmentList
		List<Department> topList = departmentService.findTopList();
		List<Department> departmentList = DepartmentUtils
				.getAllDepartments(topList);
		ActionContext.getContext().put("departmentList", departmentList);

		// 准备数据, roleList
		List<Role> roleList = roleService.findAll();
		ActionContext.getContext().put("roleList", roleList);

		// 准备回显的数据
		User user = userService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(user);
		if (user.getDepartment() != null) {
			departmentId = user.getDepartment().getId();
		}
		if (user.getRoles() != null) {
			roleIds = new Long[user.getRoles().size()];
			int index = 0;
			for (Role role : user.getRoles()) {
				roleIds[index++] = role.getId();
			}
		}
		return "editUI";
	}

	/** 初始化密码为123456 */
	public String initPassword() throws Exception {
		// 1，从数据库中取出原对象
		User user = userService.getById(model.getId());

		// 2，设置要修改的属性（要使用MD5摘要）
		String md5Digest = MD5Utils.GetMD5Code("123456");
		// String md5Digest = MD5Utils.md5Hex("123456");
		user.setPassword(md5Digest);
		// 3，更新到数据库
		userService.update(user);

		return "tolist";
	}

	
	/** 登录页面 */
	public String loginUI() throws Exception {
		return "loginUI";
	}

	/** 登录 */
	public String login() throws Exception {
		User user = userService.findByLoginNameAndPassword(model.getLoginName(), model.getPassword());
		if (user == null) {
			addFieldError("login", "用户名或密码不正确！");
			
			System.out.println("----loginUI---------"+ user);
			return "loginUI";
		} else {
			// 登录用户
			ActionContext.getContext().getSession().put("user", user);
			
			System.out.println("-----toINdex--------"+ user);
			return "toIndex";
		}
	}

	/** 注销 */
	public String logout() throws Exception { 
		ActionContext.getContext().getSession().remove("user");
		return "logout";
	}
	
	/**
	 * 注册
	 * @return
	 * @throws Exception
	 */
	public String register() throws Exception {
		// 封装到对象中
		// >> 设置所属部门
		model.setDepartment(departmentService.getById(departmentId));
		// >> 设置关联的岗位
		List<Role> roleList = roleService.getByIds(roleIds);
		model.setRoles(new HashSet<Role>(roleList));
		
		String md5Digest = MD5Utils.GetMD5Code(model.getPassword());
		model.setPassword(md5Digest);
		System.out.println("pppppppppppppppppppp----"+md5Digest);
		// 保存到数据库
		userService.save(model);
		return "tosuccess";

	}

	public String registerUI() throws Exception {
		// 准备数据, departmentList
		List<Department> topList = departmentService.findTopList();
		List<Department> departmentList = DepartmentUtils
				.getAllDepartments(topList);
		ActionContext.getContext().put("departmentList", departmentList);

		// 准备数据, roleList
		return "registerUI";
	}
	


public String checkUserIsExist() throws Exception{
	HttpServletRequest request = ServletActionContext.getRequest();
	String loginName=request.getParameter("loginName");
	if(userService.getLoginName(loginName)){
		inputStream = new ByteArrayInputStream("0".getBytes("UTF-8")); 
	} else {
		inputStream = new ByteArrayInputStream("1".getBytes("UTF-8")); 
		
	}
	
	return "ajax-success";
}
	
	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public Long[] getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(Long[] roleIds) {
		this.roleIds = roleIds;
	}
	
	public String querylistUI() throws Exception{
		List<Department> topList = departmentService.findTopList();
		List<Department> departmentList = DepartmentUtils
				.getAllDepartments(topList);
		ActionContext.getContext().put("departmentList", departmentList);
		return "querylistUI";
	}
/**
 * 组合条件查询
 * @return
 * @throws Exception
 */
	public String querylist() throws Exception{
		System.out.println("_____=="+username);
		
		new QueryHelper(User.class, "s")//
			.addCondition("s.name like ? ","%"+username+"%")//
			.preparePageBean(userService, pageNum,
				pageSize);
		return "list";
	}

public void setUsername(String username) {
	this.username = username;
}

public String getResponseText() {
	return responseText;
}

public void setResponseText(String responseText) {
	this.responseText = responseText;
}

public boolean isFlag() {
	return flag;
}

public void setFlag(boolean flag) {
	this.flag = flag;
}

public User getU() {
	return u;
}

public void setU(User u) {
	this.u = u;
}



}
