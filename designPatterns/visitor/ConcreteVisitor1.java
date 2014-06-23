package designPatterns.visitor;

import java.util.logging.Logger;

public class ConcreteVisitor1 implements VisitorInterface {
	private static final Logger log = Logger.getLogger(ConcreteVisitor1.class.getName());
	@Override
    public void visit(ConcreteElementA element) {
		log.info("1 visits A");
    }

	@Override
    public void visit(ConcreteElementB element) {
        log.info("1 visits B");
    }
}
