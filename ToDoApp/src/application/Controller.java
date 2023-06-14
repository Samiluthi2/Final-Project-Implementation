package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;


public class Controller {
/*The Simple implementations will be adding tasks to a 
 * List View, and deleting it whether it be by just deleting it
 * or from completing the task. 
 * 
 * I also implemented a way to just erase all tasks and have an 
 * error notice for if user tries to delete without selecting and/or
 * if they try to clear all when there are no tasks to clear.
 */
	
	@FXML
	private Button myButton;
	
	@FXML 
	private Button DeleteTask;
	
	@FXML
	private Button ClearAllTasks;
	
	@FXML
	private Button DoneTasks;
	
	@FXML
	private Label myLabel;
	
	@FXML
	private Label ErrorLabel; //This will be used to communicate
	//with the user about errors or invalid inputs

	@FXML
	private ListView<String> myListView;

	@FXML
	private TextField myTextField;
	
	/*Below is my attempt to save and load the information
	 * from listview onto next session, but unfortunately 
	 * I'm having difficulties.
	 */
	
	/*@FXML
	public static String toDoPath;
	
	File ToDoFile = new File("ToDoFile.txt")
	if (ToDoFile.exists()){
		try{
			Scanner scan = new Scanner(ToDoFile);
			toDoPath = scan.nextLine();
			scan.close();
			ToDoFile = new File(toDoPath);
			if(ToDoFile.exists()){
				InputStream input = new FileInputStream(ToDoFile);
				myListView.setItems(ToDoFile);
			}
		}catch(Exception e){
			toDoPath = null;
		}
	}
	
	@FXML
	public void save(Event e){
		try{
			PrintStream out = new PrintStream(new File("ToDoFile.txt"));
			if(toDoPath != null){
				out.print(toDoPath);
			}
			out.println();
		}catch(Exception ex){
		}
	}*/
	
	@FXML
	public void addTask(ActionEvent e) {
		myListView.getItems().add(myTextField.getText());
	}
	
	public void deleteTask(ActionEvent e) {
		try {
			if(myListView.getItems().isEmpty()) {
				ErrorLabel.setText("You Have No Tasks To Delete");
			}else {
			int selectedTask = myListView.getSelectionModel().getSelectedIndex();
			myListView.getItems().remove(selectedTask);}
		}catch(RuntimeException rte) {
			ErrorLabel.setText("First Select Task, Then Delete");
		}
	}
	public void clear(ActionEvent e) {
		if(myListView.getItems().isEmpty())
			ErrorLabel.setText("You Have No Tasks To Clear");
		myListView.getItems().clear();
	}
	
	public void done(ActionEvent e){
		
		try{
			if(myListView.getItems().isEmpty()) {
			ErrorLabel.setText("You Have No Tasks To Be Done With");
			}else {
			int selectedTask = myListView.getSelectionModel().getSelectedIndex();
			myListView.getItems().remove(selectedTask);
			ErrorLabel.setTextFill(javafx.scene.paint.Color.GREEN);
			ErrorLabel.setText("Congratulations!");}
		}catch(RuntimeException rte) {
			ErrorLabel.setText("First Select Task, Then Press Done");
		}
	}
	
	
	
}
