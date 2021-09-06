package br.edu.ufca.app;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class telaCriarClienteGerenteController implements Initializable{

    @FXML
    private Button botaoVoltar;

    @FXML
    private TextField textoNome;

    @FXML
    private TextField textoCPF;

    @FXML
    private Button botaoCadastro;

    @FXML
    private Label labelErro;

    public boolean consultar(RepositorioClientes repo, String nome, String cpf) {
    	for (int i = 0; i<repo.clientes.size();i++) {
    		boolean achou = false;
    		if(repo.clientes.get(i).getNome().equals(nome) ||
    				repo.clientes.get(i).getCpf().equals(cpf)) {
    			achou = true;
    			return achou;
    		} else {
    			achou = false;
    		}
    	}
    	return false;
    }
    
    void botaoCadastro(RepositorioClientes repo) {
    	botaoCadastro.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				// TODO Auto-generated method stub
				String nome, cpf;
				nome = textoNome.getText();
				cpf = textoCPF.getText();
				boolean existe = consultar(repo, nome, cpf);
				if(!existe) {
					Cliente cliente = new Cliente(nome, cpf);
		    		repo.clientes.add(cliente);
		    		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("clientes.ser"))) {
		    			oos.writeObject(repo);
		    		} catch (IOException ioe) {
		    			ioe.printStackTrace();
		    		}
				    Parent newload;
					try {
						newload = FXMLLoader.load(getClass().getResource("TelaLogin.fxml"));
				    	Stage window = (Stage) botaoVoltar.getScene().getWindow();
				    	window.setScene(new Scene(newload));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
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
					newload = FXMLLoader.load(getClass().getResource("TelaGerente.fxml"));
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
		botaoCadastro(repo);
		botaoVoltar();
	}
}