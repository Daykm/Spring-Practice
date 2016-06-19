package com.daykm.config;


import com.daykm.data.UserRepository;
import com.daykm.data.WeaponRepository;
import com.daykm.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import javax.transaction.Transactional;
import java.util.*;


@Configuration
@ComponentScan("com.daykm.data")
@EnableTransactionManagement
public class DBConfig {

    @Autowired
    UserRepository repo;

    @Autowired
    WeaponRepository repo1;

    @Bean
    @Profile("dev")
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("data/schema.sql")
                .build();
    }

    @Bean
    @Autowired
    @Profile("dev")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(
            DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource);
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setPackagesToScan("com.daykm.domain");
        Properties prop = new Properties();
        prop.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        prop.put("hibernate.show_sql", "true");
        prop.put("hibernate.format_sql", "true");
        entityManagerFactoryBean.setJpaProperties(prop);
        return entityManagerFactoryBean;
    }


    @Bean
    @Autowired
    public JpaTransactionManager manager(EntityManagerFactory emf) {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(emf);
        return txManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor thisThing() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    @Bean
    public JdbcOperations jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @PostConstruct
    @Autowired
    @Profile("dev")
    public void initializeTestData() {
        for (SiteUser user : getTestUsers(10)) {
            repo.save(user);
        }

        for (Weapon weapon : weaponList(10)) {
            repo1.saveWeapon(weapon);
        }
    }

    private List<Weapon> weaponList(int count) {
        List<Weapon> weapons = new ArrayList<>(count);
        for(int i = 0; i < count; i++) {
            Weapon weapon = new Weapon();
            weapon.setName("Test weapon " + i);
            WeaponAttributes attributes = new WeaponAttributes();
            attributes.setDamage(1 + i);
            attributes.setMagicDamage(1 + i);
            attributes.setWeight(1 + i);
            WeaponUpgradeReqs req = new WeaponUpgradeReqs();
            req.setQuantity(1 + i);
            Material material = new Material();
            material.setName("Test Material " + i);
            req.setMaterial(material);
            Set<WeaponUpgradeReqs> reqs = new HashSet<>(1);
            reqs.add(req);
            attributes.setReqs(reqs);
            Set<WeaponAttributes> attributesSet = new HashSet<>(1);
            attributesSet.add(attributes);
            weapon.setAttr(attributesSet);
            weapons.add(weapon);
        }
        return weapons;
    }

    private List<SiteUser> getTestUsers(int count) {
        ArrayList<SiteUser> users = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            users.add(new SiteUser(
                    "kody" + i,
                    "day" + i,
                    "password" + i,
                    "daykm" + i + "@gmail.com"));
        }
        return users;
    }
}
