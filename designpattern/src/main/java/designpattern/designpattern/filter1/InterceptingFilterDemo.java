package designpattern.designpattern.filter1;

/**
 * https://www.tutorialspoint.com/design_pattern/intercepting_filter_pattern.htm
 * @author servsingh
 *
 */
public class InterceptingFilterDemo {
	public static void main(String[] args) {
		FilterManager filterManager = new FilterManager(new Target());
		filterManager.setFilter(new AuthenticationFilter());
		filterManager.setFilter(new DebugFilter());

		Client client = new Client();
		client.setFilterManager(filterManager);
		client.sendRequest("HOME");
	}
}
