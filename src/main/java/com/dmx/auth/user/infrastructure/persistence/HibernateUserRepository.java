package com.dmx.auth.user.infrastructure.persistence;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.dmx.auth.credentials.domain.CredentialEmail;
import com.dmx.auth.user.domain.User;
import com.dmx.auth.user.domain.UserRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class HibernateUserRepository implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<User> find(CredentialEmail email) {
        try {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<UserEntity> query = cb.createQuery(UserEntity.class);
            Root<UserEntity> root = query.from(UserEntity.class);

            query.select(root).where(cb.equal(root.get("email"), email.value()));
            UserEntity userPersistence = entityManager.createQuery(query).getSingleResult();

            User user = userPersistence.toDomain();
            System.out.println(user.toPrimitives().toString());

            return Optional.of(user);
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    @Override
    public void save(User user) {
        this.entityManager.persist(UserEntity.fromDomain(user));
    }
}
