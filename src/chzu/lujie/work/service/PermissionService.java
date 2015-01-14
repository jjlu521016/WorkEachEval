package chzu.lujie.work.service;

import java.util.List;

import chzu.lujie.work.base.DaoSupport;
import chzu.lujie.work.domain.Permission;
import java.util.Collection;

public interface PermissionService extends DaoSupport<Permission> {

	List<Permission> findTopList();

	Collection<String> getAllPermissionUrls();

}
