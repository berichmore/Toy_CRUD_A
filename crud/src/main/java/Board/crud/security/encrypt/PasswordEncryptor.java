package board.crud.security.encrypt;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

//Spring IOC 컨테이너에 Bean을 등록
@Component
public class PasswordEncryptor {
    private final BCryptPasswordEncoder encoder;


    public PasswordEncryptor(BCryptPasswordEncoder encoder) {
        this.encoder = encoder;
    }

    public String encode(String rawPwd){
        return encoder.encode(rawPwd);
    }
    public boolean matches(String rawPwd, String encodedPwd){
        return encoder.matches(rawPwd, encodedPwd);
    }
}
