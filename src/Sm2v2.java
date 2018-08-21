import org.web3j.abi.EventEncoder;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.*;
import org.web3j.abi.datatypes.generated.Uint256;
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
public class Sm2v2 extends Contract {
    private static final String BINARY = "6080604052600160035534801561001557600080fd5b506040516107d43803806107d48339810160405280510160005b8151811015610085576001806000848481518110151561004b57fe5b602090810291909101810151600160a060020a03168252810191909152604001600020805460ff191691151591909117905560010161002f565b505061073e806100966000396000f3006080604052600436106100615763ffffffff7c0100000000000000000000000000000000000000000000000000000000600035041663147da9748114610066578063399e07921461009b57806372398259146100b3578063f96d37e1146101ce575b600080fd5b34801561007257600080fd5b50610087600160a060020a03600435166101f8565b604080519115158252519081900360200190f35b3480156100a757600080fd5b5061008760043561020d565b3480156100bf57600080fd5b5060408051602060046024803582810135601f81018590048502860185019096528585526101cc958335600160a060020a031695369560449491939091019190819084018382808284375050604080516020808901358a01803580830284810184018652818552999c8b359c909b909a950198509296508101945090925082919085019084908082843750506040805187358901803560208181028481018201909552818452989b9a998901989297509082019550935083925085019084908082843750506040805187358901803560208181028481018201909552818452989b9a9989019892975090820195509350839250850190849080828437509497506102229650505050505050565b005b3480156101da57600080fd5b506101e6600435610569565b60408051918252519081900360200190f35b60016020526000908152604090205460ff1681565b60026020526000908152604090205460ff1681565b600060048190555b600354600454101561054a5760018787876040518084600160a060020a0316600160a060020a03166c0100000000000000000000000002815260140183805190602001908083835b602083106102915780518252601f199092019160209182019101610272565b51815160209384036101000a600019018019909216911617905292019384525060405192839003019091206004548951919450899350915081106102d157fe5b90602001906020020151856004548151811015156102eb57fe5b906020019060200201518560045481518110151561030557fe5b60209081029091018101516040805160008082528185018084529790975260ff9095168582015260608501939093526080840152905160a0808401949293601f19830193908390039091019190865af1158015610366573d6000803e3d6000fd5b505060408051601f1901516005805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a039283161790819055166000908152600160208190529190205460ff1615151490506103be57600080fd5b6005546040516c01000000000000000000000000600160a060020a039283168181028352928a16026014820152875189918991899190602882019060208501908083835b602083106104215780518252601f199092019160209182019101610402565b51815160209384036101000a60001901801990921691161790529201938452506040805193849003820190932060008181526002909252929020549195505060ff1615925061047291505057600080fd5b600081815260026020908152604091829020805460ff1916600117905590516c01000000000000000000000000600160a060020a038a16028152875189928992899290916014830191908501908083835b602083106104e25780518252601f1990920191602091820191016104c3565b51815160209384036101000a60001901801990921691161790529201938452506040805193849003820190932060008181529182905292902080546001019081905560035492955091909114925061053c91505057600080fd5b60048054600101905561022a565b600354600454141561056057610560878761057b565b50505050505050565b60006020819052908152604090205481565b81600160a060020a03168160405180828051906020019080838360005b838110156105b0578181015183820152602001610598565b50505050905090810190601f1680156105dd5780820380516001836020036101000a031916815260200191505b509150506000604051808303816000865af191505015156001151514156106a65781600160a060020a03167fdc89d77e9439b1edd1b58e7e45782d8d440735ddcea64b0ee8a730e888f2ae48826040518080602001828103825283818151815260200191508051906020019080838360005b8381101561066757818101518382015260200161064f565b50505050905090810190601f1680156106945780820380516001836020036101000a031916815260200191505b509250505060405180910390a261070e565b81600160a060020a03167fb5fc491e38778bae3fde5de21aef7e2e083960be339015899ec0de6b35811171826040518080602001828103825283818151815260200191508051906020019080838360008381101561066757818101518382015260200161064f565b50505600a165627a7a72305820c128a80b735c6f22369730947269af036f6986f4b41a88f815a09ec8a9cdde8c0029";

    public static final String FUNC_VOLID = "volid";

    public static final String FUNC_CHECK = "check";

    public static final String FUNC_PASSSIGNATURES = "passSignatures";

    public static final String FUNC_CNT = "cnt";

    public static final Event MESSAGESUCESSFULPASSED_EVENT = new Event("MessageSucessfulPassed", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<DynamicBytes>() {}));
    ;

    public static final Event MESSAGEPASSFAIL_EVENT = new Event("MessagePassFail", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<DynamicBytes>() {}));
    ;

    protected Sm2v2(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Sm2v2(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public RemoteCall<Boolean> volid(String param0) {
        final Function function = new Function(FUNC_VOLID, 
                Arrays.<Type>asList(new Address(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<Boolean> check(byte[] param0) {
        final Function function = new Function(FUNC_CHECK, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<TransactionReceipt> passSignatures(String _addre, byte[] _data, byte[] _trhhash, List<BigInteger> _v, List<byte[]> _r, List<byte[]> _s) {
        final Function function = new Function(
                FUNC_PASSSIGNATURES, 
                Arrays.<Type>asList(new Address(_addre), 
                new DynamicBytes(_data), 
                new org.web3j.abi.datatypes.generated.Bytes32(_trhhash), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint8>(
                        org.web3j.abi.Utils.typeMap(_v, org.web3j.abi.datatypes.generated.Uint8.class)), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.Utils.typeMap(_r, org.web3j.abi.datatypes.generated.Bytes32.class)), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.Utils.typeMap(_s, org.web3j.abi.datatypes.generated.Bytes32.class))), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> cnt(byte[] param0) {
        final Function function = new Function(FUNC_CNT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public static RemoteCall<Sm2v2> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, List<String> volidators) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<Address>(
                        org.web3j.abi.Utils.typeMap(volidators, Address.class))));
        return deployRemoteCall(Sm2v2.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static RemoteCall<Sm2v2> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, List<String> volidators) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<Address>(
                        org.web3j.abi.Utils.typeMap(volidators, Address.class))));
        return deployRemoteCall(Sm2v2.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public List<MessageSucessfulPassedEventResponse> getMessageSucessfulPassedEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(MESSAGESUCESSFULPASSED_EVENT, transactionReceipt);
        ArrayList<MessageSucessfulPassedEventResponse> responses = new ArrayList<MessageSucessfulPassedEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            MessageSucessfulPassedEventResponse typedResponse = new MessageSucessfulPassedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.addre = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.byt = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<MessageSucessfulPassedEventResponse> messageSucessfulPassedEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, MessageSucessfulPassedEventResponse>() {
            @Override
            public MessageSucessfulPassedEventResponse call(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(MESSAGESUCESSFULPASSED_EVENT, log);
                MessageSucessfulPassedEventResponse typedResponse = new MessageSucessfulPassedEventResponse();
                typedResponse.log = log;
                typedResponse.addre = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.byt = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<MessageSucessfulPassedEventResponse> messageSucessfulPassedEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(MESSAGESUCESSFULPASSED_EVENT));
        return messageSucessfulPassedEventObservable(filter);
    }

    public List<MessagePassFailEventResponse> getMessagePassFailEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(MESSAGEPASSFAIL_EVENT, transactionReceipt);
        ArrayList<MessagePassFailEventResponse> responses = new ArrayList<MessagePassFailEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            MessagePassFailEventResponse typedResponse = new MessagePassFailEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.ad = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.by = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<MessagePassFailEventResponse> messagePassFailEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, MessagePassFailEventResponse>() {
            @Override
            public MessagePassFailEventResponse call(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(MESSAGEPASSFAIL_EVENT, log);
                MessagePassFailEventResponse typedResponse = new MessagePassFailEventResponse();
                typedResponse.log = log;
                typedResponse.ad = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.by = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<MessagePassFailEventResponse> messagePassFailEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(MESSAGEPASSFAIL_EVENT));
        return messagePassFailEventObservable(filter);
    }

    public static Sm2v2 load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Sm2v2(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static Sm2v2 load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Sm2v2(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static class MessageSucessfulPassedEventResponse {
        public Log log;

        public String addre;

        public byte[] byt;
    }

    public static class MessagePassFailEventResponse {
        public Log log;

        public String ad;

        public byte[] by;
    }
}
