package medium;

public class BowlingGame {

    private int score = 0;
    private int bonus = 0;
    private int first = 0;
    private int frame = 1;
    private boolean isFirst = true;
    private int fillBall = 0;

    public void roll(int i) {

        if (i < 0) {
            throw new IllegalStateException("Negative roll is invalid");
        } else if (i > 10 || (i + first > 10 && first != 10)) {
            throw new IllegalStateException("Pin count exceeds pins on the lane");
        } else if (frame == 11 && fillBall == 0) {
            throw new IllegalStateException("Cannot roll after game is over");
        }

        score += i;

        if (bonus > 2) {
            score += i;
            bonus--;
        }


        if (fillBall == 0) {
            if (bonus > 0) {
                score += i;
                bonus--;
            }

            if (!isFirst && i + first == 10) {
                bonus += 1;

                if (frame == 10) {
                    fillBall = 1;
                    first = 0;
                }
            }

            if (isFirst && i == 10) {

                bonus += 2;

                if (frame == 10) {


                    fillBall = 2;
                }
            }


            if (!isFirst || (isFirst && i == 10)) {
                frame++;
                isFirst = true;
            } else {
                isFirst = false;
                first = i;
            }
        } else {
            fillBall--;
            first = i;
        }
    }


    public int score() {
        if (frame == 11 && fillBall == 0) {
            return score;
        } else {
            throw new IllegalStateException("Score cannot be taken until the end of the game");
        }
    }
}
