package ferreira.filipe.pontointeligente.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import ferreira.filipe.pontointeligente.api.entities.*;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

	

	@Transactional(readOnly = true)
	Empresa findByCnpj(String cnpj);



}