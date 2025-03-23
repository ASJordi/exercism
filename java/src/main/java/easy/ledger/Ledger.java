package easy.ledger;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Ledger {

    private static final String US_LOCALE = "en-US";
    private static final String NL_LOCALE = "nl-NL";

    private static final String USD_CURRENCY = "USD";
    private static final String EUR_CURRENCY = "EUR";

    public LedgerEntry createLedgerEntry(String d, String desc, int c) {
        return new LedgerEntry(LocalDate.parse(d), desc, c);
    }

    public String format(String cur, String loc, LedgerEntry[] entries) {
        String s = null;
        String header = null;
        String curSymb = null;
        String datPat = null;
        String decSep = null;
        String thSep = null;

        if (!cur.equals(USD_CURRENCY) && !cur.equals(EUR_CURRENCY)) throw new IllegalArgumentException("Invalid currency");
        else if (!loc.equals(US_LOCALE) && !loc.equals(NL_LOCALE)) throw new IllegalArgumentException("Invalid locale");
        else {
            curSymb = cur.equals(USD_CURRENCY) ? "$" : "€";

            if (loc.equals(US_LOCALE)) {
                datPat = "MM/dd/yyyy";
                decSep = ".";
                thSep = ",";
                header = "Date       | Description               | Change       ";
            } else if (loc.equals(NL_LOCALE)) {
                datPat = "dd/MM/yyyy";
                decSep = ",";
                thSep = ".";
                header = "Datum      | Omschrijving              | Verandering  ";
            }
        }

        s = header;
        s = processLedger(loc, entries, datPat, thSep, curSymb, decSep, s);

        return s;
    }

    private static String processLedger(String loc, LedgerEntry[] entries, String datPat, String thSep, String curSymb, String decSep, String s) {
        if (entries.length > 0) {
            List<LedgerEntry> neg = new ArrayList<>();
            List<LedgerEntry> pos = new ArrayList<>();

            for (LedgerEntry e : entries) {
                if (e.getChange() >= 0) pos.add(e);
                else neg.add(e);
            }

            neg.sort(Comparator.comparing(LedgerEntry::getLocalDate));
            pos.sort(Comparator.comparing(LedgerEntry::getLocalDate));

            List<LedgerEntry> all = new ArrayList<>();
            all.addAll(neg);
            all.addAll(pos);

            for (LedgerEntry e : all) {
                String date = e.getLocalDate().format(DateTimeFormatter.ofPattern(datPat));
                String desc = e.getDescription();

                if (desc.length() > 25) {
                    desc = desc.substring(0, 22);
                    desc = desc + "...";
                }

                String converted = null;
                if (e.getChange() < 0) converted = String.format("%.02f", (e.getChange() / 100) * -1);
                else converted = String.format("%.02f", e.getChange() / 100);

                String[] parts = converted.split("\\.");
                StringBuilder amount = new StringBuilder();
                int count = 1;

                for (int ind = parts[0].length() - 1; ind >= 0; ind--) {
                    if (((count % 3) == 0) && ind > 0) amount.insert(0, thSep + parts[0].charAt(ind));
                    else amount.insert(0, parts[0].charAt(ind));
                    count++;
                }

                if (loc.equals(NL_LOCALE)) amount = new StringBuilder(curSymb + " " + amount + decSep + parts[1]);
                else amount = new StringBuilder(curSymb + amount + decSep + parts[1]);


                if (e.getChange() < 0 && loc.equals(US_LOCALE)) amount = new StringBuilder("(" + amount + ")");
                else if (e.getChange() < 0 && loc.equals(NL_LOCALE)) amount = new StringBuilder(curSymb + " -" + amount.toString().replace(curSymb, "").trim() + " ");
                else if (loc.equals(NL_LOCALE)) amount = new StringBuilder(" " + amount + " ");
                else amount.append(" ");

                s = s + "\n";
                s = s + String.format("%s | %-25s | %13s",
                        date,
                        desc,
                        amount.toString());
            }

        }
        return s;
    }

    public static class LedgerEntry {
        private LocalDate localDate;
        private String description;
        private double change;

        public LedgerEntry(LocalDate localDate, String description, double change) {
            this.localDate = localDate;
            this.description = description;
            this.change = change;
        }

        public LocalDate getLocalDate() {
            return localDate;
        }

        public void setLocalDate(LocalDate localDate) {
            this.localDate = localDate;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public double getChange() {
            return change;
        }

        public void setChange(double change) {
            this.change = change;
        }
    }

}
