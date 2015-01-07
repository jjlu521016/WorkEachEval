package chzu.lujie.work.service;

import java.util.List;

import chzu.lujie.work.base.DaoSupport;
import chzu.lujie.work.domain.Department;

public interface DepartmentService {

	List<Department> findAll();

	void delete(Long id);

	void save(Department model);

	Department getById(Long id);

	void update(Department department);

	List<Department> findTopList();

	List<Department> findChildrenList(Long parentId);

}
