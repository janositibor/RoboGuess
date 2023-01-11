package robotsGuess;

public class Responsible {
    private long solution;
    private int digitsOfSulution;

    public Responsible() {
        solution=Math.round(Math.random()*Long.MAX_VALUE);
        if(solution==0) {
            digitsOfSulution=1;
        }
        else{
            digitsOfSulution = (int) Math.floor(Math.log10(solution)) + 1;
        }
    }

    public long getSolution() {
        return solution;
    }

    public int getDigitsOfSulution() {
        return digitsOfSulution;
    }

    public Answer guess(long numberToGuess){
        if(solution<numberToGuess){
            return Answer.LESS;
        }
        if(solution>numberToGuess){
            return Answer.MORE;
        }
        return Answer.EQUAL;
    }
}
