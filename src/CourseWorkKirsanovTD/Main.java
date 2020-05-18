package CourseWorkKirsanovTD;

import CourseWorkKirsanovTD.ReadDictionary;
import CourseWorkKirsanovTD.GameCLASS;


import java.util.*;

import java.io.IOException;


public class Main {

    ArrayList<DictEntry> EntriesList;

    public static void main(String[] args) throws IOException {

        ArrayList<DictEntry> EntriesList = (ArrayList<DictEntry>) ReadDictionary.ReadDict("src\\CourseWorkKirsanovTD\\Русский Региональный Ассоциативный СловарьТезаурус.txt");


        if (EntriesList == null)

        {

            System.out.println("Словарь не был прочитан!");

        }


        do {

            GameCLASS IGRA_v_ASSOCIACII = new GameCLASS(EntriesList);

            IGRA_v_ASSOCIACII.StartToPlay();

            System.out.println("========================================================== ПРОДОЛЖИТЬ? ===========================================================\n" +
                               "======================================================== Нажмите Y или N =========================================================");



        } while (new Scanner(System.in).nextLine().toUpperCase().equals("Y"));
    }
}
