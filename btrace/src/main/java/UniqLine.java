import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * @author wuzhong
 * @create 2012 4:56 PM
 * @moduleDes
 *
 *
 *  java -classpath . UniqLine  ~/btrace/bin/btrace  `ps -ef | grep jboss.Main | awk '{print $2}'` com/taobao/wireless/VmClean.java e
 */
public class UniqLine {

    private static Set<String> sets = new HashSet<String>();

    /**
     * @param
     *        args[0]   ~/btrace/bin/btrace
     *        args[1]   pid
     *        args[2]   btrace script
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        // 1.test console args commands
        // exec("args", args);

        String[] commands = new String[] { "/bin/bash", args[0],
                 args[1], args[2]};
        // 1.test java string commands
        exec(commands);
    }

    public static void exec(String[] args) throws Exception {

        Process process = Runtime.getRuntime().exec(args);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                process.getInputStream()));

        while (true) {

           String line =  bufferedReader.readLine();
           if (null != line){
            print(line);
           }
        }

    }

    private static void print(String arg) {
        if (!sets.contains(arg)){
            System.out.println(arg);
            sets.add(arg);
        }
    }

}