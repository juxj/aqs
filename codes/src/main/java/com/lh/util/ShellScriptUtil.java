package com.lh.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by tju on 7/24/14.
 */
public class ShellScriptUtil {

    private Logger logger = LoggerFactory.getLogger(ShellScriptUtil.class);

    public synchronized int execute(String path, String name, String[] parameters) {
        logger.debug("ready to execute shell script.");
        int osReturnCode = -1;

        String[] command = this.getCommandLine(path, name, parameters);

        logger.info("shell:{}", this.getStringFromArray(command));
        try {
            Process process = Runtime.getRuntime().exec(command);
            try {
                osReturnCode = process.waitFor();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            logger.error("failed to execute shell script.");
            e.printStackTrace();
        }
        return osReturnCode;
    }

    public synchronized StringBuilder executeCmdWithOutput(String path, String name, String[] parameters) {

        StringBuilder sb = new StringBuilder();
        String line;
        String[] command = this.getCommandLine(path, name, parameters);
        int osReturnCode = 0;
        try {
            Process process = Runtime.getRuntime().exec(command);
            try {
                osReturnCode = process.waitFor();
                if (osReturnCode==0) {
                    System.out.println(osReturnCode);
                    BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                    while ((line = reader.readLine()) != null) {
                        sb.append(line);
                        sb.append("\n");
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb;
    }


    private String[] getCommandLine(String path, String name, String[] parameters) {
        String shellName = name;
        if (!path.isEmpty()) {shellName = path + name; };
        int len = parameters.length ;
        String[] command = new String[len+1];
        command[0] = shellName;
        for (int i=1; i<=len; i++) {
            command[i] = parameters[i-1];
        }
        return command;
    }

    public String getStringFromArray (String[]args){
        String str="";
        for(int i=0;i<args.length;i++){
            str+=args[i]+" ";
        }
        return str;
    }
}
