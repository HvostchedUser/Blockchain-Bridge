import org.web3j.crypto.Credentials;
import org.web3j.crypto.ECKeyPair;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

import java.io.File;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by ivan on 22.08.18.
 */
public class TokenConfig {
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



        cm.cont("Loading the wallet...");
        Credentials credentials = Credentials.create(privkey,pubkey);
        cm.cont("My address",credentials.getAddress());
        cm.cont("Ready!");
        cm.close();

        cm.open("Loading");
        cm.cont("Loading tokenin...");
        Tokenin tokenin = Tokenin.load(gc.get("tokeninaddr"),web3c,credentials,big(10),big(2000000));
        cm.close();
        cm.open("Tips");
        cm.cont("Write \"allowToMint\" to add a minter or");
        cm.cont("\"allowToBurn\" to add a burner or");
        cm.close();
        cm.open("Console");
        Scanner s=new Scanner(System.in);
        while(true){
            cm.cont("Ready!");
            String st=s.nextLine();
            if(st.equals("allowToMint")){
                cm.cont("Write an address of a new minter.");
                st=s.nextLine();
                cm.cont("Transacting...");
                cm.cont("Transaction receipt",tokenin.setPermitionToMint(st).send());
                cm.cont("OK!");
            }
            if(st.equals("allowToBurn")){
                cm.cont("Write an address of a new burner.");
                st=s.nextLine();
                cm.cont("Transacting...");
                cm.cont("Transaction receipt",tokenin.setPermitionToBurn(st).send());
                cm.cont("OK!");
            }
        }

    }

    private static BigInteger big(int i) {
        return new BigInteger(Integer.toString(i));
    }
}
