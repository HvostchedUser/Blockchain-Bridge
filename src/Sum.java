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
public class Sum extends Contract {
    private static final String BINARY = "60606040526000600055600060015534610000575b60bf806100216000396000f3606060405260e060020a600035046309cdcf9b8114603a578063569c5f6d146049578063ed1c3c02146065578063ee919d50146084575b6000565b3460005760476004356093565b005b346000576053609c565b60408051918252519081900360200190f35b34600057605360043560a7565b60408051918252519081900360200190f35b34600057604760043560b6565b005b60018190555b50565b600154600054015b90565b6001546000540181015b919050565b60008190555b5056";

    public static final String FUNC_SETB = "setB";

    public static final String FUNC_GETSUM = "getSum";

    public static final String FUNC_GETSUMTWO = "getSumTwo";

    public static final String FUNC_SETA = "setA";

    protected Sum(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Sum(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public RemoteCall<TransactionReceipt> setB(BigInteger _b) {
        final Function function = new Function(
                FUNC_SETB, 
                Arrays.<Type>asList(new Uint256(_b)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> getSum() {
        final Function function = new Function(FUNC_GETSUM, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> getSumTwo(BigInteger c) {
        final Function function = new Function(
                FUNC_GETSUMTWO, 
                Arrays.<Type>asList(new Uint256(c)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> setA(BigInteger _a) {
        final Function function = new Function(
                FUNC_SETA, 
                Arrays.<Type>asList(new Uint256(_a)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static RemoteCall<Sum> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Sum.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<Sum> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Sum.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static Sum load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Sum(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static Sum load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Sum(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }
}
