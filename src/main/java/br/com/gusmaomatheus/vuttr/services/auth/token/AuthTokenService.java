package br.com.gusmaomatheus.vuttr.services.auth.token;

import br.com.gusmaomatheus.vuttr.models.User;

public interface AuthTokenService {

    String generateToken(User user);

    String validateToken(String token);
}
