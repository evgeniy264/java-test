public class Animal {
    static int countAnimal=0;
    public Animal(){
        countAnimal++;
    }

    public void run(int distance){
        System.out.println("животное пробежало"+distance+" м");
    }
    public void swim(int distance){
        System.out.println("животное проплыло"+distance+" м");
    }
    public static int getCountAnimal(){
        return countAnimal;
    }
}

class Dog extends Animal {
    String name;
    static int countDog=0;
    public Dog(String name){
        super();
        countDog++;
        this.name=name;
    }
    @Override
    public void run(int distance){
        if (distance>500){
            System.out.println("Собака не может бегать более 500 м");
        }
        System.out.println(name+" пробежал "+distance+" м");
    }

    @Override
    public void swim(int distance) {
        if (distance>10){
            System.out.println("Собака не может плавать более 10 м");
        }
        System.out.println(name+" проплыл "+distance+" м");
    }
    public static int getCountDog (){
        return countDog;
    }
}

class Cat extends Animal{
    private Boolean fullness;
    private String name;
    private int appetite;
    static int countCat = 0;

    public Cat (String name, int appetite){
        super();
        countCat++;
        this.name = name;
        this.fullness=false;
        this.appetite=appetite;
    }

    public Cat (String name){
        super();
        countCat++;
        this.name = name;
        this.fullness=false;
    }


    @Override
    public void run(int distance) {
        if (distance > 200) {
            System.out.println("Кот не может пробежать более 200 м");
        }
        System.out.println(name + " пробежал " + distance + " м");
    }

    public void eat(Dish dish){
        if(!fullness && dish.decreaseEat(appetite)){
            fullness=true;
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println("Кот не умеет плавать");
    }

    static int getCountCat(){
        return countCat;
    }

    public void info() {
        String isHungry = !fullness ? "голоден" : "сыт";
        System.out.println(name + ": " + isHungry);
    }

}

class Dish {
    private int quantityEat;

    public Dish (int quantityEat){
        if (quantityEat>=0){
            this.quantityEat = quantityEat;
        }else{
            this.quantityEat = 0;
        }
    }
    public void addEat(int quantityEat) {
        this.quantityEat=this.quantityEat+quantityEat;
    }

    public boolean decreaseEat(int quantityEat){
        int diff=this.quantityEat-quantityEat;
        if(diff<0){
            return false;
        }
        this.quantityEat-=quantityEat;
        return true;
    }

}

