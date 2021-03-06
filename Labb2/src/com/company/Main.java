package com.company;
import java.io.File;
import java.util.Scanner;

public class Main {

    public static void searchForIt(String name, File file) {
        try {
            Scanner search = new Scanner(file);
            while (search.hasNext()) {
                if (name.equalsIgnoreCase(search.next())){
                    System.out.println(file.getAbsolutePath());
                }

            }
            search.close();

        } catch (Exception e) {
            System.err.println("Filen hittades inte: " + file.getAbsolutePath());
            e.printStackTrace();
        }
    }

    public static void whereIsIt(String name, File file){

        if (file.isDirectory()){
            File[] folderContents = file.listFiles();
            for (int i = 0; i < folderContents.length; i++){
                File f = folderContents[i];
                whereIsIt(name, f);
            }
        } else{
            searchForIt(name, file);
        }
    }

    public static String inputName(){
        Scanner input = new Scanner(System.in);
        String name = input.next();
        return name;
    }

    public static void main(String[] args) {
        File file = new File("../Labb2");
        System.out.println("Skriv in ett sökord: ");
        String name = inputName();
        whereIsIt(name, file);
    }
}
