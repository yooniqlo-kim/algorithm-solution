import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        
        while(sc.hasNextInt()) {
        	int a = sc.nextInt();
        	int b = sc.nextInt();
        	
        	System.out.println(a+b);
        }
       
        
    }
}