package array;

public class TestMyArray {
    public static void main(String[] args) {
        MyArray array = new MyArray(5);
        array.showArray();

        array.insertElement(15);
        array.showArray();

        array.insertElement(21,2);
        array.showArray();

        array.delElement(3);
        array.showArray();
    }
}
