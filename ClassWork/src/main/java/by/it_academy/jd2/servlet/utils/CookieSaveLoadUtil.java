package by.it_academy.jd2.servlet.utils;


import javax.servlet.http.Cookie;
import java.io.*;
import java.util.StringTokenizer;

public class CookieSaveLoadUtil {

    /**
     * @param name's cookie
     * @param obj to write to cookie's value
     * @param maxAge - int. How long cookie has lived
     * @param <T> - Serializable object
     * @return new Cookie(name, byte[] T)
     * @throws IOException – if an I/O error occurs while writing stream header
     */
    public static <T extends Serializable> Cookie getCookie(String name, T obj, int maxAge) throws IOException {
        ByteArrayOutputStream bStream = new ByteArrayOutputStream();
        ObjectOutputStream stream = new ObjectOutputStream(bStream);

        stream.writeObject(obj);

        StringBuilder builder = new StringBuilder();

        for (byte b : bStream.toByteArray()) {
            builder.append(b)
                    .append("%");
        }

        Cookie cookie = new Cookie(name, builder.toString());
        cookie.setMaxAge(maxAge);

        return cookie;
    }

    /**
     * Read object from cookie
     * @param cookie - from user
     * @return new <T>Object
     */
    public static <T> T getObject(Cookie cookie) throws IOException {
        String cookieValue = cookie.getValue();
        StringTokenizer tokens = new StringTokenizer(cookieValue, "%");
        byte[] rBytes = new byte[tokens.countTokens()];
        int i = 0;
        while(tokens.hasMoreTokens()) {
            rBytes[i++] = Byte.parseByte(tokens.nextToken());
        }

        ObjectInputStream rStream = new ObjectInputStream(new ByteArrayInputStream(rBytes));
        try {
            return (T) rStream.readObject();
        }catch (ClassNotFoundException e) {
            throw new ClassCastException("Не верно введён класс ");
        }
    }

}
