# expr-eval
/**
    Given an expression each chanracter will have a specific value
    and by associating  that value to particular character we have to solve -

    a) value of any given character.
    b) sum of values of characters in a given string
    c) Take an integer and print the string for which the sum matches given integer
    
    **/
    
    GIVEN SERIES
    
    A=1
    B=2A+2
    C=2B+3
    D=2C+4  and so on..
    
    Three methods have been used in the program.
    
    1) "calExpr(char ch, int pos)" -  which takes a character and it's position and calculates the value using above             series.
    2) "addLettersOfString(String str)" - This is for second part which takes a string and prints the character sum 
    3) "returnString(char[]word,int number)"- takes a number and prints the string accordingly.
