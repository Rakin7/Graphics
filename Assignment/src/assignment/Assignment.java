/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

/**
 *
 * @author Rakin
 */
import java.util.*;
import java.io.*;
public class Assignment {

    /**
     * @param args the command line arguments
     */
    public static void KeyWords(ArrayList<String> arrayList) 
  {
        ArrayList<String> KEYWORDS = new ArrayList<String>();
        //pushing all keywords in the arraylist
        KEYWORDS.add("abstract");
        KEYWORDS.add("case");
        KEYWORDS.add("continue");
        KEYWORDS.add("enum");
        KEYWORDS.add("assert");
        KEYWORDS.add("catch");
        KEYWORDS.add("default");
        KEYWORDS.add("extends");
        KEYWORDS.add("boolean");
        KEYWORDS.add("char");
        KEYWORDS.add("do");
        KEYWORDS.add("final");
        KEYWORDS.add("break");
        KEYWORDS.add("class");
        KEYWORDS.add("double");
        KEYWORDS.add("finally");
        KEYWORDS.add("byte");
        KEYWORDS.add("const");
        KEYWORDS.add("else");
        KEYWORDS.add("float");
        KEYWORDS.add("for");
        KEYWORDS.add("goto");
        KEYWORDS.add("if");
        KEYWORDS.add("implements");
        KEYWORDS.add("import");
        KEYWORDS.add("instanceof");
        KEYWORDS.add("int");
        KEYWORDS.add("interface");
        KEYWORDS.add("long");
        KEYWORDS.add("native");
        KEYWORDS.add("new");
        KEYWORDS.add("package");
        KEYWORDS.add("private");
        KEYWORDS.add("protected");
        KEYWORDS.add("public");
        KEYWORDS.add("return");
        KEYWORDS.add("transient");
        KEYWORDS.add("try");
        KEYWORDS.add("void");
        KEYWORDS.add("volatile");
        KEYWORDS.add("while");
        //converting the arraylist to array for BinarySearch
        String[] keylist = KEYWORDS.toArray(new String[KEYWORDS.size()]);
        System.out.print("Keywords: ");
        for (int i = 0; i < arrayList.size(); i++) 
        {
            StringTokenizer stringTokenizer = new StringTokenizer(arrayList.get(i));
            while (stringTokenizer.hasMoreTokens()) 
            {
                String word = stringTokenizer.nextToken();
                int position = Arrays.binarySearch(keylist, word);
                if (position >= 0 && word.equals(keylist[position])) 
                {
                    System.out.print(word + ",");
                }
            }

        }
        System.out.println();
    }

    public static void Identifiers(ArrayList<String> arrayList) {

        String[] primitiveData = {"byte", "short", "int", "long", "float", "double", "boolean", "char"};
        Arrays.sort(primitiveData);
        System.out.print("Identifiers: ");
        for (int i = 0; i<arrayList.size(); i++) 
        {
            String thisLine = arrayList.get(i);
            thisLine = thisLine.replaceAll("[^a-zA-Z0-9]", " ");
            if(!thisLine.trim().isEmpty()) 
            {
                StringTokenizer stringTokenizer = new StringTokenizer(thisLine);
                String word = stringTokenizer.nextToken();
                int position = Arrays.binarySearch(primitiveData, word);
                if (position >= 0 && word.contentEquals(primitiveData[position])) 
                {
                    while (stringTokenizer.hasMoreTokens()) 
                    {
                        System.out.print(stringTokenizer.nextToken() + ", ");

                    }
                }
            }
        }
        System.out.println();
    }

    public static void Math_Operators(ArrayList<String> arrayList) {
        System.out.print("Math Operators: ");
        ArrayList<String> Math_Operator = new ArrayList<String>();
        for (int i = 0; i < arrayList.size(); ++i) 
        {
            String word = arrayList.get(i);
            if (word.contains("+")) 
            {
                if (Math_Operator.contains("+") == false) 
                {
                    Math_Operator.add("+");
                }
            }
            if (word.contains("-")) 
            {
                if (Math_Operator.contains("-") == false) 
                {
                    Math_Operator.add("-");
                }
            }
            if (word.contains("*")) 
            {
                if (Math_Operator.contains("*") == false) 
                {
                    Math_Operator.add("*");
                }
            }
            if (word.contains("/")) 
            {
                if (Math_Operator.contains("/") == false) 
                {
                    Math_Operator.add("/");
                }
            }
            if (word.contains("=")) 
            {
                if (Math_Operator.contains("=") == false) 
                {
                    Math_Operator.add("=");
                }
            }
            if (word.contains("%")) 
            {
                if (Math_Operator.contains("%") == false) 
                {
                    Math_Operator.add("%");
                }
            }
            if (word.contains("Math.abs")) 
            {
                if (Math_Operator.contains("Math.abs") == false) 
                {
                    Math_Operator.add("Math.abs");
                }
            }
        }

        for (int i = 0; i < Math_Operator.size(); ++i)
        {            
                System.out.print(Math_Operator.get(i) + ", ");   
        }
        System.out.println();
    }

    public static void Logical_Operators(ArrayList<String> arrayList) 
    {
        System.out.print("Logical Operators: ");
        ArrayList<String> Logical_Operators = new ArrayList<String>();
        for (int i = 0; i < arrayList.size(); i++) 
        {
            String word = arrayList.get(i);
            if (word.contains(">")) 
            {
                if (!Logical_Operators.contains(">")) 
                {
                    Logical_Operators.add(">");
                }
            }
            if (word.contains("<")) 
            {
                if (!Logical_Operators.contains("<")) 
                {
                    Logical_Operators.add("<");
                }
            }
            if (word.contains("==")) 
            {
                if (!Logical_Operators.contains("==")) 
                {
                    Logical_Operators.add("==");
                }
            }
            if (word.contains("!=")) 
            {
                if (!Logical_Operators.contains("!=")) 
                {
                    Logical_Operators.add("!=");
                }
            }
            if (word.contains("<=")) 
            {
                if (!Logical_Operators.contains("<=")) 
                {
                    Logical_Operators.add("<=");
                }
            }
            if (word.contains(">=")) 
            {
                if (!Logical_Operators.contains(">=")) 
                {
                    Logical_Operators.add(">=");
                }
            }
            if (word.contains("&&")) 
            {
                if (!Logical_Operators.contains("&&")) 
                {
                    Logical_Operators.add("&&");
                }
            }
            if (word.contains("||")) 
            {
                if (!Logical_Operators.contains("||")) 
                {
                    Logical_Operators.add("||");
                }
            }
            if (word.contains("!")) 
            {
                if (!Logical_Operators.contains("!")) 
                {
                    Logical_Operators.add("!");
                }
            }
        }

        for (int i = 0; i < Logical_Operators.size(); i++) 
        {           
                System.out.print(Logical_Operators.get(i) + ",");
        }
        System.out.println();
    }


    public static void Numerical_Values(ArrayList<String> arrayList) 
    {
        ArrayList<String> Nummerical_Values = new ArrayList<String>();
        System.out.print("Numerical Values: ");
        for (int i = 0; i < arrayList.size(); i++) 
        {
            String number = arrayList.get(i);
            number = number.replaceAll("[^0-9.]", " ");
            if (!number.trim().isEmpty()) 
            {
                Nummerical_Values.add(number);
            }
        }
        for (int i=0; i<Nummerical_Values.size(); i++) 
        {
                String a=Nummerical_Values.get(i);
                a=a.replaceAll("\\s+","");
                System.out.print(a + ", ");
        }
        System.out.println();
    }
    public static void  Others(ArrayList<String> arrayList) 
    {
        System.out.print("Others: ");
        ArrayList<String> Others = new ArrayList<String>();
        for (int i = 0; i < arrayList.size(); i++) 
        {
            String word = arrayList.get(i);
            char[] characters = word.toCharArray();
            for (int j = 0; j < characters.length; j++) 
            {
                if (characters[j] == 40) 
                {
                    if (!Others.contains("(")) 
                    {
                        Others.add("(");
                    }
                }
                else if (characters[j] == 41) 
                {
                    if (!Others.contains(")")) 
                    {
                        Others.add(")");
                    }
                }
                else if (characters[j] == 91) 
                {
                    if (!Others.contains("[")) 
                    {
                        Others.add("[");
                    }
                } 
                else if (characters[j] == 93) 
                {
                    if (!Others.contains("]")) 
                    {
                        Others.add("]");
                    }
                }
                else if (characters[j] == 123) 
                {
                    if (!Others.contains("{")) 
                    {
                        Others.add("{");
                    }
                }
                else if (characters[j] == 125) 
                {
                    if (!Others.contains("}"))
                    {
                        Others.add("}");
                    }
                }
                else if (characters[j] == 59) 
                {
                    if (!Others.contains(";")) 
                    {
                        Others.add(";");
                    }
                }
                else if (characters[j] == 46) 
                {
                    if (!Others.contains(".")) 
                    {
                        Others.add(".");
                    }
                    else if (characters[j] == 58) 
                    {
                        if (!Others.contains(":")) 
                        {
                            Others.add(":");
                        }
                    }
                }
            }
        }
                Collections.sort(Others);
                for (int i = 0; i < Others.size(); i++) 
                {
                        System.out.print(Others.get(i) + " ");
                }
                System.out.println();
            }   
    public static void main(String[]args) 
    {
        // TODO code application logic here
        try
            {
                //change the destination of the input.txt file
                FileReader f=new FileReader("I:\\cse420-labs\\Bleh\\input.txt");
                BufferedReader br = new BufferedReader(f);
                //put each line on each cells of the Array List//
                ArrayList<String> LineStore = new ArrayList<String>();
                String line;
                while((line=br.readLine()) != null) 
                {
                    LineStore.add(line);
                }
                
                KeyWords(LineStore);
                Identifiers(LineStore);
                Math_Operators(LineStore);
                Logical_Operators(LineStore);
                Numerical_Values(LineStore);
                Others(LineStore);
                br.close();
            } 
        catch (Exception e) 
            {
                System.out.println("File is missing. Exception -> " + e);
            }
    }
    
}
