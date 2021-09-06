package br.edu.ufca.app;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import br.edu.ufca.repositorios.RepositorioClientes;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class deletarClienteGerenteController implements Initializable{
    @FXML
    private ComboBox<String> clientes;
    @FXML
    private Button botaoDeletar;
    @FXML
    private Button botaoVoltar;
    
    private ArrayList<String> clientesdisp = new ArrayList<>();
    private ObservableList<String> obsclientes;

    void botaoDeletar(RepositorioClientes repo) {
    	botaoDeletar.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				// TODO Auto-generated method stub
				boolean a = false;
				String comboboxvalue = clientes.getSelectionModel().getSelectedItem();
				for(int i=0;i<repo.clientes.size();i++) {
					if(repo.clientes.get(i).getNome().equals(comboboxvalue)) {
						repo.clientes.remove(i);
						a = true;
						break;
					}
				}
				if(a) {
					try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("clientes.ser"))) {
						oos.writeObject(repo);
					} catch (IOException ioe) {
						ioe.printStackTrace();
					}
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
			}
    		
    	});
    }  
    
    
    void botaoVoltar(RepositorioClientes repo) {
    	botaoVoltar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				// TODO Auto-generated method stub
				try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("clientes.ser"))) {
					oos.writeObject(repo);
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}
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
    
    void carregarClientes(RepositorioClientes repo) {
    	for (int i=0; i<repo.clientes.size();i++){
    			clientesdisp.add(repo.clientes.get(i).getNome());
    	}
    	obsclientes = FXCollections.observableArrayList(clientesdisp);
    	clientes.setItems(obsclientes);
    }
  
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		RepositorioClientes repo = new RepositorioClientes();
		try (ObjectInputStream oos = new ObjectInputStream(new FileInputStream("clientes.ser"))) {
			repo = (RepositorioClientes) oos.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		carregarClientes(repo);
    	botaoDeletar(repo);
    	botaoVoltar(repo);
	}

}
