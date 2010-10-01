package sample.java.project;

import junit.framework.TestCase;

public class SampleJavaProjectTest extends TestCase {
    public SampleJavaProjectTest(String name) {
        super(name);
    }

    SampleJavaProject sjp;

    public void setUp() {
        sjp = new SampleJavaProject();
    }

    public void testAdd() {
        assert(sjp.add(3, 4) == 7);
    }
}
