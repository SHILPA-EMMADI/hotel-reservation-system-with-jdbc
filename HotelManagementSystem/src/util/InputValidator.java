package util;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class InputValidator {
    public static int readInt(Scanner s,String m){while(true){System.out.print(m);try{return Integer.parseInt(s.nextLine().trim());}catch(NumberFormatException e){System.out.println("Enter a valid number!");}}}
    public static double readDouble(Scanner s,String m){while(true){System.out.print(m);try{double v=Double.parseDouble(s.nextLine().trim());if(v>0)return v;}catch(NumberFormatException ignored){}System.out.println("Enter a valid positive amount!");}}
    public static String readString(Scanner s,String m){while(true){System.out.print(m);String v=s.nextLine().trim();if(!v.isEmpty())return v;System.out.println("Input cannot be empty!");}}
    public static LocalDate readDate(Scanner s,String m){while(true){System.out.print(m);try{return LocalDate.parse(s.nextLine().trim());}catch(DateTimeParseException e){System.out.println("Use YYYY-MM-DD format!");}}}
}
