package library;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.fxml.FXML;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.Optional;
import java.util.List;

public class Controller {

    public TableView<Meter> tableView;
    public VBox layout;
    public Button addButton;
    public Label helloLabel;
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
        helloLabel = new Label("Library");

        addButton = new Button("Add Meter");
        addButton.setOnAction(e -> {
            addMeter();
        });

        metersMetadataLabel = new Label("");

        // Setup TableView
        configureTableView();

        // Configure our layout
        layout.setSpacing(10);
        layout.setPadding(new Insets(0, 0, 0, 0));

        layout.getChildren().addAll(tableView, addButton, helloLabel, metersMetadataLabel);



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

    /**
     * BACKUP AV GAMMEL KODe
     *
     */

    /*
    public void mainMethod() {

        System.out.println("Arbeidskrav 1");
        System.out.println("Hello, World!");

        MeterArchive meterArchive = new MeterArchive();

        // Legg til placeholder-innhold
        addPlaceholderContent(meterArchive);

        // Print ut alle
        meterArchive.printAllMeters();

        // Hent instrument med id "idToCheck"

        String idToCheck = "ABC123";

        System.out.println("*********");
        System.out.println("Ser etter instrument med ID: " + idToCheck);

        Meter meter = meterArchive.getMeter(idToCheck);

        if (meter != null) {
            System.out.println("Fant instrument med ID: " + idToCheck + ". Informasjon om instrumentet:");
            System.out.println(meter);


        }

        System.out.println("*********");

        //
        // Fjern instrument med id idToDelete
        //

        String idToDelete = "CBA321";
        System.out.println("Forsøker å slette " + idToDelete);

        if (meterArchive.delete(idToDelete)) {
            System.out.println("Slettet: " + "CBA321");
        } else {
            System.out.println("Kunne ikke slette");
        }

        System.out.println("*********");

        // Marker et instrument til å være ute av drift

        String idToSetNonFunctional = "WGT000";

        System.out.println("Setter instrument med id: " + idToSetNonFunctional + " til å være ute av drift.");
        meterArchive.setMeterNonFunctional(idToSetNonFunctional);


        System.out.println("*********");

        // Endre plassering på et instrument

        String idToChangeLocation = "WGT000";
        System.out.println("Endrer plassering på instrument med id: " + idToChangeLocation);
        meterArchive.changeMeterLocation(idToChangeLocation, "WGT100");

        System.out.println("*********");

        // Printer så listen igjen til slutt for å se endringene
        System.out.println();
        System.out.println("Da nærmer vi oss ferdig 😎 Her er oversikten over alle instrumenter akkurat nå:");
        meterArchive.printAllMeters();


        System.out.println();
        System.out.println("Takk for meg (╯°□°）╯︵ ");


    }

    public void addPlaceholderContent(MeterArchive meterArchive) {

        Clock myClock = new Clock("ABC123", "A123", true, 0.1);
        meterArchive.addMeter(myClock);

        Thermometer myThermometer = new Thermometer("CBA321", "123A", true, 0, 100);
        meterArchive.addMeter(myThermometer);

        Weight myWeight = new Weight("WGT000", "000L", true, 0, 1000);
        meterArchive.addMeter(myWeight);

        // Forsøk på å legge til duplikat:
        meterArchive.addMeter(myWeight);

    }
     */


}
