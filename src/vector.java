public class vector {
    int[] bits;

public vector(int numberofitems){
    bits = new int[numberofitems];
}

    public String readVector() {

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < bits.length; i++) {
            result.append(bits[i]).append(", ");
        }

        return result.toString();
    }

}

