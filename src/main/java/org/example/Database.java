package org.example;

import java.util.HashMap;
import java.util.Map;

public class Database {
    private static Map<Integer, MemberRecord> socios = new HashMap<>();

    public static MemberRecord getMember(Integer codigo) {
        return socios.get(codigo);
    }

    public static void addMember(MemberRecord socio) {
        socios.put(socio.getCodigo(), socio);
    }
}
