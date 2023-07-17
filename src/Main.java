import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Spreadsheet a = null;
        try {
            a = new Spreadsheet(-1, 3);
        } catch (ExceptionExample e) {
            System.out.println(e.getMessage());
        }
        try {
            a = new Spreadsheet(3, 3);
        } catch (ExceptionExample e) {
            System.out.println(e.getMessage());
        }
        a.setValueAt(0, 0, 1);
        a.setValueAt(0, 1, 2);
        a.setValueAt(0, 2, 3);

        a.setValueAt(1, 0, 4);
        a.setValueAt(1, 1, 5);
        a.setValueAt(1, 2, 6);

        a.setValueAt(2, 0, 7);
        a.setValueAt(2, 1, 8);
        a.setValueAt(2, 2, 9);

        a.printSpreadsheet();

    }
}