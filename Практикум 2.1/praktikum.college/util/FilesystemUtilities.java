package praktikum.college.util;

import java.io.*;

public class FilesystemUtilities {
    public static void readAndLoadExistingDiary(String[][] diary) {
        try (BufferedReader reader = new BufferedReader(new FileReader("file.txt"))) {
            String s = "";
            System.out.println("Записи з щоденника: \n");
            int i = 0;
            int j = 1;
            while (reader.ready()) {
                s = reader.readLine();
                System.out.println(s);
                diary[i][0] = Integer.toString(j);
                if (i > 9) {
                    diary[i][1] = s.substring(3, 13);
                    diary[i][2] = s.substring(14);
                } else {
                    if(!s.isEmpty()){
                        diary[i][1] = s.substring(2, 12);
                        diary[i][2] = s.substring(13);
                    }
                    else{
                        diary[i][1] = "";
                        diary[i][2] = "";
                    }
                }
                i++;
                j++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не знайдено! " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Виникла помилка при зчитуванні з файлу");
        } catch (StringIndexOutOfBoundsException e){
        }
    }

    public static void saveDiary(String[][] diary) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("file.txt"))){
            for (int i = 0; i < 50; i++) {
                for (int j = 0; j < 3; j++) {
                    writer.write(diary[i][j]);
                }
                writer.write("\n");
            }
            System.out.println("Щоденник успішно записано в файл!");
        } catch (FileNotFoundException e) {
            System.out.println("Файл не знайдено!" + e.getMessage());
        } catch (IOException e) {
            System.out.println("Виникла помилка при запису в файл");
        } catch (NullPointerException e){
        }
        System.out.println("Щоденник успішно збережено");
    }
}
