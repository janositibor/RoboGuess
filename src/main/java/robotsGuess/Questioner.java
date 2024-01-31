package robotsGuess;

public class Questioner {
    private long min=-1;
    private long max;
    private long guess;
    private long solution=-1;
    private int maxNumberOfQuestions;
    private int numberOfQuestions=0;

    public Questioner(int numberOfDigits) {
        max= (long) Math.pow(10,numberOfDigits);
        setGuess();
        setMaxNumberOfQuestions();
    }

    private void setGuess(){
        guess=min+((max/2)-(min/2));
    }

    private void setMaxNumberOfQuestions(){
        maxNumberOfQuestions=(int) Math.floor(Math.log(max-min-1)/Math.log(2));
    }

    public boolean gotTheSolution(){
        return solution>-1;
    }

    private void succeedMessage(){
        System.out.println("\nI have found it!");
        System.out.println("It must be: "+solution);
    }

    public void processAnswer(Answer answer){
        numberOfQuestions++;
//        System.out.println("Min: "+min);
//        System.out.println("Max: "+max);
        System.out.println("Guess: "+guess);
        System.out.println("Answer: "+answer);
        if(answer==Answer.EQUAL){
            solution=guess;
        }
        if(answer==Answer.LESS){
            max=guess;
        }
        if(answer==Answer.MORE){
            min=guess;
        }
        if(max-min==2 && !gotTheSolution()){
            solution=min+1;
        }
        if(gotTheSolution()){
            succeedMessage();
        }
        setGuess();
    }

    public long getGuess() {
        return guess;
    }

    public long getSolution() {
        return solution;
    }

    public int getMaxNumberOfQuestions() {
        return maxNumberOfQuestions;
    }

    public int getNumberOfQuestions() {
        return numberOfQuestions;
    }
}
