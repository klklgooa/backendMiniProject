package org.example.globals.utils;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class idUtil {
    private static final Path DATA = Paths.get("");

    private idUtil() {}

    public static synchronized int nextTripId() {
        try {
            Files.createDirectories(DATA.getParent());
            int current = 0;

            if (Files.exists(DATA)) {
                String s = Files.readString(DATA).trim();
                if (!s.isEmpty()) current = Integer.parseInt(s);
            }

            int next = current + 1;
            Files.writeString(
                    DATA,
                    Integer.toString(next),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING
            );
            return next;
        } catch (IOException e) {
            throw new UncheckedIOException("데이터 파일 갱신 실패", e);
        }
    }
}