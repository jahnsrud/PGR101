package library;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.fxml.FXML;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.Optional;
import java.util.List;

public class Controller {

    public TableView<Meter> tableView;
    public VBox layout;
    public Button addButton;
    public Button deleteButton;
    public Label metersMetadataLabel;

    private MeterArchive archive;

    public Controller() {

        archive = new MeterArchive();

    }

    /**
     * First things first, configure our UI
     */

    @FXML
    public void initialize() {

        tableView = new TableView<>();

        addButton = new Button("Add Meter");
        addButton.setOnAction(e -> {
            addMeter();
        });

        deleteButton = new Button("Delete");
        deleteButton.setOnAction(e -> {
            deleteSelectedItems();
        });

        metersMetadataLabel = new Label("");

        // Setup TableView
        configureTableView();

        // Menu + Items
        Menu fileMenu = new Menu("File");

        // Menu Items
        MenuItem newFile = new MenuItem("Add Meter...");
        newFile.setOnAction(e -> {
            addMeter();
        });

        newFile.setAccelerator(new KeyCombination() {
        });


        fileMenu.getItems().add(newFile);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu);
        menuBar.useSystemMenuBarProperty().set(true);

        // Configure our layout
        layout.setSpacing(10);
        layout.setPadding(new Insets(0, 0, 0, 0));

        layout.getChildren().addAll(tableView, addButton, deleteButton, metersMetadataLabel, menuBar);



    }

    private void configureTableView() {

        // Add columns for our data
        TableColumn<Meter, String> typeColumn = new TableColumn<>("Type");
        // typeColumn.setMinWidth(80);


        TableColumn<Meter, String> idColumn = new TableColumn<>("ID");
        idColumn.setMinWidth(80);
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Meter, String> locationCodeColumn = new TableColumn<>("Location Code");
        locationCodeColumn.setMinWidth(120);
        locationCodeColumn.setCellValueFactory(new PropertyValueFactory<>("locationCode"));

        TableColumn<Meter, String> functionalColumn = new TableColumn<>("Functional?");
        functionalColumn.setMinWidth(60);
        // functionalColumn.setCellValueFactory(new PropertyValueFactory<>("isFunctional"));

        /**
         * TODO: Checkbox
         */
        // functionalColumn.setCellFactory(tc -> new CheckBoxTableCell<>());

        functionalColumn.setCellValueFactory(cellData -> {

            // TODO: Fix!

            boolean isFunctional = cellData.getValue().isFunctional();
            String functionalString;

            if (isFunctional == true)
            {
                functionalString = "Yes";
            }
            else
            {
                functionalString = "No";
            }

            return new ReadOnlyStringWrapper(functionalString);

        });

        tableView.getColumns().addAll(typeColumn, idColumn, locationCodeColumn, functionalColumn);

        refresh();
    }

    /**
     * Todo: Helper method for creating columns
     */

    // private void createColumn()

    private void refresh() {

        tableView.setItems(getProducts());
        tableView.refresh();
        updateMetersMetadataLabel();


    }

    public ObservableList<Meter> getProducts() {
        ObservableList<Meter> meters = FXCollections.observableArrayList();

        List<Meter> metersToAdd = archive.getAllMeters();

        for(Meter meter : metersToAdd) {

            meters.add(meter);
            // System.out.println("Found Meter: " + meter);

        }

        return meters;

    }

    public void addMeter() {

        // Ny løsning som kommer snart
        // boolean test = AddMeterController.showAddMeter();



        // Fungerende kode


        Meter meterToAdd;

        ButtonType clockButtonType = new ButtonType("Clock", ButtonBar.ButtonData.OK_DONE);
        ButtonType thermometerButtonType = new ButtonType("Thermometer", ButtonBar.ButtonData.OK_DONE);
        ButtonType weightButtonType = new ButtonType("Weight", ButtonBar.ButtonData.OK_DONE);

        Alert alert = new Alert(Alert.AlertType.NONE, "Select Instrument Type", ButtonType.CANCEL, clockButtonType, thermometerButtonType,
                weightButtonType);

        alert.setTitle("Add Instrument");
        alert.setHeaderText("Add Instrument");

        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.CANCEL) {
            return;
        }

        boolean isClock = false;
        boolean isThermometer = false;
        boolean isWeight = false;

        // Get Meter type

        if (result.isPresent() && result.get() == clockButtonType) {
            System.out.println("Klokke");
            isClock = true;

        } else if (result.isPresent() && result.get() == thermometerButtonType) {
            System.out.println("Termometer");
            isThermometer = true;


        } else if (result.isPresent() && result.get() == weightButtonType) {
            System.out.println("Vekt");
            isWeight = true;

        }

        TextInputDialog inputDialog = new TextInputDialog();
        inputDialog.setGraphic(null);
        inputDialog.setHeaderText("Add new Meter");

        inputDialog.setTitle("Add new Meter");
        inputDialog.setContentText("Enter id:");

        String id = inputDialog.showAndWait().get();

        inputDialog.getEditor().clear();

        inputDialog.setContentText("Enter location code");
        String locationCode = inputDialog.showAndWait().get();
        inputDialog.getEditor().clear();

        // ChoiceDialog
        // Detect if instrument is functional or not

        List<String> choices = new ArrayList<>();
        choices.add("Yes");
        choices.add("No");

        ChoiceDialog<String> dialog = new ChoiceDialog<>("Yes", choices);
        dialog.setTitle("Add new Meter");
        dialog.setGraphic(null);
        dialog.setHeaderText("Meter Status");
        dialog.setContentText("Is the meter functional?");

        String isFunctioningString = dialog.showAndWait().get();

        boolean isFunctional;

        if (isFunctioningString.equalsIgnoreCase("Yes")) {
            isFunctional = true;
        } else {
            isFunctional = false;
        }

        inputDialog.getEditor().clear();

        if (isClock) {
            meterToAdd = new Clock(id, locationCode, isFunctional, 0.1);



        } else if (isThermometer) {
            meterToAdd = new Thermometer(id, locationCode, isFunctional, 0.0, 100.0);



        } else if (isWeight) {
            meterToAdd = new Weight(id, locationCode, isFunctional, 0, 1000);



        } else {
            System.out.println("Unknown Meter type. Returning...");
            return;
        }

        archive.addMeter(meterToAdd);

        archive.printAllMeters();

        updateMetersMetadataLabel();
        refresh();

        // showAlert("Added meter", meterToAdd.toString());



    }

    private void deleteSelectedItems() {

        /**
         * Todo: Fiks sletting!
         */

        ObservableList<Meter> productsSelected, allMeters;
        allMeters = tableView.getItems();

        productsSelected = tableView.getSelectionModel().getSelectedItems();
        productsSelected.forEach(allMeters::remove);

    }

    public void showAlert(String alertTitle, String alertMessage) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION, alertMessage, ButtonType.CLOSE);
        alert.setHeaderText(alertTitle);
        alert.setTitle(alertTitle);
        alert.setGraphic(null);
        alert.showAndWait();


    }

    public void updateMetersMetadataLabel() {
        metersMetadataLabel.setText("Total number of meters: " + archive.getNumberOfMeters());
    }



}
