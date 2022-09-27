
package pe.edu.upeu.modelo.comodin;

/**
 *
 * @author EP-Ing_Sist.-CALIDAD
 */
public class ComboBoxOption {
    private String key;
    private String value;

    public ComboBoxOption(String key, String value) {
        this.key = key;
        this.value = value;
    }
   @Override
    public String toString()
    {
        return value;
    }
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
    
}
