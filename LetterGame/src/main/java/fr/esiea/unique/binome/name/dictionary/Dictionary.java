package fr.esiea.unique.binome.name.dictionary;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Dictionary implements IDictionary {

    public BufferedReader OpenFile() {
        String file = "src/main/resources/dico.txt";

        BufferedReader br = null;
        try {
            InputStream ips = new FileInputStream(file);
            InputStreamReader ipsr = new InputStreamReader(ips);
            br = new BufferedReader(ipsr);
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
        return br;
    }

    public String isWord(String word) throws IOException {
        BufferedReader br = this.OpenFile();
        String currentLine;
        do {
            currentLine = br.readLine();
            if (currentLine.equals(word) || currentLine.equals(null)) {
                br.close();
                return currentLine;
            }
        } while (br.ready());
        return "";
    }

    public boolean containsWord(String word) throws IOException {
        BufferedReader br = this.OpenFile();
        String currentLine;
        do {
            currentLine = br.readLine();
            if (currentLine.startsWith(word)) {
                br.close();
                return true;
            }
        } while (br.ready());
        return false;
    }
}
