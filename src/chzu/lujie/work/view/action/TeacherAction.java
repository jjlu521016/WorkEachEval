package chzu.lujie.work.view.action;

import java.util.HashSet;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import chzu.lujie.work.base.BaseAction;
import chzu.lujie.work.domain.Department;
import chzu.lujie.work.domain.Role;
import chzu.lujie.work.domain.Teacher;
import chzu.lujie.work.domain.User;
import chzu.lujie.work.util.DepartmentUtils;
import chzu.lujie.work.util.MD5Utils;

import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class TeacherAction extends BaseAction<Teacher> {

	private Long departmentId;
	private Long[] roleIds;

	// 查询所有数据

	public String list() throws Exception {

		List<Teacher> userList = teacherService.findAll();

		ActionContext.getContext().put("userList", userList);
		return "list";
	}

	public String delete() throws Exception {

		teacherService.delete(model.getId());
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
		teacherService.save(model);
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
		Teacher teacher = teacherService.getById(model.getId());

		teacher.setLoginName(model.getLoginName());
		teacher.setName(model.getName());
		teacher.setEmail(model.getEmail());
		teacher.setGender(model.getGender());
		teacher.setPassword(model.getPassword());
		teacher.setPhoneNumber(model.getPhoneNumber());

		// >> 设置所属部门
		teacher.setDepartment(departmentService.getById(departmentId));
		// >> 设置关联的岗位
		List<Role> roleList = roleService.getByIds(roleIds);
		teacher.setRoles(new HashSet<Role>(roleList));

		teacherService.update(teacher);
		return "tolist";
	}
///////////////////////////////////////////////////////////////////////////////	
//	个人信息更改
	public String editInfoUI() throws Exception {
		

		// 准备回显的数据
		Teacher user = teacherService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(user);
		
		return "editInfoUI";
	}
	
	public String editInfo() throws Exception {
		Teacher teacher = teacherService.getById(model.getId());

		teacherService.update(model);
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
		Teacher user = teacherService.getById(model.getId());
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
		Teacher user = teacherService.getById(model.getId());

		// 2，设置要修改的属性（要使用MD5摘要）
		String md5Digest = MD5Utils.GetMD5Code("123456");
		// String md5Digest = MD5Utils.md5Hex("123456");
		user.setPassword(md5Digest);
		// 3，更新到数据库
		teacherService.update(user);

		return "tolist";
	}

	
	/** 登录页面 */
	public String loginUI() throws Exception {
		return "loginUI";
	}

	/** 登录 */
	public String login() throws Exception {
		Teacher user = teacherService.findByLoginNameAndPassword(model.getLoginName(), model.getPassword());
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

}
