package popova.itmo_lesson.find_random;

import java.util.Scanner;

public class SelectionByWeight {
    private String[] signMassiw;
    private String[] weightMassiw;


    public void giveMassivAndWeight() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите массив символов: ");
        String signs = in.nextLine();
        this.signMassiw = signs.split(" ");
        System.out.print("Введите вес для каждого символа: ");
        String weight = in.nextLine();
        this.weightMassiw = weight.split(" ");
        if(this.weightMassiw.length != this.signMassiw.length){
            throw new RuntimeException("Неверное введение данных: разное колличество символов и весов");
        }
    }

    public int findRandomValueByWeight() {
        int[] weightSumm = new int[this.weightMassiw.length];
        int finish = 0;
        for (int i = 0; i < this.weightMassiw.length; i++) {
            weightSumm[i] = Integer.parseInt(this.weightMassiw[i]);
            finish += weightSumm[i];
        }
        int check = (int)(Math.random() * finish);
        int rang = 0;
        int indexSelect = -1;
        for (int i = 0; i < weightSumm.length; i++) {
            rang += weightSumm[i];
            if (check <= rang ) {
                indexSelect =  i;
                break;
            } else {
                continue;
            }
        }
        return indexSelect;
    }

    public String getResult(int i) {
        return String.format(" Выбран символ ( %s ) с весом %s",this.signMassiw[i], this.weightMassiw[i]);
    }

    public static void main(String[] args) {
        SelectionByWeight givenValue = new SelectionByWeight();
        try {
            givenValue.giveMassivAndWeight();
            int result = givenValue.findRandomValueByWeight();
            System.out.println(givenValue.getResult(result));
        } catch (RuntimeException rte)  {
            System.out.println(rte.getMessage());
        }
    }
}
