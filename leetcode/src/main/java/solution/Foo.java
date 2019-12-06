package solution;

/**
 * 1114-按序打印
 */
class Foo {
    private volatile int index = 1;
    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        while (index != 1){
        }
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        index++;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (index != 2){
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        index++;

    }

    public void third(Runnable printThird) throws InterruptedException {
        while (index != 3){
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
