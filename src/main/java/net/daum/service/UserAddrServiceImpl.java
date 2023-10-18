package net.daum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.daum.dao.UserAddrDAO;
import net.daum.vo.UserAddrVO;

@Service
public class UserAddrServiceImpl implements UserAddrService {
	
	@Autowired
	private UserAddrDAO userAddrDAO;
	
	@Override
	public void insertUserAddr(UserAddrVO useraddr) {
		this.userAddrDAO.insertUserAddr(useraddr);
	}
	
}
