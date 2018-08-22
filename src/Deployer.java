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
        cm.cont("Deploying Tokes...(1/6)");
        Tokes tokes = Tokes.deploy(web3c,credentials,big(10),big(2000000),big(1000)).send();
        cm.cont("Tokes address",tokes.getContractAddress());
        cm.cont("Deploying sm1...(2/6)");
        List<String> validators1=new ArrayList<>();
        validators1.add("0x7b4b4d811cb805f936854bf9ea30e6b3b69ddb11");
        Sm1 sm1 = Sm1.deploy(web3c,credentials,big(10),big(2000000),validators1,big(1)).send();
        cm.cont("sm1 address",sm1.getContractAddress());
        cm.cont("Deploying sm2...(3/6)");
        List<String> validators2=new ArrayList<>();
        validators2.add("0x7b4b4d811cb805f936854bf9ea30e6b3b69ddb11");
        Sm2 sm2 = Sm2.deploy(web3e,credentials,big(10),big(2000000),validators2,big(1)).send();
        cm.cont("sm2 address",sm2.getContractAddress());
        cm.cont("Deploying Tokenin...(4/6)");
        Tokenin tokenin = Tokenin.deploy(web3e,credentials,big(10),big(2000000)).send();
        cm.cont("Tokenin address",tokenin.getContractAddress());
        cm.cont("Deploying Aux1...(5/6)");
        Aux1 aux1= Aux1.deploy(web3c,credentials,big(10),big(2000000)).send();
        cm.cont("Aux1 address",aux1.getContractAddress());
        cm.cont("Deploying Aux2...(6/6)");
        Aux2 aux2= Aux2.deploy(web3e,credentials,big(10),big(2000000)).send();
        cm.cont("Aux2 address",aux2.getContractAddress());
        cm.cont("OK!");
        cm.close();
        cm.open("Deployment finished, contract addresses");
        cm.cont("tokes",tokes.getContractAddress());
        gc.set("tokesaddr",tokes.getContractAddress());
        cm.cont("tokenin",tokenin.getContractAddress());
        gc.set("tokeninaddr",tokenin.getContractAddress());
        cm.cont("sm1",sm1.getContractAddress());
        gc.set("sm1addr",sm1.getContractAddress());
        cm.cont("sm2",sm2.getContractAddress());
        gc.set("sm2addr",sm2.getContractAddress());
        cm.cont("aux1",aux1.getContractAddress());
        gc.set("aux1addr",aux1.getContractAddress());
        cm.cont("aux2",aux2.getContractAddress());
        gc.set("aux2addr",aux2.getContractAddress());
        cm.close();
        cm.open("Warning");
        cm.cont("Run Configer to setup sm1 and sm2!");
        cm.close();
        gc.save();
        cm.open("Information");
        cm.cont("Running the firstRun program...");
        cm.close();
        //firstRun.main(new String []{});

    }

    private static BigInteger big(int i) {
        return new BigInteger(Integer.toString(i));
    }
}
