package org.example.globals.utils;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class FileNo {
    private static final String DATA_DIRECTORY = "src/main/resources";

    public Integer getNextFileNo() {
        File dir = new File(DATA_DIRECTORY);
        File[] files = dir.listFiles((d, name) -> name.endsWith(".json")); // JSON 파일만

        if (files == null || files.length == 0) {
            return 1;
        }
        Arrays.sort(files, Comparator.comparing(File::getName));

        String lastFileName = files[files.length - 1].getName();
        String numberPart = lastFileName.replace("trip_", "").replace(".json", "");
        int lastNo = Integer.parseInt(numberPart);

        return lastNo + 1;
    }
}
