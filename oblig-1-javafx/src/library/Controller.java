package library;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.fxml.FXML;

public class Controller {

    public Label helloLabel;
    public Button addButton;
    public Label metersMetadataLabel;

    private MeterArchive archive;


    public Controller() {

        archive = new MeterArchive();

    }

    @FXML
    public void initialize() {
        helloLabel.setText("Hello, World!");

        updateMetersMetadataLabel();

    }

    public void addMeter(ActionEvent actionEvent) {

        TextInputDialog inputDialog = new TextInputDialog();
        inputDialog.setTitle("Add new Meter");
        inputDialog.setContentText("Enter id:");

        String location = inputDialog.showAndWait().toString();

        inputDialog.getEditor().clear();
        inputDialog.setContentText("Enter location code");
        String locationCode = inputDialog.showAndWait().toString();
        inputDialog.getEditor().clear();

        Clock myClock = new Clock(location, locationCode, true, 0.1);
        archive.addMeter(myClock);

        archive.printAllMeters();

        updateMetersMetadataLabel();

        showAlert(myClock.toString());

    }

    public void showAlert(String alertMessage) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION, alertMessage, ButtonType.CLOSE);
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
