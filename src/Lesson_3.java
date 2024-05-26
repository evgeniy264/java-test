

public class Lesson_3 {
    public static void main(String[] args) {
        Person[] persArray = new Person[5];
        persArray[0] = new Person("Ivanov Ivan", "Engineer",
                "ivivan@mailbox.com", "892312312", 30000, 30);
        persArray[1] = new Person("Semenov Petr", "Leading Engineer",
                "sempetr@mailbox.com", "892312313", 35000, 35);
        persArray[2] = new Person("Tatarinov Alexander", "Programmer",
                "tat@mailbox.com", "892412313", 37000, 32);
        persArray[3] = new Person("Klimov Dmitriy", "Administrator",
                "kdim@mailbox.com", "892512315", 33000, 37);
        persArray[4] = new Person("Bogatikov Oleg", "Engineer",
                "olegb@mailbox.com", "892812318", 38000, 38);
        for (int i = 0; i < persArray.length; i++) {
            persArray[i].print();
        }

        Park park = new Park("Виражи", "Москва", new Park.Attractions("Гоночные машины", "c 10.00 до 17.00", 300.00));
        park.print();

    }

    public static class Person {
        private String full_name;
        private String position;
        private String email;
        private String phone;
        private int salary;
        private int age;

        public Person(String full_name, String position, String email, String phone, int salary, int age) {
            this.full_name = full_name;
            this.position = position;
            this.email = email;
            this.phone = phone;
            this.salary = salary;
            this.age = age;
        }

        public void print() {
            System.out.println("Данные сотрудника:\nФИО: " + this.full_name + "\nДолжность: " + this.position + "\nEmail: " + this.email + "\nТелефон: " + this.phone + "\nЗарплата: " + this.salary + "\nВозраст: " + this.age);
        }
    }

    public static class Park {
        private String name;
        private String location;
        private Attractions attraction;


        public Park(String name, String location, Attractions attraction) {
            this.name = name;
            this.location = location;
            this.attraction = attraction;
        }

        public static class Attractions {
            private String description;
            private String workTime;
            private double cost;

            public Attractions(String description, String workTime, double cost) {
                this.description = description;
                this.workTime = workTime;
                this.cost = cost;
            }
        }

        public void print() {
            System.out.println("Данные о парке аттракционов:\nНазвание: " + this.name + "\nРасположение: " + this.location + "\nОписание аттракционов: " + attraction.description + "\nВремя работы: " + attraction.workTime + "\nСтоимость " + attraction.cost);
        }
    }

}
