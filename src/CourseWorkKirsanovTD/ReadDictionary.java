package CourseWorkKirsanovTD;

import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadDictionary {

    public static List<DictEntry> ReadDict(String DictPath){

        ArrayList<DictEntry> EntriesList = new ArrayList<DictEntry>();



        try (final Stream<String> STROKI = Files.lines(Paths.get(DictPath)) .flatMap(line-> Arrays.stream(line.split("[,;\\s+]"))))

        {


            List<String> storageList = STROKI.filter(x -> x.length() != 0).collect(Collectors.toList());

            DictEntry Entry_Dict = new DictEntry("Старт");

            for (String say : storageList){
                say = say.replace(",", " ").trim();
                try {
                    if (!say.matches("[0-9]{1,30}")) {


                        Entry_Dict.Add_Association(say);

                    }else
                        {

                            Entry_Dict.Adding_Weight(Integer.parseInt(say));

                        }

                } catch (NumberFormatException nfe)

                {

                    System.out.println("Читатель словаря: "+nfe);
                }

                if (say.matches("[А-Я]{1,50}:"))
                {

                    Entry_Dict = new DictEntry(say.substring(0,say.length()-1));

                    EntriesList.add(Entry_Dict);

                }
            }


        } catch (NullPointerException npe)

        {

            System.out.println("NullPointerException");
        }

        catch (NoSuchFileException ex)

        {

            System.out.println("Файл не существует");

        }

        catch (Exception e){
            System.out.println(e);
        }

        return EntriesList;
    }
}
