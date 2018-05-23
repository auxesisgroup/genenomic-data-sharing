package com.auxesisgroup.shivom.contracts;

import org.springframework.context.annotation.ComponentScan;

import com.auxesisgroup.shivom.entity.DnaFile;
import com.auxesisgroup.shivom.entity.Response;

@ComponentScan
public interface ISmartContract {
	// Response smartContractDeploy(MerchantAndVendor MarchantAndVendor);
	//
	// Response setPoDetail(PurchaseOrder PurchaseOrder);
	//
	// Response setInvoiceDetail(InvoiceAndChallan InvoiceAndChallan);
	//
	// Response getPaymentTransactionDetails(String _contractAddress);
	//
	// public Response setLoanDetails(loanDetails loanDetails);
	//
	// public Response setLoanPayment(loanPayment loanPayment);

	/////

	public Response smartContractDeploy();

	public Response addUser(DnaFile DonorFileDetails);

	public Response fileHashMapping(DnaFile DonorFileDetails);

	public Response getFile(DnaFile DonorFileDetails);

	public Response getWalletBalance(String userAddress);

	public Response getFileHashDetails(String fileHash);

	public Response getUplodedFileUserList(String userId);
}
