package com.daykm.data;

import com.daykm.domain.Weapon;

import javax.transaction.Transactional;
import java.util.List;

public interface WeaponRepository {

    List<Weapon> getWeapons();

    Weapon saveWeapon(Weapon weapon);
}
