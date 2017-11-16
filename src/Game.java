/**
 * @author Z
 * @since 16 November 2017
 */

import org.jetbrains.annotations.Nullable;
import java.util.Scanner;
import java.util.Random;

public class Game
{
    public enum Type
    {
        Rock
        {
            public boolean beats(Type other)
            {
                return other == Scissor;
            }
        },
        Paper
        {
            public boolean beats(Type other)
            {
                return other == Rock;
            }
        },
        Scissor
        {
            public boolean beats(Type other)
            {
                return other == Paper;
            }
        };

        public abstract boolean beats(Type other);

        @Nullable
        public static Type parseType(String value)
        {
            switch (value.toLowerCase())
            {
                case "rock":
                    return Rock;
                case "paper":
                    return Paper;
                case "scissor":
                    return Scissor;
                default:
                    return null;
            }
        }
    }

    private final static Scanner SCAN = new Scanner(System.in);
    private final static Random RANDOM = new Random();

    public static void main(String[] args)
    {
        Type t_ComputerMove = getRandomMove(), t_UserMove;

        t_UserMove = Type.parseType(promptMove("Enter your move: "));

        while (t_UserMove == null)
            t_UserMove = Type.parseType(promptMove("Invalid move: "));

        if (t_UserMove.equals(t_ComputerMove))
            System.out.println("It's a tie!");
        else if (t_UserMove.beats(t_ComputerMove))
            System.out.println(String.format("%s beats %s. You win!", t_UserMove, t_ComputerMove));
        else
            System.out.println(String.format("%s beats %s. You lose!", t_ComputerMove, t_UserMove));
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

    @Nullable
    public static Type getRandomMove()
    {
        int iRandom = RANDOM.nextInt(3) + 1;

        switch (iRandom)
        {
            case 1:
                return Type.Rock;
            case 2:
                return Type.Paper;
            case 3:
                return Type.Scissor;
            default:
                return null;
        }
    }
}
