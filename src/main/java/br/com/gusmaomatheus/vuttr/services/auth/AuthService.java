package br.com.gusmaomatheus.vuttr.services.auth;

import br.com.gusmaomatheus.vuttr.dtos.auth.register.UserRegisterRequest;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AuthService extends UserDetailsService {

    void register(UserRegisterRequest data);
}
