package br.edu.univas.si.view.cadastrousuario;

import java.awt.BorderLayout;

import br.edu.univas.si.controller.usuario.ControllerAlterar;
import br.edu.univas.si.controller.usuario.ControllerIncluir;
import br.edu.univas.si.listeners.ButtonsListenersCadastro;
import br.edu.univas.si.model.to.UsuarioTO;
import br.edu.univas.si.view.defaultcomponents.ButtonsPanelCadastro;
import br.edu.univas.si.view.util.MyJFrame;

public class FramePrincipalUsuario extends MyJFrame {

	private static final long serialVersionUID = -6140725584051515117L;

	private ButtonsPanelCadastro buttonsPanel;
	private PanelTableUsuario tableUsuario;
	private ControllerIncluir controllerIncluir;
	private ControllerAlterar controllerAlterar;
	
	public FramePrincipalUsuario() {
		super("Cadastro usuário");

		initialize();
		setExtendedState(MAXIMIZED_BOTH);
		pack();
		setLocationRelativeTo(null);
	}

	private void initialize() {
		add(getButtonsPanel(), BorderLayout.NORTH);
		add(getTableUsuario(), BorderLayout.CENTER);
	}

	private ButtonsPanelCadastro getButtonsPanel() {
		if (buttonsPanel == null) {
			buttonsPanel = new ButtonsPanelCadastro();
			buttonsPanel.addButtonsListener(new ButtonsListenersCadastro() {

				@Override
				public void incluiPerformed() {
					incluiClicked();

				}

				@Override
				public void excluiPerformed() {
					excluiClicked();

				}

				@Override
				public void alteraPerformed() {
					alteraClicked();

				}

				@Override
				public void SairPerformed() {
					sairClicked();

				}
			});
		}
		return buttonsPanel;
	}

	public PanelTableUsuario getTableUsuario() {
		if(tableUsuario==null){
			tableUsuario = new PanelTableUsuario();
		}
		
		return tableUsuario;
	}
	
	private void incluiClicked(){
		controllerIncluir = new ControllerIncluir(this);
		controllerIncluir.initialize();
	}
	
	private void alteraClicked(){
		controllerAlterar = new ControllerAlterar(this);
		controllerAlterar.initialize();
		controllerAlterar.populatePanel(getRowSelected());
	}
	
	private void excluiClicked(){
		//TODO
	}
	
	private void sairClicked(){
		if(controllerIncluir!=null){
			controllerIncluir.close();	}
		if(controllerAlterar!=null){
			controllerAlterar.close();	}
		
		this.dispose();
	}
	
	//pega registro da linha selecionada no JTable
	private UsuarioTO getRowSelected(){
		
		int linha = getTableUsuario().getTable().getSelectedRow();
		UsuarioTO usuario = new UsuarioTO();
		
		if(linha != -1){ 	//-1 é o flag quando nenhuma linha está selecionada.
//			FIXME: olhar null pointer
			//Extrai conteudo da linha selecionada
			String cpf  = String.valueOf(getTableUsuario().getTable().getValueAt(linha, 0));
			String nome = String.valueOf(getTableUsuario().getTable().getValueAt(linha, 1));
		//	String senha = String.valueOf(getTableUsuario().getTable().getValueAt(linha, 2));
			boolean administrador = Boolean.valueOf(new String(String.valueOf(getTableUsuario().getTable().getValueAt(linha, 3))));
			boolean caixa = Boolean.valueOf(new String(String.valueOf(getTableUsuario().getTable().getValueAt(linha, 2))));
			
			//Monta TO
			usuario.setCpf(cpf);
			usuario.setNome(nome);
		//	usuario.setSenha(senha);
			usuario.setGerente(administrador);
			usuario.setCaixa(caixa);
		}
		return usuario;
	}
}
