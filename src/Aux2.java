import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.5.0.
 */
public class Aux2 extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b5060008054600160a060020a03191633179055610524806100326000396000f30060806040526004361061006c5763ffffffff7c01000000000000000000000000000000000000000000000000000000006000350416634f2fa36881146100715780638b6cf858146100945780639a3fd1fb146100b85780639b0d963814610121578063ee9b80a414610142575b600080fd5b34801561007d57600080fd5b50610092600160a060020a0360043516610163565b005b3480156100a057600080fd5b50610092600160a060020a036004351660243561019f565b3480156100c457600080fd5b50604080516020600460443581810135601f8101849004840285018401909552848452610092948235600160a060020a03169460248035953695946064949201919081908401838280828437509497506102299650505050505050565b34801561012d57600080fd5b50610092600160a060020a0360043516610476565b34801561014e57600080fd5b50610092600160a060020a03600435166104bc565b6003805473ffffffffffffffffffffffffffffffffffffffff19908116600160a060020a03938416179182905560018054929093169116179055565b600254604080517fa9059cbb000000000000000000000000000000000000000000000000000000008152600160a060020a038581166004830152602482018590529151919092169163a9059cbb91604480830192600092919082900301818387803b15801561020d57600080fd5b505af1158015610221573d6000803e3d6000fd5b505050505050565b600454600090606090600160a060020a0316331461024657600080fd5b600254604080517f70a0823100000000000000000000000000000000000000000000000000000000815230600482015290518692600160a060020a0316916370a082319160248083019260209291908290030181600087803b1580156102ab57600080fd5b505af11580156102bf573d6000803e3d6000fd5b505050506040513d60208110156102d557600080fd5b505110156102e257600080fd5b5050604080517f70617373546f6b656e28616464726573732c75696e74323536290000000000008152815190819003601a018120600160a060020a038087166024808501919091526044808501889052855180860382018152606495860187526020810180517bffffffffffffffffffffffffffffffffffffffffffffffffffffffff167fffffffff00000000000000000000000000000000000000000000000000000000871617815260015460055489517f69a0751b000000000000000000000000000000000000000000000000000000008152908716600482018181529682019a8b5284519582019590955283519799939891909616966369a0751b96949589959094939201919080838360005b8381101561040a5781810151838201526020016103f2565b50505050905090810190601f1680156104375780820380516001836020036101000a031916815260200191505b509350505050600060405180830381600087803b15801561045757600080fd5b505af115801561046b573d6000803e3d6000fd5b505050505050505050565b600054600160a060020a0316331461048d57600080fd5b6005805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a0392909216919091179055565b6004805473ffffffffffffffffffffffffffffffffffffffff19908116600160a060020a039384161791829055600280549290931691161790555600a165627a7a723058209362a1fdf5603ba79323de4f1642dfd4b49d4a10e6eb44a9f1840e0d0d5b42860029";

    public static final String FUNC_SETSM1 = "setSm1";

    public static final String FUNC_PASSTOKEN = "passToken";

    public static final String FUNC_TOKENFALLBACK = "tokenFallBack";

    public static final String FUNC_SETAUX = "setAux";

    public static final String FUNC_SETERC20 = "setErc20";

    protected Aux2(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Aux2(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public RemoteCall<TransactionReceipt> setSm1(String _contracta) {
        final Function function = new Function(
                FUNC_SETSM1, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_contracta)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> passToken(String _to, BigInteger amount) {
        final Function function = new Function(
                FUNC_PASSTOKEN, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_to), 
                new org.web3j.abi.datatypes.generated.Uint256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> tokenFallBack(String _from, BigInteger _amount, byte[] _data) {
        final Function function = new Function(
                FUNC_TOKENFALLBACK, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_from), 
                new org.web3j.abi.datatypes.generated.Uint256(_amount), 
                new org.web3j.abi.datatypes.DynamicBytes(_data)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> setAux(String _to) {
        final Function function = new Function(
                FUNC_SETAUX, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_to)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> setErc20(String _erc) {
        final Function function = new Function(
                FUNC_SETERC20, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_erc)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static RemoteCall<Aux2> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Aux2.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<Aux2> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Aux2.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static Aux2 load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Aux2(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static Aux2 load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Aux2(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }
}
