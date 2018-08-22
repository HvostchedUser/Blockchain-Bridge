import org.web3j.abi.EventEncoder;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.*;
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
public class Sm2 extends Contract {
    private static final String BINARY = "6080604052600060045534801561001557600080fd5b50604051610b59380380610b598339810160405280516020820151910190600080821161004157600080fd5b5060005b82518110156100e35760016000848381518110151561006057fe5b6020908102909101810151600160a060020a031682528101919091526040016000205460ff1615156100db576001806000858481518110151561009f57fe5b602090810291909101810151600160a060020a03168252810191909152604001600020805460ff19169115159190911790556004805460010190555b600101610045565b60038290556004548211156100f757600080fd5b505050610a50806101096000396000f30060806040526004361061006c5763ffffffff7c01000000000000000000000000000000000000000000000000000000006000350416632f55dfe4811461007157806369a0751b146100945780638a85d399146100fb57806390da087d1461011c578063de0f130e14610134575b600080fd5b34801561007d57600080fd5b50610092600160a060020a036004351661024d565b005b3480156100a057600080fd5b5060408051602060046024803582810135601f8101859004850286018501909652858552610092958335600160a060020a03169536956044949193909101919081908401838280828437509497506102c49650505050505050565b34801561010757600080fd5b50610092600160a060020a036004351661037b565b34801561012857600080fd5b50610092600435610403565b34801561014057600080fd5b5060408051602060046024803582810135601f8101859004850286018501909652858552610092958335600160a060020a031695369560449491939091019190819084018382808284375050604080516020808901358a01803580830284810184018652818552999c8b359c909b909a950198509296508101945090925082919085019084908082843750506040805187358901803560208181028481018201909552818452989b9a998901989297509082019550935083925085019084908082843750506040805187358901803560208181028481018201909552818452989b9a9989019892975090820195509350839250850190849080828437509497506104249650505050505050565b3360009081526001602081905260409091205460ff1615151461026f57600080fd5b600160a060020a03811660009081526001602052604090205460ff161561029557600080fd5b600160a060020a03166000908152600160208190526040909120805460ff191682179055600480549091019055565b7f6e3c72dcd88f70559516b069820c6cbcadae49f53e0a583ecc963fa1769987f182826040518083600160a060020a0316600160a060020a0316815260200180602001828103825283818151815260200191508051906020019080838360005b8381101561033c578181015183820152602001610324565b50505050905090810190601f1680156103695780820380516001836020036101000a031916815260200191505b50935050505060405180910390a15050565b6004546003541161038b57600080fd5b3360009081526001602081905260409091205460ff161515146103ad57600080fd5b600160a060020a03811660009081526001602081905260409091205460ff161515146103d857600080fd5b600160a060020a03166000908152600160205260409020805460ff1916905560048054600019019055565b60045481101561041257600080fd5b6000811161041f57600080fd5b600355565b6000805b600354821015610a1a5760018888886040516020018084600160a060020a0316600160a060020a03166c0100000000000000000000000002815260140183805190602001908083835b602083106104905780518252601f199092019160209182019101610471565b51815160209384036101000a60001901801990921691161790529201938452506040805180850381529382019081905283519395509350839290850191508083835b602083106104f15780518252601f1990920191602091820191016104d2565b6001836020036101000a0380198251168184511680821785525050505050509050019150506040518091039020868481518110151561052c57fe5b90602001906020020151868581518110151561054457fe5b90602001906020020151868681518110151561055c57fe5b60209081029091018101516040805160008082528185018084529790975260ff9095168582015260608501939093526080840152905160a0808401949293601f19830193908390039091019190865af11580156105bd573d6000803e3d6000fd5b505060408051601f1901516005805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a039283161790819055166000908152600160208190529190205460ff16151514905061061557600080fd5b600560009054906101000a9004600160a060020a03168888886040516020018085600160a060020a0316600160a060020a03166c0100000000000000000000000002815260140184600160a060020a0316600160a060020a03166c0100000000000000000000000002815260140183805190602001908083835b602083106106ae5780518252601f19909201916020918201910161068f565b51815160209384036101000a6000190180199092169116179052920193845250604080518085038152938201908190528351939650945084935085019190508083835b602083106107105780518252601f1990920191602091820191016106f1565b51815160209384036101000a6000190180199092169116179052604080519290940182900390912060008181526002909252929020549194505060ff1615159150610a0f905057600081815260026020908152604091829020805460ff1916600117905590516c01000000000000000000000000600160a060020a038b160281830190815289518b938b938b93926034909101918501908083835b602083106107ca5780518252601f1990920191602091820191016107ab565b51815160209384036101000a60001901801990921691161790529201938452506040805180850381529382019081905283519395509350839290850191508083835b6020831061082b5780518252601f19909201916020918201910161080c565b51815160209384036101000a6000190180199092169116179052604080519290940182900390912060008181529182905292902080546001019081905560035492955091909114159250610a0f9150505787600160a060020a03168760405180828051906020019080838360005b838110156108b1578181015183820152602001610899565b50505050905090810190601f1680156108de5780820380516001836020036101000a031916815260200191505b509150506000604051808303816000865af191505015156001151514156109a75787600160a060020a03167fdc89d77e9439b1edd1b58e7e45782d8d440735ddcea64b0ee8a730e888f2ae48886040518080602001828103825283818151815260200191508051906020019080838360005b83811015610968578181015183820152602001610950565b50505050905090810190601f1680156109955780820380516001836020036101000a031916815260200191505b509250505060405180910390a2610a1a565b87600160a060020a03167fb5fc491e38778bae3fde5de21aef7e2e083960be339015899ec0de6b358111718860405180806020018281038252838181518152602001915080519060200190808383600083811015610968578181015183820152602001610950565b600190910190610428565b50505050505050505600a165627a7a72305820da1e9b0e14c711ed444b3980bc11c1e04af1ee1380554e943ee0e8a684454f380029";

    public static final String FUNC_ADDVALID = "addValid";

    public static final String FUNC_TRANSWERMESSAGE = "transwerMessage";

    public static final String FUNC_REMOVEVALID = "removeValid";

    public static final String FUNC_SETSIGNATURES = "setSignatures";

    public static final String FUNC_PASSSIGNATUREFROMCHEAP = "PassSignatureFromCheap";

    public static final Event REQUESSTOPASMESSAGE_EVENT = new Event("RequessToPasMessage", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<DynamicBytes>() {}));
    ;

    public static final Event MESSAGESUCESSFULPASSED_EVENT = new Event("MessageSucessfulPassed", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<DynamicBytes>() {}));
    ;

    public static final Event MESSAGEPASSFAIL_EVENT = new Event("MessagePassFail", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<DynamicBytes>() {}));
    ;

    protected Sm2(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Sm2(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public RemoteCall<TransactionReceipt> addValid(String _a) {
        final Function function = new Function(
                FUNC_ADDVALID, 
                Arrays.<Type>asList(new Address(_a)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> transwerMessage(String _to, byte[] _data) {
        final Function function = new Function(
                FUNC_TRANSWERMESSAGE, 
                Arrays.<Type>asList(new Address(_to),
                new DynamicBytes(_data)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> removeValid(String _a) {
        final Function function = new Function(
                FUNC_REMOVEVALID, 
                Arrays.<Type>asList(new Address(_a)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> setSignatures(BigInteger _num) {
        final Function function = new Function(
                FUNC_SETSIGNATURES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_num)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> PassSignatureFromCheap(String _to, byte[] _data, byte[] _trhhash, List<BigInteger> _v, List<byte[]> _r, List<byte[]> _s) {
        final Function function = new Function(
                FUNC_PASSSIGNATUREFROMCHEAP,
                Arrays.<Type>asList(new Address(_to),
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

    public static RemoteCall<Sm2> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, List<String> volidators, BigInteger _num) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<Address>(
                        org.web3j.abi.Utils.typeMap(volidators, Address.class)),
                new org.web3j.abi.datatypes.generated.Uint256(_num)));
        return deployRemoteCall(Sm2.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static RemoteCall<Sm2> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, List<String> volidators, BigInteger _num) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<Address>(
                        org.web3j.abi.Utils.typeMap(volidators, Address.class)),
                new org.web3j.abi.datatypes.generated.Uint256(_num)));
        return deployRemoteCall(Sm2.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public List<RequessToPasMessageEventResponse> getRequessToPasMessageEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(REQUESSTOPASMESSAGE_EVENT, transactionReceipt);
        ArrayList<RequessToPasMessageEventResponse> responses = new ArrayList<RequessToPasMessageEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            RequessToPasMessageEventResponse typedResponse = new RequessToPasMessageEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._to = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse._data = (byte[]) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<RequessToPasMessageEventResponse> requessToPasMessageEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, RequessToPasMessageEventResponse>() {
            @Override
            public RequessToPasMessageEventResponse call(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(REQUESSTOPASMESSAGE_EVENT, log);
                RequessToPasMessageEventResponse typedResponse = new RequessToPasMessageEventResponse();
                typedResponse.log = log;
                typedResponse._to = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse._data = (byte[]) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<RequessToPasMessageEventResponse> requessToPasMessageEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(REQUESSTOPASMESSAGE_EVENT));
        return requessToPasMessageEventObservable(filter);
    }

    public List<MessageSucessfulPassedEventResponse> getMessageSucessfulPassedEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(MESSAGESUCESSFULPASSED_EVENT, transactionReceipt);
        ArrayList<MessageSucessfulPassedEventResponse> responses = new ArrayList<MessageSucessfulPassedEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            MessageSucessfulPassedEventResponse typedResponse = new MessageSucessfulPassedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.to = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.data = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
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
                typedResponse.to = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.data = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
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
            typedResponse.to = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.data = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
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
                typedResponse.to = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.data = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<MessagePassFailEventResponse> messagePassFailEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(MESSAGEPASSFAIL_EVENT));
        return messagePassFailEventObservable(filter);
    }

    public static Sm2 load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Sm2(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static Sm2 load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Sm2(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static class RequessToPasMessageEventResponse {
        public Log log;

        public String _to;

        public byte[] _data;
    }

    public static class MessageSucessfulPassedEventResponse {
        public Log log;

        public String to;

        public byte[] data;
    }

    public static class MessagePassFailEventResponse {
        public Log log;

        public String to;

        public byte[] data;
    }
}
