package newmain1;


import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.*;
import java.util.Scanner;
import java.util.regex.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alvar
 */
public class NewMain1 {

    
    public static NewMain1 NM = new NewMain1();
 
     public static String path1="E:\\Descargas\\";
   
    String Name = "All Data.txt" ;
   
    File Archivo = new File(path1+Name);
    
    public static String ScanPath ="E:\\Descargas\\Anime";
    
    
    
    public static void main(String[] args)throws IOException {         
             walkin(new File(ScanPath)); //Replace this with a suitable directory 
    }
   
  public void WriteFiles(String Data)throws IOException{
      
      RandomAccessFile raf=null;
      
        File f=new File("E:/Descargas/AllData.txt");
        
        try {
            raf=new RandomAccessFile(f,"rw");
// seek skips the length of the file itself and writes to the end
            raf.seek(f.length());          
             byte[]b=(Data + "\n" ).getBytes();
            raf.write(b);                 
             
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            if(raf!=null){
                raf.close();
            }
        }

  }  
    //ITERATIVA VS RECURSIVA
    public static void walkin(File dir)throws IOException {
 
        File listFile[] = dir.listFiles();
        if (listFile != null) {
            for (int i = 0; i < listFile.length; i++) {
                if (listFile[i].isDirectory()) {
                    
                    System.out.println(listFile[i].getName());
                    NM.WriteFiles(listFile[i].getName());
                    
                    walkin(listFile[i]);
                    
                } else {
                    System.out.println(listFile[i].getName());
                    NM.WriteFiles(listFile[i].getName());
                }
            }
        }
    }
    
    
    
    
    
    
    
}
