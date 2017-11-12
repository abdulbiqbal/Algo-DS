package designpattern.designpattern.visitor;

/**
 * http://www.journaldev.com/1769/visitor-design-pattern-java
 * The benefit of this pattern is that if the logic of operation changes, 
 * then we need to make change only in the visitor implementation rather than doing it in all the item classes.

	Another benefit is that adding a new item to the system is easy, 
	it will require change only in visitor interface and implementation and existing item classes will not be affected.
 * @author servsingh
 *
 */
public interface ShoppingCartVisitor {

	int visit(Book book);
	int visit(Fruit fruit);
}
