package br.edu.ufca.app;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;

import br.edu.ufca.basicas.Cliente;
import br.edu.ufca.repositorios.RepositorioClientes;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class telaLoginController implements Initializable{
	@FXML
    private Button botaoVoltar;
    @FXML
    private TextField textoNome;
    @FXML
    private TextField textoCPF;
    @FXML
    private Button botaoEntrar;
    @FXML
    private Button botaoCadastro;
  
    public boolean consultar(RepositorioClientes repo, String nome, String cpf) {
    	for (Cliente element : repo.clientes) {
    		if(element.getNome().equals(nome) &&
    				element.getCpf().equals(cpf)) {
    			return true;
    		} else {
    			return false;
    		}
    	}
    	return false;
    }
    
    void botaoEntrar(RepositorioClientes repo) {
    	botaoEntrar.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				// TODO Auto-generated method stub
				boolean login = consultar(repo, textoNome.getText(), textoCPF.getText());
				//System.out.print(login);
				if(login == true) {
			    	Parent newload;
					try {
						newload = FXMLLoader.load(getClass().getResource("TelaCliente.fxml"));
				    	Stage window = (Stage) botaoEntrar.getScene().getWindow();
				    	window.setScene(new Scene(newload));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
    		
    	});
    }
    void botaoCadastro(){
    	botaoCadastro.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				// TODO Auto-generated method stub
		    	Parent newload;
				try {
					newload = FXMLLoader.load(getClass().getResource("TelaCadastro.fxml"));
			    	Stage window = (Stage) botaoCadastro.getScene().getWindow();
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
					newload = FXMLLoader.load(getClass().getResource("TelaInicio.fxml"));
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
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		RepositorioClientes repo = new RepositorioClientes();
		try (ObjectInputStream oos = new ObjectInputStream(new FileInputStream("clientes.ser"))) {
			repo = (RepositorioClientes) oos.readObject();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (ClassNotFoundException ioe) {
			// TODO Auto-generated catch block
			ioe.printStackTrace();
		}
		botaoVoltar();
		botaoEntrar(repo);
		botaoCadastro();
	}

}
