package code.patterns.design.structural.proxy;

/**
 * is a structural design pattern that lets you provide a substitute or placeholder for another object. A proxy
 * controls access to the original object, allowing you to perform something either before or after the request gets
 * through to the original object.
 *
 * client <-> proxy <-> server
 *
 * pros:
 * - You can control the service object without clients knowing about it.
 * - You can manage the lifecycle of the service object when clients don’t care about it.
 * - The proxy works even if the service object isn’t ready or is not available.
 * - Open/Closed Principle. You can introduce new proxies without changing the service or clients.
 *
 * cons:
 * - code may become more complicated since u need to introduce new classes.
 * - slight delay in response from client to proxy and finally to server.
 */
public class ProxyPattern {
    public static void main(String[] args) {
        Image image = new ProxyImage("test_10mb.jpg");

        image.display();
        System.out.println("");

        image.display();

    }
}
