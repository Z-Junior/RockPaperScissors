/**
 * @author Z
 * @since 16 November 2017
 */

import java.util.Scanner;

public class Game
{
    public enum Type
    {
        Rock
        {
            //@Override
            public boolean beats(Type other)
            {
                return other == Paper;
            }
        },
        Paper
        {
            //@Override
            public boolean beats(Type other)
            {
                return other == Scissor;
            }
        },
        Scissor
        {
            //@Override
            public boolean beats(Type other) {
                return other == Rock;
            }
        };

        public abstract boolean beats(Type other);
    }

    private final static Scanner SCAN = new Scanner(System.in);

    public static void main(String[] args)
    {

    }

    private static String promptMove(String question)
    {
        System.out.print(question);

        while (!SCAN.hasNextLine())
        {
            System.out.flush();

            System.out.print("String only: ");

            SCAN.next();
        }

        return SCAN.nextLine();
    }

    public static Type getRandomMove(int iMin, int iMax)
    {

    }

}
