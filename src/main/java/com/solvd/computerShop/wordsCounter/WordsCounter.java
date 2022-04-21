package com.solvd.computerShop.wordsCounter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

import static org.apache.commons.io.FileUtils.writeStringToFile;

public class WordsCounter {

    private final static Logger LOGGER1 = LogManager.getLogger(WordsCounter.class.getName());
    private final static String PATH_TEXT_FILE = "src/main/resources/article.txt";
    private final static String PATH_RESULT_FILE = "src/main/resources/countResult.txt";


    public static void main(String[] arg) {
        File text = new File(PATH_TEXT_FILE);
        File result = new File(PATH_RESULT_FILE);

        countWords(text,result);
    }

    public static void countWords(File file, File result) {
        FileReader fr = null;
        BufferedReader br;
        Map<String, Integer> words = new HashMap();

        try {
            file = new File("src/main/resources/article.txt");
            fr = new FileReader(file);
            br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null) {
                //I generate a String[] to delimit the words
                for (String word : line.replace(",", "").replace(".", "").replace(";", "").replace(":", "").split(" ")) {
                    words.put(word, words.containsKey(word) ? words.get(word) + 1 : 1);
                }
            }
            //I create some arrays to order the words in the new file
            String[] temp = new String[words.size()];
            int[] repetitions = new int[words.size()];
            words.keySet().toArray(temp);
            IntStream.range(0,temp.length).forEach(i->{
                repetitions[i] = words.get(temp[i]);
            });
            sortArrays(temp, repetitions);

            //I write the results in the results file
            IntStream.range(0,repetitions.length).forEach(i-> {
                writeFile(temp[i] + " = " + repetitions[i] + " times \n", result);
            });
        } catch (IOException e) {
            LOGGER1.info(e.getMessage());
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (IOException e2) {
                LOGGER1.info(e2.getMessage());
            }
        }

    }

    public static void writeFile(String msg, File file) {

        try {
            writeStringToFile(file, msg, (String) null, true);
        } catch (IOException e) {
            LOGGER1.info(e.getMessage());
        }
    }

    public static void sortArrays(String[] words, int[] amount) {
        for (int i = words.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (j + 1 <= i && amount[j] < amount[j + 1]) {
                    String aux = words[j];
                    int iux = amount[j];
                    words[j] = words[j + 1];
                    amount[j] = amount[j + 1];
                    words[j + 1] = aux;
                    amount[j + 1] = iux;
                }
            }
        }
    }
}
