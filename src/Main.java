public class Main {
    public static void main(String[] args) {
        //1-я задача
        Animal animal = new Animal();
        Animal animal1 = new Animal();
        Animal animal2 = new Animal();

        Cat boris = new Cat("Борис");
        Dog toshka = new Dog("Тошка");
        Cat vasya = new Cat("Василий");
        Dog tuzik = new Dog("Тузик");
        boris.run(150);
        vasya.run(201);

        toshka.run(500);
        tuzik.run(501);
        System.out.println("Общее количество животных: " + Animal.getCountAnimal());
        System.out.println("Количество котов: " + Cat.getCountCat());
        System.out.println("Количество собак: " + Dog.getCountDog());

        Cat[] cats = {new Cat("Барсик", 50), new Cat("Рыжик", 40), new Cat("Тишка", 60)};
        Dish dish = new Dish(100);
        for (Cat cat : cats) {
            cat.eat(dish);
            cat.info();
        }

        System.out.println("Задача №2:");
        //2 -я задача
        Figure circle = new Circle(10);
        circle.setFillColor("Красный");
        circle.setBorderColor("Черный");
        circle.getArea();
        circle.getPerimeter();
        System.out.println(circle.toString());


        Figure rectangle = new Rectangle(10, 5);
        rectangle.setFillColor("Зеленый");
        rectangle.setBorderColor("Красный");
        rectangle.getArea();
        rectangle.getPerimeter();
        System.out.println(rectangle.toString());

        Figure triangle = new Triangle(13, 4, 5);
        triangle.setFillColor("Синий");
        triangle.setBorderColor("Зеленый");
        triangle.getArea();
        triangle.getPerimeter();
        System.out.println(triangle.toString());
    }

    interface Figure {
        default void setFillColor(String color) {
            System.out.println("Установлен цвет заливки⁚ " + color);
        }

        default void setBorderColor(String color) {
            System.out.println("Установлен цвет границы⁚ " + color);

        }

        default double getPerimeter() {
            return 0;
        }

        default double getArea() {
            return 0;
        }

    }

    public static class Circle implements Figure {
        private double radius;
        private final String name = "Круг";

        public Circle(double radius) {
            this.radius = radius;
        }

        @Override
        public double getPerimeter() {
            return 2 * Math.PI * radius;
        }

        @Override
        public double getArea() {
            return Math.PI * radius * radius;
        }

        @Override
        public String toString() {
            String info = name;
            info += " периметр:" + getPerimeter();
            info += " площадь:" + getArea();
            info += "\n";
            return info;
        }


    }

    public static class Rectangle implements Figure {
        private double a;
        private double b;
        private final String name = "Прямоугольник";

        public Rectangle(double a, double b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public double getPerimeter() {
            return 2 * (a + b);
        }

        @Override
        public double getArea() {
            return a * b;
        }

        @Override
        public String toString() {
            String info = name;
            info += " периметр:" + getPerimeter();
            info += " площадь:" + getArea();
            info += "\n";
            return info;
        }
    }

    public static class Triangle implements Figure {
        private double a;
        private double b;
        private double c;
        private final String name = "Треугольник";

        public Triangle(double a, double b, double c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public double getPerimeter() {
            return a + b + c;
        }

        @Override
        public double getArea() {
            double p = getPerimeter() / 2;
            return Math.sqrt(p * (p - a) * (p - b) * (p - c));
        }

        @Override
        public String toString() {
            String info = name;
            info += " периметр:" + getPerimeter();
            info += " площадь:" + getArea();
            info += "\n";
            return info;
        }
    }
}
