import org.web3j.crypto.Credentials;
import org.web3j.crypto.ECKeyPair;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.EthLog;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ivan on 17.08.18.
 */
public class firstRun {
    public static void main(String[] args) throws Exception {
        ConsoleMessager cm=new ConsoleMessager();
        cm.open("Loading");
        cm.cont("Reading the configuration file...");
        GlobalConf gc=new GlobalConf(new File("config.conf"));
        cm.cont("Starting WEB3j...(1/2)");
        Web3j web3c = Web3j.build(new HttpService(gc.get("netc")));
        cm.cont("Starting WEB3j...(2/2)");
        Web3j web3e = Web3j.build(new HttpService(gc.get("nete")));
        cm.cont("Generating keys...");


        String sm1addr=gc.get("sm1addr");
        String sm2addr=gc.get("sm2addr");
        String ethaddr=gc.get("ethaddr");
        String cheapaddr=gc.get("cheapaddr");


        String privkey=gc.get("privkey");
        String pubkey="";

        BigInteger privateKeyInBT = new BigInteger(privkey, 16);

        ECKeyPair aPair = ECKeyPair.create(privateKeyInBT);

        BigInteger publicKeyInBT = aPair.getPublicKey();

        String sPublickeyInHex = publicKeyInBT.toString(16);
        pubkey=sPublickeyInHex;




        cm.cont("Loading the wallet...");
        Credentials credentials = Credentials.create(privkey,pubkey);

        cm.cont("Loading smart contract interfaces...(1/4)");
        Sm1 sm1= Sm1.load(sm1addr,web3c,credentials,big(10),big(8000000));
        cm.cont("Loading smart contract interfaces...(2/4)");
        Sm2 sm2= Sm2.load(sm2addr,web3e,credentials,big(10),big(8000000));
        cm.cont("Loading smart contract interfaces...(3/4)");
        Cheap cheap= Cheap.load(cheapaddr,web3c,credentials,big(10),big(8000000));
        cm.cont("Loading smart contract interfaces...(4/4)");
        Eth eth= Eth.load(ethaddr,web3e,credentials,big(10),big(8000000));
        cm.close();
        cm.open("Check");
        cm.cont("Checking the listener...(1/2)");
        //int oldl=updateEvents(web3,sm1,sm1addr).size()-1;
        cm.cont("Checking the listener...(2/2)");
        cm.cont("Event listening begins!");
        cm.close();
        cm.open("First run initalizing");
        cm.cont("Writing eth address to cheap...");
        cm.cont("Transaction receipt",cheap.getAddress(ethaddr).send().toString());
        cm.cont("Writing cheap address to eth...");
        cm.cont("Transaction receipt",eth.getAddress(cheapaddr).send().toString());
        cm.close();
        cm.open("Information");
        cm.cont("Running the configer...");
        cm.close();
        Configer.main(new String[]{});
        cm.open("Information");
        cm.cont("Running the bridge...");
        cm.close();
        project3.main(new String[]{});
    }


    private static String packBytes(String a, String b, String c) {
        return "0x"+a.substring(2)+b.substring(2)+c.substring(2);
    }

    private static List<FuncParams> updateEvents(Web3j web3, Sm1 sm1, String sm1addr) throws IOException {
        //String sm1addr=sm1.getContractAddress();
        EthFilter filter = new EthFilter(DefaultBlockParameterName.EARLIEST, DefaultBlockParameterName.LATEST, sm1addr);
        List<FuncParams> data=new ArrayList<>();
        List<EthLog.LogResult> logRes=web3.ethGetLogs(filter).send().getLogs();
        for (EthLog.LogResult t:logRes) {
            String txHash=getTXHash(t.toString());
            TransactionReceipt tr=web3.ethGetTransactionReceipt(txHash).send().getTransactionReceipt().get();
            List<Sm1.RequessToPasMessageEventResponse> evs=sm1.getRequessToPasMessageEvents(tr);
            for (Sm1.RequessToPasMessageEventResponse te:
                    evs) {
                FuncParams fp=new FuncParams();
                fp.addr=te._to;
                fp.txHash=txHash;
                fp.data=te._data;
                data.add(fp);
            }
            //System.out.println(tr.toString());
        }
        return data;
    }

    private static String getTXHash(String s) {
        String st=s.substring(s.lastIndexOf("transactionHash=\'")+17);
        st=st.substring(0,st.indexOf("\'"));
        return st;
    }
    public static byte[] hexStringToByteArray(String s) {
        s=s.substring(2);
        byte[] b = new byte[s.length() / 2];
        for (int i = 0; i < b.length; i++) {
            int index = i * 2;
            int v = Integer.parseInt(s.substring(index, index + 2), 16);
            b[i] = (byte) v;
        }
        return b;
    }
    public static String bytesToHex(byte[] bytes) {
        char[] hexArray = "0123456789ABCDEF".toCharArray();
        char[] hexChars = new char[bytes.length * 2];
        for ( int j = 0; j < bytes.length; j++ ) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return "0x"+new String(hexChars);
    }
    private static BigInteger big(int i) {
        return new BigInteger(Integer.toString(i));
    }
}
