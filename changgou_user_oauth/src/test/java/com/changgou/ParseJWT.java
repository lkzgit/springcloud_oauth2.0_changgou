package com.changgou;

import org.junit.Test;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.RsaVerifier;

public class ParseJWT {

    /**
     * 效验令牌
     */
    @Test
    public void testParseJWT(){


        //令牌
        String token="eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJyb2xlcyI6IlJPTEVfVklQLFJPTEVfVVNFUiIsIm5hbWUiOiJjaGFuZ2dvdSIsImlkIjoiMSJ9.mLZML0-Zk4b5vpQWdcTYYw7kumHNsy-6F70t9vWth10SDx12fnEUBREnmKcndaUmuptWOGsx4dUix7qNBErv6oD18KNwAi24kDOiGWYyoULn2DfnQerbk6nRmLa3MDWJaIcBu_7_SONqeTXpSmPbgL9u_hfp4Fxpe-uanPQY2IO_WDiy6YS6h9cEYqjTC5sk1AWS2YAcKf-fPhwiw5KiL_zH7PMVAFFaBJfipluuNXwRzwPr07OVbiFHbHU4VgNDYfzFxufm0AGG6YnZe0Usk5PN3GS2p6Sng6TwpkBz4_cZo8yCyOx7vbp6fiRQHPWwgokmhP8rd5ucQk0ENRVX3A";
        //公钥
        String publickey="-----BEGIN PUBLIC KEY-----MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAq4OozjojcED389ROALfun8Ur6PIjTPZfoZXZINQRQQItq3FT0+V1ZpbnPvH9FtF5oBiqm7JZrxNWxELVMrrCkKsoEey3t2DexFTEWRL2BuLVBdk1JNOeZSAbM8W7GEKnG35NOlay0A8Ra1tn4bfgA5/C87WNcJOqdS8Boij9KqURflmjprdBWV2sfIQXaH33a098awaGX+e4PQMsDCtORp5gSrOIX1drFAbiyrp9v7fy0fHHWRBSN41XP6nT+WIXKovkyX2UiY4eKwpGwmek0vYIEEkcoDY1W4K3lH7uVmvNkkS9WakjQSmV+hjfKwKiU6wy5cQuSZdqFiQ8Al90dwIDAQAB-----END PUBLIC KEY-----";


        //校验Jwt
        Jwt jwt = JwtHelper.decodeAndVerify(token, new RsaVerifier(publickey));

        //获取Jwt原始内容
        String claims = jwt.getClaims();
        System.out.println(claims);
        //jwt令牌
        String encoded = jwt.getEncoded();
        System.out.println(encoded);

    }
}
