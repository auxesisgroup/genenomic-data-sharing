package com.auxesisgroup.shivom.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auxesisgroup.shivom.daoInt.IKeypairDao;
import com.auxesisgroup.shivom.entity.Response;
import com.auxesisgroup.shivom.serviceInt.IKeypair;

@Service
public class SKeypair implements IKeypair {

	@Autowired
	IKeypairDao KeypairDao;

	@Override
	public Response getById(String userId) {
		return KeypairDao.getById(userId);
	}

}
