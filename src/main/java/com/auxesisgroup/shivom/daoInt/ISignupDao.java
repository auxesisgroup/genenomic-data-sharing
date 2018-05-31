package com.auxesisgroup.shivom.daoInt;

import com.auxesisgroup.shivom.entity.Keypair;
import com.auxesisgroup.shivom.entity.Signup;

public interface ISignupDao {
	public boolean signup(Signup signUp, Keypair createkeypairs);

	public Signup login(Signup sign_up);
}
