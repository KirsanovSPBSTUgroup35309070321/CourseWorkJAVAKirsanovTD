package CourseWorkKirsanovTD;

import java.util.ArrayList;
import java.util.Scanner;

public class GameCLASS {


    private final int DIFFICULTY;
    private String DiffStr;
    private int Counter_RL;
    private DictEntry Entry_Dict;
    ArrayList<DictEntry> EntriesList;
    private ArrayList<String> AGiven;
    private ArrayList<String> AssociationEntries;
    private boolean CONTINUE = true;



    public GameCLASS(ArrayList<DictEntry> EntriesList) {
        AGiven = new ArrayList<>();
        this.EntriesList = EntriesList;
        System.out.println("=========================================================   НОВАЯ ИГРА  ==========================================================\n"+
                           "____________________________________________________Предоставляется выбор: _______________________________________________________\n" +
                           "||||||||||||||||||||||||||||| 1 - Лёгкая (Включает в себя 20 попыток, обычные и средние ассоциации) |||||||||||||||||||||||||||||\n" +
                           "||||||||||||||||||||||||||||| 2 - Средняя (Включает в себя 15 попыток, простые и средние ассоциации)|||||||||||||||||||||||||||||\n" +
                           "|||||||||||||||||||||||||||||   3 - Тяжёлая (Включает в себя 5 попыток и очень редкие ассоциации)   |||||||||||||||||||||||||||||");
        this.DIFFICULTY = new Scanner(System.in).nextInt();

        switch (DIFFICULTY){
            case (1):
                Counter_RL = 20;

                DiffStr = "Легкий ____________________________________________________";
                do
                    {

                    Entry_Dict = EntriesList.get((int)Math.floor(Math.random()*EntriesList.size()));


                } while ( (Entry_Dict.Get_STRONG().size()+Entry_Dict.Get_MEDIUM().size() )<= Counter_RL);

                AssociationEntries = new ArrayList<String>( Entry_Dict.Get_STRONG().keySet() );

                AssociationEntries.addAll( Entry_Dict.Get_MEDIUM().keySet() );
                break;
            case (2):

                Counter_RL = 15;
                DiffStr = "Средний ___________________________________________________";
                do {

                    Entry_Dict = EntriesList.get( (int)Math.floor(Math.random()*EntriesList.size() ) );


                } while ( ( Entry_Dict.Get_STRONG().size()+Entry_Dict.Get_MEDIUM().size() ) <=Counter_RL );

                AssociationEntries =  new ArrayList<String> (Entry_Dict.Get_STRONG().keySet() );

                AssociationEntries.addAll(Entry_Dict.Get_MEDIUM().keySet());
                break;
            case (3):

                Counter_RL = 5;


                DiffStr = "Сложный ____________________________________________________";


                do {

                    Entry_Dict = EntriesList.get((int)Math.floor(Math.random()*EntriesList.size()));


                } while (Entry_Dict.Get_EASY().size()<=Counter_RL);

                AssociationEntries =  new ArrayList<String>(Entry_Dict.Get_EASY().keySet());
                break;


        }
    }

    public void StartToPlay (){

        boolean WINNING = false;

        while (( Counter_RL > 0 ) && !WINNING && CONTINUE ) {


            WINNING = GAMEPLAYRound();
        }


        System.out.println("Слово \""+Entry_Dict.Word_Getting()+"\"");
        if (WINNING) {
            System.out.println("========================================================= ПОЗДРАВЛЯЕМ С ПОБЕДОЙ! ==========================================================\n");
        } else {
            System.out.println("____________________________________________________ Закончились попытки! Игра окончена. ____________________________________________________\n");
        }

    }

    private boolean GAMEPLAYRound(){
        System.out.println("____________________________________________________ Уровень сложности: "+DiffStr+"\n"+
                "_____________________________________________________________ Попытки: "+Counter_RL+" _________________________________________________________\n\n"+
                "Список Ассоциаций:"
        );

        int ListNumber = (int)(Math.random()*AssociationEntries.size());

        String AssociationNEW = AssociationEntries.get(ListNumber);
        AssociationEntries.remove(ListNumber);
        AGiven.add(AssociationNEW);

        for (String ASSOCIATION : AGiven)
            System.out.println(ASSOCIATION);


        String Сhoice = new Scanner(System.in).nextLine();

        Counter_RL--;

        if(Сhoice.equals("Выход")) {

            CONTINUE = false;

            System.out.println("Вы ввели \"Выход\"");

            return false;

        } else if (Сhoice.equalsIgnoreCase(Entry_Dict.Word_Getting())) {

            System.out.println("ВЕРНО! \n");

            return true;

        }else {
            System.out.println("НЕ ВЕРНО! \n");

            return false;
        }
    }
}
