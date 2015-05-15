package chzu.lujie.work.service.Impl;

import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import chzu.lujie.work.base.DaoSupportImpl;
import chzu.lujie.work.dao.UserDao;
import chzu.lujie.work.domain.User;
import chzu.lujie.work.service.UserService;
import chzu.lujie.work.util.MD5Utils;

@Service
@Transactional
public class UserServiceImpl extends DaoSupportImpl<User> implements
		UserService {

	public User findByLoginNameAndPassword(String loginName, String password) {

		// 使用密码的MD5摘要进行对比
		String md5Digest = MD5Utils.GetMD5Code(password);
		return (User) getSession().createQuery(//
				"FROM User u WHERE u.loginName=? AND u.password=?")//
				.setParameter(0, loginName)//
				.setParameter(1, md5Digest)//
				.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean getLoginName(String username) {
		String hql="from User u where u.loginName='"+username+"'";//r.email='"+email+"'";		
		List<User> list = getSession().createQuery(hql).list();
		if(list!=null&&list.size()>0){
			//数据库已经存在
			return true;
		}
		//数据库中不存在
		return false;      
	}

}
