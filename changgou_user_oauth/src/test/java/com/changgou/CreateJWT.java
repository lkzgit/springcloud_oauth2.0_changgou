package com.changgou;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.RsaSigner;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import java.security.KeyPair;
import java.security.interfaces.RSAPrivateKey;
import java.util.HashMap;
import java.util.Map;

public class CreateJWT {

    /**
     * 创建令牌测试
     */

    @Test
    public void testCreatJWT(){

        //证书文件路径
        String key_location="changgou.jks";
        //秘钥库密码
        String key_password="changgou";
        //秘钥密码
        String keypwd = "changgou";
        //秘钥别名
        String alias = "changgou";
        // 访问证书路径
        ClassPathResource resource=new ClassPathResource(key_location);
        //创建秘钥工厂
        KeyStoreKeyFactory keyStoreKeyFactory=new KeyStoreKeyFactory(resource,key_password.toCharArray());
        // 读取秘钥对
        KeyPair keyPair = keyStoreKeyFactory.getKeyPair(alias, keypwd.toCharArray());
        //获取私钥
        RSAPrivateKey aPrivate =(RSAPrivateKey) keyPair.getPrivate();

        //定义Payload
        Map<String, Object> tokenMap = new HashMap<>();
        tokenMap.put("id", "1");
        tokenMap.put("name", "changgou");
        tokenMap.put("roles", "ROLE_VIP,ROLE_USER");

        //生成Jwt令牌
        Jwt jwt = JwtHelper.encode(JSON.toJSONString(tokenMap), new RsaSigner(aPrivate));//签名

        //取出令牌
        String encoded = jwt.getEncoded();
        System.out.println(encoded);
    }

}
