package chzu.lujie.work.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import chzu.lujie.work.base.DaoSupportImpl;
import chzu.lujie.work.dao.RoleDao;
import chzu.lujie.work.domain.Role;
import chzu.lujie.work.service.RoleService;

@Service
@Transactional
public class RoleServiceImpl extends DaoSupportImpl<Role> implements RoleService {

//	@Resource
//	private RoleDao roleDao;
//
//	@Override
//	public void save(Role role) {
//		roleDao.save(role);
//
//	}
//
//	@Override
//	public List<Role> findAll() {
//		return roleDao.findAll();
//	}
//
//	@Override
//	public void delete(Long id) {
//		roleDao.delete(id);
//
//	}
//
//	@Override
//	public Role getById(Long id) {
//		// TODO Auto-generated method stub
//		return roleDao.getById(id);
//	}
//
//	@Override
//	public void update(Role role) {
//		roleDao.update(role);
//		
//	}

}
