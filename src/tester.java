import org.web3j.crypto.Credentials;
import org.web3j.crypto.ECKeyPair;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

import java.math.BigInteger;

public class tester {

    public static void main(String[] args) throws Exception{
        // write your code here
        Web3j web3 = Web3j.build(new HttpService("https://kovan.infura.io/mew"));



        String sm1addr="0x16039e45f59c46507ba4c1c8a40e829af281256a";
        String sm2addr="0x1286470032cc2729774f5cf966770b450825f104";

        String privkey="8e1a2ec8d8e729183e028207c068ec9a4655512017e456b301a18d5bbc350775";
        String pubkey="";

        BigInteger privateKeyInBT = new BigInteger(privkey, 16);

        ECKeyPair aPair = ECKeyPair.create(privateKeyInBT);

        BigInteger publicKeyInBT = aPair.getPublicKey();

        String sPublickeyInHex = publicKeyInBT.toString(16);
        pubkey=sPublickeyInHex;




        Credentials credentials = Credentials.create(privkey,pubkey);//WalletUtils.loadCredentials("cfvggkrubhcg","MezhBlockchain/keyMetamask.json");
        //TransactionManager tm=;
        //Sum sumc=Sum.deploy(web3,credentials,big(1),big(200000)).send();
        //System.out.println(sumc.getContractAddress());
        //Sum sumc=Sum.load("",web3,credentials,big(1),big(200000));System.out.println("CONNECTED!");
        Sm1 sm1=Sm1.load(sm1addr,web3,credentials,big(1),big(2000000));
        System.out.println("SM1 IS READY!");
        //Sm2 sm2=Sm2.load(sm2addr,web3,credentials,big(0),big(2000000));
        //System.out.println("SM2 IS READY!");

        sm1.transwerMessage("0xafd6f3dd885ee964365f891d91733133b6c93017",new byte[]{1,2,3,100}).send();
        System.out.println("OK!");
    }

    private static BigInteger big(int i) {
        return new BigInteger(Integer.toString(i));
    }
}
