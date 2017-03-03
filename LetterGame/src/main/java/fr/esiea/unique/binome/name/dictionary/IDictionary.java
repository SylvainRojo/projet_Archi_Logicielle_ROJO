package fr.esiea.unique.binome.name.dictionary;

import java.io.IOException;

/**
 * Created on 16/01/17.
 */
public interface IDictionary {
    boolean isWord(String word)throws IOException;
}
