package step4_racingCarWithWinner;

public class Car {

    private String name;
    private final StringBuilder distance = new StringBuilder();

    public Car(String name){
        this.name = name;
        nameCheck(name);
    }

    private void nameCheck(String name) {
        if(name.length() > 5){
            throw new IllegalArgumentException("자동차 이름의 길이는 5자를 넘을 수 없습니다.");
        }
    }

    public String carName(){
        return this.name;
    }
    public String carDistance() {
        return this.distance.toString();
    }
    @Override
    public String toString(){
        return this.name + " : " + this.distance;
    }

    public void printStatus(){
        System.out.println(this);
    }

    public void forward() {
        this.distance.append("-");
    }
}