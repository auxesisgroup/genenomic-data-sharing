package com.auxesisgroup.shivom.daoInt;

import java.util.List;

import com.auxesisgroup.shivom.entity.DnaFile;

public interface IDnaFileDao {
	public boolean save(DnaFile dnaFile);

	public List<DnaFile> list();

	public DnaFile byId(String id);

	public DnaFile byHash(String fileHash);

	public List<DnaFile> getByUserId(String userId);
}
