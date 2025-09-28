package client;

import factory.AbstractThemeFactory;
import product.Button;
import product.TextBox;

public class ThemeApplication {
    private Button button;
    private TextBox textBox;

    public ThemeApplication(AbstractThemeFactory factory) {
        button = factory.createButton();
        textBox = factory.createTextBox();
    }

    public void renderUI() {
        button.render();
        textBox.render();
    }
}
