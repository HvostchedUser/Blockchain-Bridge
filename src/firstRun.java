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


        //String sm1addr="0x16039e45f59c46507ba4c1c8a40e829af281256a";
        //String sm2addr="0x1286470032cc2729774f5cf966770b450825f104";


        String privkey=gc.get("privkey");
        String pubkey="";

        BigInteger privateKeyInBT = new BigInteger(privkey, 16);

        ECKeyPair aPair = ECKeyPair.create(privateKeyInBT);

        BigInteger publicKeyInBT = aPair.getPublicKey();

        String sPublickeyInHex = publicKeyInBT.toString(16);
        pubkey=sPublickeyInHex;


        //aux1 adminize
        //aux1/2 send erc20addrs
        cm.cont("Loading the wallet...");
        Credentials credentials = Credentials.create(privkey,pubkey);
        cm.cont("My address",credentials.getAddress());
        cm.cont("Ready!");
        cm.cont("Loading smart contract interfaces...(1/4)");
        Aux1 aux1= Aux1.load(gc.get("aux1addr"),web3c,credentials,big(10),big(8000000));
        cm.cont("Loading smart contract interfaces...(2/4)");
        Aux2 aux2=Aux2.load(gc.get("aux2addr"),web3e,credentials,big(10),big(8000000));
        cm.cont("Loading smart contract interfaces...(3/4)");
        Tokenin tokenin= Tokenin.load(gc.get("tokeninaddr"),web3c,credentials,big(10),big(8000000));
        cm.cont("Loading smart contract interfaces...(4/4)");
        Tokes tokes= Tokes.load(gc.get("tokesaddr"),web3e,credentials,big(10),big(8000000));
        cm.close();
        cm.open("Setup");
        cm.cont("Adminize aux1...");
        cm.cont("Transacting...");
        cm.cont("Aux1 is now a professional tokenin minter! Prove",tokenin.setPermitionToMint(gc.get("aux1addr")).send());
        cm.cont("Aux1 is now a professional tokenin burner! Prove",tokenin.setPermitionToBurn(gc.get("aux1addr")).send());
        cm.cont("Aux1 has permissions to mint and burn tokens");
        cm.cont("Informate aux1 and aux2 about tokenin and tokes and everything else...");
        cm.cont("Aux2 knows where sm2 is! Transaction receipt",aux2.setSm1(gc.get("sm2addr")).send());
        cm.cont("Aux2 knows where tokes are stored! Transaction receipt",aux2.setErc20(gc.get("tokesaddr")).send());
        cm.cont("Aux2 has found his brother, Aux1! Transaction receipt",aux2.setAux(gc.get("aux1addr")).send());
        cm.cont("Aux1 knows where sm1 is! Transaction receipt",aux1.setSm1(gc.get("sm1addr")).send());
        cm.cont("Aux1 knows where tokenins are stored! Transaction receipt",aux1.setErc20(gc.get("tokeninaddr")).send());
        cm.cont("Aux1 has found his brother, Aux2! Transaction receipt",aux1.setAux(gc.get("aux2addr")).send());
        cm.cont("Everything is ok, bye!");
        cm.close();

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
