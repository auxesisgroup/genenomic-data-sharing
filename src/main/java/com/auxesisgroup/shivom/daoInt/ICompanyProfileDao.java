package com.auxesisgroup.shivom.daoInt;

import com.auxesisgroup.shivom.entity.CompanyProfile;

public interface ICompanyProfileDao {
	public boolean save(CompanyProfile company_profile);

	public CompanyProfile byId(String id);

	public CompanyProfile byUserId(String UserId);
}
