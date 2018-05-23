package com.auxesisgroup.shivom.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auxesisgroup.shivom.daoInt.IDonorHealthSurveyDao;
import com.auxesisgroup.shivom.entity.DonorHealthSurvey;
import com.auxesisgroup.shivom.serviceInt.IDonorHealthSurvey;

@Service
public class SDonorHealthSurvey implements IDonorHealthSurvey {

	@Autowired
	IDonorHealthSurveyDao DonorHealthSurveyDao;

	@Override
	public boolean save(DonorHealthSurvey survey_details) {
	
		return DonorHealthSurveyDao.save(survey_details);
	}

	@Override
	public DonorHealthSurvey getById(String userId) {
		return DonorHealthSurveyDao.getById(userId);
	}

}
