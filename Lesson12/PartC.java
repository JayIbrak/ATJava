package Lesson12 ;
public class PartC{

public static int countVowels(String phrase)
{
    int count = 0;
    for(int i = 0; i<phrase.length(); i++)
    {
        char character = phrase.charAt(i);
        if(isVowel(character))
        {
            count++;
        }
    }
    return count;   
    
}

public static boolean isVowel(char character)
{
    character = Character.toLowerCase(character);
    if(character == 'a')
    {
        return true;
    }
    else if(character == 'e')
    {
        return true;
    }
     else if(character == 'i')
    {
        return true;
    }
     else if(character == 'o')
    {
        return true;
    }
     else if(character == 'u')
    {
        return true;
    }
     else
    {
        return false;
    }
    
    
}


 public static void main(String[] args)
    {
        String phrase = "DS IS AWESOME";
        System.out.println("In the phrase, " + phrase + ", there are " + countVowels(phrase) + " vowels.");
    }

}