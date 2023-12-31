package br.com.gusmaomatheus.vuttr.services.auth;

import br.com.gusmaomatheus.vuttr.config.security.SecurityConfig;
import br.com.gusmaomatheus.vuttr.dtos.auth.login.UserLoginRequest;
import br.com.gusmaomatheus.vuttr.dtos.auth.register.UserRegisterRequest;
import br.com.gusmaomatheus.vuttr.exceptions.customs.auth.InvalidPasswordException;
import br.com.gusmaomatheus.vuttr.exceptions.customs.auth.UserUsernameNotFoundException;
import br.com.gusmaomatheus.vuttr.exceptions.customs.auth.UsernameAlreadyExistsException;
import br.com.gusmaomatheus.vuttr.models.User;
import br.com.gusmaomatheus.vuttr.repositories.UserRepository;
import br.com.gusmaomatheus.vuttr.services.auth.token.AuthTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private SecurityConfig securityConfig;
    @Autowired
    private AuthTokenService authTokenService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.repository.findByUsername(username);
    }

    @Override
    public void register(UserRegisterRequest request) {
        if (repository.existsByUsername(request.username())) {
            throw new UsernameAlreadyExistsException(String.format("A record with username '%s' already exists", request.username()));
        }

        String encryptedPassword = securityConfig.passwordEncoder().encode(request.password());
        User user = new User(request.username(), encryptedPassword, request.role());

        repository.save(user);
    }

    @Override
    public String login(UserLoginRequest request) throws Exception {
        if (!repository.existsByUsername(request.username())) {
            throw new UserUsernameNotFoundException(String.format("There are no records for user '%s'.", request.username()));
        }

        UserDetails userDetails = repository.findByUsername(request.username());

        if (!securityConfig.passwordEncoder().matches(request.password(), userDetails.getPassword())) {
            throw new InvalidPasswordException(String.format("Invalid password for '%s' user.", request.username()));
        }

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(request.username(), request.password());
        Authentication auth = securityConfig.authManager(new AuthenticationConfiguration()).authenticate(usernamePasswordAuthenticationToken);

        return authTokenService.generateToken((User) auth.getPrincipal());
    }
}
