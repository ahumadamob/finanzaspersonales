package com.ahumada.finanzaspersonales.usuario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.lang.Long;
import java.lang.String;
import java.util.List;
import java.util.Optional;
import org.springframework.aot.generate.Generated;
import org.springframework.data.jpa.repository.aot.AotRepositoryFragmentSupport;
import org.springframework.data.jpa.repository.query.QueryEnhancerSelector;
import org.springframework.data.repository.core.support.RepositoryFactoryBeanSupport;

/**
 * AOT generated JPA repository implementation for {@link UsuarioRepository}.
 */
@Generated
public class UsuarioRepositoryImpl__AotRepository extends AotRepositoryFragmentSupport {
  private final RepositoryFactoryBeanSupport.FragmentCreationContext context;

  private final EntityManager entityManager;

  public UsuarioRepositoryImpl__AotRepository(EntityManager entityManager,
      RepositoryFactoryBeanSupport.FragmentCreationContext context) {
    super(QueryEnhancerSelector.DEFAULT_SELECTOR, context);
    this.entityManager = entityManager;
    this.context = context;
  }

  /**
   * AOT generated implementation of {@link UsuarioRepository#findAllByRetiradoFalseOrderByIdAsc()}.
   */
  public List<Usuario> findAllByRetiradoFalseOrderByIdAsc() {
    String queryString = "SELECT u FROM Usuario u WHERE u.retirado = FALSE ORDER BY u.id asc";
    Query query = this.entityManager.createQuery(queryString);

    return (List<Usuario>) query.getResultList();
  }

  /**
   * AOT generated implementation of {@link UsuarioRepository#findByIdAndRetiradoFalse(java.lang.Long)}.
   */
  public Optional<Usuario> findByIdAndRetiradoFalse(Long id) {
    String queryString = "SELECT u FROM Usuario u WHERE u.id = :id AND u.retirado = FALSE";
    Query query = this.entityManager.createQuery(queryString);
    query.setParameter("id", id);

    return Optional.ofNullable((Usuario) convertOne(query.getSingleResultOrNull(), false, Usuario.class));
  }
}
