
import java.util.HashSet;
import java.util.Scanner;


public class PasswordApp {
    
	static Scanner in = new Scanner(System.in);
    
	 BloomFilter bf;
	 static HashSet<String> weakPass = new HashSet<>();
	 
    
	public PasswordApp(BloomFilter bf) {

       this.bf=bf;
	}
	

	public int passwordCheck(String password) {
		
        
		boolean hasLetter = false;
		boolean hasDigit = false;
		boolean hasUpper=false;
		boolean hasLower=false;

		if (password.length() >= 8) {
			for (int i = 0; i < password.length(); i++) {
				char x = password.charAt(i);
				if (Character.isLetter(x)) {
					if (Character.isUpperCase(x)) {
						hasUpper=true;
					}
					if (Character.isLowerCase(x)) {
						hasLower=true;
					}
					if(hasLower&&hasUpper) {
						hasLetter = true;
					}

				}

				else if (Character.isDigit(x)) {

					hasDigit = true;
				}

				// no need to check further, break the loop
				if(hasLetter && hasDigit){

					break;
				}

			}
			
			if (!hasDigit) {

				System.out.println("Weak");
				bf.add(password);
				return 1;

			} 
			else if(!hasLower&&!hasUpper) {
				System.out.println("Weak");
				bf.add(password);
				return 1;
				
			}
			else if(hasLower&&!hasUpper) {
				System.out.println("Medium");
				return 2;
			}
			else if(!hasLower&&hasUpper) {
				System.out.println("Medium");
				return 2;
			}
			else if(hasLetter && hasDigit) {
				System.out.println("Strong");
				return 3;
			}
		
		
		} else {
			System.out.println("HAVE AT LEAST 8 CHARACTERS");
            return 1;
		}
       return 0;
	}
	
	public void addToWeakPassDict(String password) {
		weakPass.add(password);
	}
   
	public int getFalsePsitive() {
		int count = 0;
	    
	  
		
		return count;
	}

	public String isStrong(String password) {
	

		boolean hasLetter = false;
		boolean hasDigit = false;
		boolean hasUpper=false;
		boolean hasLower=false;

		if (password.length() >= 8) {
			for (int i = 0; i < password.length(); i++) {
				char x = password.charAt(i);
				if (Character.isLetter(x)) {
					if (Character.isUpperCase(x)) {
						hasUpper=true;
					}
					if (Character.isLowerCase(x)) {
						hasLower=true;
					}
					if(hasLower&&hasUpper) {
						hasLetter = true;
					}

				}

				else if (Character.isDigit(x)) {

					hasDigit = true;
				}

				if(hasLetter && hasDigit){

					break;
				}

			}
			if (!hasDigit) {

				//System.out.println("Weak");
				bf.add(password);
				addToWeakPassDict(password);
				System.out.println("Weak password - added to filter");
				return "Weak password - added to filter";


			} 
			else if(!hasLower&&!hasUpper) {
				//System.out.println("Weak");
				bf.add(password);
				addToWeakPassDict(password);
				System.out.println("Weak password - added to filter");
				return "Weak password - added to filter";

			}
			else if(hasLower&&!hasUpper) {
				//	System.out.println("Medium");
				System.out.println("Password is not weak - is not added to filter");
				return "Password is not weak and  is not added to filter";
			}
			else if(!hasLower&&hasUpper) {
				//	System.out.println("Medium");
				System.out.println("Password is not weak - is not added to filter");
				return "Password is not weak  and is not added to filter";
			}
			else if(hasLetter && hasDigit) {
				//	System.out.println("Strong");
				System.out.println("Password is not weak - is not added to filter");
				return "Password is not weak  and is not added to filter";
			}


		} else {
			System.out.println("HAVE AT LEAST 8 CHARACTERS");
			return "HAVE AT LEAST 8 CHARACTERS";

		}
     return "password added";

	}
}