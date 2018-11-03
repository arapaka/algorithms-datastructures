package LeetCode.TwoPointers;

/**
 * Created by archithrapaka on 4/13/17.
 * // We are playing the Guess Game. The game is as follows:
 * <p>
 * // I pick a number from 1 to n. You have to guess which number I picked.
 * <p>
 * // Every time you guess wrong, I'll tell you whether the number is higher or lower.
 */
public class GuessGame {

    public GuessGame(int N, int guess) {
        this.ANSWER = guess;
        this.N = N;
    }

    private int ANSWER = 0;
    private int count = 0;
    private int N = 0;

    public int getGuesses(int n) {
        return binarySearch(1, n, 0);
    }

    private int binarySearch(int start, int end, int count) {
        if (start > end) {
            return -1;
        }
        count = count + 1;
        if (guess(start) == 0) return start;
        if (guess(end) == 0) return end;
        int mid = start + (end - start) / 2;
        if (guess(mid) == 0) return mid;
        else if (guess(mid) == 1) return binarySearch(start, mid - 1, count);
        return binarySearch(mid + 1, end, count);
    }

    private int guess(Integer guess) {
        return (guess == this.ANSWER) ? 0
                : (guess > this.ANSWER) ? 1 : -1;
    }

    public static void main(String[] args) {
        GuessGame guessGame = new GuessGame(1000, 5);
        int guesses = guessGame.getGuesses(1000);
        System.out.print(guesses);
    }
}
