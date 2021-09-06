package br.edu.ufca.app;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class telaInicioController implements Initializable{
    @FXML
    private RadioButton botaoCliente;

    @FXML
    private ToggleGroup sistema;

    @FXML
    private RadioButton botaoFuncionario;

    @FXML
    private RadioButton botaoGerente;

    @FXML
    private Button botaoOk;
    
    
    
    void botaoOk() {
    	botaoOk.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e){
				// TODO Auto-generated method stub
		    	Parent newload;
				if (botaoCliente.isSelected()) {
					try {
						newload = FXMLLoader.load(getClass().getResource("TelaLogin.fxml"));
						Stage window = (Stage) botaoOk.getScene().getWindow();
				    	window.setScene(new Scene(newload));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else if (botaoFuncionario.isSelected()) {
					try {
						newload = FXMLLoader.load(getClass().getResource("TelaLoginSemCadastro.fxml"));
						Stage window = (Stage) botaoOk.getScene().getWindow();
				    	window.setScene(new Scene(newload));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else if (botaoGerente.isSelected()) {
					try {
						newload = FXMLLoader.load(getClass().getResource("TelaLoginSemCadastro.fxml"));
						Stage window = (Stage) botaoOk.getScene().getWindow();
				    	window.setScene(new Scene(newload));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}	
				}
			}
    		
    	});
    }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		botaoOk();
	}

}
