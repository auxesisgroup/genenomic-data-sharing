package com.auxesisgroup.shivom.rest;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.auxesisgroup.shivom.contracts.ISmartContract;
import com.auxesisgroup.shivom.entity.CompanyProfile;
import com.auxesisgroup.shivom.entity.DnaFile;
import com.auxesisgroup.shivom.entity.Donor;
import com.auxesisgroup.shivom.entity.DonorHealthSurvey;
import com.auxesisgroup.shivom.entity.Response;
import com.auxesisgroup.shivom.entity.Signup;
import com.auxesisgroup.shivom.entity.Transaction;
import com.auxesisgroup.shivom.serviceInt.ICompanyProfile;
import com.auxesisgroup.shivom.serviceInt.IDnaFile;
import com.auxesisgroup.shivom.serviceInt.IDonor;
import com.auxesisgroup.shivom.serviceInt.IDonorHealthSurvey;
import com.auxesisgroup.shivom.serviceInt.IKeypair;
import com.auxesisgroup.shivom.serviceInt.ISignup;
import com.auxesisgroup.shivom.serviceInt.ITransaction;

@RestController
@RequestMapping("shivom")
public class ShivomResource {
	final static Logger LOGGER = LoggerFactory.getLogger(ShivomResource.class);

	@Autowired
	ISmartContract smart;

	@Autowired
	IDonor donorDetailsInt;

	@Autowired
	ISignup signup;

	@Autowired
	IDonorHealthSurvey DonorHealthSurvey;

	@Autowired
	IDnaFile file;

	@Autowired
	ICompanyProfile companyProfile;

	@Autowired
	ITransaction trasanctionDetails;

	@Autowired
	IKeypair wallet;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<Object> init() {
		try {
			System.out.println("shivom started.............");
			return new ResponseEntity<Object>("shivom started.....", HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<Object>(ex, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/user/signup", method = RequestMethod.POST)
	public ResponseEntity<Object> signup(@RequestBody Signup Signup) {
		Response res = new Response();
		try {
			String errorMsg = "";
			ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
			Validator validator = factory.getValidator();
			Set<ConstraintViolation<Signup>> violations = validator.validate(Signup);
			for (ConstraintViolation<Signup> violation : violations) {
				errorMsg += violation.getMessage() + " ";
			}
			if (violations.size() != 0) {
				res.setResult(errorMsg);
				return new ResponseEntity<Object>(res, HttpStatus.OK);
			}

			LOGGER.info("signup : " + Signup.toString());
			res = signup.signup(Signup);
			if (res.getMessage() != null) {
				return new ResponseEntity<Object>(res, HttpStatus.UNAUTHORIZED);
			}
			return new ResponseEntity<Object>(res, HttpStatus.OK);
		} catch (Exception ex) {
			res.setMessage("Exception : " + ex);
			return new ResponseEntity<Object>(ex, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/user/login", method = RequestMethod.POST)
	public ResponseEntity<Object> login(@RequestBody Signup Signup) {
		Response res = new Response();
		try {
			String errorMsg = "";
			ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
			Validator validator = factory.getValidator();
			Set<ConstraintViolation<Signup>> violations = validator.validate(Signup);
			for (ConstraintViolation<Signup> violation : violations) {
				errorMsg += violation.getMessage() + " ";
			}
			if (violations.size() != 0) {
				res.setResult(errorMsg);
				return new ResponseEntity<Object>(res, HttpStatus.OK);
			}

			Signup _Signup = signup.login(Signup);

			if (_Signup.getId() == null) {
				res.setMessage("invalid credentials" + _Signup.getId());
				return new ResponseEntity<Object>(res, HttpStatus.UNAUTHORIZED);
			}
			res.setResult(_Signup);
			return new ResponseEntity<Object>(res, HttpStatus.OK);
		} catch (Exception ex) {
			res.setResult(null);
			res.setMessage("Exception : " + ex);
			return new ResponseEntity<Object>(res, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public ResponseEntity<Object> user(@RequestBody Donor _DonorDetails) {
		Response res = new Response();
		try {
			String errorMsg = "";
			ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
			Validator validator = factory.getValidator();
			Set<ConstraintViolation<Donor>> violations = validator.validate(_DonorDetails);
			for (ConstraintViolation<Donor> violation : violations) {
				errorMsg += violation.getMessage() + " ";
			}
			if (violations.size() != 0) {
				res.setResult(errorMsg);
				return new ResponseEntity<Object>(res, HttpStatus.OK);
			}

			//_DonorDetails.setId(UUID.randomUUID().toString());
			boolean update = donorDetailsInt.save(_DonorDetails);
			if (!update) {
				res.setMessage("Unable to add details");
				return new ResponseEntity<Object>(res, HttpStatus.BAD_REQUEST);
			}
			res.setResult("user added successfully");
			return new ResponseEntity<Object>(res, HttpStatus.OK);
		} catch (Exception ex) {
			res.setResult(null);
			res.setMessage("Exception : " + ex);
			return new ResponseEntity<Object>(res, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/user/healthsurvey", method = RequestMethod.POST)
	public ResponseEntity<Object> healthsurvey(@RequestBody DonorHealthSurvey surveyDetails) {
		Response res = new Response();
		try {
			String errorMsg = "";
			ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
			Validator validator = factory.getValidator();
			Set<ConstraintViolation<DonorHealthSurvey>> violations = validator.validate(surveyDetails);
			for (ConstraintViolation<DonorHealthSurvey> violation : violations) {
				errorMsg += violation.getMessage() + " ";
			}
			if (violations.size() != 0) {
				res.setResult(errorMsg);
				return new ResponseEntity<Object>(res, HttpStatus.OK);
			}
			boolean update = DonorHealthSurvey.save(surveyDetails);
			if (!update) {
				res.setMessage("Unable to add details");
				return new ResponseEntity<Object>(res, HttpStatus.BAD_REQUEST);
			}
			res.setResult("Health Survey details added successfully");
			return new ResponseEntity<Object>(res, HttpStatus.OK);
		} catch (Exception ex) {
			res.setResult(null);
			res.setMessage("Exception : " + ex);
			return new ResponseEntity<Object>(res, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/user/healthsurvey/{userid}", method = RequestMethod.GET)
	public ResponseEntity<Object> healthsurvey(@PathVariable("userid") String userId) {
		Response res = new Response();
		try {
			DonorHealthSurvey trs = DonorHealthSurvey.getById(userId);
			if (trs.Id == null) {
				res.setMessage("No data found.");
				res.setResult(res);
			}

			res.setResult(trs);
			return new ResponseEntity<Object>(res, HttpStatus.OK);
		} catch (Exception ex) {
			res.setResult(null);
			res.setMessage("Exception : " + ex);
			return new ResponseEntity<Object>(res, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/user/file", method = RequestMethod.POST)
	public ResponseEntity<Object> uploadFile(@RequestBody DnaFile dnaFile) {
		Response res = new Response();
		try {
			String errorMsg = "";
			ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
			Validator validator = factory.getValidator();
			Set<ConstraintViolation<DnaFile>> violations = validator.validate(dnaFile);
			for (ConstraintViolation<DnaFile> violation : violations) {
				errorMsg += violation.getMessage() + " ";
			}
			if (violations.size() != 0) {
				res.setResult(errorMsg);
				return new ResponseEntity<Object>(res, HttpStatus.OK);
			}
			res = file.save(dnaFile);
			if (res.getMessage() != null) {
				// res.setMessage("Unable to add details");
				res.setResult(null);
				return new ResponseEntity<Object>(res, HttpStatus.BAD_REQUEST);
			}
			res.setResult("Details added successfully");
			return new ResponseEntity<Object>(res, HttpStatus.OK);
		} catch (Exception ex) {
			res.setResult(null);
			res.setMessage("Exception : " + ex);
			return new ResponseEntity<Object>(res, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ResponseEntity<Object> users() {
		Response res = new Response();
		try {
			List<Donor> DonorDetails = donorDetailsInt.list();
			res.setResult(DonorDetails);
			return new ResponseEntity<Object>(DonorDetails, HttpStatus.OK);
		} catch (Exception ex) {
			res.setResult(null);
			res.setMessage("Exception : " + ex);
			return new ResponseEntity<Object>(res, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/deploysmartcontract", method = RequestMethod.GET)
	public ResponseEntity<Object> deploySmartContract() {
		Response res = new Response();
		try {
			res = smart.smartContractDeploy();
			return new ResponseEntity<Object>(res, HttpStatus.OK);
		} catch (Exception ex) {
			res.setResult(null);
			res.setMessage("Exception : " + ex);
			return new ResponseEntity<Object>(ex, HttpStatus.BAD_REQUEST);
		}
	}

	// @RequestMapping(value = "/getfiledetails", method = RequestMethod.GET)
	// public ResponseEntity<Object> getFileDetails(@RequestBody DnaFile
	// DonorFileDetails) {
	// Response res = new Response();
	// try {
	// System.out.println("adasdadadsadasdsadsad*****************************" +
	// DonorFileDetails.getFileHash());
	// res = donorDetailsInt.getFileDetails(DonorFileDetails.getFileHash());
	// if (res.getMessage() == null) {
	// res.setMessage("Unable to add details");
	// return new ResponseEntity<Object>(res, HttpStatus.BAD_REQUEST);
	// }
	// return new ResponseEntity<Object>(res, HttpStatus.OK);
	// } catch (Exception ex) {
	// res.setResult(null);
	// res.setMessage("Exception : " + ex);
	// return new ResponseEntity<Object>(res, HttpStatus.BAD_REQUEST);
	// }
	// }

	@RequestMapping(value = "/file/download", method = RequestMethod.POST)
	public ResponseEntity<Object> file(@RequestBody DnaFile DonorFileDetails) {
		Response res = new Response();
		try {
			System.out.println("adasdadadsadasdsadsad*****************************");
			res = file.fileAccess(DonorFileDetails);
			if (res.getMessage() != null) {
				res.setMessage("Unable to do transaction");
				return new ResponseEntity<Object>(res, HttpStatus.BAD_REQUEST);
			}
			return new ResponseEntity<Object>(res, HttpStatus.OK);
		} catch (Exception ex) {
			res.setResult(null);
			res.setMessage("Exception : " + ex);
			return new ResponseEntity<Object>(res, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/user/balance/{userid}", method = RequestMethod.GET)
	public ResponseEntity<Object> balance(@PathVariable("userid") String user_id) {
		Response res = new Response();
		try {
			res = donorDetailsInt.getBalance(user_id);
			if (res.getMessage() == null) {
				res.setMessage("Unable to do transaction");
				return new ResponseEntity<Object>(res, HttpStatus.BAD_REQUEST);
			}
			return new ResponseEntity<Object>(res, HttpStatus.OK);
		} catch (Exception ex) {
			res.setResult(null);
			res.setMessage("Exception : " + ex);
			return new ResponseEntity<Object>(res, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/pharma", method = RequestMethod.POST)
	public ResponseEntity<Object> pharma(@RequestBody CompanyProfile _companyProfile) {
		Response res = new Response();
		try {
			String errorMsg = "";
			ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
			Validator validator = factory.getValidator();
			Set<ConstraintViolation<CompanyProfile>> violations = validator.validate(_companyProfile);
			for (ConstraintViolation<CompanyProfile> violation : violations) {
				errorMsg += violation.getMessage() + " ";
			}
			if (violations.size() != 0) {
				res.setResult(errorMsg);
				return new ResponseEntity<Object>(res, HttpStatus.OK);
			}
			// _companyProfile.Id = UUID.randomUUID().toString();
			boolean add = companyProfile.save(_companyProfile);
			if (!add) {
				res.setMessage("Unable save data.");
				return new ResponseEntity<Object>(res, HttpStatus.BAD_REQUEST);
			}
			res.setMessage("Data save data.");
			res.setResult(add);
			return new ResponseEntity<Object>(res, HttpStatus.OK);
		} catch (Exception ex) {
			res.setResult(null);
			res.setMessage("Exception : " + ex);
			return new ResponseEntity<Object>(res, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/pharma/{companyId}", method = RequestMethod.GET)
	public ResponseEntity<Object> pharma(@PathVariable("companyId") String companyId) {
		Response res = new Response();
		try {
			CompanyProfile company = companyProfile.byUserId(companyId);
			res.setResult(company);
			return new ResponseEntity<Object>(res, HttpStatus.OK);
		} catch (Exception ex) {
			res.setResult(null);
			res.setMessage("Exception : " + ex);
			return new ResponseEntity<Object>(res, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/transaction/{userid}", method = RequestMethod.GET)
	public ResponseEntity<Object> transaction(@PathVariable("userid") String userId) {
		Response res = new Response();
		try {
			List<Transaction> trs = trasanctionDetails.list(userId);
			if (trs.size() == 0) {
				res.setMessage("No data found.");
			}
			res.setResult(trs);
			return new ResponseEntity<Object>(res, HttpStatus.OK);
		} catch (Exception ex) {
			res.setResult(null);
			res.setMessage("Exception : " + ex);
			return new ResponseEntity<Object>(res, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/transaction", method = RequestMethod.GET)
	public ResponseEntity<Object> transaction() {
		Response res = new Response();
		try {
			List<Transaction> trs = trasanctionDetails.list();
			res.setResult(trs);
			return new ResponseEntity<Object>(res, HttpStatus.OK);
		} catch (Exception ex) {
			res.setResult(null);
			res.setMessage("Exception : " + ex);
			return new ResponseEntity<Object>(res, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/dnafile", method = RequestMethod.GET)
	public ResponseEntity<Object> dnafile() {
		Response res = new Response();
		try {
			List<DnaFile> trs = file.list();
			res.setResult(trs);
			return new ResponseEntity<Object>(res, HttpStatus.OK);
		} catch (Exception ex) {
			res.setResult(null);
			res.setMessage("Exception : " + ex);
			return new ResponseEntity<Object>(res, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/dnafile/{filehash}", method = RequestMethod.GET)
	public ResponseEntity<Object> dnafile(@PathVariable("filehash") String fileHash) {
		Response res = new Response();
		try {
			DnaFile trs = file.byHash(fileHash);
			res.setResult(trs);
			return new ResponseEntity<Object>(res, HttpStatus.OK);
		} catch (Exception ex) {
			res.setResult(null);
			res.setMessage("Exception : " + ex);
			return new ResponseEntity<Object>(res, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/user/wallet/{userid}", method = RequestMethod.GET)
	public ResponseEntity<Object> wallet(@PathVariable("userid") String userId) {
		Response res = new Response();
		try {
			res = wallet.getById(userId);

			return new ResponseEntity<Object>(res, HttpStatus.OK);
		} catch (Exception ex) {
			res.setResult(null);
			res.setMessage("Exception : " + ex);
			return new ResponseEntity<Object>(res, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/file/{userid}", method = RequestMethod.GET)
	public ResponseEntity<Object> file(@PathVariable("userid") String userId) {
		Response res = new Response();
		try {
			List<DnaFile> _file = file.getByUserId(userId);
			if (_file.size() == 0) {
				res.setMessage("No data found.");
				return new ResponseEntity<Object>(res, HttpStatus.OK);
			}
			res.setResult(_file);
			return new ResponseEntity<Object>(res, HttpStatus.OK);
		} catch (Exception ex) {
			res.setResult(null);
			res.setMessage("Exception : " + ex);
			return new ResponseEntity<Object>(res, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/blockchain/file/{filehash}", method = RequestMethod.GET)
	public ResponseEntity<Object> fileBc(@PathVariable("filehash") String filehash) {
		Response res = new Response();
		try {
			res = smart.getFileHashDetails(filehash);
			return new ResponseEntity<Object>(res, HttpStatus.OK);
		} catch (Exception ex) {
			res.setResult(null);
			res.setMessage("Exception : " + ex);
			return new ResponseEntity<Object>(res, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/blockchain/user/{userId}", method = RequestMethod.GET)
	public ResponseEntity<Object> userfileBc(@PathVariable("userId") String userId) {
		Response res = new Response();
		try {
			res = smart.getUplodedFileUserList(userId);
			return new ResponseEntity<Object>(res, HttpStatus.OK);
		} catch (Exception ex) {
			res.setResult(null);
			res.setMessage("Exception : " + ex);
			return new ResponseEntity<Object>(res, HttpStatus.BAD_REQUEST);
		}
	}

	// @RequestMapping(value = "/addHashFile", method = RequestMethod.POST)
	// public ResponseEntity<Object> addHashFile(@RequestBody JSONObject
	// tokenRequest) {
	// try {
	// String file_hash = tokenRequest.get("file_hash").toString();
	// String user_id = tokenRequest.get("user_id").toString();
	// createkeypairs createkeypairs = donorDetailsInt.getById(user_id);
	// JSONObject json = (JSONObject) rcpcall.issue_asset(file_hash, 100,
	// createkeypairs.address);
	// //
	// // tokenRequest.issuer_transaction_id =
	// // (json.get("result").toString());
	// // tokenRequest.status = 1;
	// // List<Object[]> list =
	// // transactionService.TokenRequestConfirm(tokenRequest, sessionID,
	// // scheme.wallet_address, json.get("result").toString());
	// // return new ResponseEntity<Object>(list, HttpStatus.OK);
	// // }
	//
	// return new ResponseEntity<Object>(json, HttpStatus.OK);
	// } catch (Exception Ex) {
	// return new ResponseEntity<Object>(Ex, HttpStatus.BAD_REQUEST);
	// }
	// }

}
