import java.io.*;
import java.util.Random;

public class Free {
    public static void main(String[] args) throws IOException {
        String fileName = "tagToImport.txt";
        importTag(fileName);

    }

    public static int generatingIntegerBounded(int a, int b){

        int min = a;
        int max = b;
        int intBounded = min + ((int) (new Random().nextFloat() * (max - min)));
        return intBounded;
    }

    public static void importTag(String fileName) throws IOException {
        InputStreamReader isr;
        isr = new InputStreamReader(new FileInputStream(fileName), "utf-8");
        BufferedReader br = new BufferedReader(isr);

        String textLine;
        String str = "";
        String position = "";
        while((textLine = br.readLine()) != null){
            position = textLine;
            if(Character.isDigit(position.charAt(0))){
                int[] temp = new int [3];
                for(int i=0; i<temp.length; i++){
                    temp[i] = position.charAt(i);
                    System.out.println(temp[i]);
                }
                str = br.readLine();
                String[] tags = str.split(" ");

                System.out.println(tags[0]);

            }
        }

    }
}
