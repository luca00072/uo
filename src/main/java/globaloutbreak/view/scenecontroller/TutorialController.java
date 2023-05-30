package globaloutbreak.view.scenecontroller;

import org.slf4j.Logger;

import globaloutbreak.view.scenemanager.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * Class that manage button handlers.
 */
public class TutorialController extends AbstractSceneController {

    @FXML
    private Button newGameButton;

    @FXML
    private Button tutorialButton;

    @FXML
    private Button exitButton;

    @FXML
    private Button submitButton;

    private Stage stage;
    private SceneManager sceneManager;
    private Logger logger;

    /**
     * Initialize logger.
     */
    public final void initialize() {

    }

    /**
     * Go to the previous scene.
     * 
     * @param evt event handler
     */
    @FXML
    public final void backScene(final MouseEvent evt) {
        this.stage = this.stage == null ? this.getStage(evt) : this.stage;

        this.getSceneManager().openBackScene(stage);
    }
}
