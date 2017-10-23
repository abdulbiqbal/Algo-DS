package designpattern.designpattern.bridge;

/**
 * https://www.tutorialspoint.com/design_pattern/bridge_pattern.htm
 * @author servsingh
 *
 */
public class BridgePatternDemo {
	public static void main(String[] args) {
		Shape redCircle = new Circle(100, 100, 10, new RedCircle());
		Shape greenCircle = new Circle(100, 100, 10, new GreenCircle());

		redCircle.draw();
		greenCircle.draw();
	}
}
