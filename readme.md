Fonctionnement du projet :
- Le main se trouve dans la classe Methodes. 
- Pour exécuter le projet, il suffit donc de lancer la classe Methodes.
- Pour créer un nouveau dessin, il faut créer séparément les différents éléments constitutifs de ce dessin à l'aide des constructeurs appropriés.
- Les constructeurs sont les suivants : Cercle(), CourbeBeziers(), Segment(), Point(), Polygone().
- Chaque constructeur prend différentes variables d'entrées.
- Pour plus d'informations, consulter directement la classe désirée.
- Chaque constructeur prend également comme variable d'entrée un Crayon, qui représente la couleur et l'épaisseur du tracé.
- Par exemple, pour créer un cercle de centre le point (50,50), de rayon 40 de couleur noire et d'épaisseur 2, on utilise le code suivant :
		Crayon crayon = new Crayon("black", 2);
		Cercle cercle1 = new Cercle(50, 50, 40, crayon);
- Dans le cas de figures géométriques pleines, il est possible de les remplir en utilisant la méthode remplir(color), où color est une String de la couleur choisie.
- Par exemple, pour colorier le cercle cercle1 en noir, utiliser cercle1.remplir("black");
- Une fois tous les objets graphiques créés, il faut créer un dessin, et y ajouter les objets.
- Pour créer un dessin, il faut utiliser le dessin vide (patron singleton), et ajouter le 1er élément : Dessin dessin = DessinVide.getInstance().addElmt(cercle1);
- Pour ajouter d'autres objets, utiliser à nouveau la méthode addElmt(objetAAjouter);
- Par exemple, pour ajouter un autre cercle cercle2, on utilise la commande : dessin = dessin.addElmt(cercle2);
- Une fois tous les éléments ajoutés dans l'ordre désiré, utiliser une des méthodes display() pour en afficher le contenu.
- L'affichage se fait sous deux formes : un affichage console, et une visualisation dans un navigateur web.
- Pour avoir un affichage console, utiliser la méthode displayTexte(); ( exemple : dession.displayTexte(); )
- Pour avoir un affichage graphique, utiliser la méthode displayGraphique(), en précisant la taille de la fenêtre, en pixels. ( exemple : dessin.displayGraphique(800,600); ).
- Voici un exemple de code qui affiche un dessin composé d'un cercle et d'un segment : 

	public static void main(String[] args) {
	
		Crayon c = new Crayon("black", 2);
		Cercle c1 = new Cercle(50, 50, 40, c);
		c1.remplir("red");
		Segment c2 = new Segment(10, 20, 150, 300, c);
		Dessin dessin = DessinVide.getInstance().addElmt(c1);
		dessin = dessin.addElmt(c2);
		dessin.displayGraphique(1000, 1000);
	}
	
- Le code fourni permet également de sauvegarder un dessin, en vue d'une modification ultérieure. Pour cela, utiliser la méthode save(String fileName, Dessin dessinAEnregistrer).
- Pour récupérer le dessin enregistré de cette façon, utiliser la méthode recover().
- Exemple : un Dessin dessin veut être sauvegardé, puis récupéré pour y effectuer un changement. On peut utiliser le code suivant :
	save("sauvegardeDessin.txt",dessin);
	DessinAbstrait d = recover("sauvegardeDessin.txt");
- Pour plus d'informations sur le projet, veuillez consulter le rapport de présentation du projet.