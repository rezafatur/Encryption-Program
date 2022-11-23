import java.util.Scanner;

public class Encryption{
    public static void main(String[] args){
        Scanner input_string = new Scanner(System.in);
        System.out.println("Input: ");
        String input = input_string.nextLine();
        count(input);
    }
    
    public static void count(String input){
        int count_word = 0;
        int endofString = input.length() - 1;
        boolean word = false;
        char[] character = input.toCharArray();
        
        // Menghitung jumlah kata
        for(int j = 0; j < input.length(); j++){
            // Identifikasi kata
            // Jika karakter adalah huruf dan indeks ke-j tidak sama dengan endofString, maka word bernilai true
            if(Character.isLetter(character[j]) && j != endofString){
                word = true;
            }
            // Identifikasi yang bukan kata
            // Jika karakter bukan huruf dan word bernilai true atau terdapat huruf sebelumnya, maka count_word bertambah 1 dan word kembali bernilai false 
            else if(!Character.isLetter(character[j]) && word){
                count_word++;
                word = false;
            }
            // Identifikasi kata pada akhir kalimat
            // Jika karakter adalah huruf dan indeks ke-j sama dengan endofString, maka count_word bertambah 1
            else if(Character.isLetter(character[j]) && j == endofString){
                count_word++;
            }
        }
        encrypt(input, count_word);
    }
    
    public static void encrypt(String input, int count_word){
        String[] array1D = input.split(" ");
        String[][] array2D = new String[count_word][count_word];
        for(int j = 0; j < count_word; j++){
            for(int k = 0; k < 1; k++){
                array2D[j][k] = array1D[j];
            }
        }
        
        for(int l = 0; l < count_word; l++){
            for(int m = 0; m < 1; m++){
                for(int n = 0; n < array2D[l][m].length(); n++){
                    int result = 0;
                    if(array2D[l][m].charAt(n) == 'A' || array2D[l][m].charAt(n) == 'I' || array2D[l][m].charAt(n) == 'U' || array2D[l][m].charAt(n) == 'E' || array2D[l][m].charAt(n) == 'O' ||
                       array2D[l][m].charAt(n) == 'a' || array2D[l][m].charAt(n) == 'i' || array2D[l][m].charAt(n) == 'u' || array2D[l][m].charAt(n) == 'e' || array2D[l][m].charAt(n) == 'o'){
                        result = (int) (l + 1 + Math.pow(l + 1, 2) + array2D[l][m].charAt(n));
                        System.out.print(result);
                    }
                    else{
                        System.out.print(array2D[l][m].charAt(n));
                    }
                }
                System.out.print(" ");
            }
        }
        System.out.print("\n");
    }
}