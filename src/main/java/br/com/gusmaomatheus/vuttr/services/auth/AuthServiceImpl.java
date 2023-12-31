package br.com.gusmaomatheus.vuttr.services.auth;

import br.com.gusmaomatheus.vuttr.config.security.SecurityConfig;
import br.com.gusmaomatheus.vuttr.dtos.auth.register.UserRegisterRequest;
import br.com.gusmaomatheus.vuttr.exceptions.customs.auth.UsernameAlreadyExistsException;
import br.com.gusmaomatheus.vuttr.models.User;
import br.com.gusmaomatheus.vuttr.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private SecurityConfig securityConfig;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.repository.findByUsername(username);
    }

    public void register(UserRegisterRequest request) {
        if (repository.existsByUsername(request.username())) {
            throw new UsernameAlreadyExistsException(String.format("A record with username '%s' already exists", request.username()));
        }

        String encryptedPassword = securityConfig.passwordEncoder().encode(request.password());
        User user = new User(request.username(), encryptedPassword, request.role());

        repository.save(user);
    }
}
