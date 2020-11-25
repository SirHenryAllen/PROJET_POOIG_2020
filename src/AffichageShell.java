public class AffichageShell {

	public static void afficherFormatPlateau(Plateau p) {
		char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		System.out.println("\n########################\n########################\n");
		System.out.print("     |  ");
		for (int i = 0 ; i<p.getPlateau().length ; i++) {
			System.out.print(alphabet[i] + "  ");
		}
		System.out.println("");
		for (int j = 0 ; j<p.getPlateau().length ; j++) {
			System.out.print("  " + j + "  |  ");
			for (int k = 0 ; k<p.getPlateau().length ; k++) {
				if (p.getBlock(j, k) == null) {
					System.out.print(".  ");
				}
				if (p.getBlock(j, k) instanceof BlockFixe) {
					System.out.print("#  ");
				}
				if (p.getBlock(j, k) instanceof BlockDestructible) {
					if(((BlockDestructible)p.getBlock(j, k)).couleur == 'a') {
						System.out.print("a  ");
					}
					if(((BlockDestructible)p.getBlock(j, k)).couleur == 'b') {
						System.out.print("b  ");
					}
					if(((BlockDestructible)p.getBlock(j, k)).couleur == 'c') {
						System.out.print("c  ");
					}
					if(((BlockDestructible)p.getBlock(j, k)).couleur == 'd') {
						System.out.print("d  ");
					}
				}
				if (p.getBlock(j, k) instanceof BlockDestructibleSi) {
					System.out.print("-  ");
				}
			}
			System.out.println("");	
		}
	}
}