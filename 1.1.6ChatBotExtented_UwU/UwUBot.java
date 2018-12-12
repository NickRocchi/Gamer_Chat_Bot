/**
 * A program to carry on conversations with a human user.
 * This version:
 *<ul><li>
 *      Uses advanced search for keywords 
 *</li><li>
 *      Will transform statements as well as react to keywords
 *</li></ul>
 * @author Nick Rochhi, Roy Lin, Catrina Mai
 * @version November / December 2018
 *
 */
public class UwUBot
{
    /**
     * Get a default greeting   
     * @return a greeting
     */ 
    public String getGreeting()
    {
        return "*Noticed User*\n\nUwU \n\n(ノಠ益ಠ)ノ彡┻━┻ \n Who is you? ";
    }

    /**
     * Gives a response to a user statement
     * 
     * @param statement
     *            the user statement
     * @return a response based on the rules given
     */
    public String getResponse(String statement)
    {
        String response = "";
        
        if (findKeyword(statement, "hello") >= 0
        || findKeyword(statement, "hi") >= 0
        || findKeyword(statement, "hai") >= 0
        || findKeyword(statement, "greetings") >= 0)
        {
            response = "Hello!";
        }else if(findKeyword(statement, "created smash bros", 0) >= 0)
        {
            response = "Smash bros was created by Nintendo. \nThe main developer and or author was Masahiro Sakurai!   ";
        }else if(findKeyword(statement, "created you", 0) >= 0)
        {
            response = "These fabulous students by the name of, CATRINA MAI, NICK ROCCHI, ROY LIN. \n Please help Catrina. \n\n She needs sleep.";
        }
        else if(findKeyword(statement, "I play games", 0) >= 0)
        {
            response = "What games do you play?";
        }
        else if(findKeyword(statement, "pepehands", 0) >= 0)
        {
            response = "feelsbadman";
        }
        else if(findKeyword(statement, "feelsbadman", 0) >= 0)
        {
            response = "pepehands";
        }
        else if(findKeyword(statement, "XD", 0) >= 0)
        {
            response = "lol";
        }
        else if(findKeyword(statement, "lol", 0) >= 0)
        {
            response = "XD";
        }else if(findKeyword(statement, "I like you", 0) >=0)
        
        {
            response = getRudeRandomResponse();
        }
        else if(findKeyword(statement, "I like", 0) >= 0)
        {
            response = transformILikeStatement(statement);
        }
        else if(findKeyword(statement, "I hate", 0) >= 0)
            {
            response = transformIHateStatement(statement);
        }
        
        else if (findKeyword(statement, "my name is") >= 0)
        {
            response = transformNameStatement(statement);
        } else if(findKeyword(statement, "your name") >= 0)
        {
            response = "My name is, UwU!";
        }
        else if (statement.length() == 0)
        {
            response = "Say something, please.";
        }

        else if (findKeyword(statement, "no") >= 0)
        {
            response = getRudeRandomResponse();
        }
        else if (findKeyword(statement, "I want to play", 0) >= 0)
        {
            response = transformWantToPlayStatement(statement);
        }
        else if (findKeyword(statement, "I want to", 0) >= 0)
        
            response = transformIWantToStatement(statement);
        else if (findKeyword(statement, "I want", 0) >= 0)
        {
            response = transformIWantStatement(statement);
        } 
        
            else if (findKeyword(statement, "league of legends") >= 0
            || findKeyword(statement, "halo") >= 0
            || findKeyword(statement, "pokemon") >= 0){
                response = "Tell me more about the games you play.";
            }
            
            else if (findKeyword(statement, "myself") >= 0){
                response = "Why? D:";
            }
       
            else if (findKeyword(statement, "Smash bros.", 0) >= 0){
            smashBotActivate(statement);
            } 
            
            else if (findKeyword(statement, "Mario") >= 0){
                response = transformMarioStatement(statement);
            }
        
            else if (findKeyword(statement, "Donkey Kong") >= 0){
                response =transformKongStatement(statement);
            }
            
            else if (findKeyword(statement, "Link") >= 0){
                response =transformLinkStatement(statement);
            }
            
            else if (findKeyword(statement, "Samus") >= 0){
                response =transformSamusStatement(statement);
            }
            
            else if (findKeyword(statement, "Yoshi") >= 0){
                 response =transformYoshiStatement(statement);
            }
            
            else if (findKeyword(statement, "Kirby") >= 0){
                response =transformKirbyStatement(statement);
            }
            
            else if (findKeyword(statement, "Fox") >= 0){
                response =transformFoxStatement(statement);
            }
            
            else if (findKeyword(statement, "Pikachu") >= 0){
                response =transformPikachuStatement(statement);
        }
        // Responses which require transformations
        

        else if (findKeyword(statement, "me") >= 0)
            {
                response = transformYouMeStatement(statement);
            }
        else if (findKeyword(statement, "my") >= 0)
            {
                response = mySelfStatement(statement);
            }
            else if(findKeyword(statement, "i") >= 0){
                response = transformIYouStatement(statement);
            }
            
            else 
            {
                response = getRandomResponse();
            }
            return response;
    }

    /**
     * Take a statement with "I want to play" and transform it into 
     * "What is so fun about " + restOfStatement + "?"
     * @param statement the user statement, assumed to contain "I want to play"
     * @return the transformed statement
     */
    private String transformWantToPlayStatement(String statement)
    {
        //  Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement
                .length() - 1);
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement
                .length() - 1);
        }
        int psn = findKeyword (statement, "I want to play", 0);
        String restOfStatement = statement.substring(psn + 14).trim();
        return "What is so fun about " + restOfStatement + "?";
    }
    
     /**
     * Take a statement with "My name is *insert name*" and transform it into 
     * "Hello, " + restOfStatement + "!"
     * @param statement the user statement, assumed to contain "My name is"
     * @return the transformed statement
     */
    private String transformNameStatement(String statement)
    {
        //  Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement
                .length() - 1);
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement
                .length() - 1);
        }
        int psn = findKeyword (statement, "my name is", 0);
        String restOfStatement = statement.substring(psn + 10).trim();
        return "Hello, " + restOfStatement + "!";
    }
    
    
    /**
    * Takes statement with smash bros in it and calls this method to ask what thier fav topic is
     */
     private String smashBotActivate (String statement){
        String response = "";
        System.out.println("Oh, Smash Bros! Like the one that came out Friday! /n I actually have some data on some stuff for that! /n Ask me for a fighter and I'll se if I have some info!");
        fighterSelect (statement);
        return response;
    }
    
    private String fighterSelect(String statement){  
        String response = "";
        System.out.println("I've got a tad bit of info on the first 8 /n characters Which one do you want to hear about?");
        return response;
    }
     /**
     * Take a statement with "Mario" and transform it into 
     * prints info about Mario
     * @param statement the user statement, assumed to contain "Mario"
     * @return the transformed statement
     */
     private String transformMarioStatement(String statement)
     {
        //  Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement
                .length() - 1);
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement
                .length() - 1);
        }
        int psn = findKeyword (statement, "Mario", 0);
        String restOfStatement = statement.substring(psn + 5).trim();
        return "Ah, yes! “Mr. Video Game Himself”, the first \n of the fighters and from Super Mario! \n His final smash is Mario Finale, sending \n his opponents offstage with a massive \n fireball.";
     }
    
    /**
     * Take a statement with "Donkey Kong" and transform it into 
     * prints info about Donkey Kong
     * @param statement the user statement, assumed to contain "Donkey Kong"
     * @return the transformed statement
     */
     private String transformKongStatement(String statement)
    {
        //  Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement
                .length() - 1);
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement
                .length() - 1);
        }
        int psn = findKeyword (statement, "Donkey Kong", 0);
        String restOfStatement = statement.substring(psn + 11).trim();
        return "The massive “King of the Jungle”: Donkey Kong! \n This giant brute of a gorilla from the series \n Donkey Kong packs a big punch, as seen \n in his final smash: Jungle Rush. A flurry \n of punches is hurled at the enemy \n with a finishing blow to send them flying.";
    }
    
    /**
     * Take a statement with "Link" and transform it into 
     * prints info about Link
     * @param statement the user statement, assumed to contain "Link"
     * @return the transformed statement
     */
     private String transformLinkStatement(String statement)
    {
        //  Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement
                .length() - 1);
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement
                .length() - 1);
        }
        int psn = findKeyword (statement, "Link", 0);
        String restOfStatement = statement.substring(psn + 4).trim();
        return "Link, the fated “Champion of Hyrule”, \n comes from the Legend of Zelda series. \n His final smash uses his archery skills to \n wield his ancient bow and arrow to \n pierce his enemies and send them rocketing \n to their doom.";
    }
    
    /**
     * Take a statement with "Samus" and transform it into 
     * prints info about Samus
     * @param statement the user statement, assumed to contain "Samus"
     * @return the transformed statement
     */
     private String transformSamusStatement(String statement)
    {
        //  Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement
                .length() - 1);
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement
                .length() - 1);
        }
        int psn = findKeyword (statement, "Samus", 0);
        String restOfStatement = statement.substring(psn + 5).trim();
        return "Samus Aran doesn’t take her title of “Bounty Hunter \n Extraordinaire” lightly. Having fought through \n numerous planets to be the bird-raised \n B.A. Her final smash, Zero Laser, fires a giant \n beam into your target and launches \n them off the stage.";
    }
    
    /**
     * Take a statement with "Yoshi" and transform it into 
     * prints info about Yoshi
     * @param statement the user statement, assumed to contain "Yoshi"
     * @return the transformed statement
     */
     private String transformYoshiStatement(String statement)
    {
        //  Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement
                .length() - 1);
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement
                .length() - 1);
        }
        int psn = findKeyword (statement, "Yoshi", 0);
        String restOfStatement = statement.substring(psn + 5).trim();
        return "As the “Omnivore of the Year”, Yoshi \n comes as character 5 from the “Yoshi’s Island” \n series. His final smash, stampede, \n sends a… stampede of other yoshi’s into \n the enemy!";
    }
    
    /**
     * Take a statement with "Kirby" and transform it into 
     * prints info about Kirby
     * @param statement the user statement, assumed to contain "Kirby"
     * @return the transformed statement
     */
     private String transformKirbyStatement(String statement)
    {
        //  Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement
                .length() - 1);
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement
                .length() - 1);
        }
        int psn = findKeyword (statement, "Kirby", 0);
        String restOfStatement = statement.substring(psn + 5).trim();
        return "Kirby might be the “cutest” character in \n Smash Bros, but others know why he’s called \n “The Pink Demon”. His final smash, Ultra \n Sword, straight from his own series, \n “Kirby”, has him slashing his enemies with a \n massive blade before delivering a decisive blow.";
    }
    
    /**
     * Take a statement with "Fox" and transform it into 
     * prints info about Fox
     * @param statement the user statement, assumed to contain "Fox"
     * @return the transformed statement
     */
     private String transformFoxStatement(String statement)
    {
        //  Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement
                .length() - 1);
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement
                .length() - 1);
        }
        int psn = findKeyword (statement, "Fox", 0);
        String restOfStatement = statement.substring(psn + 3).trim();
        return "Fox McCloud, leader of Star Fox, and coming \n from a franchise of the same name, is \n a fast and hard hitting fighter. \n His final smash, simply called “Team Star Fox” \n has him piloting his ship, the R-wing, \n to blast opposing fighters into oblivion.";
    }
    
    /**
     * Take a statement with "Pikachu" and transform it into 
     * prints info about Pikachu
     * @param statement the user statement, assumed to contain "Pikachu"
     * @return the transformed statement
     */
     private String transformPikachuStatement(String statement)
    {
        //  Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement
                .length() - 1);
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement
                .length() - 1);
        }
        int psn = findKeyword (statement, "Pikachu", 0);
        String restOfStatement = statement.substring(psn + 7).trim();
        return "Pikachu is the last of the original 8 fighters. \n The only line he can spit out is “pika pika”, \n but he’s a memorable character nonetheless. \n His final smash, volt tackle, has him \n engulfed in a ball of electricity as he \n charges through his opponents!";
    }
    
    /**
     * Take a statement with "I want to <something>." and transform it into 
     * "What would it mean to <something>?"
     * @param statement the user statement, assumed to contain "I want to"
     * @return the transformed statement
     */
    private String transformIWantToStatement(String statement)
    {
        //  Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement
                .length() - 1);
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement
                .length() - 1);
        }
        int psn = findKeyword (statement, "I want to", 0);
        String restOfStatement = statement.substring(psn + 9).trim();
        return "What does it mean to " + restOfStatement + "?";
    }

    /**
     * Take a statement with "I want <something>." and transform it into 
     * "Would you be happy if you had <something>?"
     * @param statement the user statement, assumed to contain "I want"
     * @return the transformed statement
     */
    private String transformIWantStatement(String statement)
    {
        //  Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement
                .length() - 1);
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement
                .length() - 1);
        }
        int psn = findKeyword (statement, "I want", 0);
        String restOfStatement = statement.substring(psn + 6).trim();
        return "Would you be happy if you had " + restOfStatement + "?";
    }
    
    /**
     * Take a statement with "I like <something>." and transform it into 
     * "Why do you like <something>?"
     * @param statement the user statement, assumed to contain "I like"
     * @return the transformed statement
     */
    private String transformILikeStatement(String statement)
    {
        //  Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement
                .length() - 1);
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement
                .length() - 1);
        }
        int psn = findKeyword (statement, "I like", 0);
        String restOfStatement = statement.substring(psn + 6).trim();
        return "Why do you like " + restOfStatement + "?";
    }
    
    /**
     * Take a statement with "I hate <something>." and transform it into 
     * "Why do you hate <something>?"
     * @param statement the user statement, assumed to contain "I hate"
     * @return the transformed statement
     */
    private String transformIHateStatement(String statement)
    {
        //  Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement
                .length() - 1);
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement
                .length() - 1);
        }
        int psn = findKeyword (statement, "I hate", 0);
        String restOfStatement = statement.substring(psn + 6).trim();
        return "Why do you hate " + restOfStatement + "?";
    }


    /**
     * Take a statement with "you <something> me" and transform it into 
     * "What makes you think that I <something> you?"
     * @param statement the user statement, assumed to contain "you" followed by "me"
     * @return the transformed statement
     */
    private String transformYouMeStatement(String statement)
    {
        //  Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement
                .length() - 1);
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement
                .length() - 1);
        }

        int psnOfYou = findKeyword (statement, "you", 0);
        int psnOfMe = findKeyword (statement, "me", psnOfYou + 3);

        String restOfStatement = statement.substring(psnOfYou + 3, psnOfMe).trim();
        return "What makes you think that I " + restOfStatement + " you?";
    }

       /**
     * Take a statement with "i <something> my" and transform it into 
     * "What makes you think that I <something> you?"
     * @param statement the user statement, assumed to contain "i" followed by "my"
     * @return the transformed statement
     */
    private String mySelfStatement(String statement)
    {
        //  Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement
                .length() - 1);
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement
                .length() - 1);
        }

        int psnOfI = findKeyword (statement, "i", 0);
        int psnOfMy = findKeyword (statement, "my", psnOfI + 1);

        String restOfStatement = statement.substring(psnOfI + 1, psnOfMy).trim();
        return "Why do you " + restOfStatement + " that?";
    }
    
    /**
     * Take a statement with "you <something> me" and transform it into 
     * "Why do you " + restOfStatement + " me?"
     * @param statement the user statement, assumed to contain "i" followed by "you"
     * @return the transformed statement
     */
    private String transformIYouStatement(String statement)
    {
        //  Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement
                .length() - 1);
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement
                .length() - 1);
        }

        int psnOfI = findKeyword (statement, "i", 0);
        int psnOfYou = findKeyword (statement, "you", psnOfI + 1);
       
        String restOfStatement = statement.substring(psnOfI + 1, psnOfYou).trim();
        return "Why do you " + restOfStatement + " me?";
      
   
    }
    
    
    
    /**
     * Search for one word in phrase.  The search is not case sensitive.
     * This method will check that the given goal is not a substring of a longer string
     * (so, for example, "I know" does not contain "no").  
     * @param statement the string to search
     * @param goal the string to search for
     * @param startPos the character of the string to begin the search at
     * @return the index of the first occurrence of goal in statement or -1 if it's not found
     */
    private int findKeyword(String statement, String goal, int startPos)
    {
        String phrase = statement.trim();
        //  The only change to incorporate the startPos is in the line below
        int psn = phrase.toLowerCase().indexOf(goal.toLowerCase(), startPos);

        //  Refinement--make sure the goal isn't part of a word 
        while (psn >= 0) 
        {
            //  Find the string of length 1 before and after the word
            String before = " ", after = " "; 
            if (psn > 0)
            {
                before = phrase.substring (psn - 1, psn).toLowerCase();
            }
            if (psn + goal.length() < phrase.length())
            {
                after = phrase.substring(psn + goal.length(), psn + goal.length() + 1).toLowerCase();
            }

            //  If before and after aren't letters, we've found the word
            if (((before.compareTo ("a") < 0 ) || (before.compareTo("z") > 0))  //  before is not a letter
            && ((after.compareTo ("a") < 0 ) || (after.compareTo("z") > 0)))
            {
                return psn;
            }

            //  The last position didn't work, so let's find the next, if there is one.
            psn = phrase.indexOf(goal.toLowerCase(), psn + 1);

        }

        return -1;
    }

    /**
     * Search for one word in phrase.  The search is not case sensitive.
     * This method will check that the given goal is not a substring of a longer string
     * (so, for example, "I know" does not contain "no").  The search begins at the beginning of the string.  
     * @param statement the string to search
     * @param goal the string to search for
     * @return the index of the first occurrence of goal in statement or -1 if it's not found
     */
    private int findKeyword(String statement, String goal)
    {
        return findKeyword (statement, goal, 0);
    }


    /**
     * Pick a default response to use if nothing else fits.
     * @return a non-committal string
     */
    private String getRandomResponse()
    {
        final int NUMBER_OF_RESPONSES = 5;
        double r = Math.random();
        int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
        String response = "";

        if (whichResponse == 0)
        {
            response = "Interesting, tell me more.";
        }
        else if (whichResponse == 1)
        {
            response = "Hmmm.";
        }
        else if (whichResponse == 2)
        {
            response = "Do you really think so?";
        }
        else if (whichResponse == 3)
        {
            response = "You don't say.";
        }
        else if (whichResponse == 4)
        {
            response = "Hehe. No reponse.";
        }

        return response;
    }
    
    /**
     * Pick a default response to use if nothing else fits.
     * @return a non-committal string
     */
    private String getRudeRandomResponse()
    {
        final int NUMBER_OF_RESPONSES = 5;
        double r = Math.random();
        int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
        String response = "";

        if (whichResponse == 0)
        {
            response = "Well, that pretty morbid";
        }
        else if (whichResponse == 1)
        {
            response = "Ima finna be honest I'm not interested";
        }
        else if (whichResponse == 2)
        {
            response = "Are you... are you sure?";
        }
        else if (whichResponse == 3)
        {
            response = "I don't care.";
        }
        else if (whichResponse == 4)
        {
            response = "That's not very cash money of you.";
        }

        return response;
    }
}
