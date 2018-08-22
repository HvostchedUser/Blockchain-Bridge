import org.web3j.crypto.Credentials;
import org.web3j.crypto.ECKeyPair;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

import java.io.File;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ivan on 15.08.18.
 */
public class Deployer {
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
        cm.cont("Ready!");
        cm.close();
        cm.open("Deploy");
        cm.cont("Deployment begins!");
        cm.cont("Deploying Tokes...(1/4)");
        Tokes cheap = Tokes.deploy(web3c,credentials,big(10),big(2000000)).send();
        cm.cont("cheap address",cheap.getContractAddress());
        cm.cont("Deploying sm1...(2/4)");
        List<String> validators1=new ArrayList<>();
        validators1.add("0x7b4b4d811cb805f936854bf9ea30e6b3b69ddb11");
        Sm1 sm1 = Sm1.deploy(web3c,credentials,big(10),big(2000000),validators1,big(1)).send();
        cm.cont("sm1 address",sm1.getContractAddress());
        cm.cont("Deploying sm2...(3/4)");
        List<String> validators2=new ArrayList<>();
        validators2.add("0x7b4b4d811cb805f936854bf9ea30e6b3b69ddb11");
        Sm2 sm2 = Sm2.deploy(web3e,credentials,big(10),big(2000000),validators2,big(1)).send();
        cm.cont("sm2 address",sm2.getContractAddress());
        cm.cont("Deploying Tokenin...(4/4)");
        Tokenin eth = Tokenin.deploy(web3e,credentials,big(10),big(2000000)).send();
        cm.cont("eth address",eth.getContractAddress());
        cm.cont("OK!");
        cm.close();
        cm.open("Deployment finished, contract addresses");
        cm.cont("cheap",cheap.getContractAddress());
        gc.set("cheapaddr",cheap.getContractAddress());
        cm.cont("sm1",sm1.getContractAddress());
        gc.set("sm1addr",sm1.getContractAddress());
        cm.cont("sm2",sm2.getContractAddress());
        gc.set("sm2addr",sm2.getContractAddress());
        cm.cont("eth",eth.getContractAddress());
        gc.set("ethaddr",eth.getContractAddress());
        cm.close();
        cm.open("Warning");
        cm.cont("Run Configer to setup these contracts!");
        cm.close();
        gc.save();
        cm.open("Information");
        cm.cont("Running the firstRun program...");
        cm.close();
        firstRun.main(new String []{});

    }

    private static BigInteger big(int i) {
        return new BigInteger(Integer.toString(i));
    }
}
