import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.5.0.
 */
public class Cheap extends Contract {
    private static final String BINARY = "608060405260005460018054600160a060020a031916600160a060020a0390921691909117905534801561003257600080fd5b50610317806100426000396000f3006080604052600436106100615763ffffffff7c01000000000000000000000000000000000000000000000000000000006000350416633cefa92a8114610066578063ae22c57d1461008d578063cad0899b146100bd578063f4b37934146100d8575b600080fd5b34801561007257600080fd5b5061007b61010c565b60408051918252519081900360200190f35b34801561009957600080fd5b506100bb73ffffffffffffffffffffffffffffffffffffffff60043516610112565b005b3480156100c957600080fd5b506100bb60043560243561014e565b3480156100e457600080fd5b506100bb73ffffffffffffffffffffffffffffffffffffffff60043516602435604435610154565b60025490565b6000805473ffffffffffffffffffffffffffffffffffffffff191673ffffffffffffffffffffffffffffffffffffffff92909216919091179055565b01600255565b604080517f73756d2875696e743235362c75696e74323536290000000000000000000000008152815190819003601401812060248083018690526044808401869052845180850382018152606494850186526020810180517bffffffffffffffffffffffffffffffffffffffffffffffffffffffff167fffffffff00000000000000000000000000000000000000000000000000000000861617815260015487517f69a0751b00000000000000000000000000000000000000000000000000000000815273ffffffffffffffffffffffffffffffffffffffff8c811660048301908152968201998a5284519582019590955283519698939794909116956369a0751b958c95899591949193019180838360005b8381101561027f578181015183820152602001610267565b50505050905090810190601f1680156102ac5780820380516001836020036101000a031916815260200191505b509350505050600060405180830381600087803b1580156102cc57600080fd5b505af11580156102e0573d6000803e3d6000fd5b5050505050505050505600a165627a7a72305820e2442e68e6402c1135ff5b341284f179e1a8c46facdfe7ad31c5db5983b0ec310029";

    public static final String FUNC_COUT = "cout";

    public static final String FUNC_GETADDRESS = "getAddress";

    public static final String FUNC_SUM = "sum";

    public static final String FUNC_GETFUNCTION = "GetFunction";

    protected Cheap(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Cheap(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public RemoteCall<BigInteger> cout() {
        final Function function = new Function(FUNC_COUT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> getAddress(String _contracta) {
        final Function function = new Function(
                FUNC_GETADDRESS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_contracta)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> sum(BigInteger _i, BigInteger _a) {
        final Function function = new Function(
                FUNC_SUM, 
                Arrays.<Type>asList(new Uint256(_i),
                new Uint256(_a)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> GetFunction(String _to, BigInteger _a, BigInteger _b) {
        final Function function = new Function(
                FUNC_GETFUNCTION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_to), 
                new Uint256(_a),
                new Uint256(_b)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static RemoteCall<Cheap> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Cheap.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<Cheap> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Cheap.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static Cheap load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Cheap(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static Cheap load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Cheap(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }
}
