
public class App {
	public static void main(String[] args) {		
		ArvoreBinaria arvere = new ArvoreBinaria<>();
		
		try {
			arvere.getRoot();
			
		}
		catch (EmptyTreeException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
