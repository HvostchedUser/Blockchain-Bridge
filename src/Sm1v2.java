

import org.web3j.abi.EventEncoder;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.*;
import org.web3j.abi.datatypes.generated.Bytes32;
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
public class Sm1v2 extends Contract {
    private static final String BINARY = "6080604052600160035534801561001557600080fd5b50604051610b19380380610b198339810160405280510160005b8151811015610085576001806000848481518110151561004b57fe5b602090810291909101810151600160a060020a03168252810191909152604001600020805460ff191691151591909117905560010161002f565b5050610a83806100966000396000f3006080604052600436106100985763ffffffff7c0100000000000000000000000000000000000000000000000000000000600035041663147da974811461009d578063338b41a2146100d2578063399e0792146100fc5780635bad2b701461011457806369a0751b146101dd57806376cf132b14610244578063a7a44b7d14610272578063e5cfd84914610309578063f96d37e114610321575b600080fd5b3480156100a957600080fd5b506100be600160a060020a0360043516610339565b604080519115158252519081900360200190f35b3480156100de57600080fd5b506100ea60043561034e565b60408051918252519081900360200190f35b34801561010857600080fd5b506100be60043561036d565b34801561012057600080fd5b50604080516020600480358082013583810280860185019096528085526101db95369593946024949385019291829185019084908082843750506040805187358901803560208181028481018201909552818452989b9a998901989297509082019550935083925085019084908082843750506040805187358901803560208181028481018201909552818452989b9a9989019892975090820195509350839250850190849080828437509497506103829650505050505050565b005b3480156101e957600080fd5b5060408051602060046024803582810135601f81018590048502860185019096528585526101db958335600160a060020a03169536956044949193909101919081908401838280828437509497506104889650505050505050565b34801561025057600080fd5b5061025c60043561053f565b6040805160ff9092168252519081900360200190f35b34801561027e57600080fd5b5060408051602060046024803582810135601f81018590048502860185019096528585526102ed958335600160a060020a03169536956044949193909101919081908401838280828437509497505084359550505050602082013560ff16916040810135915060600135610571565b60408051600160a060020a039092168252519081900360200190f35b34801561031557600080fd5b506100ea600435610a37565b34801561032d57600080fd5b506100ea600435610a45565b60016020526000908152604090205460ff1681565b600680548290811061035c57fe5b600091825260209091200154905081565b60026020526000908152604090205460ff1681565b7fe8b60eba09f3d26903fbcf4bde281a2f62954a8e2a581ad9fba54618f3fcdbe083838360405180806020018060200180602001848103845287818151815260200191508051906020019060200280838360005b838110156103ee5781810151838201526020016103d6565b50505050905001848103835286818151815260200191508051906020019060200280838360005b8381101561042d578181015183820152602001610415565b50505050905001848103825285818151815260200191508051906020019060200280838360005b8381101561046c578181015183820152602001610454565b50505050905001965050505050505060405180910390a1505050565b7f6e3c72dcd88f70559516b069820c6cbcadae49f53e0a583ecc963fa1769987f182826040518083600160a060020a0316600160a060020a0316815260200180602001828103825283818151815260200191508051906020019080838360005b838110156105005781810151838201526020016104e8565b50505050905090810190601f16801561052d5780820380516001836020036101000a031916815260200191505b50935050505060405180910390a15050565b600480548290811061054d57fe5b9060005260206000209060209182820401919006915054906101000a900460ff1681565b6000806000808989896040518084600160a060020a0316600160a060020a03166c0100000000000000000000000002815260140183805190602001908083835b602083106105d05780518252601f1990920191602091820191016105b1565b51815160209384036101000a6000190180199092169116179052920193845250604080519384900382018420600080865285840180845282905260ff8f1686840152606086018e9052608086018d905291519099506001965060a080860196509294601f19820194508190039092019190865af1158015610655573d6000803e3d6000fd5b505060408051601f190151600160a060020a0381166000908152600160208190529290205490945060ff16151514905061068e57600080fd5b818a8a8a6040518085600160a060020a0316600160a060020a03166c0100000000000000000000000002815260140184600160a060020a0316600160a060020a03166c0100000000000000000000000002815260140183805190602001908083835b6020831061070f5780518252601f1990920191602091820191016106f0565b51815160209384036101000a60001901801990921691161790529201938452506040805193849003820190932060008181526002909252929020549195505060ff1615925061076091505057600080fd5b600081815260026020908152604091829020805460ff1916600117905590516c01000000000000000000000000600160a060020a038d160281528a518c928c928c9290916014830191908501908083835b602083106107d05780518252601f1990920191602091820191016107b1565b6001836020036101000a0380198251168184511680821785525050505050509050018260001916600019168152602001935050505060405180910390209050600080826000191660001916815260200190815260200160002060008154809291906001019190505550600487908060018154018082558091505090600182039060005260206000209060209182820401919006909192909190916101000a81548160ff021916908360ff160217905550506005869080600181540180825580915050906001820390600052602060002001600090919290919091509060001916905550600685908060018154018082558091505090600182039060005260206000200160009091929091909150906000191690555060035460008083600019166000191681526020019081526020016000205414151561090f57600080fd5b610a2a600480548060200260200160405190810160405280929190818152602001828054801561097c57602002820191906000526020600020906000905b825461010083900a900460ff1681526020600192830181810494850194909303909202910180841161094d5790505b505050505060058054806020026020016040519081016040528092919081815260200182805480156109ce57602002820191906000526020600020905b815481526001909101906020018083116109b9575b50505050506006805480602002602001604051908101604052809291908181526020018280548015610a2057602002820191906000526020600020905b81548152600190910190602001808311610a0b575b5050505050610382565b5050509695505050505050565b600580548290811061035c57fe5b600060208190529081526040902054815600a165627a7a72305820bb9e772f4a2ab1e01e5d00539c0931ac01dab9a64f9b9bcb79935d4acb536e360029";

    public static final String FUNC_VOLID = "volid";

    public static final String FUNC_S = "S";

    public static final String FUNC_CHECK = "check";

    public static final String FUNC_TRANSWERVRS = "transwerVRS";

    public static final String FUNC_TRANSWERMESSAGE = "transwerMessage";

    public static final String FUNC_V = "V";

    public static final String FUNC_SIGNMESSAGE = "signMessage";

    public static final String FUNC_R = "R";

    public static final String FUNC_CNT = "cnt";

    public static final Event REQUESSTOPASMESSAGE_EVENT = new Event("RequessToPasMessage", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<DynamicBytes>() {}));
    ;

    public static final Event REQUESSTOPASVRS_EVENT = new Event("RequessToPasVRS", 
            Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Uint8>>() {}, new TypeReference<DynamicArray<Bytes32>>() {}, new TypeReference<DynamicArray<Bytes32>>() {}));
    ;

    protected Sm1v2(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Sm1v2(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public RemoteCall<Boolean> volid(String param0) {
        final Function function = new Function(FUNC_VOLID, 
                Arrays.<Type>asList(new Address(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<byte[]> S(BigInteger param0) {
        final Function function = new Function(FUNC_S, 
                Arrays.<Type>asList(new Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteCall<Boolean> check(byte[] param0) {
        final Function function = new Function(FUNC_CHECK, 
                Arrays.<Type>asList(new Bytes32(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<TransactionReceipt> transwerVRS(List<BigInteger> _V, List<byte[]> _R, List<byte[]> _S) {
        final Function function = new Function(
                FUNC_TRANSWERVRS, 
                Arrays.<Type>asList(new DynamicArray<Uint8>(
                        org.web3j.abi.Utils.typeMap(_V, Uint8.class)), 
                new DynamicArray<Bytes32>(
                        org.web3j.abi.Utils.typeMap(_R, Bytes32.class)), 
                new DynamicArray<Bytes32>(
                        org.web3j.abi.Utils.typeMap(_S, Bytes32.class))), 
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

    public RemoteCall<BigInteger> V(BigInteger param0) {
        final Function function = new Function(FUNC_V, 
                Arrays.<Type>asList(new Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
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

    public RemoteCall<byte[]> R(BigInteger param0) {
        final Function function = new Function(FUNC_R, 
                Arrays.<Type>asList(new Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteCall<BigInteger> cnt(byte[] param0) {
        final Function function = new Function(FUNC_CNT, 
                Arrays.<Type>asList(new Bytes32(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public static RemoteCall<Sm1v2> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, List<String> volidators) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new DynamicArray<Address>(
                        org.web3j.abi.Utils.typeMap(volidators, Address.class))));
        return deployRemoteCall(Sm1v2.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static RemoteCall<Sm1v2> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, List<String> volidators) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new DynamicArray<Address>(
                        org.web3j.abi.Utils.typeMap(volidators, Address.class))));
        return deployRemoteCall(Sm1v2.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
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
            typedResponse._V = (List<BigInteger>) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse._R = (List<byte[]>) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse._S = (List<byte[]>) eventValues.getNonIndexedValues().get(2).getValue();
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
                typedResponse._V = (List<BigInteger>) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse._R = (List<byte[]>) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse._S = (List<byte[]>) eventValues.getNonIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<RequessToPasVRSEventResponse> requessToPasVRSEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(REQUESSTOPASVRS_EVENT));
        return requessToPasVRSEventObservable(filter);
    }

    public static Sm1v2 load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Sm1v2(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static Sm1v2 load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Sm1v2(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static class RequessToPasMessageEventResponse {
        public Log log;

        public String _to;

        public byte[] _data;
    }

    public static class RequessToPasVRSEventResponse {
        public Log log;

        public List<BigInteger> _V;

        public List<byte[]> _R;

        public List<byte[]> _S;
    }
}
