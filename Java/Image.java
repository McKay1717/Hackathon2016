import java.util.Locale;
import java.util.Scanner;

class Image {

	byte[][] pixels;
	int width;
	int height;

	public Image(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new byte[height][width];
	}

	public void readPixels(Scanner scan) {
		String[] line = new String[this.height];
		for (int i = 0; i < this.height; i++) {
			line[i] = scan.next();
		}
		for (int j = 0; j < line.length; j++) {
			char[] c = line[j].toCharArray();
			for (int k = 0; k < c.length; k++) {
				this.pixels[j][k] = Byte.parseByte("" + c[k]);

			}
		}

	}

	public void printBoundingBox() {

		int boxUp = Integer.MAX_VALUE, boxLeft = Integer.MAX_VALUE;
		int boxWidth = 0, boxHeight = 0;
		int maxH = 0, maxW = 0;
		for (int i = 0; i < this.height; i++) {
			for (int j = 0; j < this.width; j++) {

				if (this.pixels[i][j] != 0) {
					if (boxUp > i) {
						boxUp = i;
					}
					if (boxLeft > j) {
						boxLeft = j;
					}
					if (maxW <= j) {
						maxW = j;
					}
					if (maxH <= i) {
						maxH = i;
					}

				}
			}
		}
		// maxW = + boxWidth
		//
		boxWidth = maxW - boxLeft + 1;
		boxHeight = maxH - boxUp + 1;
		System.out.println(boxLeft + " " + boxUp + " " + boxWidth + " "
				+ boxHeight);
	}
}

class Cropping {

	public static void main(String[] args) {

		Locale.setDefault(Locale.ENGLISH);

		Scanner scan = new Scanner(System.in);
		Image I = new Image(scan.nextInt(), scan.nextInt());
		I.readPixels(scan);
		I.printBoundingBox();
	}
}
