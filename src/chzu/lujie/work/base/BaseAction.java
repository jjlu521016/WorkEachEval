package chzu.lujie.work.base;

import java.lang.reflect.ParameterizedType;

import javax.annotation.Resource;

import chzu.lujie.work.service.DepartmentService;
import chzu.lujie.work.service.ForumService;
import chzu.lujie.work.service.PermissionService;
import chzu.lujie.work.service.RoleService;
import chzu.lujie.work.service.UserService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class BaseAction<T> extends ActionSupport implements ModelDriven<T> {

	public T model;
	
	public BaseAction(){
		try{
			ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
			
			//通过反射获取model的真实类型
			Class<T> clazz =(Class<T>) pt.getActualTypeArguments()[0];
			//通过反射创建model的真实类型
			model = clazz.newInstance();
		}
		catch (Exception e){
			throw new RuntimeException(e);
			
		}
		
	}

	public T getModel() {
		return model;
	}

	public void setModel(T model) {
		this.model = model;
	}
@Resource	
protected RoleService roleService;

@Resource
protected DepartmentService departmentService;

@Resource
protected UserService userService;

@Resource
protected PermissionService permissionService;

@Resource
protected ForumService forumService;
}
