import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
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

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.5.0.
 */
public class Tokes extends Contract {
    private static final String BINARY = "60c0604052600460808190527f48312e300000000000000000000000000000000000000000000000000000000060a090815262000040916007919062000137565b503480156200004e57600080fd5b5060405160208062001094833981016040525160028054600160a060020a031916339081179091556200008b908264010000000062000092810204565b50620001dc565b600254600160a060020a03163314620000aa57600080fd5b600354620000c79082640100000000620005696200011d82021704565b600355600160a060020a038216600090815260208190526040902054620000fd9082640100000000620005696200011d82021704565b600160a060020a0390921660009081526020819052604090209190915550565b6000828201838110156200013057600080fd5b9392505050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106200017a57805160ff1916838001178555620001aa565b82800160010185558215620001aa579182015b82811115620001aa5782518255916020019190600101906200018d565b50620001b8929150620001bc565b5090565b620001d991905b80821115620001b85760008155600101620001c3565b90565b610ea880620001ec6000396000f3006080604052600436106100d75763ffffffff60e060020a60003504166306fdde038114610221578063091136b4146102ab578063095ea7b31461032e57806315a4d27f146103525780632194f3a21461037c57806323b872dd146103ad578063313ce567146103d75780633e20f7fb1461040257806354fd4d501461041957806365f2bc2e1461042e57806370a082311461045557806387da21e314610476578063933ba4131461048b57806395d89b41146104a0578063a9059cbb146104b5578063cae9ca51146104d9578063dd62ed3e14610542575b6009546000906100ed903463ffffffff61056916565b60095560085461010490349063ffffffff61058616565b600a54600160a060020a031660009081526020819052604090205490915081111561012e57600080fd5b600a54600160a060020a0316600090815260208190526040902054610159908263ffffffff6105b416565b600a54600160a060020a031660009081526020819052604080822092909255338152205461018d908263ffffffff61056916565b336000818152602081815260409182902093909355600a54815185815291519293600160a060020a03909116927fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef9281900390910190a3600a54604051600160a060020a03909116903480156108fc02916000818181858888f1935050505015801561021d573d6000803e3d6000fd5b5050005b34801561022d57600080fd5b506102366105cb565b6040805160208082528351818301528351919283929083019185019080838360005b83811015610270578181015183820152602001610258565b50505050905090810190601f16801561029d5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b3480156102b757600080fd5b50604080516020601f60643560048181013592830184900484028501840190955281845261031a94600160a060020a0381358116956024803590921695604435953695608494019181908401838280828437509497506106599650505050505050565b604080519115158252519081900360200190f35b34801561033a57600080fd5b5061031a600160a060020a036004351660243561076c565b34801561035e57600080fd5b5061031a600160a060020a03600435811690602435166044356107d3565b34801561038857600080fd5b506103916107f9565b60408051600160a060020a039092168252519081900360200190f35b3480156103b957600080fd5b5061031a600160a060020a0360043581169060243516604435610808565b3480156103e357600080fd5b506103ec610980565b6040805160ff9092168252519081900360200190f35b34801561040e57600080fd5b50610417610989565b005b34801561042557600080fd5b50610236610a5e565b34801561043a57600080fd5b50610443610ab9565b60408051918252519081900360200190f35b34801561046157600080fd5b50610443600160a060020a0360043516610abf565b34801561048257600080fd5b50610443610ada565b34801561049757600080fd5b50610443610ae0565b3480156104ac57600080fd5b50610236610ae6565b3480156104c157600080fd5b5061031a600160a060020a0360043516602435610b41565b3480156104e557600080fd5b50604080516020600460443581810135601f810184900484028501840190955284845261031a948235600160a060020a0316946024803595369594606494920191908190840183828082843750949750610bd79650505050505050565b34801561054e57600080fd5b50610443600160a060020a0360043581169060243516610d72565b60008282018381101561057b57600080fd5b8091505b5092915050565b600080831515610599576000915061057f565b508282028284828115156105a957fe5b041461057b57600080fd5b600080838311156105c457600080fd5b5050900390565b6004805460408051602060026001851615610100026000190190941693909304601f810184900484028201840190925281815292918301828280156106515780601f1061062657610100808354040283529160200191610651565b820191906000526020600020905b81548152906001019060200180831161063457829003601f168201915b505050505081565b6000610666858585610808565b5061067084610dd9565b1515600114156107645783600160a060020a0316639a3fd1fb8685856040518463ffffffff1660e060020a0281526004018084600160a060020a0316600160a060020a0316815260200183815260200180602001828103825283818151815260200191508051906020019080838360005b838110156106f95781810151838201526020016106e1565b50505050905090810190601f1680156107265780820380516001836020036101000a031916815260200191505b50945050505050600060405180830381600087803b15801561074757600080fd5b505af115801561075b573d6000803e3d6000fd5b50505050600190505b949350505050565b336000818152600160209081526040808320600160a060020a038716808552908352818420869055815186815291519394909390927f8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b925928290030190a35060015b92915050565b60006107f18484846020604051908101604052806000815250610659565b509392505050565b600a54600160a060020a031681565b600160a060020a03831660009081526020819052604081205482118015906108395750816108368533610d72565b10155b80156108455750600082115b151561085057600080fd5b600160a060020a038316600090815260208190526040902054610879908363ffffffff61056916565b600160a060020a0380851660009081526020819052604080822093909355908616815220546108ae908363ffffffff6105b416565b600160a060020a0380861660008181526020819052604090209290925584161461092b57600160a060020a0384166000908152600160209081526040808320338452909152902054610906908363ffffffff6105b416565b600160a060020a03851660009081526001602090815260408083203384529091529020555b82600160a060020a031684600160a060020a03167fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef846040518082815260200191505060405180910390a35060019392505050565b60055460ff1681565b33600090815260208181526040918290206103e890819055600355815180830190925260088083527f44696d6173696b61000000000000000000000000000000000000000000000000929091019182526109e591600491610de1565b506005805460ff1916600a1790556040805180820190915260048082527f444d534b000000000000000000000000000000000000000000000000000000006020909201918252610a3791600691610de1565b506001600855600a805473ffffffffffffffffffffffffffffffffffffffff191633179055565b6007805460408051602060026001851615610100026000190190941693909304601f810184900484028201840190925281815292918301828280156106515780601f1061062657610100808354040283529160200191610651565b60085481565b600160a060020a031660009081526020819052604090205490565b60035481565b60095481565b6006805460408051602060026001851615610100026000190190941693909304601f810184900484028201840190925281815292918301828280156106515780601f1061062657610100808354040283529160200191610651565b336000908152602081905260408120548211801590610b605750600082115b1515610b6b57600080fd5b3360008181526020818152604080832080548790039055600160a060020a03871680845292819020805487019055805186815290519293927fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef929181900390910190a350600192915050565b336000818152600160209081526040808320600160a060020a038816808552908352818420879055815187815291519394909390927f8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b925928290030190a383600160a060020a031660405180807f72656365697665417070726f76616c28616464726573732c75696e743235362c81526020017f616464726573732c627974657329000000000000000000000000000000000000815250602e019050604051809103902060e060020a9004338530866040518563ffffffff1660e060020a0281526004018085600160a060020a0316600160a060020a0316815260200184815260200183600160a060020a0316600160a060020a03168152602001828051906020019080838360005b83811015610d17578181015183820152602001610cff565b50505050905090810190601f168015610d445780820380516001836020036101000a031916815260200191505b509450505050506000604051808303816000875af1925050501515610d6857600080fd5b5060019392505050565b600081600160a060020a031683600160a060020a03161415610dad5750600160a060020a0382166000908152602081905260409020546107cd565b50600160a060020a03918216600090815260016020908152604080832093909416825291909152205490565b6000903b1190565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f10610e2257805160ff1916838001178555610e4f565b82800160010185558215610e4f579182015b82811115610e4f578251825591602001919060010190610e34565b50610e5b929150610e5f565b5090565b610e7991905b80821115610e5b5760008155600101610e65565b905600a165627a7a723058204ce52bb3d785f863923c805ae218a0d1e92ad674729af8ee19edba941ae891930029";

    public static final String FUNC_NAME = "name";

    public static final String FUNC_TRANSFERANDCALL = "transferAndCall";

    public static final String FUNC_APPROVE = "approve";

    public static final String FUNC_FUNDSWALLET = "fundsWallet";

    public static final String FUNC_TRANSFERFROM = "transferFrom";

    public static final String FUNC_DECIMALS = "decimals";

    public static final String FUNC_HASHNODETESTCOIN = "HashnodeTestCoin";

    public static final String FUNC_VERSION = "version";

    public static final String FUNC_UNITSONEETHCANBUY = "unitsOneEthCanBuy";

    public static final String FUNC_BALANCEOF = "balanceOf";

    public static final String FUNC_TOTALMONEY = "totalMoney";

    public static final String FUNC_TOTALETHINWEI = "totalEthInWei";

    public static final String FUNC_SYMBOL = "symbol";

    public static final String FUNC_TRANSFER = "transfer";

    public static final String FUNC_APPROVEANDCALL = "approveAndCall";

    public static final String FUNC_ALLOWANCE = "allowance";

    public static final Event TRANSFER_EVENT = new Event("Transfer", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event APPROVAL_EVENT = new Event("Approval", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}));
    ;

    protected Tokes(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Tokes(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
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

    public static RemoteCall<Tokes> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger _money) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Uint256(_money)));
        return deployRemoteCall(Tokes.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static RemoteCall<Tokes> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger _money) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Uint256(_money)));
        return deployRemoteCall(Tokes.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
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

    public static Tokes load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Tokes(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static Tokes load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Tokes(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
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
