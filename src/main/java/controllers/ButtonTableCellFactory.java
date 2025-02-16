package controllers;

import javafx.scene.control.*;
import javafx.scene.control.cell.*;
import javafx.util.Callback;

public class ButtonTableCellFactory<T> implements Callback<TableColumn<T, Void>, TableCell<T, Void>> {

    private final String buttonText;
    private final ButtonAction<T> action;

    public ButtonTableCellFactory(String buttonText, ButtonAction<T> action) {
        this.buttonText = buttonText;
        this.action = action;
    }

    @Override
    public TableCell<T, Void> call(final TableColumn<T, Void> param) {
        return new TableCell<>() {
            private final Button button = new Button(buttonText);

            {
                button.setOnAction(event -> {
                    T item = getTableView().getItems().get(getIndex());
                    action.execute(item);
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(button);
                }
            }
        };
    }

    @FunctionalInterface
    public interface ButtonAction<T> {
        void execute(T item);
    }
}
