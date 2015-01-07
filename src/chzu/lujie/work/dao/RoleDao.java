package chzu.lujie.work.dao;

import java.util.List;

import chzu.lujie.work.domain.Role;

public interface RoleDao
{

	List<Role> findAll();

	void delete(Long id);

	void save(Role role);

}
