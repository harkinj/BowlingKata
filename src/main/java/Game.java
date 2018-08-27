public class Game {
    private int[] rolls = new int[21];
    private int currRoll=0;
    void roll(int pins)
    {
        rolls[currRoll++] = pins;

    }
    int score()
    {
        int score = 0;
        int frameIndex =0;
        for (int frames = 0; frames <10; frames++) {

            if (isStrike(frameIndex))
            {
                score += 10 + strikeBonus(frameIndex);
                frameIndex++; //move on to next one
            }
            else if (isSpare(frameIndex)) {
                score += 10 + spareBonus(frameIndex);
                frameIndex = frameIndex+2;
            } else {
                score += sumOfBallsInFrame(frameIndex);
                frameIndex = frameIndex+2;
            }
        }
        return score;
    }

    private boolean isStrike(int frameIndex) {
        return rolls[frameIndex] == 10;
    }

    private int sumOfBallsInFrame(int frameIndex) {
        return rolls[frameIndex] + rolls[frameIndex+1];
    }

    private int spareBonus(int frameIndex) {
        return rolls[frameIndex + 2];
    }

    private int strikeBonus(int frameIndex) {
        return rolls[frameIndex + 1] + rolls[frameIndex + 2];
    }

    private boolean isSpare(int frameIndex)
    {
        return ( (rolls[frameIndex] + rolls[frameIndex+1])  == 10);
    }
}
