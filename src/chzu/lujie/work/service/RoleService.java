package chzu.lujie.work.service;

import java.util.List;

import chzu.lujie.work.domain.Role;

public interface RoleService {
	// 查询所有的方法
	List<Role> findAll();

	void delete(Long id);

	void save(Role role);

}
