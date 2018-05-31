package com.auxesisgroup.shivom.daoInt;

import com.auxesisgroup.shivom.entity.DonorHealthSurvey;

public interface IDonorHealthSurveyDao {
	public boolean save(DonorHealthSurvey donorHealthSurvey);

	public DonorHealthSurvey getById(String userId);
}
