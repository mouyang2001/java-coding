package code.patterns.design.structural.proxy;

/**
 * is a structural design pattern that lets you provide a substitute or placeholder for another object. A proxy
 * controls access to the original object, allowing you to perform something either before or after the request gets
 * through to the original object.
 */
public class ProxyPattern {
    public static void main(String[] args) {
        Image image = new ProxyImage("test_10mb.jpg");

        //image will be loaded from disk
        image.display();
        System.out.println("");

        //image will not be loaded from disk
        image.display();
    }
}
