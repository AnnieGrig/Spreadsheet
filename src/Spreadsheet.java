public class Spreadsheet {

    private static Cell[][] cells;
    private int columns;
    private int rows;

    public Spreadsheet(int col, int row) throws ExceptionExample {

        if (col <= 0 || row <= 0) {
            throw new ExceptionExample("Try again!");
        }
        this.columns = col;
        this.rows = row;
        cells = new Cell[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                cells[i][j] = new Cell();
            }
        }
    }

    void addColumn(int column) {

        column += column;
        for (int i = 0; i < columns; ++i) {
            System.out.print(cells[i][column].getValue() + "\t");
        }
        System.out.println();
    }


    void addRow(int row) {

        row += row;

        for (int i = 0; i < rows; ++i) {
            System.out.print(cells[row][i].getValue() + "\t");
        }
        System.out.println();
    }

    void setValueAt(int row, int column, Object value) {

        if (row < 0 || column < 0 || row > rows || column > columns) {
            throw new RuntimeException("Your row or column out of bounds!");
        }

        cells[row][column].setValue(value);

    }

    Object getValueAt(int row, int column) {

        if (row < 0 || column < 0 || row > rows || column > columns) {
            throw new RuntimeException("Your row or column out of bounds!");
        }

        return cells[row][column].getValue();
    }

    void setColorAt(int row, int column, Color color) {

        if (row < 0 || column < 0 || row > rows || column > columns) {
            throw new RuntimeException("Your row or column out of bounds!");
        }

        cells[row][column].setColor(color);
    }

    Color getColorAt(int row, int column) {

        if (row < 0 || column < 0 || row > rows || column > columns) {
            throw new RuntimeException("Your row or column out of bounds!");
        }

        return cells[row][column].getColor();
    }

    void reset() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                cells[i][j].reset();
            }
        }
    }


    void resetCellAt(int row, int column) {
        cells[row][column].reset();
    }

    double getColumnSum(int column) {
        Object sumOfColumn = 0;
        for (int i = 0; i < rows; i++) {
            switch (cells[i][column].getType()) {
                case STRING:
                    throw new IllegalArgumentException("The type isn't NUMBER!");
                case DATE:
                    throw new IllegalArgumentException("The type isn't NUMBER");
                case NUMBER:
                    sumOfColumn += cells[i][column].getValue().toString();
                default:
                    throw new IllegalArgumentException("Can't accept this TYPE");
            }
        }
        return (double) sumOfColumn;
    }

    double getRowSum(int row) {
        Object sumOfRow = 0;
        for (int i = 0; i < columns; i++) {
            switch (cells[row][i].getType()) {
                case STRING:
                    throw new IllegalArgumentException("The type isn't NUMBER!");
                case DATE:
                    throw new IllegalArgumentException("The type isn't NUMBER");
                case NUMBER:
                    sumOfRow += cells[row][i].getValue().toString();
                default:
                    throw new IllegalArgumentException("Can't accept this TYPE");
            }
        }
        return (double) sumOfRow;
    }


    double getAreaSum(int row1, int column1, int row2, int column2) throws ExceptionExample {
        double sum = 0;
        for (int i = row1; i <= row2; i++) {
            for (int j = column1; j <= column2; j++) {
                if (cells[i][j].getType() == Type.NUMBER) {
                    Number value =(Number) cells[i][j].getValue();
                    sum += value.doubleValue();
                } else {
                    throw new ExceptionExample("No Number");
                }
            }
        }
        return sum;
    }

    double getColumnAverage(int column) {
        return (double) getColumnSum(column) / rows;
    }

    double getRowAverage(int row) {
        return getRowSum(row) / columns;
    }

    double getAreaAverage(int row1, int column1, int row2, int column2) {
        Object sum = 0;
        int count = 0;

        for (int i = row1; i <= row2; i++) {
            for (int j = column1; j <= column2; j++) {
                sum += cells[i][j].getValue().toString();
                count++;
            }

        }
        return (double) sum / count;
    }

    public void printSpreadsheet() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(cells[i][j].getValue() + "\t");
            }
            System.out.println();
        }
    }

}






