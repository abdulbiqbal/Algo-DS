package designpattern.designpattern.decorator;

/**
 * http://www.journaldev.com/1540/decorator-design-pattern-in-java-example
 * 
 * @author servsingh
 *
 */
public class DecoratorPatternTest {

	public static void main(String[] args) {
		Car sportsCar = new SportsCar(new BasicCar());
		sportsCar.assemble();
		System.out.println("\n*****");
		
		Car sportsLuxuryCar = new SportsCar(new LuxuryCar(new BasicCar()));
		sportsLuxuryCar.assemble();
	}

}
