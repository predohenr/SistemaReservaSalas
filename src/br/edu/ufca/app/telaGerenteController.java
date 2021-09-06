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

public class telaGerenteController implements Initializable{
    @FXML
    private Button botaoVoltar;
    @FXML
    private Button botaoGerenciarSalas;
    @FXML
    private Button botaoAlugarSala;
    @FXML
    private Button botaoDevolverSala;
    @FXML
    private Button botaoCriarFuncionario;
    @FXML
    private Button botaoDeletarFuncionario;
    @FXML
    private Button botaoCriarCliente;
    @FXML
    private Button botaoDeletarCliente;
    
    void botaoCriarCliente() {
    	botaoCriarCliente.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				// TODO Auto-generated method stub
		    	Parent newload;
				try {
					newload = FXMLLoader.load(getClass().getResource("TelaCriarClienteGerente.fxml"));
			    	Stage window = (Stage) botaoCriarCliente.getScene().getWindow();
			    	window.setScene(new Scene(newload));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
    		
    	});
    }
    
    void botaoDeletarCliente() {
    	botaoDeletarCliente.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				// TODO Auto-generated method stub
		    	Parent newload;
				try {
					newload = FXMLLoader.load(getClass().getResource("DeletarClienteGerente.fxml"));
			    	Stage window = (Stage) botaoDeletarCliente.getScene().getWindow();
			    	window.setScene(new Scene(newload));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
    		
    	});
    }
    
    void botaoGerenciar() {
    	botaoGerenciarSalas.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				// TODO Auto-generated method stub
		    	Parent newload;
				try {
					newload = FXMLLoader.load(getClass().getResource("TelaVaziaGerente.fxml"));
			    	Stage window = (Stage) botaoGerenciarSalas.getScene().getWindow();
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
    
    void botaoCriarFuncionario() {
    	botaoCriarFuncionario.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				// TODO Auto-generated method stub
		    	Parent newload;
				try {
					newload = FXMLLoader.load(getClass().getResource("telaCadastroFuncionario.fxml"));
			    	Stage window = (Stage) botaoCriarFuncionario.getScene().getWindow();
			    	window.setScene(new Scene(newload));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
    		
    	});
    }
    
    void botaoDeletarFuncionario() {
    	botaoDeletarFuncionario.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				// TODO Auto-generated method stub
		    	Parent newload;
				try {
					newload = FXMLLoader.load(getClass().getResource("DeletarFuncionarioGerente.fxml"));
			    	Stage window = (Stage) botaoCriarFuncionario.getScene().getWindow();
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
					newload = FXMLLoader.load(getClass().getResource("AlugarSalaGerente.fxml"));
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
					newload = FXMLLoader.load(getClass().getResource("DevolverSalaGerente.fxml"));
			    	Stage window = (Stage) botaoDevolverSala.getScene().getWindow();
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
		botaoCriarFuncionario();
		botaoDeletarFuncionario();
		botaoCriarCliente();
		botaoDeletarCliente();
		botaoGerenciar();
		botaoVoltar();
		botaoAlugar();
		botaoDevolver();
	}
}
