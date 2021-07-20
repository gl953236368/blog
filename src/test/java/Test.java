import io.jsonwebtoken.Jwts;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

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
        String reqUrl = "/auth/edit/role?userId=3&roleId=2";
        String url =reqUrl.substring(0, reqUrl.indexOf("?"));
        System.out.println(url);
    }
}
