package robotsGuess;

public class Main {
    public static void main(String[] args) {
        Responsible responsible=new Responsible();
        System.out.println("Robot1:");
        System.out.println("I thought a number!");
        System.out.println("Number of digits: "+responsible.getDigitsOfSulution());
        System.out.println("(For later reference, the solution is the following: "+responsible.getSolution()+")\n");

        System.out.println("Robot2:");
        Questioner questioner=new Questioner(responsible.getDigitsOfSulution());
        System.out.println("I will guess the number!");
        System.out.println("Number of questions in the worst case:"+ questioner.getMaxNumberOfQuestions()+"\n");
        while(!questioner.gotTheSolution()){
            questioner.processAnswer(responsible.guess(questioner.getGuess()));
        }
        System.out.println("Number of questions was:"+ questioner.getNumberOfQuestions());
    }
}
