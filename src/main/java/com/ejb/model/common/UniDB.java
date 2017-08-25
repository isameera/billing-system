/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb.model.common;

import java.util.List;
import java.util.Set;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 *
 * @author Sameera
 */
@Stateless
public class UniDB implements UniDBLocal {

    @PersistenceContext(unitName = "com.exon_billing-system_war_1.0PU")
    EntityManager em;

    @Override
    public void create(Object obj) {

        try {
            em.persist(obj);
            em.flush();
        } catch (ConstraintViolationException e) {
            System.out.println("Exception Says: " + e);
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();

            Set<ConstraintViolation<Object>> constraintViolations = validator.validate(obj);

            if (constraintViolations.size() > 0) {
                System.out.println("Constraint Violations occurred..");
                for (ConstraintViolation<Object> contraints : constraintViolations) {
                    System.out.println(contraints.getRootBeanClass().getSimpleName()
                            + "." + contraints.getPropertyPath() + " " + contraints.getMessage());
                }
            }

        }

    }

    @Override
    public void update(Object obj) {

        try {
            em.merge(obj);
        } catch (ConstraintViolationException e) {
            System.out.println("Exception Says: " + e);
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();

            Set<ConstraintViolation<Object>> constraintViolations = validator.validate(obj);

            if (constraintViolations.size() > 0) {
                System.out.println("Constraint Violations occurred..");
                for (ConstraintViolation<Object> contraints : constraintViolations) {
                    System.out.println(contraints.getRootBeanClass().getSimpleName()
                            + "." + contraints.getPropertyPath() + " " + contraints.getMessage());
                }
            }
        }
    }

    @Override
    public List findAll(Class c) {
        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(c));
        return em.createQuery(cq).getResultList();
    }

    @Override
    public Object find(int id, Class c) {
        try {
            return em.find(c.newInstance().getClass(), id);
        } catch (IllegalAccessException | InstantiationException e) {
            return null;
        }
    }

    @Override
    public void remove(int id, Class c) {

        try {
            em.remove(find(id, c));
        } catch (ConstraintViolationException e) {
            System.out.println("Exception Says: " + e);
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();

            Set<ConstraintViolation<Object>> constraintViolations = validator.validate(find(id, c));

            if (constraintViolations.size() > 0) {
                System.out.println("Constraint Violations occurred..");
                for (ConstraintViolation<Object> contraints : constraintViolations) {
                    System.out.println(contraints.getRootBeanClass().getSimpleName()
                            + "." + contraints.getPropertyPath() + " " + contraints.getMessage());
                }
            }
        }
    }

    @Override
    public List searchByQuery(String query) {
        return em.createQuery(query).getResultList();
    }

    @Override
    public List searchByQuerySingle(String query) {
        return em.createQuery(query).setMaxResults(1).getResultList();
    }

    @Override
    public List searchByQueryLimit(String query, int limit) {
        return em.createQuery(query).setMaxResults(limit).getResultList();
    }
}
