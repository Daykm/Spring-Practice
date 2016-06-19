package com.daykm.data;

import com.daykm.domain.Weapon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;


@Repository
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
@Transactional
public class WeaponRepoImpl implements WeaponRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<Weapon> getWeapons() {
        return em.createQuery("SELECT w FROM Weapon w").getResultList();
    }

    @Override
    public Weapon saveWeapon(Weapon weapon) {
        em.persist(weapon);
        return weapon;
    }


}
