import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static String calc(String example) throws Exception {
        int result=0;
        int i=0;
        int elemMass=0;
        int k=0;
        int[] numbers;
        String answer ="";
        numbers = new int[2];
        int[] numbersMass = new int[2];
        Map<Character, Integer> romanNumbers = new HashMap<>();
        {
            romanNumbers.put('I', 1);
            romanNumbers.put('V', 5);
            romanNumbers.put('X', 10);
            romanNumbers.put('L', 50);
            romanNumbers.put('C', 100);
        }
        int  []A = { 1, 4, 5, 9, 10, 40, 50, 90, 100};
        String []R = {"I","IV","V","IX","X","XL","L","XC","C"};
        int summIndex = example.indexOf("+");
        int subtractionIndex = example.indexOf("-");
        int multiplicationIndex = example.indexOf("*");
        int divisionIndex = example.indexOf("/");
        StringTokenizer tokenizer = new StringTokenizer(example,"+-/*");

        while (tokenizer.hasMoreTokens()){
            String token = tokenizer.nextToken();
            try {
                numbers[elemMass]=Integer.parseInt(token);
                elemMass++;
            }
            catch (NumberFormatException e) {
                result=0;
                int prev = 0;
                for(i=token.length()-1;i>=0;i--) {
                    int curr = romanNumbers.get(token.charAt(i));
                    if (curr<prev){
                        result-=curr;
                    } else {
                        result+=curr;
                    }
                    prev=curr;
                }
                numbersMass[k]=result;
                k++;
            }

        }
        boolean b = (numbers[0] > 10) || (numbers[1] > 10) || (numbers[0] <= 0) || (numbers[1] <= 0);
        boolean c = (numbersMass[0] > 10) || (numbersMass[1] > 10) || (numbersMass[0] <= 0) || (numbersMass[1] <= 0);
        if (summIndex!=-1){
            if(k==0) {
                if (b){
                    throw new Exception ("????????????!");
                }
                result = numbers[0]+numbers[1];
            }
            else {
                if (k==1){
                    throw new Exception ("????????????!");
                }
                if (c){
                    throw new Exception ("????????????!");
                }
                answer="";
                result=numbersMass[0]+numbersMass[1];
                int d = 8;
                while (result > 0) {
                    while (A[d] > result){
                        d--;
                    }
                    answer = answer.concat(R[d]);
                    result -= A[d];

                }
            }
        }
        else if (subtractionIndex!=-1){
            if(k==0) {
                if (b){
                    throw new Exception ("????????????!");
                }
                result = numbers[0]-numbers[1];
            }
            else {
                if (k==1){
                    throw new Exception ("????????????!");
                }
                if (c){
                    throw new Exception ("????????????!");
                }
                answer="";
                result=numbersMass[0]-numbersMass[1];
                int d = 8;
                while (result > 0) {
                    while (A[d] > result){
                        d--;
                    }
                    answer = answer.concat(R[d]);
                    result -= A[d];
                }
                if (answer==""){
                    throw new Exception ("????????????!");
                }

            }

        }
        else if (multiplicationIndex!=-1){
            if(k==0) {
                if (b){
                    throw new Exception ("????????????!");
                }

                result = numbers[0]*numbers[1];
            }
            else {
                if (k==1){
                    throw new Exception ("????????????!");
                }
                if (c){
                    throw new Exception ("????????????!");
                }
                answer="";
                result=numbersMass[0]*numbersMass[1];
                int d = 8;
                while (result > 0) {
                    while (A[d] > result){
                        d--;
                    }
                    answer = answer.concat(R[d]);
                    result -= A[d];

                }
                if (answer==""){
                    throw new Exception ("????????????!");
                }
            }
        }
        else if (divisionIndex!=-1){
            if(k==0) {
                if (b){
                    throw new Exception ("????????????!");
                }

                result = numbers[0]/numbers[1];
            }
            else {
                if (k==1){
                    throw new Exception ("????????????!");
                }
                if (c){
                    throw new Exception ("????????????!");
                }
                answer="";
                result=numbersMass[0]/numbersMass[1];
                int d = 8;
                while (result > 0) {
                    while (A[d] > result){
                        d--;
                    }
                    answer = answer.concat(R[d]);
                    result -= A[d];

                }
                if (answer==""){
                    throw new Exception ("????????????!");
                }
            }
        }

        if (k==0){
            return Integer.toString(result);
        }
        else return answer;
    }
    public static void main(String[] args) throws Exception {

        Scanner in = new Scanner(System.in);
        String example = in.nextLine();
        System.out.println(calc(example));
    }

}

