package com.uptc.proveedores.persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PersistenceUtil {
    private static EntityManagerFactory MY_ENTITY_MANAGER_FACTORY;
    public static EntityManager getEntityManager(){
        if(MY_ENTITY_MANAGER_FACTORY==null){
            MY_ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("MAPPED_PROVENDERED");
        }
        return MY_ENTITY_MANAGER_FACTORY.createEntityManager();
    }

    /*public static EntityManager getEntityManager() {
    }*/








    /*private static final EntityManagerFactory ENTITY_MANAGER_FACTORIY;
    static {
        ENTITY_MANAGER_FACTORIY = Persistence.createEntityManagerFactory("MAPEO_PROVEEDORES");

    }
    public static EntityManager getEntityManager(){
        return ENTITY_MANAGER_FACTORIY.createEntityManager();
    }*/
}
