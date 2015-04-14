package chzu.lujie.work.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * 角色
 * 
 * @author lujie
 * 
 */
public class Role {
	private Long id;
	private String name;
	private String description;
	private Set<User> users = new HashSet<User>();
	private Set<Teacher> teachers = new HashSet<Teacher>();
	
	private Set<Permission> permissions = new HashSet<Permission>();
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

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

	public Set<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(Set<Permission> permissions) {
		this.permissions = permissions;
	}

	public Set<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}



}
