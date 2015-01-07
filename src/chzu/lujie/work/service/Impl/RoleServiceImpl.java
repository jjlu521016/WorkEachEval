package chzu.lujie.work.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import chzu.lujie.work.dao.RoleDao;
import chzu.lujie.work.domain.Role;
import chzu.lujie.work.service.RoleService;

@Service
@Transactional
public class RoleServiceImpl implements RoleService{
@Override
	public void save(Role role) {
		roleDao.save(role);
		
	}

@Resource
	private RoleDao roleDao;
	@Override
	public List<Role> findAll() {
		return roleDao.findAll();
	}

	@Override
	public void delete(Long id) {
		roleDao.delete(id);
		
	}

}
