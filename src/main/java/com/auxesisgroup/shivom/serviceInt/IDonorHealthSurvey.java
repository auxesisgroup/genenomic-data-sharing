package com.auxesisgroup.shivom.serviceInt;

import com.auxesisgroup.shivom.entity.DonorHealthSurvey;

public interface IDonorHealthSurvey {
	public boolean save(DonorHealthSurvey donorHealthSurvey);
	public DonorHealthSurvey getById(String userId);
}
