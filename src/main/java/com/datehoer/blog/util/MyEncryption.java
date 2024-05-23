package com.datehoer.blog.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.security.SecureRandom;

public class MyEncryption {

    // 使用 SHA-256 对密码进行哈希加密
    public static String hashPassword(String password, String salt) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt.getBytes());
            byte[] hashedPassword = md.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(hashedPassword);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    // 生成一个安全的随机盐值
    public static String generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }

    // 验证输入的密码是否与存储的哈希密码匹配
    public static boolean verifyPassword(String password, String salt, String hashedPassword) {
        String computedHash = hashPassword(password, salt);
        return computedHash != null && computedHash.equals(hashedPassword);
    }
}
