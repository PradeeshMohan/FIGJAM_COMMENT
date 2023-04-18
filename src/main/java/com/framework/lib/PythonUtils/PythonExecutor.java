package com.framework.lib.PythonUtils;

import com.framework.lib.utils.ConfigFileReader;
import com.framework.lib.utils.PropertyFileManager;
import io.cucumber.java.sl.In;
import org.checkerframework.framework.qual.PurityUnqualified;
import org.openqa.selenium.WebDriver;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PythonExecutor {

    public WebDriver webDriver;

    private final ConfigFileReader config = PropertyFileManager.getInstance().getConfigReader();
    String ssDir=config.getProperty("screen-shot-dir");


    public PythonExecutor(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public List<String> execute(String fileName) throws IOException {
        ArrayList<String> list = new ArrayList<>();
        String s = null;
        Process p = Runtime.getRuntime().exec("python " + "src\\main\\java\\com\\framework\\lib\\PythonUtils\\pyScripts\\" + fileName);
        BufferedReader stdInput = new BufferedReader(new
                InputStreamReader(p.getInputStream()));

        BufferedReader stdError = new BufferedReader(new
                InputStreamReader(p.getErrorStream()));

        // read the output from the command
        while ((s = stdInput.readLine()) != null) {
            list.add(s);
        }

        // read any errors from the attempted command
        while ((s = stdError.readLine()) != null) {
            list.add(s);
        }
        return list;
    }

    public List<Float> detectAreas(String screenShotFileName) throws IOException {
        File ssFile=new File(ssDir+"\\"+screenShotFileName);
//        System.out.println(execute("detect.py " + ssFile.getPath()));
        return execute("detect.py " + ssFile.getPath()).stream().map(Float::parseFloat).collect(Collectors.toList());
    }

    public List<List<Integer>> detectCenters(String screenShotFileName) throws IOException {
        File ssFile=new File(ssDir+"\\"+screenShotFileName);
        List<String> cordsStringList=execute("getCoordinate.py "+ssFile.getPath());
        List<List<Integer>> coordsList=new ArrayList<>();
        for (int i = 0; i < cordsStringList.size(); i++) {
            List<Integer> tmpList= Arrays.stream(cordsStringList.get(i).
                    split(" ")).map(Integer::parseInt).collect(Collectors.toList());
            coordsList.add(tmpList);
        }
        return coordsList;
    }
}
