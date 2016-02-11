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

		int boxUp = 0, boxLeft = 0;
		int boxWidth = 0, boxHeight = 0;
		for (int i = 0; i < this.height; i++) {
			for (int j = 0; j < this.width; j++) {
				if (this.pixels[i][j] != 0) {
					if (boxUp == 0) {
						boxUp = i;
						boxLeft = j - 1;
					}
					if (boxWidth < j) {
						boxWidth = j - 1;
					}
					if (boxHeight < i - 1) {
						boxHeight = i;
					}

				}
			}
		}
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
