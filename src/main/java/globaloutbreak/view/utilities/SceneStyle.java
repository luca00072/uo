package globaloutbreak.view.utilities;

/**
 * Enumeration of scenes.
 */
public enum SceneStyle {

    /**
     * Initial menu scene.
     */
    INITIALMENU("Initial Menu", "layouts/MenuGui.fxml"),
    /**
     * Choose disease scene.
     */
    CHOOSEDISEASE("Choose Disease", "layouts/ChooseDisease.fxml"),
    /**
     * Choose disease name scene.
     */
    DISEASENAME("Choose disease name", "layouts/DiseaseNameGui.fxml"),
    /**
     * Tutorial scene.
     */
    TUTORIAL("Tutorial", "layouts/TutorialGui.fxml"),
    /**
     * Game Settings Scene.
     */
    SETTINGS("Settings", "layouts/GameSettings.fxml"),
      /**
     * Game Settings Scene.
     */
    MUTATION("Mutation", "layouts/Mutation.fxml"),
    /**
     * Map Scene.
     */
    MAP("Map", "layouts/MapGui.fxml"),
    /**
     * World Graph Scene.
     */
    WORLDGRAPH("World graph", "layouts/worldGraph.fxml"),
    /**
     * Cure Graph Scene.
     */
    CUREGRAPH("Cure graph", "layouts/cureGraph.fxml");

    private final String fxmlFile;
    private final String title;

    SceneStyle(final String title, final String fxmlFile) {
        this.title = title;
        this.fxmlFile = fxmlFile;
    }

    /**
     * @return the fxml file of the scene
     */
    public String getFxmlFile() {
        return this.fxmlFile;
    }

    /**
     * @return the fxml path of the scene
     */
    public String getTitle() {
        return this.title;
    }
}
