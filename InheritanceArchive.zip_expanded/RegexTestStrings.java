package edu.neu.csye6200;

import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author
 * https://www.vogella.com/tutorials/JavaRegularExpressions/article.html
 *
 */
public class RegexTestStrings {
	public static final String K_BLANK = "FillInTheBlank";
    public static final String EXAMPLE_TEST = "This is my small example "
            + "string which I'm going to " + "use for pattern matching.";

    /**
     * Demonstrate three String methods with RegEx:
     * 		1. exampleString.matches(matchString);
     * 		2. exampleString.split(regexString);
     * 		3. exampleString.replaceAll(regexString);
     * @param s
     */
    public void demoRegex(String s) {
    	System.out.println("\n\t" + RegexTestStrings.class.getName() + ".demoRegex()...");
		/**
		 * Match Example String using RegEx
		 */
		String matchStr = "\\w.*";
    	System.out.println("MATCH: '" + matchStr + "'' in Example String:\n '" + EXAMPLE_TEST + "'");
        System.out.println(s.matches(matchStr));
        /**
         * Split Example String using RegEx
         */
        String[] splitTokens = (s.split("\\s+"));
        System.out.println(splitTokens.length + " tokens split from Example String.");// should be 14
        for (String string : splitTokens) {
            System.out.print(string + ", ");
        }
        System.out.println();
        
        /**
         *  replace all whitespace with tabs
         */
        String findStr = "\\s+";
        String replaceStr = "\t";
        System.out.print("REPLACE_ALL: '" + findStr + "' with '" + replaceStr + "' :\n'");
        System.out.println(s.replaceAll(findStr, replaceStr));
    	System.out.println("\n\t" + RegexTestStrings.class.getName() + ".demoRegex()... done!");
    }
    
    /**
     * Grade a Fill-in-the-blank question based on supplied answers.
     * 
     * @param question	Strings with FillInThisBlank
     * @param answers	Strings with correct answers to FillInTheBlank in order
     * 
     * @return			Score
     */
    public int quizMatch(List<String> questions, List<String> answers) {
    	int score = 0;
    	
    	for (String s : questions) {
//    		int i = 0;
//    		String[] fillIntokens = s.split(K_BLANK);
    		for (String answer : answers) {
				score += ( answer.matches(s) ) ? 1 : 0;
//				score += ( answer.matches(fillIntokens[i]) ) ? 1 : 0;
			}
		}
    	return score;
    }
    public void demoQuizMatch() {
    	System.out.println("\n\t" + RegexTestStrings.class.getName() + ".demoQuizMatch()...");
    	String fi1 = "Daniel";
    	String fi2 = "Peters";
    	String fi3 = "Daniel";
    	String fi4 = "Peters";
    	List<String> questionList = Arrays.asList(
    			"My First Name is " + fi1,
//    			"My First Name is  " + fi1,
    			"My Last Name is " + fi2,
    			"My Full Name is " + fi3 + " " + fi4
    			);
//    	List<String> questionList = Arrays.asList(
//    			"My First Name is " + K_BLANK,
//    			"My Last Name is " + K_BLANK,
//    			"My Full Name is " + K_BLANK + " " + K_BLANK
//    			);
    	List<String> answerList = Arrays.asList(
    			"My First Name is Daniel",
//    			"My First Name is\\s*Daniel",
    			"My Last Name is Peters",
    			"My Full Name is Daniel Peters"
    			);
    	System.out.println("Score = " + quizMatch(questionList, answerList)); 
    	
    	System.out.println("\n\t" + RegexTestStrings.class.getName() + ".demoQuizMatch()... done!");
    }
    
    /**
     * Demonstrate the use of this class
     */
    public static void demo() {
		System.out.println("\n\t" + RegexTestStrings.class.getName() + ".demo()...");
		RegexTestStrings obj = new RegexTestStrings();
		
		obj.demoRegex(EXAMPLE_TEST);
		obj.demoQuizMatch();

        System.out.println("\n\t" + RegexTestStrings.class.getName() + ".demo()... done!");
    }
}