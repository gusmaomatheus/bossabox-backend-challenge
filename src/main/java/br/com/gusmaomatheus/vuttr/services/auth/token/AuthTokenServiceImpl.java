package br.com.gusmaomatheus.vuttr.services.auth.token;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AuthTokenServiceImpl implements AuthTokenService {
    @Value("${api.security.token.secret}")
    private String secret;

}
