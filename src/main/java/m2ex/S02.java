package m2ex;

public class S02 {
	/**
	 * Average speed
	 * 
	 * @param distance in meters
	 * @param time     in seconds
	 * @return speed in meters per second
	 */
	public static double speed(double distance, double time) {
		return distance / time;
	}

	/**
	 * Distance between (x0, y0) and (x1, y1)
	 * 
	 * @param x0 first point x
	 * @param y0 first point y
	 * @param x1 second point x
	 * @param y1 second point y
	 * @return distance
	 */
	public static double distance(int x0, int y0, int x1, int y1) {
		Punto p1 = new Punto(x0, y0);
		Punto p2 = new Punto(x1, y1);
		return Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2));
	}

	/**
	 * Engine capacity
	 * 
	 * @param bore   in mm
	 * @param stroke in mm
	 * @param nr     number of cylinders
	 * @return the engine capacity in cm^3
	 */
	public static double engineCapacity(double bore, double stroke, int nr) {
		return (Math.pow(bore / 2, 2) * Math.PI * stroke * nr) / 1000;
	}

	/**
	 * Add up all the digits in an integer
	 * 
	 * @param value
	 * @return sum of digits
	 */
	public static int digitSum(int value) {
		if(value < 0) {
			value = value * -1;
		}
		StringBuilder numericString = new StringBuilder().append(value);
		char[] arrayNumberChar = numericString.toString().toCharArray();
		int somma = 0;
		if (arrayNumberChar.length >= 2) {
			for (int i = 0; i < arrayNumberChar.length; i++) {
				int number = Character.getNumericValue(arrayNumberChar[i]);
				somma += number;
			}
			return somma;
		}
		return value;
	}

	/**
	 * Score based on distance from (0, 0) [1, 5, 10] -> [10, 5, 1, 0]
	 *
	 * @param x
	 * @param y
	 *
	 * @return
	 */
	public static int score(double x, double y) {
		double distance = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
		if(distance > 0 && distance <= 1) {
			return 10;
		} else if(distance > 1 && distance <= 5) {
			return 5;
		} else if(distance > 5 && distance <= 10) {
			return 1;
		} else 
			return 0;
	}
}
