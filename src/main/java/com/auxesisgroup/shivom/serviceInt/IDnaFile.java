package com.auxesisgroup.shivom.serviceInt;

import java.util.List;

import com.auxesisgroup.shivom.entity.DnaFile;
import com.auxesisgroup.shivom.entity.Response;

public interface IDnaFile {
	public Response save(DnaFile donorFileDetail);
	public Response fileAccess(DnaFile donorFileDetails);
	public List<DnaFile> list();
	public DnaFile byId(String id);
	public DnaFile byHash(String fileHash);
	public List<DnaFile> getByUserId(String userId);
}
