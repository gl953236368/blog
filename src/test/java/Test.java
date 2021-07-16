import io.jsonwebtoken.Jwts;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class Test {
    public static void tst() throws UnsupportedEncodingException {
        String token = "eyJhbGciOiJIUzUxMiJ9.eyJweCI6IueuoeeQhuWRmCIsImV4cCI6MTYyNjQxOTM2OSwidXNlcm5hbWUiOiJhZG1pbiJ9.OndyZ-q4BPE2dY9bVVRCgOfvnuyEUwx7pbo2mKQQkfp5XMIXew4oelJfESuFYgvpdhK99l3chYmbZFHJqdo3tQ";
        String user = Jwts.parser()
                .setSigningKey("secret")
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
        System.out.println(user);
    }
    public static void main(String[] args) throws UnsupportedEncodingException {
//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        System.out.println(bCryptPasswordEncoder.encode("111111"));
        tst();
    }
}
