package principal;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class Ejemplos {

    public static void main(String[] args) {
        ejemploLocalDate();
        ejemploLocalTime();
        ejemploLocalDateTime();
        ejemploInstant();
        ejemploDuration();
        ejemploPeriod();
        ejemploDateTimeFormatterYParseo();
        ejemploComparacionesYSumas();
        imprimirTablaConvenciones();
    }

    // -------------------------
    // LocalDate
    // -------------------------
    private static void ejemploLocalDate() {
        System.out.println("=== LocalDate ===");
        LocalDate date1 = LocalDate.of(1989, 11, 11); // 1989-11-11
        System.out.println("date1: " + date1);
        System.out.println("getYear(): " + date1.getYear());
        System.out.println("getMonth(): " + date1.getMonth());
        System.out.println("getDayOfMonth(): " + date1.getDayOfMonth());

        LocalDate date2 = LocalDate.of(1989, Month.NOVEMBER, 11);
        System.out.println("date2 (using Month enum): " + date2);

        LocalDate hoy = LocalDate.now();
        System.out.println("Hoy (LocalDate.now()): " + hoy);
        System.out.println();
    }

    // -------------------------
    // LocalTime
    // -------------------------
    private static void ejemploLocalTime() {
        System.out.println("=== LocalTime ===");
        LocalTime time1 = LocalTime.of(5, 30, 45, 35); // 05:30:45.000000035
        System.out.println("time1: " + time1);
        System.out.println("getHour(): " + time1.getHour());
        System.out.println("getMinute(): " + time1.getMinute());
        System.out.println("getSecond(): " + time1.getSecond());
        System.out.println("getNano(): " + time1.getNano());

        LocalTime ahora = LocalTime.now();
        System.out.println("Ahora (LocalTime.now()): " + ahora);
        System.out.println();
    }

    // -------------------------
    // LocalDateTime
    // -------------------------
    private static void ejemploLocalDateTime() {
        System.out.println("=== LocalDateTime ===");
        LocalDateTime dt1 = LocalDateTime.of(1989, 11, 11, 5, 30, 45, 35);
        System.out.println("dt1: " + dt1); // 1989-11-11T05:30:45.000000035

        LocalDate date = LocalDate.of(1989, 11, 11);
        LocalTime time = LocalTime.of(5, 30, 45, 35);
        LocalDateTime dt2 = LocalDateTime.of(date, time);
        System.out.println("dt2 (from LocalDate + LocalTime): " + dt2);

        LocalDateTime ahora = LocalDateTime.now();
        System.out.println("Ahora (LocalDateTime.now()): " + ahora);

        // Mostrar día del año, día de la semana, semana del año/mes (usando formateador)
        System.out.println("Día del año: " + ahora.getDayOfYear());
        System.out.println("Día de la semana (enum): " + ahora.getDayOfWeek());
        System.out.println("Nº de día de la semana: " + ahora.getDayOfWeek().getValue());
        System.out.println();
    }

    // -------------------------
    // Instant
    // -------------------------
    private static void ejemploInstant() {
        System.out.println("=== Instant ===");
        Instant instant = Instant.ofEpochSecond(120);
        System.out.println("Instant.ofEpochSecond(120): " + instant); // 1970-01-01T00:02:00Z

        Instant ahora = Instant.now();
        System.out.println("Instant.now(): " + ahora);
        System.out.println();
    }

    // -------------------------
    // Duration
    // -------------------------
    private static void ejemploDuration() {
        System.out.println("=== Duration ===");
        LocalTime t1 = LocalTime.of(12, 25);
        LocalTime t2 = LocalTime.of(17, 35);
        Duration dur = Duration.between(t1, t2);
        System.out.println("Duration between 12:25 and 17:35: " + dur); // PT5H10M

        LocalDateTime ldt1 = LocalDateTime.of(2016, Month.JULY, 18, 14, 13);
        LocalDateTime ldt2 = LocalDateTime.of(2016, Month.JULY, 20, 12, 25);
        Duration dur2 = Duration.between(ldt1, ldt2);
        System.out.println("Duration between two LocalDateTime: " + dur2);

        Duration oneDay = Duration.of(1, ChronoUnit.DAYS);
        System.out.println("Duration.of(1, DAYS): " + oneDay);
        Duration oneDayAlt = Duration.ofDays(1);
        System.out.println("Duration.ofDays(1): " + oneDayAlt);
        System.out.println();
    }

    // -------------------------
    // Period
    // -------------------------
    private static void ejemploPeriod() {
        System.out.println("=== Period ===");
        LocalDate d1 = LocalDate.of(2016, Month.JULY, 18);
        LocalDate d2 = LocalDate.of(2016, Month.JULY, 20);
        Period p = Period.between(d1, d2);
        System.out.println("Period between 2016-07-18 and 2016-07-20: " + p); // P2D

        Period pFull = Period.of(1, 2, 3); // 1 year, 2 months, 3 days
        System.out.println("Period.of(1,2,3): " + pFull);
        Period pYear = Period.ofYears(1);
        System.out.println("Period.ofYears(1): " + pYear);
        System.out.println();
    }

    // -------------------------
    // DateTimeFormatter y parseo/formatos
    // -------------------------
    private static void ejemploDateTimeFormatterYParseo() {
        System.out.println("=== DateTimeFormatter y parseo ===");
        DateTimeFormatter f1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaStr = "08/01/1990";
        try {
            LocalDate fecha = LocalDate.parse(fechaStr, f1);
            System.out.println("Parseado (dd/MM/yyyy): " + fecha);

            DateTimeFormatter out1 = DateTimeFormatter.ofPattern("d-M-yy");
            System.out.println("Formato d-M-yy: " + fecha.format(out1));

            DateTimeFormatter out2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            System.out.println("Formato yyyy-MM-dd: " + fecha.format(out2));

            DateTimeFormatter out3 = DateTimeFormatter.ofPattern("dd-MMM-yyyy", Locale.ENGLISH);
            System.out.println("Formato dd-MMM-yyyy: " + fecha.format(out3));

            DateTimeFormatter out4 = DateTimeFormatter.ofPattern("yyyy-MMMM-dd", Locale.ENGLISH);
            System.out.println("Formato yyyy-MMMM-dd: " + fecha.format(out4));

            // Mostrar nombre del mes en español
            System.out.println(fecha.getDayOfMonth() + " de " + fecha.getMonth().toString() + " de " + fecha.getYear());
            System.out.println(fecha.getDayOfMonth() + " de " +
                    fecha.getMonth().getDisplayName(TextStyle.FULL, new Locale("es", "ES")) + " de " + fecha.getYear());
        } catch (Exception e) {
            System.out.println("Error parseando fecha: " + e.getMessage());
        }

        // Formateos con LocalDateTime
        LocalDateTime ahora = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        System.out.println("Ahora formateado (dd/MM/yyyy HH:mm): " + ahora.format(formato));

        formato = DateTimeFormatter.ofPattern("dd/MM/yyyy KK:mm a", Locale.ENGLISH);
        System.out.println("Ahora formateado (dd/MM/yyyy KK:mm a): " + ahora.format(formato));

        formato = DateTimeFormatter.ofPattern("dd/MMM/yyyy KK:mm a", Locale.ENGLISH);
        System.out.println("Ahora formateado (dd/MMM/yyyy KK:mm a): " + ahora.format(formato));

        formato = DateTimeFormatter.ofPattern("dd/MMMM/yyyy KK:mm a", Locale.ENGLISH);
        System.out.println("Ahora formateado (dd/MMMM/yyyy KK:mm a): " + ahora.format(formato));

        // Semana del año y semana del mes (usando patrones 'w' y 'W')
        DateTimeFormatter weekOfYearFmt = DateTimeFormatter.ofPattern("w");
        String semanaDelAno = ahora.format(weekOfYearFmt);
        System.out.println("Semana del año: " + semanaDelAno);

        DateTimeFormatter weekOfMonthFmt = DateTimeFormatter.ofPattern("W");
        String semanaDelMes = ahora.format(weekOfMonthFmt);
        System.out.println("Semana del mes: " + semanaDelMes);

        System.out.println("Día del año: " + ahora.getDayOfYear());
        System.out.println("Día de la semana en inglés: " + ahora.getDayOfWeek());
        System.out.println("Día de la semana en francés: " + ahora.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.FRANCE));
        System.out.println();
    }

    // -------------------------
    // Comparaciones y sumas/restas
    // -------------------------
    private static void ejemploComparacionesYSumas() {
        System.out.println("=== Comparaciones y operaciones plus/minus ===");
        LocalDateTime hoy = LocalDateTime.now();
        LocalDateTime otro = LocalDateTime.of(1999, 7, 30, 18, 55, 50);

        System.out.println("hoy: " + hoy);
        System.out.println("otro: " + otro);

        System.out.println("equals: " + hoy.equals(otro));
        System.out.println("isBefore(otro): " + hoy.isBefore(otro));
        System.out.println("isAfter(otro): " + hoy.isAfter(otro));
        System.out.println("compareTo(otro): " + hoy.compareTo(otro));

        LocalDateTime masUnAno = hoy.plusYears(1);
        LocalDateTime menosDosMeses = hoy.minusMonths(2);
        LocalDateTime masTresDias = hoy.plusDays(3);
        LocalDateTime menosHoras = hoy.minusHours(5);

        System.out.println("plusYears(1): " + masUnAno);
        System.out.println("minusMonths(2): " + menosDosMeses);
        System.out.println("plusDays(3): " + masTresDias);
        System.out.println("minusHours(5): " + menosHoras);

        // Ejemplo con Duration y Period aplicados a LocalDateTime/LocalDate
        Duration dur = Duration.ofHours(48);
        LocalDateTime futuro = hoy.plus(dur);
        System.out.println("hoy + Duration.ofHours(48): " + futuro);

        Period per = Period.ofDays(10);
        LocalDate fechaFutura = LocalDate.now().plus(per);
        System.out.println("LocalDate.now() + Period.ofDays(10): " + fechaFutura);
        System.out.println();
    }

    // -------------------------
    // Imprimir tabla de la presentación (convenciones de nombres)
    // -------------------------
    private static void imprimirTablaConvenciones() {
        System.out.println("=== Tabla: Convención en el nombre de los métodos ===");
        String[] headers = {"Nombre", "Tipo", "Uso"};
        String[][] rows = {
                {"of", "static", "Crear una instancia del objeto a partir de los datos de entrada"},
                {"from", "static", "Convertir el parámetro de entrada en una instancia de la clase"},
                {"parse", "static", "Procesar la cadena de entrada y construir una instancia"},
                {"format", "instancia", "Procesar los datos para producir una cadena"},
                {"get", "instancia", "Devolver una parte del objeto"},
                {"is", "instancia", "Consultar el estado del objeto"},
                {"with", "instancia", "Devolver una copia con elementos modificados"},
                {"plus", "instancia", "Devolver copia con tiempo añadido"},
                {"minus", "instancia", "Devolver copia con tiempo sustraído"},
                {"to", "instancia", "Convertir el objeto en otro tipo"},
                {"at", "instancia", "Combinar el objeto con otro objeto"}
        };

        // Imprimir tabla simple
        System.out.printf("%-10s | %-8s | %s%n", headers[0], headers[1], headers[2]);
        System.out.println("---------------------------------------------------------------");
        for (String[] r : rows) {
            System.out.printf("%-10s | %-8s | %s%n", r[0], r[1], r[2]);
        }
        System.out.println();
    }
}

