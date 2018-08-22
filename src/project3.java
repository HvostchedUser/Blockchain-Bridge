import org.web3j.crypto.Credentials;
import org.web3j.crypto.ECKeyPair;
import org.web3j.crypto.Sign;
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
public class project3 {
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

        cm.cont("Loading smart contract interfaces...(1/2)");
        Sm1 sm1= Sm1.load(sm1addr,web3c,credentials,big(10),big(8000000));
        cm.cont("Loading smart contract interfaces...(2/2)");
        Sm2 sm2= Sm2.load(sm2addr,web3e,credentials,big(10),big(8000000));
        //cm.cont("Loading smart contract interfaces...(3/4)");
        //Cheap cheap= Cheap.load(cheapaddr,web3c,credentials,big(10),big(8000000));
        //cm.cont("Loading smart contract interfaces...(4/4)");
        //Eth eth= Eth.load(ethaddr,web3e,credentials,big(10),big(8000000));
        cm.close();
        cm.open("Check");
        //int oldl=updateEvents(web3,sm1,sm1addr).size()-1;
        cm.cont("Event listening begins!");
        Thread sm1tosm2=new Thread(new Runnable() {
            @Override
            public void run() {
                cm.cont("Checking the listener of cheapnet events...");

                int rtpm1l= 0;
                try {
                    rtpm1l = updateEvents1rtpm(web3c,sm1,sm1.getContractAddress()).size();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                int rtpVRS1l= 0;
                try {
                    rtpVRS1l = updateEvents1rtpVRS(web3c,sm1,sm1.getContractAddress()).size();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                cm.cont("Cheapnet listener is OK!");
                while(true){
                    try {
                        List<RTPVRSSM1> pasVRS1 = updateEvents1rtpVRS(web3c, sm1, sm1.getContractAddress());
                        List<RTPMSM1> pasMes1 = updateEvents1rtpm(web3c, sm1, sm1.getContractAddress());
                        if (pasMes1.size() > rtpm1l) {
                            cm.open("Event response");
                            cm.cont("Got event from SM1, request to sign the message.");
                            rtpm1l = pasMes1.size();
                            RTPMSM1 rm1;
                            rm1 = pasMes1.get(rtpm1l - 1);
                            cm.cont("Address",rm1.addr);
                            cm.cont("Data",rm1.data);
                            cm.cont("Transaction hash",rm1.txHash);
                            cm.close();
                            cm.open("Information");
                            cm.cont("Generating the signature...");
                            Sign.SignatureData sigRes = Sign.signMessage(hexStringToByteArray(packBytes(rm1.addr, bytesToHex(rm1.data), rm1.txHash)), aPair);
                            cm.cont("V",sigRes.getV());
                            cm.cont("R",sigRes.getR());
                            cm.cont("S",sigRes.getS());
                            cm.cont("Signing the message...");
                            cm.cont("Transaction receipt",sm1.signMessage(rm1.addr, rm1.data, hexStringToByteArray(rm1.txHash), big(sigRes.getV()), sigRes.getR(), sigRes.getS()).send());
                            cm.close();
                        }
                        if ( pasVRS1.size() > rtpVRS1l) {
                            cm.open("Event response");
                            cm.cont("Got event from SM1, request to pass V, R and S.");
                            rtpVRS1l = pasVRS1.size();
                            RTPVRSSM1 rvrs1;
                            rvrs1 = pasVRS1.get(rtpVRS1l - 1);
                            cm.cont("Address",rvrs1.addr);
                            cm.cont("Data",rvrs1.data);
                            cm.cont("Transaction hash",rvrs1.rttrhash);
                            cm.cont("V",rvrs1.v);
                            cm.cont("R",rvrs1.r);
                            cm.cont("S",rvrs1.s);
                            cm.cont("Sending the signature...");
                            cm.cont("Transaction receipt",sm2.PassSignatureFromCheap(rvrs1.addr, rvrs1.data, rvrs1.rttrhash, rvrs1.v, rvrs1.r, rvrs1.s).send());
                            cm.close();
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread sm2tosm1=new Thread(new Runnable() {
            @Override
            public void run() {
                cm.cont("Checking the listener of expensivenet events...");
                int rtpm1l= 0;
                try {
                    rtpm1l = updateEvents1rtpm(web3c,sm1,sm1.getContractAddress()).size();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                cm.cont("Expensivenet listener is OK!");
                while(true){
                    try {
                        List<RTPMSM1> pasMes1 = updateEvents2rtpm(web3e, sm2, sm2.getContractAddress());
                        if (pasMes1.size() > rtpm1l) {
                            cm.open("Event response");
                            cm.cont("Got event from SM2, request to pass the message.");
                            rtpm1l = pasMes1.size();
                            RTPMSM1 rm1;
                            rm1 = pasMes1.get(rtpm1l - 1);
                            cm.cont("Address",rm1.addr);
                            cm.cont("Data",rm1.data);
                            cm.cont("Transaction hash",rm1.txHash);
                            cm.cont("Sending the message...");
                            cm.cont("Transaction receipt",sm1.PassMesage(rm1.addr,rm1.data,hexStringToByteArray(rm1.txHash)).send());
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        });
        sm1tosm2.start();
        sm2tosm1.start();

        Thread.sleep(5000);

        cm.close();
    }
    private static List<RTPVRSSM1> updateEvents1rtpVRS(Web3j web3, Sm1 sm1, String sm1addr) throws IOException {
        //String sm1addr=sm1.getContractAddress();
        EthFilter filter = new EthFilter(DefaultBlockParameterName.EARLIEST, DefaultBlockParameterName.LATEST, sm1addr);
        List<RTPVRSSM1> data=new ArrayList<>();
        List<EthLog.LogResult> logRes=web3.ethGetLogs(filter).send().getLogs();
        for (EthLog.LogResult t:logRes) {
            String txHash=getTXHash(t.toString());
            TransactionReceipt tr=web3.ethGetTransactionReceipt(txHash).send().getTransactionReceipt().get();
            List<Sm1.RequessToPasVRSEventResponse> evs=sm1.getRequessToPasVRSEvents(tr);
            for (Sm1.RequessToPasVRSEventResponse te:
                    evs) {
                RTPVRSSM1 fp=new RTPVRSSM1();
                fp.addr=te._to;
                fp.data=te._data;
                fp.rttrhash=te._trhhash;
                fp.v=te._V;
                fp.r=te._R;
                fp.s=te._S;
                data.add(fp);
            }
            //System.out.println(tr.toString());
        }
        return data;
    }
    private static List<RTPMSM1> updateEvents2rtpm(Web3j web3, Sm2 sm1, String sm1addr) throws IOException {
        //String sm1addr=sm1.getContractAddress();
        EthFilter filter = new EthFilter(DefaultBlockParameterName.EARLIEST, DefaultBlockParameterName.LATEST, sm1addr);
        List<RTPMSM1> data=new ArrayList<>();
        List<EthLog.LogResult> logRes=web3.ethGetLogs(filter).send().getLogs();
        for (EthLog.LogResult t:logRes) {
            String txHash=getTXHash(t.toString());
            TransactionReceipt tr=web3.ethGetTransactionReceipt(txHash).send().getTransactionReceipt().get();
            List<Sm2.RequessToPasMessageEventResponse> evs=sm1.getRequessToPasMessageEvents(tr);
            for (Sm2.RequessToPasMessageEventResponse te:
                    evs) {
                RTPMSM1 fp=new RTPMSM1();
                fp.addr=te._to;
                fp.txHash=txHash;
                fp.data=te._data;
                data.add(fp);
            }
            //System.out.println(tr.toString());
        }
        return data;
    }

    private static List<RTPMSM1> updateEvents1rtpm(Web3j web3, Sm1 sm1, String sm1addr) throws IOException {
        //String sm1addr=sm1.getContractAddress();
        EthFilter filter = new EthFilter(DefaultBlockParameterName.EARLIEST, DefaultBlockParameterName.LATEST, sm1addr);
        List<RTPMSM1> data=new ArrayList<>();
        List<EthLog.LogResult> logRes=web3.ethGetLogs(filter).send().getLogs();
        for (EthLog.LogResult t:logRes) {
            String txHash=getTXHash(t.toString());
            TransactionReceipt tr=web3.ethGetTransactionReceipt(txHash).send().getTransactionReceipt().get();
            List<Sm1.RequessToPasMessageEventResponse> evs=sm1.getRequessToPasMessageEvents(tr);
            for (Sm1.RequessToPasMessageEventResponse te:
                    evs) {
                RTPMSM1 fp=new RTPMSM1();
                fp.addr=te._to;
                fp.txHash=txHash;
                fp.data=te._data;
                data.add(fp);
            }
            //System.out.println(tr.toString());
        }
        return data;
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
