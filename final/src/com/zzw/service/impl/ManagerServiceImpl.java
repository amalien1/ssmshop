package com.zzw.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzw.dao.ManagerDao;
import com.zzw.pojo.Manager;
import com.zzw.service.ManagerService;
@Service
public class ManagerServiceImpl implements ManagerService {
	@Autowired
	private ManagerDao managerDao;
	//管理员登录
	@Override
	public Manager login(Manager manager) {
		return managerDao.login(manager);
	}

}
