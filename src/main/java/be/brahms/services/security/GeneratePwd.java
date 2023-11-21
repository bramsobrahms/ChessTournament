package be.brahms.services.security;


import java.security.SecureRandom;
import java.util.Random;

public class GeneratePwd {

    public static String GeneratePassword (int length) {

        if (length <4) {
            length = 6;
        }

        final char[] alphLowerCase = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        final char[] alphaUpperCase = "ABCDEFGJKLMNPRSTUVWXYZ".toCharArray();
        final char[] number = "0123456789".toCharArray();
        final char[] symbol = "@^_!\"+.=$&%*? ".toCharArray();
        final char[] allAllowed = "abcdefghijklmnopqrstuvwxyzABCDEFGJKLMNPRSTUVWXYZABCDEFGJKLMNPRSTUVWXYZ-_@".toCharArray();

        Random rdm = new SecureRandom();

        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            password.append(allAllowed[rdm.nextInt(allAllowed.length)]);
        }

        password.insert(rdm.nextInt(password.length()), alphLowerCase[rdm.nextInt(alphLowerCase.length)]);
        password.insert(rdm.nextInt(password.length()), alphaUpperCase[rdm.nextInt(alphaUpperCase.length)]);
        password.insert(rdm.nextInt(password.length()), number[rdm.nextInt(number.length)]);
        password.insert(rdm.nextInt(password.length()), allAllowed[rdm.nextInt(allAllowed.length)]);

        return password.toString();

    }

}
