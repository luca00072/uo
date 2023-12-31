package globaloutbreak.view.scenecontroller;

import globaloutbreak.model.infodata.InfoData;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;

public class CureGraphSceneController extends AbstractSceneController implements SceneInitializer {

    @FXML
    private ProgressBar progressBar;
    @FXML
    private Button worldButton;
    @FXML
    private Button cureButton;
    @FXML
    private Label progress;
    @FXML
    private TextField cureContributors;

    @Override
    public void initializeScene() {
        final InfoData infoData = this.getView().getInfoData();
        final int percentage = infoData.getCureData().getProgress();
        this.progressBar.setProgress(percentage / 100);
        this.progress.setText(Integer.toString(percentage) + " %");
        infoData.getCureData().getMajorContributors().stream().map(region -> region.getName()).toList();
        final String listContributors = String.join(",", infoData.getCureData().getMajorContributors().stream().map(region -> region.getName()).toList());
        this.cureContributors.setText(listContributors);
    }

    @FXML
    public void showWorldInfo() {
        this.getSceneManager().openWorldGraphScene();
    }

    @FXML
    public void showCureProgress() {
    }

    @FXML
    public void backScene() {
        this.getSceneManager().openMap();
    }
}
