package CourseWorkKirsanovTD;

import java.util.HashMap;

public class DictEntry {


    private static final int BoundMedium = 5; //Значения для веса ассоциации (XY)

    private static final int BoundStrong = 15;

    private String latest; //

    private String say;

    private final HashMap<String, Integer> EASY;

    private final HashMap<String, Integer> MEDIUM;

    private final HashMap<String, Integer> HARD;


    public DictEntry(String say) {
        this.say = say;

        EASY = new HashMap<String, Integer>();

        MEDIUM = new HashMap<String, Integer>();

        HARD = new HashMap<String, Integer>();
    }

    public void Add_Association(String association) {
        EASY.put(association, 1);


        latest = association;
    }


    public String Word_Getting() {

        return say;
    }

    public HashMap<String, Integer> Get_EASY() {

        return EASY;
    }

    public HashMap<String, Integer> Get_MEDIUM() {

        return MEDIUM;
    }

    public HashMap<String, Integer> Get_STRONG() {

        return HARD;
    }

    @Override
    public String toString() {

        return "Слово = " + say + '\'' + "\n" +
                ", Простые Ассоциации(" + EASY.size() + ") =" + EASY.toString() + "\n" + ", Средние Ассоциации (" + MEDIUM.size() + ") =" + MEDIUM.toString() + "\n" +
                ", Сильные Ассоциации (" + HARD.size() + ") =" + HARD.toString();
    }




    public void Adding_Weight(int weight) {

        try {

            if (weight < BoundMedium) {


                EASY.replace(latest, weight);


            } else if ((BoundMedium <= weight) && (weight < BoundStrong)) {

                HARD.remove(latest);

                MEDIUM.put(latest, weight);

                EASY.remove(latest);


            } else {

                MEDIUM.remove(latest);

                HARD.put(latest, weight);

                EASY.remove(latest);


            }

        } catch (Exception e) {
            System.out.println("Последний ввод: " + latest + " Ширина: " + weight);

            System.out.println(e);
        }
    }
}




