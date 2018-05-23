package com.auxesisgroup.shivom.serviceInt;

import java.util.List;

import com.auxesisgroup.shivom.entity.DnaFile;
import com.auxesisgroup.shivom.entity.Donor;
import com.auxesisgroup.shivom.entity.Keypair;
import com.auxesisgroup.shivom.entity.Response;

public interface IDonor {

	public boolean save(Donor donor);

	public List<Donor> list();

	public Keypair getById(String id);

	public Response getFileDetails(String fileHash);

	public Response getBalance(String userId);

	//public Response getFile(DnaFile donorFileDetail);
}
