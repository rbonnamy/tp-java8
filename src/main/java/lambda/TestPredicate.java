package lambda;

public class TestPredicate {

	public static void main(String[] args) {
		
		// Etape 1 : class anonyme
		Predicate p1 = new Predicate(){
			public boolean test(String s) {
				return s.length()>10;
			}
		};
		
		// Etape 2: je vire le code administratif (signature de méthode) et
		// j'ajoute la flêche des lambdas
		Predicate p2 = (String s) -> {
				return s.length()>10;
			};
			
		// Java sait que s est de type String car p3 est de type Predicate et Java
		// peut voir dans la signature de son unique méthode que le paramètre est 
		// de type String
		Predicate p3 = s -> {
			return s.length()>10;
		};
		
		// Comme il n'y a que le return dans le corps de la méthode,
		// je poeux supprimer les accolades ainsi que le return 
		Predicate p4 = s -> s.length()>10;

	}

}
