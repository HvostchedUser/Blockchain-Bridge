import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.DynamicBytes;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Bytes32;
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
public class Sm1 extends Contract {
    private static final String BINARY = "6080604052600060045534801561001557600080fd5b506040516113e33803806113e38339810160405280516020820151910190600080821161004157600080fd5b5060005b82518110156100e35760016000848381518110151561006057fe5b6020908102909101810151600160a060020a031682528101919091526040016000205460ff1615156100db576001806000858481518110151561009f57fe5b602090810291909101810151600160a060020a03168252810191909152604001600020805460ff19169115159190911790556004805460010190555b600101610045565b60038290556004548211156100f757600080fd5b5050506112da806101096000396000f3006080604052600436106100a35763ffffffff7c010000000000000000000000000000000000000000000000000000000060003504166311b1ed1481146100a857806322388dea146101c35780632f55dfe4146101f057806369a0751b1461021157806385907c6f146102785780638742415f1461029357806389a9aa04146102fc5780638a85d3991461032d57806390da087d1461034e578063a7a44b7d14610366575b600080fd5b3480156100b457600080fd5b5060408051602060046024803582810135601f81018590048502860185019096528585526101c1958335600160a060020a031695369560449491939091019190819084018382808284375050604080516020808901358a01803580830284810184018652818552999c8b359c909b909a950198509296508101945090925082919085019084908082843750506040805187358901803560208181028481018201909552818452989b9a998901989297509082019550935083925085019084908082843750506040805187358901803560208181028481018201909552818452989b9a9989019892975090820195509350839250850190849080828437509497506103e19650505050505050565b005b3480156101cf57600080fd5b506101de60043560243561057a565b60408051918252519081900360200190f35b3480156101fc57600080fd5b506101c1600160a060020a03600435166105aa565b34801561021d57600080fd5b5060408051602060046024803582810135601f81018590048502860185019096528585526101c1958335600160a060020a03169536956044949193909101919081908401838280828437509497506106219650505050505050565b34801561028457600080fd5b506101de6004356024356106d8565b34801561029f57600080fd5b5060408051602060046024803582810135601f81018590048502860185019096528585526101c1958335600160a060020a031695369560449491939091019190819084018382808284375094975050933594506106f39350505050565b34801561030857600080fd5b50610317600435602435610b5b565b6040805160ff9092168252519081900360200190f35b34801561033957600080fd5b506101c1600160a060020a0360043516610b9d565b34801561035a57600080fd5b506101c1600435610c25565b34801561037257600080fd5b5060408051602060046024803582810135601f81018590048502860185019096528585526101c1958335600160a060020a03169536956044949193909101919081908401838280828437509497505084359550505050602082013560ff16916040810135915060600135610c46565b7f7842af17c341a3fc40fcf993d6bb448661254aa84e7794549652c8ee1659d5758686868686866040518087600160a060020a0316600160a060020a0316815260200180602001866000191660001916815260200180602001806020018060200185810385528a818151815260200191508051906020019080838360005b8381101561047757818101518382015260200161045f565b50505050905090810190601f1680156104a45780820380516001836020036101000a031916815260200191505b508581038452885181528851602091820191808b01910280838360005b838110156104d95781810151838201526020016104c1565b50505050905001858103835287818151815260200191508051906020019060200280838360005b83811015610518578181015183820152602001610500565b50505050905001858103825286818151815260200191508051906020019060200280838360005b8381101561055757818101518382015260200161053f565b505050509050019a505050505050505050505060405180910390a1505050505050565b60076020528160005260406000208181548110151561059557fe5b90600052602060002001600091509150505481565b3360009081526001602081905260409091205460ff161515146105cc57600080fd5b600160a060020a03811660009081526001602052604090205460ff16156105f257600080fd5b600160a060020a03166000908152600160208190526040909120805460ff191682179055600480549091019055565b7f6e3c72dcd88f70559516b069820c6cbcadae49f53e0a583ecc963fa1769987f182826040518083600160a060020a0316600160a060020a0316815260200180602001828103825283818151815260200191508051906020019080838360005b83811015610699578181015183820152602001610681565b50505050905090810190601f1680156106c65780820380516001836020036101000a031916815260200191505b50935050505060405180910390a15050565b60086020528160005260406000208181548110151561059557fe5b60006003546004541015801561070b57506000600354115b151561071657600080fd5b3360009081526001602081905260409091205460ff1615151415610b5557338484846040516020018085600160a060020a0316600160a060020a03166c0100000000000000000000000002815260140184600160a060020a0316600160a060020a03166c0100000000000000000000000002815260140183805190602001908083835b602083106107b85780518252601f199092019160209182019101610799565b51815160209384036101000a6000190180199092169116179052920193845250604080518085038152938201908190528351939650945084935085019190508083835b6020831061081a5780518252601f1990920191602091820191016107fb565b51815160209384036101000a6000190180199092169116179052604080519290940182900390912060008181526002909252929020549194505060ff1615159150610b55905057600081815260026020908152604091829020805460ff1916600117905590516c01000000000000000000000000600160a060020a038716028183019081528551879387938793926034909101918501908083835b602083106108d45780518252601f1990920191602091820191016108b5565b51815160209384036101000a60001901801990921691161790529201938452506040805180850381529382019081905283519395509350839290850191508083835b602083106109355780518252601f199092019160209182019101610916565b51815160209384036101000a6000190180199092169116179052604080519290940182900390912060008181529182905292902080546001019081905560035492955091909114159250610b559150505783600160a060020a03168360405180828051906020019080838360005b838110156109bb5781810151838201526020016109a3565b50505050905090810190601f1680156109e85780820380516001836020036101000a031916815260200191505b509150506000604051808303816000865af19150501515600115151415610ab15783600160a060020a03167fdc89d77e9439b1edd1b58e7e45782d8d440735ddcea64b0ee8a730e888f2ae48846040518080602001828103825283818151815260200191508051906020019080838360005b83811015610a72578181015183820152602001610a5a565b50505050905090810190601f168015610a9f5780820380516001836020036101000a031916815260200191505b509250505060405180910390a2610b55565b83600160a060020a03167fb5fc491e38778bae3fde5de21aef7e2e083960be339015899ec0de6b35811171846040518080602001828103825283818151815260200191508051906020019080838360005b83811015610b1a578181015183820152602001610b02565b50505050905090810190601f168015610b475780820380516001836020036101000a031916815260200191505b509250505060405180910390a25b50505050565b600660205281600052604060002081815481101515610b7657fe5b9060005260206000209060209182820401919006915091509054906101000a900460ff1681565b60045460035411610bad57600080fd5b3360009081526001602081905260409091205460ff16151514610bcf57600080fd5b600160a060020a03811660009081526001602081905260409091205460ff16151514610bfa57600080fd5b600160a060020a03166000908152600160205260409020805460ff1916905560048054600019019055565b600454811015610c3457600080fd5b60008111610c4157600080fd5b600355565b600060018787876040516020018084600160a060020a0316600160a060020a03166c0100000000000000000000000002815260140183805190602001908083835b60208310610ca65780518252601f199092019160209182019101610c87565b51815160209384036101000a60001901801990921691161790529201938452506040805180850381529382019081905283519395509350839290850191508083835b60208310610d075780518252601f199092019160209182019101610ce8565b51815160209384036101000a60001901801990921691161790526040805192909401829003822060008084528383018087529190915260ff8c1683860152606083018b9052608083018a9052935160a08084019750919550601f1981019492819003909101925090865af1158015610d83573d6000803e3d6000fd5b505060408051601f1901516005805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a039283161790819055166000908152600160208190529190205460ff161515149050610ddb57600080fd5b600560009054906101000a9004600160a060020a03168787876040516020018085600160a060020a0316600160a060020a03166c0100000000000000000000000002815260140184600160a060020a0316600160a060020a03166c0100000000000000000000000002815260140183805190602001908083835b60208310610e745780518252601f199092019160209182019101610e55565b51815160209384036101000a6000190180199092169116179052920193845250604080518085038152938201908190528351939650945084935085019190508083835b60208310610ed65780518252601f199092019160209182019101610eb7565b51815160209384036101000a6000190180199092169116179052604080519290940182900390912060008181526002909252929020549194505060ff16159150610f21905057600080fd5b600081815260026020908152604091829020805460ff1916600117905590516c01000000000000000000000000600160a060020a038a160281830190815288518a938a938a93926034909101918501908083835b60208310610f945780518252601f199092019160209182019101610f75565b51815160209384036101000a60001901801990921691161790529201938452506040805180850381529382019081905283519395509350839290850191508083835b60208310610ff55780518252601f199092019160209182019101610fd6565b6001836020036101000a0380198251168184511680821785525050505050509050019150506040518091039020905060008082600019166000191681526020019081526020016000206000815480929190600101919050555060066000826000191660001916815260200190815260200160002084908060018154018082558091505090600182039060005260206000209060209182820401919006909192909190916101000a81548160ff021916908360ff1602179055505060076000826000191660001916815260200190815260200160002083908060018154018082558091505090600182039060005260206000200160009091929091909150906000191690555060086000826000191660001916815260200190815260200160002082908060018154018082558091505090600182039060005260206000200160009091929091909150906000191690555060035460008083600019166000191681526020019081526020016000205414156112a55760008181526006602090815260409182902080548351818402810184019094528084526112a5938b938b938b9390918301828280156111e557602002820191906000526020600020906000905b825461010083900a900460ff168152602060019283018181049485019490930390920291018084116111b65790505b5050506000888152600760209081526040918290208054835181840281018401909452808452929450925083018282801561124057602002820191906000526020600020905b8154815260019091019060200180831161122b575b5050506000898152600860209081526040918290208054835181840281018401909452808452929450925083018282801561129b57602002820191906000526020600020905b81548152600190910190602001808311611286575b50505050506103e1565b505050505050505600a165627a7a72305820719f1e6dd20956688e33774724b5ed0666c6b2b9f9abe12bc912a9ecca5101930029";

    public static final String FUNC_TRANSWERVRS = "transwerVRS";

    public static final String FUNC_R = "R";

    public static final String FUNC_ADDVALID = "addValid";

    public static final String FUNC_TRANSWERMESSAGE = "transwerMessage";

    public static final String FUNC_S = "S";

    public static final String FUNC_PASSMESAGE = "PassMesage";

    public static final String FUNC_V = "V";

    public static final String FUNC_REMOVEVALID = "removeValid";

    public static final String FUNC_SETSIGNATURES = "setSignatures";

    public static final String FUNC_SIGNMESSAGE = "signMessage";

    public static final Event MESSAGESUCESSFULPASSED_EVENT = new Event("MessageSucessfulPassed", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<DynamicBytes>() {}));
    ;

    public static final Event MESSAGEPASSFAIL_EVENT = new Event("MessagePassFail", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<DynamicBytes>() {}));
    ;

    public static final Event REQUESSTOPASMESSAGE_EVENT = new Event("RequessToPasMessage", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<DynamicBytes>() {}));
    ;

    public static final Event REQUESSTOPASVRS_EVENT = new Event("RequessToPasVRS", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<DynamicBytes>() {}, new TypeReference<Bytes32>() {}, new TypeReference<DynamicArray<Uint8>>() {}, new TypeReference<DynamicArray<Bytes32>>() {}, new TypeReference<DynamicArray<Bytes32>>() {}));
    ;

    protected Sm1(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Sm1(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public RemoteCall<TransactionReceipt> transwerVRS(String _to, byte[] _data, byte[] _trhhash, List<BigInteger> _V, List<byte[]> _R, List<byte[]> _S) {
        final Function function = new Function(
                FUNC_TRANSWERVRS, 
                Arrays.<Type>asList(new Address(_to),
                new DynamicBytes(_data),
                new Bytes32(_trhhash),
                new DynamicArray<Uint8>(
                        org.web3j.abi.Utils.typeMap(_V, Uint8.class)),
                new DynamicArray<Bytes32>(
                        org.web3j.abi.Utils.typeMap(_R, Bytes32.class)),
                new DynamicArray<Bytes32>(
                        org.web3j.abi.Utils.typeMap(_S, Bytes32.class))),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<byte[]> R(byte[] param0, BigInteger param1) {
        final Function function = new Function(FUNC_R, 
                Arrays.<Type>asList(new Bytes32(param0),
                new org.web3j.abi.datatypes.generated.Uint256(param1)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
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

    public RemoteCall<byte[]> S(byte[] param0, BigInteger param1) {
        final Function function = new Function(FUNC_S, 
                Arrays.<Type>asList(new Bytes32(param0),
                new org.web3j.abi.datatypes.generated.Uint256(param1)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteCall<TransactionReceipt> PassMesage(String _to, byte[] _data, byte[] _trhhash) {
        final Function function = new Function(
                FUNC_PASSMESAGE, 
                Arrays.<Type>asList(new Address(_to),
                new DynamicBytes(_data),
                new Bytes32(_trhhash)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> V(byte[] param0, BigInteger param1) {
        final Function function = new Function(FUNC_V, 
                Arrays.<Type>asList(new Bytes32(param0),
                new org.web3j.abi.datatypes.generated.Uint256(param1)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
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

    public RemoteCall<TransactionReceipt> signMessage(String _to, byte[] _data, byte[] _trhhash, BigInteger _v, byte[] _r, byte[] _s) {
        final Function function = new Function(
                FUNC_SIGNMESSAGE, 
                Arrays.<Type>asList(new Address(_to),
                new DynamicBytes(_data),
                new Bytes32(_trhhash),
                new Uint8(_v),
                new Bytes32(_r),
                new Bytes32(_s)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static RemoteCall<Sm1> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, List<String> volidators, BigInteger _num) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new DynamicArray<Address>(
                        org.web3j.abi.Utils.typeMap(volidators, Address.class)),
                new org.web3j.abi.datatypes.generated.Uint256(_num)));
        return deployRemoteCall(Sm1.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static RemoteCall<Sm1> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, List<String> volidators, BigInteger _num) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new DynamicArray<Address>(
                        org.web3j.abi.Utils.typeMap(volidators, Address.class)),
                new org.web3j.abi.datatypes.generated.Uint256(_num)));
        return deployRemoteCall(Sm1.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
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

    public List<RequessToPasVRSEventResponse> getRequessToPasVRSEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(REQUESSTOPASVRS_EVENT, transactionReceipt);
        ArrayList<RequessToPasVRSEventResponse> responses = new ArrayList<RequessToPasVRSEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            RequessToPasVRSEventResponse typedResponse = new RequessToPasVRSEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._to = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse._data = (byte[]) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse._trhhash = (byte[]) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse._V = (List<BigInteger>) eventValues.getNonIndexedValues().get(3).getValue();
            typedResponse._R = (List<byte[]>) eventValues.getNonIndexedValues().get(4).getValue();
            typedResponse._S = (List<byte[]>) eventValues.getNonIndexedValues().get(5).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<RequessToPasVRSEventResponse> requessToPasVRSEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, RequessToPasVRSEventResponse>() {
            @Override
            public RequessToPasVRSEventResponse call(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(REQUESSTOPASVRS_EVENT, log);
                RequessToPasVRSEventResponse typedResponse = new RequessToPasVRSEventResponse();
                typedResponse.log = log;
                typedResponse._to = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse._data = (byte[]) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse._trhhash = (byte[]) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse._V = (List<BigInteger>) eventValues.getNonIndexedValues().get(3).getValue();
                typedResponse._R = (List<byte[]>) eventValues.getNonIndexedValues().get(4).getValue();
                typedResponse._S = (List<byte[]>) eventValues.getNonIndexedValues().get(5).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<RequessToPasVRSEventResponse> requessToPasVRSEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(REQUESSTOPASVRS_EVENT));
        return requessToPasVRSEventObservable(filter);
    }

    public static Sm1 load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Sm1(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static Sm1 load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Sm1(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
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

    public static class RequessToPasMessageEventResponse {
        public Log log;

        public String _to;

        public byte[] _data;
    }

    public static class RequessToPasVRSEventResponse {
        public Log log;

        public String _to;

        public byte[] _data;

        public byte[] _trhhash;

        public List<BigInteger> _V;

        public List<byte[]> _R;

        public List<byte[]> _S;
    }
}
