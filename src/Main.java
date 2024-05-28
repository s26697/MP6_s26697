import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<Item> items = new ArrayList<>();
        ArrayList<Integer> masses = new ArrayList<>();
        ArrayList<Integer> values = new ArrayList<>();
        String filename = args[0];

        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line;

        if ((line = br.readLine())!= null) {

            //ilość przedmiotów oraz pojemnosc plecaka z 1 linijki
            String[] knLines = line.split(" ");
            int capacity = Integer.parseInt(knLines[0]);
            int numberOfItems = Integer.parseInt(knLines[1]);

            //spisanie wartosci i mas przedmiotów do arraylist

            //masa
            line = br.readLine();
            String[] a = line.split(",");
            for(int i =0; i<a.length;i++){
                masses.add(Integer.parseInt(a[i]));
            }

            //wartośc
            line = br.readLine();
            String[] b = line.split(",");
            for(int i =0; i<b.length;i++){
                values.add(Integer.parseInt(b[i]));
            }
            br.close();

            //stworzenie przedmiotów z konstruktora
            for (int i = 0; i < numberOfItems; i++) {
                items.add(new Item(values.get(i), masses.get(i)));
            }

            vector result = new vector(numberOfItems);
            int bestValue =0;


            // główne dzialanie programu
            for (int i = 0; i < Math.pow(2, numberOfItems); i++) {
                int value = 0;
                int weight = 0;
                for (int j = 0; j < numberOfItems; j++) {
                        //jeżeli bit "not included" to omin"
                        if(((i>>j)&1)!=1) continue;

                        value += items.get(j).value;
                        weight += items.get(j).weight;
                }

                if (weight <= capacity && value>bestValue)
                {

                    bestValue = value;




                    for (int j = 0; j < result.bits.length; j++) {
                        if(((i>>j)&1)!=1) result.bits[j] = 0;
                        else result.bits[j] = 1;
                    }

                    System.out.println("nowy najlepszy wektor: "  + result.readVector() + " Waga: " + weight + " Wartosc: " +  bestValue + " iteracja: " + i );
                }




            }

           


        } else {
            System.out.println("Brak danych w pliku.");
        }


    }




}
