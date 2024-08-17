package _06_DefiningClasses.Exercise.RawData;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tire tire;

    public Car(String model, Engine engine, Cargo cargo, Tire tire) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tire = tire;
    }

    public void extract(String command){
        if(command.equals("flamable")){
            if(engine.getPower() > 250){
                System.out.println(model);
            }
        }else{
            if(tire.isPressureUnderOne()){
                System.out.println(model);
            }
        }
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public Tire getTire() {
        return tire;
    }

    public Cargo getCargo() {
        return cargo;
    }
}