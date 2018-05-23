package com.auxesisgroup.shivom.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auxesisgroup.shivom.daoInt.ICompanyProfileDao;
import com.auxesisgroup.shivom.entity.CompanyProfile;
import com.auxesisgroup.shivom.serviceInt.ICompanyProfile;
@Service
public class SCompanyProfile implements ICompanyProfile {
	@Autowired
	ICompanyProfileDao CompanyProfile;

	@Override
	public boolean save(CompanyProfile company_profile) {
		return CompanyProfile.save(company_profile);

	}

	@Override
	public com.auxesisgroup.shivom.entity.CompanyProfile byId(String id) {
		return CompanyProfile.byId(id);
	}

	@Override
	public com.auxesisgroup.shivom.entity.CompanyProfile byUserId(String UserId) {
		return CompanyProfile.byUserId(UserId);
	}
}
