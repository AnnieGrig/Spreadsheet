import javax.xml.crypto.Data;
import java.util.Date;

public class Cell {
    private Type type;

    private Color color;

    private Object value;

    public Cell() {

        this.value = "";
        this.color = Color.WHITE;
        this.type = Type.STRING;
    }

    public Type getType() {
        return type;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Object getValue() {
        try {
            return value;
        } catch (NullPointerException nle) {
            return "-";
        }
    }

    public void setValue(Object value) {
        if (value instanceof Number) {
            this.type = Type.NUMBER;
            this.value = value;
        } else if (value instanceof Date) {
            this.type = Type.DATE;
            this.value = value;
        } else {
            this.type = Type.STRING;
            this.value = value.toString();
        }
    }

        public void reset () {
            this.value = "";
            this.color = Color.WHITE;
            this.type = Type.STRING;
        }
    }
