package br.com.senac.api.repositorio;

import br.com.senac.api.entidades.Enderecos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EnderecosRepository extends JpaRepository<Enderecos, Long> {

    @Query("select c from enderecos c where rua like %:rua%")
    public List<Enderecos> findByEndereco(@Param("rua") String rua);
}
