package ferreira.filipe.pontointeligente.api.security.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ferreira.filipe.pontointeligente.api.entities.Funcionario;
import ferreira.filipe.pontointeligente.api.security.JwtUserFactory;
import ferreira.filipe.pontointeligente.api.services.FuncionarioService;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {



	@Autowired
	private FuncionarioService funcionarioService;


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Funcionario> funcionario = funcionarioService.buscarPorEmail(username);
		
		if (funcionario.isPresent()) {
			return JwtUserFactory.create(funcionario.get());
		}

		throw new UsernameNotFoundException("Email não encontrado.");
	}



}