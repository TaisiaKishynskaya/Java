package com.example.studentgroupapp;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import com.example.studentgroupapp.model.Person;

public class MainApp extends Application {
    private Stage primaryStage;
    private BorderPane rootLayout;

    private ObservableList<Person> personData = FXCollections.observableArrayList();

    public MainApp(){
        personData.add(new Person("Петро","П'яточкін"));
        personData.add(new Person("Іван","Зайців"));
        personData.add(new Person("Катерина","Васильченка"));
        personData.add(new Person("Ольга","Жук"));
        personData.add(new Person("Людміла","Алексєєва"));
        personData.add(new Person("Даніл","Кац"));
        personData.add(new Person("Євген","Васнецов"));
        personData.add(new Person("Дмитро","Жуликів"));
        personData.add(new Person("Мрат","Алібов"));
        personData.add(new Person("Martin","Mueller"));
    }
    /**
     * Повертає дані у вигляді спостережуваного списку студентів.
     * @return
     */
    public ObservableList<Person> getPersonData() {
        return personData;
    }

    @Override
    public void start(Stage stage) throws IOException {
        this.primaryStage = stage;
        this.primaryStage.setTitle("StudentGroupApp");
        initRootLayout();
        showPersonOverview();
    }
    /**
     * Ініціалізує кореневий макет.
     */
    public void initRootLayout(){
        FXMLLoader fxmlLoader = new FXMLLoader();
        // Завантажуємо кореневий макет з файлу fxml.
        fxmlLoader.setLocation(getClass().getResource("/com/example/studentgroupapp/RootLayout.fxml"));
        try {
            rootLayout = (BorderPane) fxmlLoader.load();
//Відображаємо сцену, яка містить кореневий макет.
            Scene scene=new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * Показує у кореневому макеті відомості про студентів.
     */
    public void showPersonOverview(){
        FXMLLoader fxmlLoader = new FXMLLoader();
        // Завантажуємо відомості про студентів.
        fxmlLoader.setLocation(MainApp.class.getResource("/com/example/studentgroupapp/PersonOverview.fxml"));

        try {
            AnchorPane personOverview = (AnchorPane) fxmlLoader.load();
// Поміщаємо відомості про студентів до центру кореневого макета.
            rootLayout.setCenter(personOverview);
            PersonOverviewController controller=fxmlLoader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean showPersonEditDialog(Person person) {
        try{
// Завантажуємо файл fxml і створюємо нову сцену для діалогового вікна.
            FXMLLoader loader=new FXMLLoader();

            loader.setLocation(MainApp.class.getResource("/com/example/studentgroupapp/PersonEditDialog.fxml"));
            AnchorPane page= (AnchorPane)loader.load();
//Створюємо діалогове вікно Stage.
            Stage dialogStage=new Stage();
            dialogStage.setTitle("Edit Person");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene=new Scene(page);
            dialogStage.setScene(scene);
// Передаємо студента до контролера.
            PersonEditDialogController controller=loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setPerson(person);
// Відображаємо діалогове вікно та чекаємо, поки користувач його не закриє
            dialogStage.showAndWait();
            return controller.isOkClicked();
        }catch(IOException e) {e.printStackTrace(); return false;
        }
    }

    public boolean showDeleteConfirmationDialog() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/studentgroupapp/DeleteConfirmationDialog.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        DeleteConfirmationDialogController controller = loader.getController();
        Stage dialogStage = new Stage();
        controller.setDialogStage(dialogStage);

// Открываем диалог
        Scene scene = new Scene(root);
        dialogStage.setScene(scene);
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.showAndWait();

// После закрытия диалога, проверяем, подтверждено ли удаление
        return controller.isDeleteConfirmed();
    }
            /**
             * Повертає головну сцену.
             * @return
             */
    public Stage getPrimaryStage(){
        return primaryStage;
    }
    public static void main(String[] args) {
        launch();
    }
}