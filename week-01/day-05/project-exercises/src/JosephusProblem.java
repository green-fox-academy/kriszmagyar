import java.util.ArrayList;

public class JosephusProblem {
    public static void main(String[] args) {

        int numbOfPeople;

        numbOfPeople = 1;
        System.out.println(getWinningSeat(numbOfPeople)); // expects 1

        numbOfPeople = 2;
        System.out.println(getWinningSeat(numbOfPeople)); // expects 1

        numbOfPeople = 3;
        System.out.println(getWinningSeat(numbOfPeople)); // expects 3

        numbOfPeople = 7;
        System.out.println(getWinningSeat(numbOfPeople)); // expects 7

        numbOfPeople = 12;
        System.out.println(getWinningSeat(numbOfPeople)); // expects 9

        numbOfPeople = 41;
        System.out.println(getWinningSeat(numbOfPeople)); // expects 19

    }

    private static int getWinningSeat(int numbOfPeople) {

        ArrayList<Integer> people = new ArrayList<>();

        for (int i = 0; i < numbOfPeople ; i++) {
            people.add(i);
        }

        int indexOfKiller = 0;
        int killTarget = indexOfKiller + 1;

        for (int i = 0; i < numbOfPeople - 1 ; i++) {

            people.remove(killTarget);
            indexOfKiller = killTarget;
            killTarget = (indexOfKiller + 1) % people.size();

        }

        return people.get(0) + 1;
    }

}
