package com.lpu.example;

public class CarEngineMain {

    public static void main(String[] args) {

        CRUDEngineCarImp crud = new CRUDEngineCarImp();

        Engine engine = new Engine();
        engine.setId(101L);
        engine.setCc(1500.0f);

        Car car = new Car();
        car.setId(1L);
        car.setBrand("Toyota");
        car.setEngine(engine);

        crud.saveCar(car);

        crud.findCar(1L);

        crud.updateEngineCC(1L, 2000f);
        crud.updateCarBrand(1L, "Honda");

        crud.findAll();

//        crud.deleteCar(1L);

        crud.close();
    }
}

