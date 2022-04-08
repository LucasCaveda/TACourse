package com.solvd.computerShop.utils;

import java.io.File;
import java.io.IOException;

import static com.solvd.computerShop.utils.LoggerClass.LOGGER1;
import static org.apache.commons.io.FileUtils.*;


public class FilesMain {
    private final static String PATH_TEXT_FILE = "src/main/resources/ImTheHighway.txt";
    private final static String PATH_RESULT_FILE = "src/main/resources/countResult.txt";

    public static void main(String[] args) throws IOException {
        File text = new File(PATH_TEXT_FILE);
        File result = new File(PATH_RESULT_FILE);

        findWord(text,"highway",result);
        findWord(text,"yeah",result);
        findWord(text,"am",result);


    }

    public static void findWord(File file, String word, File result){
        try {
            String fileContent = readFileToString(file,(String) null);

            String[] count = fileContent.split(word);
            LOGGER1.debug(count.length-1);
            writeFile("The word \""+word+ "\" was found "+(count.length-1)+" times in the file\n",result );
        } catch (IOException e) {
            LOGGER1.info(e.getMessage());
        }
    }


    public static void writeFile(String msg, File file) {

        try {
            writeStringToFile(file, msg, (String) null, true);
        } catch (IOException e) {
            LOGGER1.info(e.getMessage());
        }
    }
}
