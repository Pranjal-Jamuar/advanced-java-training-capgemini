package com.lpu.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class CRUDEngineCarImp {

    private EntityManagerFactory emf;
    private EntityManager em;

    public CRUDEngineCarImp() {
        emf = Persistence.createEntityManagerFactory("dev");
        em = emf.createEntityManager();
    }

    public void saveCar(Car car) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(car);
        et.commit();
    }

    public void updateEngineCC(long carId, float cc) {
        Car car = em.find(Car.class, carId);

        if (car != null && car.getEngine() != null) {
            EntityTransaction et = em.getTransaction();
            et.begin();
            car.getEngine().setCc(cc);
            et.commit();
        } else {
            System.out.println("Car or Engine not found.");
        }
    }

    public void updateCarBrand(long carId, String brand) {
        Car car = em.find(Car.class, carId);

        if (car != null) {
            EntityTransaction et = em.getTransaction();
            et.begin();
            car.setBrand(brand);
            et.commit();
        } else {
            System.out.println("Car not found.");
        }
    }

    public void deleteCar(long carId) {
        Car car = em.find(Car.class, carId);

        if (car != null) {
            EntityTransaction et = em.getTransaction();
            et.begin();
            em.remove(car);   // Engine auto-deletes because of cascade
            et.commit();
        } else {
            System.out.println("Car not found.");
        }
    }

    public void findCar(long carId) {
        Car car = em.find(Car.class, carId);

        if (car != null) {
            System.out.println("Car ID: " + car.getId());
            System.out.println("Brand: " + car.getBrand());
            if (car.getEngine() != null) {
                System.out.println("Engine CC: " + car.getEngine().getCc());
            }
        } else {
            System.out.println("Car not found.");
        }
    }

    public void findAll() {
    	List<Car> cars = em
    	        .createQuery("SELECT c FROM Car c", Car.class)
    	        .getResultList();


        for (Car car : cars) {
            System.out.println("Car ID: " + car.getId());
            System.out.println("Brand: " + car.getBrand());
            if (car.getEngine() != null) {
                System.out.println("Engine CC: " + car.getEngine().getCc());
            }
            System.out.println("------------------------");
        }
    }

    public void close() {
        if (em != null) em.close();
        if (emf != null) emf.close();
    }
}

