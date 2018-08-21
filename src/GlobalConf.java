import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by ivan on 20.08.18.
 */
public class GlobalConf {
    File file;
    HashMap<String,String> map=new HashMap<>();
    public GlobalConf(File f) throws FileNotFoundException {
        file=f;
        Scanner s=new Scanner(f);
        while(s.hasNext()){
            map.put(s.next(),s.next());
        }
    }
    public String get(String s){
        return map.get(s);
    }
    public void set(String a,String b){
        map.put(a,b);
    }
    public void save() throws IOException {
        BufferedWriter bw=new BufferedWriter(new FileWriter(file));
        for (String key:map.keySet()) {
            bw.write(key+" "+map.get(key)+" ");
            bw.newLine();
        }
        bw.close();
    }
}
