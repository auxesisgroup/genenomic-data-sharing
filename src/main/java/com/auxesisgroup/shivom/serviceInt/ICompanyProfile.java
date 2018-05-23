package com.auxesisgroup.shivom.serviceInt;

import com.auxesisgroup.shivom.entity.CompanyProfile;

public interface ICompanyProfile {
	public boolean save(CompanyProfile company_profile);
	public CompanyProfile byId(String id);
	public CompanyProfile byUserId(String UserId);
}
