package chzu.lujie.work.service.Impl;

import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import chzu.lujie.work.base.DaoSupportImpl;
import chzu.lujie.work.domain.Teacher;
import chzu.lujie.work.service.TeacherService;
import chzu.lujie.work.util.MD5Utils;

@Service
@Transactional
public class TeacherServiceImpl extends DaoSupportImpl<Teacher> implements
		TeacherService {

	public Teacher findByLoginNameAndPassword(String loginName, String password) {

		// 使用密码的MD5摘要进行对比
		String md5Digest = MD5Utils.GetMD5Code(password);
		return (Teacher) getSession().createQuery(//
				"FROM Teacher u WHERE u.loginName=? AND u.password=?")//
				.setParameter(0, loginName)//
				.setParameter(1, md5Digest)//
				.uniqueResult();
	}

}
