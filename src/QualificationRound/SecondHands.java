package QualificationRound;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
Sandy's store has N pre-owned clock parts for sale, where the ith part is of style Si.
The store also has two display cases, each capable of holding at most K parts.
To maximize the aesthetics of Sandy's secondhand second hands, she'd like to put each of the
N parts into one of the two cases so that neither case ends up with two different parts of the same style,
and neither case has more than K parts total. Can you determine if this is possible?
*/

public class SecondHands {

    public static void main(String[] args) {

        int T; // number of test cases, 1 <= T <= 90

        List<String> DisplayCase1 = new ArrayList<>();
        List<String> DisplayCase2 = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        T = scanner.nextInt(); scanner.nextLine();

        for (int i=0;i<T;i++){

            String[] line1 = scanner.nextLine().trim().split(" "); // N and K
            String[] line2 = scanner.nextLine().trim().split(" "); // parts line

            int n = Integer.parseInt(line1[0]);
            int k = Integer.parseInt(line1[1]);

            TestCase t = new TestCase(n,k);
            t.parts = line2;
            Result r = Result.NO;

            if((2 * t.K) >= t.N) {

                r = Result.YES;

                for (String s:t.parts) {

                    if (!DisplayCase1.contains(s)){

                        DisplayCase1.add(s);

                    }else if (DisplayCase1.contains(s) && !DisplayCase2.contains(s)){

                        DisplayCase2.add(s);

                    }else if (DisplayCase1.contains(s) && DisplayCase2.contains(s)){

                        r = Result.NO;
                        break;

                    }

                }




            }

            System.out.println("-----------------------------------------------");
            System.out.printf("Case #%s: %s\n", i + 1, r);
            System.out.println(DisplayCase1);
            System.out.println(DisplayCase2);
            System.out.println("-----------------------------------------------");

            DisplayCase1.clear();
            DisplayCase2.clear();


        }



    }

}

enum Result {YES,NO}

class TestCase{

    int N; // number of parts
    int K; // capacity of each display case
    String[] parts;

    public TestCase(int N,int K){
        this.N = N;
        this.K = K;
        this.parts = new String[N];
    }

}
