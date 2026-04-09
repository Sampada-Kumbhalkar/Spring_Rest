package com.nt.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.nt.entity.TravellerEntity;
import com.nt.utility.HibernateUtil;
import jakarta.persistence.*;

@Repository
public class TravellerRepoImpl implements ITravellerRepo {

    @Override
    public int saveTraveller(TravellerEntity entity) {

        Session session = null;
        Transaction tx = null;
        int idVal = 0;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            session.persist(entity);      // ✅ using persist()

            tx.commit();

            idVal = entity.getTid();      // ✅ get ID AFTER commit

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }

        return idVal;//return id as a criteria value of saved object
    }
    //=======================================
    @Override
    public List<TravellerEntity> findAll() {

        Session session = null;
        Transaction tx = null;
        List<TravellerEntity> list = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            // HQL Query
       list = session.createQuery("FROM TravellerEntity", TravellerEntity.class).list();

            tx.commit();
        } catch (Exception e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            if (session != null)
                session.close();
        }

        return list;
    }
    //==================================
    @Override
    public TravellerEntity getTravellerById(int id) {

        Session session = null;
        TravellerEntity entity = null;
        Transaction tx = null;

        try {
        	session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            entity = session.get(TravellerEntity.class, id);

        } catch (Exception e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            if (session != null)
                session.close();
        }

        return entity;
    }
//=====================================

    public int updateHeadingToByLocation(String loc, String dest) {

        Session session = null;
        Transaction tx = null;
        int count = 0;

        try {
        	session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            count = session.createQuery(
                    "UPDATE TravellerEntity SET headingTo = :dest WHERE currentLocation = :loc")
                    .setParameter("dest", dest)
                    .setParameter("loc", loc)
                    .executeUpdate();

            tx.commit();

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            if (session != null)
                session.close();
        }

        return count;
    }
    //=======================================
    @Override
    public void updateTravellerData(TravellerEntity entity) {

        Session session = null;
        Transaction tx = null;

        try {
        	session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            session.update(entity);

            tx.commit();

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null)
                session.close();
        }
    }
    //=================================================
	
	 @Override
	    public void deleteTravellerId(int id) {
	        Session session = null;
	        Transaction tx = null;

	        try {
	        	session = HibernateUtil.getSessionFactory().openSession();
	            tx = session.beginTransaction();
	                TravellerEntity entity = session.get(TravellerEntity.class, id);

	                if (entity != null) {
	                    session.delete(entity);
	                }

	                tx.commit();
	            }
	         catch (Exception e) {
	            if (tx != null) {
	                tx.rollback();
	            }
	            e.printStackTrace();
	        }
	    }
	}
	

