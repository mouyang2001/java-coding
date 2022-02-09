package code.patterns.design.creational.factory;

/**
 * is a creational design pattern that provides an interface for creating objects in a superclass, but allows
 * subclasses to alter the type of objects that will be created.
 *
 * Pros:
 * You avoid tight coupling between the creator and the concrete products.
 * SRP. You can move the product creation code into one place in the program, making the code easier to support.
 *  Open/Closed Principle. You can introduce new concrete products into the program without breaking existing client code.
 *
 *  Cons:
 *  Complicates code, since you need to introduce a lot of subclasses. It's recommended to only be applied
 *  to code that already has a hierarchy of classes.
 */
public abstract class Dialog {

    public void renderWindow() {
        // ... other code ...

        Button okButton = createButton();
        okButton.render();
    }

    /**
     * Subclasses will override this method in order to create specific button
     * objects.
     */
    public abstract Button createButton();
}
