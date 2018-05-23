package com.auxesisgroup.shivom.serviceInt;

import com.auxesisgroup.shivom.entity.Response;
import com.auxesisgroup.shivom.entity.Signup;

public interface ISignup {

	public Response signup(Signup signup);

	public Signup login(Signup signup);
}
