package globaloutbreak.view.scenecontroller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * Class that manage button handlers (Choose name scene).
 */
public class DiseaseNameController extends AbstractSceneController {

    @FXML
    private TextField nameTextField;
    @FXML
    private Button submitButton;

    /**
     * Initialize logger.
     */
    public void initialize() {
    }

    /**
     * Go to the previous scene.
     */
    @FXML
    public final void backScene() {
        this.getSceneManager().openDiseaseChoice();
    }

    /**
     * Start the game.
     */
    @FXML
    public final void startGame() {
        this.getView().choosenNameDisease(this.nameTextField.getText());
        this.getSceneManager().openMap();
    }

}
