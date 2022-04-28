package clock;

import java.time.LocalTime;

public class FractionClock {

	private static LocalTime time;
	
	
	public static int[] getHour() {
		time = LocalTime.now();
		return new int[] {CalculateHours(time.getHour())[0],CalculateHours(time.getHour())[1]};
	}
	
	public static int[] getMinute() {
		time = LocalTime.now();
		return new int[] {CalculateMinutes(time.getMinute())[0],CalculateMinutes(time.getMinute())[1]};
	}

	private static int[] CalculateMinutes(int numerator) {
		if(numerator != 0) {
		if(60 % numerator == 0) {
			return new int[] {1,60/numerator};
		}
		if(numerator <= 10) {
		for(int i = 2; i < numerator-1; i++) {
			if(numerator % i == 0) {
				return new int[] {numerator/i, 60/i};
			}
		}
		} else {
		for(int i = numerator-1; i > 2; i--) {
			if(numerator % i == 0 && 60 % i == 0) {
				return new int[] {numerator/i, 60/i};
				}
			}
			
		}
		
		return new int[] {numerator, 60};

		
	}
		return new int[] {numerator, 60};
	}
	private static int[] CalculateHours(int numerator) {
		if(24 % numerator == 0) {
			return new int[] {1,24/numerator};
		}
		if(numerator <= 10) {
		for(int i = 2; i < numerator-1; i++) {
			if(numerator % i == 0) {
				return new int[] {numerator/i, 24/i};
			}
		}
		} else {
		for(int i = numerator-1; i > 2; i--) {
			if(numerator % i == 0 && 24 % i == 0) {
				return new int[] {numerator/i, 24/i};
				}
			}
			
		}
		
		return new int[] {numerator, 24};
	}
}
