package com.manytimepadbreaker;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Michał(Krokogator) on 16.03.2018.
 */
public class Binary {

    File file;
    byte[] data;

    public Binary(String filePath) throws Exception {
        Path path = Paths.get(filePath);
        file = path.toFile();
        data = Files.readAllBytes(path);
    }

    public String getContent(){
        String content = "";

        try(FileReader fileStream = new FileReader( file );
            BufferedReader bufferedReader = new BufferedReader( fileStream ) ) {

            String line;

            while( (line = bufferedReader.readLine()) != null ) {
                content += line;
            }

        } catch ( FileNotFoundException ex ) {
            System.out.println("File not found: "+ex.getMessage());
        } catch ( IOException ex ) {
            //exception Handling
        }

        return content;
    }

    public byte[][] getBytes(){
        byte[][] byte256 = new byte[(data.length/256)+1][256];
        for(int i=0;i<=data.length/256;i++){
            for(int j=0;j<256;j++){
                try{
                    byte256[i][j] = data[i*256+j];
                } catch (ArrayIndexOutOfBoundsException e){
                    byte256[i][j] = 0;
                }
            }
        }
        return byte256;
    }

    public String getFileName(){
        return file.getName();
    }
}
