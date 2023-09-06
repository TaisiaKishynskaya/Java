public class MyClass {
    private int myField1;
    private final String myField2;

    // Конструктор класса
    public MyClass(int field1, String field2) {
        this.myField1 = field1;
        this.myField2 = field2;
    }

    // Методы класса
    public void printFields() {
        System.out.println("myField1: " + myField1);
        System.out.println("myField2: " + myField2);
    }

    public int getMyField1() {
        return myField1;
    }

    public void setMyField1(int myField1) {
        this.myField1 = myField1;
    }


    public static void main(String[] args) {
        // Создаем объект класса MyClass
        MyClass myObject = new MyClass(42, "Hello, Java!");

        // Вызываем метод для вывода полей объекта
        myObject.printFields();

        // Изменяем значение поля myField1
        myObject.setMyField1(55);

        // Выводим обновленное значение поля myField1
        System.out.println("Updated myField1: " + myObject.getMyField1());
    }
}