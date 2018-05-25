package com.auxesisgroup.shivom.smartcontract;

/*
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple2;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;

*//**
	* <p>
	* Auto generated code.
	* <p>
	* <strong>Do not modify!</strong>
	* <p>
	* Please use the <a href="https://docs.web3j.io/command_line.html">web3j
	* command line tools</a>, or the
	* org.web3j.codegen.SolidityFunctionWrapperGenerator in the
	* <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen
	* module</a> to update.
	*
	* <p>
	* Generated with web3j version 3.0.2.
	*//*
	public final class Shivom extends Contract {
	private static final String BINARY = "6060604052341561000f57600080fd5b6105fd8061001e6000396000f3006060604052600436106100775763ffffffff7c01000000000000000000000000000000000000000000000000000000006000350416632570e31e811461007c5780636386c1c7146100b257806372623819146100f357806380bd5ffe14610115578063c8d9e3a514610137578063fbef4b17146101e6575b600080fd5b341561008757600080fd5b61009e600435600160a060020a036024351661020b565b604051901515815260200160405180910390f35b34156100bd57600080fd5b6100d1600160a060020a0360043516610233565b604051600160a060020a03909216825260208201526040908101905180910390f35b34156100fe57600080fd5b61009e600160a060020a0360043516602435610259565b341561012057600080fd5b61009e600160a060020a03600435166024356102d0565b341561014257600080fd5b61014d60043561030f565b604051808060200180602001838103835285818151815260200191508051906020019060200280838360005b83811015610191578082015183820152602001610179565b50505050905001838103825284818151815260200191508051906020019060200280838360005b838110156101d05780820151838201526020016101b8565b5050505090500194505050505060405180910390f35b34156101f157600080fd5b61009e600435602435600160a060020a036044351661041c565b600160a060020a03166000908152602081905260409020600190810180549290920190915590565b600160a060020a0390811660009081526020819052604090208054600190910154911691565b6000610263610538565b604080519081016040908152600160a060020a038616808352602080840187905260009182528190522090915081908151815473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a0391909116178155602082015160019182015595945050505050565b60008181526001602081905260409091208054600160a060020a03851673ffffffffffffffffffffffffffffffffffffffff1990911617905592915050565b61031761054f565b61031f61054f565b60008061032a61054f565b61033261054f565b6000878152600260205260408082208054909650945081908590518059106103575750595b90808252806020026020018201604052509350846040518059106103785750595b90808252806020026020018201604052509250600091505b855482101561040e5785828154811015156103a757fe5b600091825260209091206002909102018054909150600160a060020a03168483815181106103d157fe5b600160a060020a0390921660209283029091019091015260018101548383815181106103f957fe5b60209081029091010152600190910190610390565b509197909650945050505050565b60008060008061042a610538565b600160a060020a0386166000908152602081905260409020600181015490945087901080159061045957508615155b1561052857600088815260016020818152604080842054600160a060020a0316808552918490529283902080830180548c01905591870180548b900390559450925080519081016040908152600160a060020a038816825260208083018a905260008b8152600290915220805491925090600181016104d88382610561565b600092835260209092208391600202018151815473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a0391909116178155602082015181600101555050506001945061052d565b600094505b505050509392505050565b604080519081016040526000808252602082015290565b60206040519081016040526000815290565b81548183558181151161058d5760020281600202836000526020600020918201910161058d9190610592565b505050565b6105ce91905b808211156105ca57805473ffffffffffffffffffffffffffffffffffffffff1916815560006001820155600201610598565b5090565b905600a165627a7a72305820df7cac7dbb0c0b23e375b29ea7fe117982cf21307709093ce5c4e65bbea58dd80029";
	
	private Shivom(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice,
			BigInteger gasLimit) {
		super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
	}
	
	private Shivom(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice,
			BigInteger gasLimit) {
		super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
	}
	
	public RemoteCall<TransactionReceipt> getTokens(BigInteger amount, String userAddress) {
		Function function = new Function("getTokens",
				Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(amount),
						new org.web3j.abi.datatypes.Address(userAddress)),
				Collections.<TypeReference<?>>emptyList());
		return executeRemoteCallTransaction(function);
	}
	
	public RemoteCall<Tuple2<String, BigInteger>> getUserInfo(String to) {
		final Function function = new Function("getUserInfo",
				Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(to)),
				Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {
				}, new TypeReference<Uint256>() {
				}));
		return new RemoteCall<Tuple2<String, BigInteger>>(new Callable<Tuple2<String, BigInteger>>() {
			public Tuple2<String, BigInteger> call() throws Exception {
				List<Type> results = executeCallMultipleValueReturn(function);
				;
				return new Tuple2<String, BigInteger>((String) results.get(0).getValue(),
						(BigInteger) results.get(1).getValue());
			}
		});
	}
	
	public RemoteCall<TransactionReceipt> login(String to, BigInteger value) {
		Function function = new Function("login",
				Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(to),
						new org.web3j.abi.datatypes.generated.Uint256(value)),
				Collections.<TypeReference<?>>emptyList());
		return executeRemoteCallTransaction(function);
	}
	
	public RemoteCall<TransactionReceipt> fileUpload(String to, byte[] fileHash) {
		Function function = new Function("fileUpload",
				Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(to),
						new org.web3j.abi.datatypes.generated.Bytes32(fileHash)),
				Collections.<TypeReference<?>>emptyList());
		return executeRemoteCallTransaction(function);
	}
	
	public RemoteCall<Tuple2<List<Address>, List<Uint256>>> getFileUserList(byte[] fileHash) {
		final Function function = new Function("getFileUserList",
				Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(fileHash)),
				Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Address>>() {
				}, new TypeReference<DynamicArray<Uint256>>() {
				}));
		return new RemoteCall<Tuple2<List<Address>, List<Uint256>>>(
				new Callable<Tuple2<List<Address>, List<Uint256>>>() {
					public Tuple2<List<Address>, List<Uint256>> call() throws Exception {
						List<Type> results = executeCallMultipleValueReturn(function);
						;
						return new Tuple2<List<Address>, List<Uint256>>((List<Address>) results.get(0).getValue(),
								(List<Uint256>) results.get(1).getValue());
					}
				});
	}
	
	public RemoteCall<TransactionReceipt> download(byte[] fileHash, BigInteger amount, String downloaderAddress) {
		Function function = new Function("download",
				Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(fileHash),
						new org.web3j.abi.datatypes.generated.Uint256(amount),
						new org.web3j.abi.datatypes.Address(downloaderAddress)),
				Collections.<TypeReference<?>>emptyList());
		return executeRemoteCallTransaction(function);
	}
	
	public static RemoteCall<Shivom> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice,
			BigInteger gasLimit) {
		return deployRemoteCall(Shivom.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
	}
	
	public static RemoteCall<Shivom> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice,
			BigInteger gasLimit) {
		return deployRemoteCall(Shivom.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
	}
	
	public static Shivom load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice,
			BigInteger gasLimit) {
		return new Shivom(contractAddress, web3j, credentials, gasPrice, gasLimit);
	}
	
	public static Shivom load(String contractAddress, Web3j web3j, TransactionManager transactionManager,
			BigInteger gasPrice, BigInteger gasLimit) {
		return new Shivom(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
	}
	}
	*/

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple2;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;

/**
 * <p>
 * Auto generated code.
 * <p>
 * <strong>Do not modify!</strong>
 * <p>
 * Please use the <a href="https://docs.web3j.io/command_line.html">web3j
 * command line tools</a>, or the
 * org.web3j.codegen.SolidityFunctionWrapperGenerator in the
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen
 * module</a> to update.
 *
 * <p>
 * Generated with web3j version 3.0.2.
 */
public final class Shivom extends Contract {
	private static final String BINARY = "6060604052341561000f57600080fd5b6107998061001e6000396000f3006060604052600436106100825763ffffffff7c01000000000000000000000000000000000000000000000000000000006000350416632570e31e811461008757806331636266146100bd57806337cfb3b81461016c5780634ebc5b3e146101ee5780636386c1c71461021057806372623819146102515780639d50060d14610273575b600080fd5b341561009257600080fd5b6100a9600435600160a060020a0360243516610298565b604051901515815260200160405180910390f35b34156100c857600080fd5b6100d36004356102c0565b604051808060200180602001838103835285818151815260200191508051906020019060200280838360005b838110156101175780820151838201526020016100ff565b50505050905001838103825284818151815260200191508051906020019060200280838360005b8381101561015657808201518382015260200161013e565b5050505090500194505050505060405180910390f35b341561017757600080fd5b61018b600160a060020a03600435166103cc565b604051600160a060020a038216602082015260408082528190810184818151815260200191508051906020019060200280838360005b838110156101d95780820151838201526020016101c1565b50505050905001935050505060405180910390f35b34156101f957600080fd5b6100a9600160a060020a036004351660243561046f565b341561021b57600080fd5b61022f600160a060020a03600435166104db565b604051600160a060020a03909216825260208201526040908101905180910390f35b341561025c57600080fd5b6100a9600160a060020a0360043516602435610501565b341561027e57600080fd5b6100a9600435602435600160a060020a0360443516610578565b600160a060020a03166000908152602081905260409020600190810180549290920190915590565b6102c8610696565b6102d0610696565b6000806102db610696565b6102e3610696565b6000878152600360205260408082208054909650945081908590518059106103085750595b90808252806020026020018201604052509350846040518059106103295750595b90808252806020026020018201604052509250600091505b848210156103be57858281548110151561035757fe5b600091825260209091206002909102018054909150600160a060020a031684838151811061038157fe5b600160a060020a0390921660209283029091019091015260018101548383815181106103a957fe5b60209081029091010152600190910190610341565b509197909650945050505050565b6103d4610696565b60008060006103e1610696565b600160a060020a0386166000908152600160205260408082208054909550935083905180591061040e5750595b90808252806020026020018201604052509150600090505b8281101561046657838181548110151561043c57fe5b90600052602060002090015482828151811061045457fe5b60209081029091010152600101610426565b50959350505050565b6000818152600260209081526040808320805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a038716908117909155835260019182905282208054909181016104c383826106a8565b50600091825260209091200182905550600192915050565b600160a060020a0390811660009081526020819052604090208054600190910154911691565b600061050b6106d1565b604080519081016040908152600160a060020a038616808352602080840187905260009182528190522090915081908151815473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a0391909116178155602082015160019182015595945050505050565b6000806000806105866106d1565b600160a060020a038616600090815260208190526040902060018101549094508790108015906105b557508615155b1561068657600088815260026020908152604080832054600160a060020a03168084529183905291829020600181810180548c019055870180548b90039055909450925080519081016040908152600160a060020a038816825260208083018a905260008b81526003909152208054919250906001810161063683826106e8565b600092835260209092208391600202018151815473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a0391909116178155602082015181600101555050506001945061068b565b600094505b505050509392505050565b60206040519081016040526000815290565b8154818355818115116106cc576000838152602090206106cc918101908301610714565b505050565b604080519081016040526000808252602082015290565b8154818355818115116106cc576002028160020283600052602060002091820191016106cc9190610735565b61073291905b8082111561072e576000815560010161071a565b5090565b90565b61073291905b8082111561072e57805473ffffffffffffffffffffffffffffffffffffffff191681556000600182015560020161073b5600a165627a7a72305820684f2fb1e542057647abb2bf64e4c276ea6a1b710260081ab52f2dc9836b7f7e0029";

	private Shivom(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice,
			BigInteger gasLimit) {
		super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
	}

	private Shivom(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice,
			BigInteger gasLimit) {
		super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
	}

	public RemoteCall<TransactionReceipt> getTokens(BigInteger amount, String userAddress) {
		Function function = new Function("getTokens",
				Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(amount),
						new org.web3j.abi.datatypes.Address(userAddress)),
				Collections.<TypeReference<?>>emptyList());
		return executeRemoteCallTransaction(function);
	}

	public RemoteCall<Tuple2<List<Address>, List<Uint256>>> getFileUserList(BigInteger fileHash) {
		final Function function = new Function("getFileUserList",
				Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(fileHash)),
				Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Address>>() {
				}, new TypeReference<DynamicArray<Uint256>>() {
				}));
		return new RemoteCall<Tuple2<List<Address>, List<Uint256>>>(
				new Callable<Tuple2<List<Address>, List<Uint256>>>() {
					@Override
					public Tuple2<List<Address>, List<Uint256>> call() throws Exception {
						List<Type> results = executeCallMultipleValueReturn(function);
						;
						return new Tuple2<List<Address>, List<Uint256>>((List<Address>) results.get(0).getValue(),
								(List<Uint256>) results.get(1).getValue());
					}
				});
	}

	public RemoteCall<TransactionReceipt> fileUpload(String to, BigInteger fileHash) {
		Function function = new Function("fileUpload",
				Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(to),
						new org.web3j.abi.datatypes.generated.Uint256(fileHash)),
				Collections.<TypeReference<?>>emptyList());
		return executeRemoteCallTransaction(function);
	}

	public RemoteCall<Tuple2<String, BigInteger>> getUserInfo(String to) {
		final Function function = new Function("getUserInfo",
				Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(to)),
				Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {
				}, new TypeReference<Uint256>() {
				}));
		return new RemoteCall<Tuple2<String, BigInteger>>(new Callable<Tuple2<String, BigInteger>>() {
			@Override
			public Tuple2<String, BigInteger> call() throws Exception {
				List<Type> results = executeCallMultipleValueReturn(function);
				;
				return new Tuple2<String, BigInteger>((String) results.get(0).getValue(),
						(BigInteger) results.get(1).getValue());
			}
		});
	}

	public RemoteCall<Tuple2<List<BigInteger>, String>> getUplodedFileUserList(String to) {
		final Function function = new Function("getUplodedFileUserList",
				Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(to)),
				Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Uint256>>() {
				}, new TypeReference<Address>() {
				}));
		return new RemoteCall<Tuple2<List<BigInteger>, String>>(new Callable<Tuple2<List<BigInteger>, String>>() {
			@Override
			public Tuple2<List<BigInteger>, String> call() throws Exception {
				List<Type> results = executeCallMultipleValueReturn(function);
				;
				return new Tuple2<List<BigInteger>, String>((List<BigInteger>) results.get(0).getValue(),
						(String) results.get(1).getValue());
			}
		});
	}

	public RemoteCall<TransactionReceipt> login(String to, BigInteger value) {
		Function function = new Function("login",
				Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(to),
						new org.web3j.abi.datatypes.generated.Uint256(value)),
				Collections.<TypeReference<?>>emptyList());
		return executeRemoteCallTransaction(function);
	}

	public RemoteCall<TransactionReceipt> download(BigInteger fileHash, BigInteger amount, String downloaderAddress) {
		Function function = new Function("download",
				Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(fileHash),
						new org.web3j.abi.datatypes.generated.Uint256(amount),
						new org.web3j.abi.datatypes.Address(downloaderAddress)),
				Collections.<TypeReference<?>>emptyList());
		return executeRemoteCallTransaction(function);
	}

	public static RemoteCall<Shivom> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice,
			BigInteger gasLimit) {
		return deployRemoteCall(Shivom.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
	}

	public static RemoteCall<Shivom> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice,
			BigInteger gasLimit) {
		return deployRemoteCall(Shivom.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
	}

	public static Shivom load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice,
			BigInteger gasLimit) {
		return new Shivom(contractAddress, web3j, credentials, gasPrice, gasLimit);
	}

	public static Shivom load(String contractAddress, Web3j web3j, TransactionManager transactionManager,
			BigInteger gasPrice, BigInteger gasLimit) {
		return new Shivom(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
	}
}