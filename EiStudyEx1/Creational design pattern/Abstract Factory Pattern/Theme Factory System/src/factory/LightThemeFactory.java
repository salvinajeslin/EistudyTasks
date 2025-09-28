package factory;

import product.Button;
import product.TextBox;
import product.LightButton;
import product.LightTextBox;

public class LightThemeFactory implements AbstractThemeFactory {

    @Override
    public Button createButton() {
        return new LightButton();
    }

    @Override
    public TextBox createTextBox() {
        return new LightTextBox();
    }
}
