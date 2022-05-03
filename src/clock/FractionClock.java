package clock;

import java.time.LocalTime;
import java.util.Random;

public class FractionClock {
	
	private static LocalTime time;
	private static int old_minute;
	private static int old_hour;
	private static int min_rand;
	private static int hour_rand;
	Random random;
	
	public  int[] getRandomized(int complexity_min, int complexity_max) {
		Random random = new Random();
		time = LocalTime.now();
		
		if(time.getMinute() != old_minute) {
			min_rand = random.nextInt(complexity_max);
			while(min_rand <= complexity_min) min_rand = random.nextInt(complexity_max);
		}
		
		if(time.getHour() != old_hour) {
			hour_rand = random.nextInt(complexity_max);
			while(hour_rand <= complexity_min) hour_rand = random.nextInt(complexity_max);
		}
		
		old_hour = time.getHour();
		old_minute = time.getMinute();

		return new int[] {CalculateHours(time.getHour())[0] * hour_rand, CalculateHours(time.getHour())[1] * hour_rand, CalculateMinutes(time.getMinute())[0] * min_rand,CalculateMinutes(time.getMinute())[1] * min_rand};		
	}
	
	public  int[] getHour() {
		time = LocalTime.now();
		return new int[] {CalculateHours(time.getHour())[0],CalculateHours(time.getHour())[1]};
	}
	public  int[] getMinute() {
		time = LocalTime.now();
		return new int[] {CalculateMinutes(time.getMinute())[0],CalculateMinutes(time.getMinute())[1]};
	}

	private  int[] CalculateMinutes(int numerator) {
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
	private  int[] CalculateHours(int numerator) {
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
