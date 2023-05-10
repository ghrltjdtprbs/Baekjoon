import java.util.Scanner;
public class b2869 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int A = scanner.nextInt();
		int B = scanner.nextInt();
		int V = scanner.nextInt();
		int result = (V-B)/(A-B);
		
		if((V-B)%(A-B)!= 0) 
			result++;
		    
	
		System.out.print(result);
		

	}

}
