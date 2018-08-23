import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.*;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import rx.Observable;
import rx.functions.Func1;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.5.0.
 */
public class ERC_1 extends Contract {
    private static final String BINARY = "60c0604052600460808190527f48312e300000000000000000000000000000000000000000000000000000000060a090815261003e9160099190610063565b5034801561004b57600080fd5b5060028054600160a060020a031916331790556100fe565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106100a457805160ff19168380011785556100d1565b828001600101855582156100d1579182015b828111156100d15782518255916020019190600101906100b6565b506100dd9291506100e1565b5090565b6100fb91905b808211156100dd57600081556001016100e7565b90565b6110a3806200010e6000396000f3006080604052600436106101035763ffffffff60e060020a60003504166306fdde03811461024d578063091136b4146102d7578063095ea7b31461035a57806315a4d27f1461037e5780631fd9b0e3146103a85780632194f3a2146103cb57806323b872dd146103fc578063313ce567146104265780633e20f7fb1461045157806340c10f191461046657806342966c681461048a57806354fd4d50146104a257806365f2bc2e146104b757806370a08231146104de57806387da21e3146104ff578063933ba4131461051457806395d89b4114610529578063a9059cbb1461053e578063c45132aa14610562578063cae9ca5114610583578063dd62ed3e146105ec575b600b54600090610119903463ffffffff61061316565b600b55600a5461013090349063ffffffff61063016565b600c54600160a060020a031660009081526020819052604090205490915081111561015a57600080fd5b600c54600160a060020a0316600090815260208190526040902054610185908263ffffffff61065e16565b600c54600160a060020a03166000908152602081905260408082209290925533815220546101b9908263ffffffff61061316565b336000818152602081815260409182902093909355600c54815185815291519293600160a060020a03909116927fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef9281900390910190a3600c54604051600160a060020a03909116903480156108fc02916000818181858888f19350505050158015610249573d6000803e3d6000fd5b5050005b34801561025957600080fd5b50610262610675565b6040805160208082528351818301528351919283929083019185019080838360005b8381101561029c578181015183820152602001610284565b50505050905090810190601f1680156102c95780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b3480156102e357600080fd5b50604080516020601f60643560048181013592830184900484028501840190955281845261034694600160a060020a0381358116956024803590921695604435953695608494019181908401838280828437509497506107039650505050505050565b604080519115158252519081900360200190f35b34801561036657600080fd5b50610346600160a060020a0360043516602435610816565b34801561038a57600080fd5b50610346600160a060020a036004358116906024351660443561087d565b3480156103b457600080fd5b506103c9600160a060020a03600435166108a3565b005b3480156103d757600080fd5b506103e06108d2565b60408051600160a060020a039092168252519081900360200190f35b34801561040857600080fd5b50610346600160a060020a03600435811690602435166044356108e1565b34801561043257600080fd5b5061043b610a59565b6040805160ff9092168252519081900360200190f35b34801561045d57600080fd5b506103c9610a62565b34801561047257600080fd5b506103c9600160a060020a0360043516602435610b37565b34801561049657600080fd5b506103c9600435610bad565b3480156104ae57600080fd5b50610262610c2a565b3480156104c357600080fd5b506104cc610c85565b60408051918252519081900360200190f35b3480156104ea57600080fd5b506104cc600160a060020a0360043516610c8b565b34801561050b57600080fd5b506104cc610ca6565b34801561052057600080fd5b506104cc610cac565b34801561053557600080fd5b50610262610cb2565b34801561054a57600080fd5b50610346600160a060020a0360043516602435610d0d565b34801561056e57600080fd5b506103c9600160a060020a0360043516610da3565b34801561058f57600080fd5b50604080516020600460443581810135601f8101849004840285018401909552848452610346948235600160a060020a0316946024803595369594606494920191908190840183828082843750949750610dd29650505050505050565b3480156105f857600080fd5b506104cc600160a060020a0360043581169060243516610f6d565b60008282018381101561062557600080fd5b8091505b5092915050565b6000808315156106435760009150610629565b5082820282848281151561065357fe5b041461062557600080fd5b6000808383111561066e57600080fd5b5050900390565b6006805460408051602060026001851615610100026000190190941693909304601f810184900484028201840190925281815292918301828280156106fb5780601f106106d0576101008083540402835291602001916106fb565b820191906000526020600020905b8154815290600101906020018083116106de57829003601f168201915b505050505081565b60006107108585856108e1565b5061071a84610fd4565b15156001141561080e5783600160a060020a0316639a3fd1fb8685856040518463ffffffff1660e060020a0281526004018084600160a060020a0316600160a060020a0316815260200183815260200180602001828103825283818151815260200191508051906020019080838360005b838110156107a357818101518382015260200161078b565b50505050905090810190601f1680156107d05780820380516001836020036101000a031916815260200191505b50945050505050600060405180830381600087803b1580156107f157600080fd5b505af1158015610805573d6000803e3d6000fd5b50505050600190505b949350505050565b336000818152600160209081526040808320600160a060020a038716808552908352818420869055815186815291519394909390927f8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b925928290030190a35060015b92915050565b600061089b8484846020604051908101604052806000815250610703565b509392505050565b6003805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a0392909216919091179055565b600c54600160a060020a031681565b600160a060020a038316600090815260208190526040812054821180159061091257508161090f8533610f6d565b10155b801561091e5750600082115b151561092957600080fd5b600160a060020a038316600090815260208190526040902054610952908363ffffffff61061316565b600160a060020a038085166000908152602081905260408082209390935590861681522054610987908363ffffffff61065e16565b600160a060020a03808616600081815260208190526040902092909255841614610a0457600160a060020a03841660009081526001602090815260408083203384529091529020546109df908363ffffffff61065e16565b600160a060020a03851660009081526001602090815260408083203384529091529020555b82600160a060020a031684600160a060020a03167fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef846040518082815260200191505060405180910390a35060019392505050565b60075460ff1681565b33600090815260208181526040918290206103e890819055600555815180830190925260088083527f44696d6173696b6100000000000000000000000000000000000000000000000092909101918252610abe91600691610fdc565b506007805460ff1916600a1790556040805180820190915260048082527f444d534b000000000000000000000000000000000000000000000000000000006020909201918252610b1091600891610fdc565b506001600a55600c805473ffffffffffffffffffffffffffffffffffffffff191633179055565b600354600160a060020a03163314610b4e57600080fd5b600554610b61908263ffffffff61061316565b600555600160a060020a038216600090815260208190526040902054610b8d908263ffffffff61061316565b600160a060020a0390921660009081526020819052604090209190915550565b336000908152602081905260409020548111801590610bd65750600454600160a060020a031633145b1515610be157600080fd5b33600090815260208190526040902054610c01908263ffffffff61065e16565b33600090815260208190526040902055600554610c24908263ffffffff61065e16565b60055550565b6009805460408051602060026001851615610100026000190190941693909304601f810184900484028201840190925281815292918301828280156106fb5780601f106106d0576101008083540402835291602001916106fb565b600a5481565b600160a060020a031660009081526020819052604090205490565b60055481565b600b5481565b6008805460408051602060026001851615610100026000190190941693909304601f810184900484028201840190925281815292918301828280156106fb5780601f106106d0576101008083540402835291602001916106fb565b336000908152602081905260408120548211801590610d2c5750600082115b1515610d3757600080fd5b3360008181526020818152604080832080548790039055600160a060020a03871680845292819020805487019055805186815290519293927fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef929181900390910190a350600192915050565b6004805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a0392909216919091179055565b336000818152600160209081526040808320600160a060020a038816808552908352818420879055815187815291519394909390927f8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b925928290030190a383600160a060020a031660405180807f72656365697665417070726f76616c28616464726573732c75696e743235362c81526020017f616464726573732c627974657329000000000000000000000000000000000000815250602e019050604051809103902060e060020a9004338530866040518563ffffffff1660e060020a0281526004018085600160a060020a0316600160a060020a0316815260200184815260200183600160a060020a0316600160a060020a03168152602001828051906020019080838360005b83811015610f12578181015183820152602001610efa565b50505050905090810190601f168015610f3f5780820380516001836020036101000a031916815260200191505b509450505050506000604051808303816000875af1925050501515610f6357600080fd5b5060019392505050565b600081600160a060020a031683600160a060020a03161415610fa85750600160a060020a038216600090815260208190526040902054610877565b50600160a060020a03918216600090815260016020908152604080832093909416825291909152205490565b6000903b1190565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061101d57805160ff191683800117855561104a565b8280016001018555821561104a579182015b8281111561104a57825182559160200191906001019061102f565b5061105692915061105a565b5090565b61107491905b808211156110565760008155600101611060565b905600a165627a7a72305820d8177f86dddd10af082c409a816e5af0c48030f9fd2214e2a7e641191c5290e90029";

    public static final String FUNC_NAME = "name";

    public static final String FUNC_TRANSFERANDCALL = "transferAndCall";

    public static final String FUNC_APPROVE = "approve";

    public static final String FUNC_SETPERMITIONTOMINT = "setPermitionToMint";

    public static final String FUNC_FUNDSWALLET = "fundsWallet";

    public static final String FUNC_TRANSFERFROM = "transferFrom";

    public static final String FUNC_DECIMALS = "decimals";

    public static final String FUNC_HASHNODETESTCOIN = "HashnodeTestCoin";

    public static final String FUNC_MINT = "mint";

    public static final String FUNC_BURN = "burn";

    public static final String FUNC_VERSION = "version";

    public static final String FUNC_UNITSONEETHCANBUY = "unitsOneEthCanBuy";

    public static final String FUNC_BALANCEOF = "balanceOf";

    public static final String FUNC_TOTALMONEY = "totalMoney";

    public static final String FUNC_TOTALETHINWEI = "totalEthInWei";

    public static final String FUNC_SYMBOL = "symbol";

    public static final String FUNC_TRANSFER = "transfer";

    public static final String FUNC_SETPERMITIONTOBURN = "setPermitionToBurn";

    public static final String FUNC_APPROVEANDCALL = "approveAndCall";

    public static final String FUNC_ALLOWANCE = "allowance";

    public static final Event TRANSFER_EVENT = new Event("Transfer", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event APPROVAL_EVENT = new Event("Approval", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}));
    ;

    protected ERC_1(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected ERC_1(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public RemoteCall<String> name() {
        final Function function = new Function(FUNC_NAME, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> transferAndCall(String _from, String _to, BigInteger _money, byte[] _data) {
        final Function function = new Function(
                FUNC_TRANSFERANDCALL, 
                Arrays.<Type>asList(new Address(_from),
                new Address(_to),
                new Uint256(_money),
                new org.web3j.abi.datatypes.DynamicBytes(_data)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> approve(String _from, BigInteger _money) {
        final Function function = new Function(
                FUNC_APPROVE, 
                Arrays.<Type>asList(new Address(_from),
                new Uint256(_money)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> transferAndCall(String _from, String _to, BigInteger _amount) {
        final Function function = new Function(
                FUNC_TRANSFERANDCALL, 
                Arrays.<Type>asList(new Address(_from),
                new Address(_to),
                new Uint256(_amount)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> setPermitionToMint(String _ri) {
        final Function function = new Function(
                FUNC_SETPERMITIONTOMINT, 
                Arrays.<Type>asList(new Address(_ri)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> fundsWallet() {
        final Function function = new Function(FUNC_FUNDSWALLET, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> transferFrom(String _from, String _to, BigInteger _money) {
        final Function function = new Function(
                FUNC_TRANSFERFROM, 
                Arrays.<Type>asList(new Address(_from),
                new Address(_to),
                new Uint256(_money)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> decimals() {
        final Function function = new Function(FUNC_DECIMALS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> HashnodeTestCoin() {
        final Function function = new Function(
                FUNC_HASHNODETESTCOIN, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> mint(String _to, BigInteger _newmoney) {
        final Function function = new Function(
                FUNC_MINT, 
                Arrays.<Type>asList(new Address(_to),
                new Uint256(_newmoney)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> burn(BigInteger _amount) {
        final Function function = new Function(
                FUNC_BURN, 
                Arrays.<Type>asList(new Uint256(_amount)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> version() {
        final Function function = new Function(FUNC_VERSION, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<BigInteger> unitsOneEthCanBuy() {
        final Function function = new Function(FUNC_UNITSONEETHCANBUY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> balanceOf(String _gin) {
        final Function function = new Function(FUNC_BALANCEOF, 
                Arrays.<Type>asList(new Address(_gin)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> totalMoney() {
        final Function function = new Function(FUNC_TOTALMONEY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> totalEthInWei() {
        final Function function = new Function(FUNC_TOTALETHINWEI, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<String> symbol() {
        final Function function = new Function(FUNC_SYMBOL, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> transfer(String _to, BigInteger _money) {
        final Function function = new Function(
                FUNC_TRANSFER, 
                Arrays.<Type>asList(new Address(_to),
                new Uint256(_money)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> setPermitionToBurn(String _volter) {
        final Function function = new Function(
                FUNC_SETPERMITIONTOBURN, 
                Arrays.<Type>asList(new Address(_volter)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> approveAndCall(String _spender, BigInteger _value, byte[] _extraData) {
        final Function function = new Function(
                FUNC_APPROVEANDCALL, 
                Arrays.<Type>asList(new Address(_spender),
                new Uint256(_value),
                new org.web3j.abi.datatypes.DynamicBytes(_extraData)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> allowance(String _owner, String _spender) {
        final Function function = new Function(FUNC_ALLOWANCE, 
                Arrays.<Type>asList(new Address(_owner),
                new Address(_spender)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public static RemoteCall<ERC_1> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ERC_1.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<ERC_1> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ERC_1.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public List<TransferEventResponse> getTransferEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(TRANSFER_EVENT, transactionReceipt);
        ArrayList<TransferEventResponse> responses = new ArrayList<TransferEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            TransferEventResponse typedResponse = new TransferEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._from = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse._to = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse._value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<TransferEventResponse> transferEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, TransferEventResponse>() {
            @Override
            public TransferEventResponse call(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(TRANSFER_EVENT, log);
                TransferEventResponse typedResponse = new TransferEventResponse();
                typedResponse.log = log;
                typedResponse._from = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse._to = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse._value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<TransferEventResponse> transferEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(TRANSFER_EVENT));
        return transferEventObservable(filter);
    }

    public List<ApprovalEventResponse> getApprovalEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(APPROVAL_EVENT, transactionReceipt);
        ArrayList<ApprovalEventResponse> responses = new ArrayList<ApprovalEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            ApprovalEventResponse typedResponse = new ApprovalEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._owner = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse._spender = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse._value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<ApprovalEventResponse> approvalEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, ApprovalEventResponse>() {
            @Override
            public ApprovalEventResponse call(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(APPROVAL_EVENT, log);
                ApprovalEventResponse typedResponse = new ApprovalEventResponse();
                typedResponse.log = log;
                typedResponse._owner = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse._spender = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse._value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<ApprovalEventResponse> approvalEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(APPROVAL_EVENT));
        return approvalEventObservable(filter);
    }

    public static ERC_1 load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new ERC_1(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static ERC_1 load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new ERC_1(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static class TransferEventResponse {
        public Log log;

        public String _from;

        public String _to;

        public BigInteger _value;
    }

    public static class ApprovalEventResponse {
        public Log log;

        public String _owner;

        public String _spender;

        public BigInteger _value;
    }
}
