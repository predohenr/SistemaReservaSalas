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
import javafx.stage.Stage;

public class telaFuncionarioController implements Initializable {
    @FXML
    private Button botaoVoltar;
    @FXML
    private Button botaoDevolverSala;
    @FXML
    private Button botaoAlugarSala;
    @FXML
    private Button botaoGerenciarSalas;
    
    void botaoGerenciar() {
    	botaoGerenciarSalas.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				// TODO Auto-generated method stub
		    	Parent newload;
				try {
					newload = FXMLLoader.load(getClass().getResource("TelaVaziaFuncionario.fxml"));
			    	Stage window = (Stage) botaoGerenciarSalas.getScene().getWindow();
			    	window.setScene(new Scene(newload));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
    		
    	});
    }
    
    void botaoAlugar() {
    	botaoAlugarSala.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				// TODO Auto-generated method stub
		    	Parent newload;
				try {
					newload = FXMLLoader.load(getClass().getResource("AlugarSalaFuncionario.fxml"));
			    	Stage window = (Stage) botaoAlugarSala.getScene().getWindow();
			    	window.setScene(new Scene(newload));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
    		
    	});
    }
    
    void botaoDevolver() {
    	botaoDevolverSala.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				// TODO Auto-generated method stub
		    	Parent newload;
				try {
					newload = FXMLLoader.load(getClass().getResource("DevolverSalaFuncionario.fxml"));
			    	Stage window = (Stage) botaoDevolverSala.getScene().getWindow();
			    	window.setScene(new Scene(newload));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
    		
    	});
    }
    void botaoVoltar() {
    	botaoVoltar.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				// TODO Auto-generated method stub
		    	Parent newload;
				try {
					newload = FXMLLoader.load(getClass().getResource("TelaLoginSemCadastro.fxml"));
			    	Stage window = (Stage) botaoVoltar.getScene().getWindow();
			    	window.setScene(new Scene(newload));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
    		
    	});
    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		botaoGerenciar();
		botaoAlugar();
		botaoDevolver();
		botaoVoltar();
	}
	
}
