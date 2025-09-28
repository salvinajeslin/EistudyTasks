package factory;

import product.Button;
import product.TextBox;
import product.DarkButton;
import product.DarkTextBox;

public class DarkThemeFactory implements AbstractThemeFactory {

    @Override
    public Button createButton() {
        return new DarkButton();
    }

    @Override
    public TextBox createTextBox() {
        return new DarkTextBox();
    }
}
