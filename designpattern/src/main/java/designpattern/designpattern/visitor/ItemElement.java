package designpattern.designpattern.visitor;

public interface ItemElement {

	public int accept(ShoppingCartVisitor visitor);
}
