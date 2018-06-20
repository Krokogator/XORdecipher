package com.manytimepadbreaker;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michał(Krokogator) on 16.03.2018.
 *
 * Loads as binaries
 */
public class BinaryLoader {

    List<Binary> binaries;
    String extension;
    int count;

    public BinaryLoader(String folderPath, int count, String extension){
        this.count = count;
        this.extension = extension;
        binaries = load(folderPath);
    }

    public Binary getBinary(String id){
        return binaries.get(Integer.valueOf(id));
    }

    private List<Binary> load(String folderPath){
        List<Binary> binaries = new ArrayList<>();

        for(int i=0;i<count;i++){
            try {
                binaries.add(new Binary(folderPath+String.format("%03d",i)+"."+extension));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return binaries;
    }
}
