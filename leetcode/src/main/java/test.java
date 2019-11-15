import com.nb.annotation.Singleton;

@Singleton
public class test {
    public static void main(String[] args) {
        new test().test();
    }
    public void test() {
        System.out.println("hello");
    }
}
