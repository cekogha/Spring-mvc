package fr.cekogha.security;

import java.text.ParseException;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import fr.cekogha.security.entities.Student;
import fr.cekogha.security.entities.StudentRepository;

@SpringBootApplication
public class SpringSecurityApplication {

	public static void main(String[] args) throws ParseException {
		ApplicationContext ctx = SpringApplication.run(SpringSecurityApplication.class, args);

		StudentRepository studentRepository = ctx.getBean(StudentRepository.class);
		
//    	List<String> firstnameList = 
//    			Arrays.asList("Alex","Augustin","Arnaud","Aaron","Antonin","Diego",
//				"Emilien","Esteban","Damien","Erwan","Charles","Anthony",
//				"Ayoub","Bastien","Alan","Aymeric","Bryan","Alban","Aurelien",
//				"Benjamin","Elias","Gabin","Gael","Jordan","Jean","Jeremy",
//				"Dorian","Dylan","David","Etienne","Corentin","Marius",
//				"Killian","Luca","Lukas","Florian","Noe","Morgan","Remi",
//				"Guillaume","Gaetan","Gaspard","Rafael","Tony","Kevin",
//				"Kilian","Mathias","Matthieu","Martin","Loic","Lorenzo",
//				"Vincent","Victor","Thibault","Mateo","Samuel","Simon",
//				"Tiago","Yann","Oscar","Tristan","William","Eliot","Eliott",
//				"Bilal","Robin","Thibaut","Mehdi","Elouan","Lilian","Ilyes",
//				"Ilan","Malo","Mathys","Mohamed","Nolan","Kyllian","Ruben",
//				"Ryan","Titouan","Ewan","Luka","Yannis","Matis","Margot",
//				"Kenzo","Laurine","Younes","Timothe","Melvin","Timeo");
//    	
//    	List<String> lastnameList =
//    			Arrays.asList("Martin","Bernard","Thomas","Petit","Robert","Richard","Durand","Dubois",
//    					"Moreau","Laurent","Simon","Michel","Lefebvre","Leroy","Roux",
//    					"David","Bertrand","Morel","Fournier","Girard","Bonnet","Dupont","Lambert",
//    					"Fontaine","Rousseau","Vincent","Muller","Lefevre","Faure","Andre",
//    					"Mercier","Blanc","Guerin","Boyer","Garnier","Chevalier","Francois",
//    					"Legrand","Gauthier","Garcia","Perrin","Robin","Clement","Morin","Nicolas",
//    					"Henry","Roussel","Mathieu","Gautier","Masson","Marchand","Duval","Denis",
//    					"Dumont","Marie","Lemaire","Noel","Meyer","Dufour","Meunier",
//    					"Brun","Blanchard","Giraud","Joly","Riviere","Lucas","Brunet","Gaillard","Barbier",
//    					"Arnaud","Martinez","Gerard","Roche","Renard","Schmitt","Roy","Leroux",
//    					"Colin","Vidal","Caron","Picard","Roger","Fabre","Aubert","Lemoine",
//    					"Renaud","Dumas","Lacroix","Olivier","Philippe","Bourgeois",
//    					"Pierre","Benoit","Rey","Leclerc","Payet","Rolland","Leclercq","Guillaume",
//    					"Lecomte","Lopez","Jean","Dupuy","Guillot","Hubert","Berger","Carpentier",
//    					"Sanchez","Dupuis","Moulin","Louis","Deschamps","Huet","Vasseur","Perez",
//    					"Boucher","Fleury","Royer","Klein","Jacquet","Adam","Paris","Poirier",
//    					"Marty","Aubry","Guyot","Carre","Charles","Renault","Charpentier","Menard",
//    					"Maillard","Baron","Bertin","Bailly","Herve","Schneider","Fernandez","Le Gall",
//    					"Collet","Leger","Bouvier","Julien","Prevost","Millet","Perrot","Daniel",
//    					"Le Roux","Cousin","Germain","Breton","Besson","Langlois","Remy","Le Goff",
//    					"Pelletier","Leveque","Perrier","Leblanc","Barre","Lebrun","Marchal","Weber",
//    					"Mallet","Hamon","Boulanger","Jacob","Monnier","Michaud","Rodriguez","Guichard",
//    					"Gillet","Etienne","Grondin","Poulain","Tessier","Chevallier","Collin","Chauvin",
//    					"Da Silva","Bouchet","Gay","Lemaitre","Benard","Marechal","Humbert","Reynaud",
//    					"Antoine","Hoarau","Perret","Barthelemy","Cordier","Pichon","Lejeune","Gilbert",
//    					"Lamy","Delaunay","Pasquier","Carlier","Laporte");
//		
//    	List<String> birthdayList = Arrays.asList("1990-01-14","1990-07-11","1993-09-01","1994-01-01","1994-02-22",
//    			"1990-03-04","1990-07-13","1993-08-04","1996-01-01","1996-12-21",
//    			"1990-01-10","1990-04-16","1993-09-07","1994-05-31","1996-11-24",
//    			"1990-06-12","1990-04-18","1993-09-08","1995-05-04","1994-02-12",
//    			"1990-01-14","1990-07-21","1993-08-11","1996-05-06","1994-02-16");
//    	
//		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		
//		for(int i = 0; i < 4;i++) {
//
//			 studentRepository.save(
//					 new Student(firstnameList.get((int) (Math.random() * 90)),
//							 lastnameList.get((int) (Math.random() * 199)),
//							 dateFormat.parse(birthdayList.get((int) (Math.random() * 24)))));
//		}
		
		List<Student> students = studentRepository.findAll();

		students.forEach(
				s -> System.out.println(
						s.getIdStudent() + ", " + s.getLastname() + ", " + s.getFirstname() + ", " + s.getBirthday()
						));
	}


}
