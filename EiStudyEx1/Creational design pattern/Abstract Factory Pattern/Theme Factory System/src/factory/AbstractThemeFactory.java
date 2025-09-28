package factory;

import product.Button;
import product.TextBox;

public interface AbstractThemeFactory {
    Button createButton();
    TextBox createTextBox();
}
