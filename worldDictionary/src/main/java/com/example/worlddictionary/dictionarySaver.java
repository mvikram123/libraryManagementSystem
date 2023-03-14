package com.example.worlddictionary;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class dictionarySaver {
    private HashMap<String, String> dictionaryList;

    public dictionarySaver() {
        dictionaryList = new HashMap<>();
    }

    HashMap<String, String> getDictionaryList() {
        return dictionaryList;
    }

    void serializeHashMap() {
        try {
            FileOutputStream fos = new FileOutputStream("dictionaryData");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(dictionaryList);
            oos.close();
            fos.close();
        } catch (Exception ioe) {
            ioe.printStackTrace();
        }

    }

    void deSerializeHashMap() throws IOException, ClassNotFoundException {
        FileInputStream file = new FileInputStream("dictionaryData");
        ObjectInputStream ois = new ObjectInputStream(file);
        dictionaryList = (HashMap<String, String>) ois.readObject();

        file.close();
        ois.close();
    }

}

