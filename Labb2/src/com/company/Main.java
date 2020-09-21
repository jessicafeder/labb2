package com.company;
import java.io.File;
import java.util.Scanner;

public class Main {



    public static void FileCrawler(String name, File file) {


        try {
            Scanner search = new Scanner(file);
            while (search.hasNext()) {
                if (name.equals(search.next())){
                    System.out.println(file.getAbsolutePath());
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void WhereIsIt(String name, File file){

        if (file.isDirectory()){
            File[] folderContents = file.listFiles();
            for (int i = 0; i < folderContents.length; i++){
                File f = folderContents[i];
                WhereIsIt(name, f);
            }

        } else{
            FileCrawler(name, file);
        }

    }

    public static String InputName(){
        Scanner input = new Scanner(System.in);
        String name = input.next();
        return name;
    }


    public static void main(String[] args) {
        File file = new File("C:\\DEV\\Labb2");
        System.out.println("Skriv in ett sökord: ");
        String name = InputName();
        WhereIsIt(name, file);
        //System.out.println(name);
        //FileCrawler(name, file);



    }
}
