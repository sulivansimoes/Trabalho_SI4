package br.edu.univas.si.view.cadastrounidademedida;

import java.awt.BorderLayout;

import br.edu.univas.si.controller.unidademedida.ControllerAlterar;
import br.edu.univas.si.controller.unidademedida.ControllerExcluir;
import br.edu.univas.si.controller.unidademedida.ControllerIncluir;
import br.edu.univas.si.listeners.ButtonsListenersCadastro;
import br.edu.univas.si.model.to.UnidadeMedidaTO;
import br.edu.univas.si.view.defaultcomponents.ButtonsPanelCadastro;
import br.edu.univas.si.view.util.MyJFrame;

public class FramePrincipalUnidadeMedida extends MyJFrame {

	private static final long serialVersionUID = -7511419928508107918L;

	private ButtonsPanelCadastro buttonsPanel;
	private PanelTableUnidadeMedida tableUnidadeMedia;
	private ControllerIncluir controllerIncluir;
	private ControllerAlterar controllerAlterar;
	private ControllerExcluir controllerExcluir;
	
	public FramePrincipalUnidadeMedida() {
		super("Cadastro Unidade Medida");

		initialize();
		setExtendedState(MAXIMIZED_BOTH);
		pack();
		setLocationRelativeTo(null);
	}

	private void initialize() {
		add(getButtonsPanel(), BorderLayout.NORTH);
		add(getTableUnidadeMedia(), BorderLayout.CENTER);
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

	public PanelTableUnidadeMedida getTableUnidadeMedia(){
		if(tableUnidadeMedia==null){
			tableUnidadeMedia = new PanelTableUnidadeMedida();	
		}
		return tableUnidadeMedia;
	}
	
	private void incluiClicked(){
		controllerIncluir = new ControllerIncluir(this); //Chamando tela de inclusão passando refencia da principal
		controllerIncluir.initialize(); 
	}
	
	private void alteraClicked(){			
		controllerAlterar = new ControllerAlterar(this); //Chamando tela de alteração passando refencia da principal		
		controllerAlterar.initialize();
		controllerAlterar.populatePane(getRowSelected());
	}
	
	private void excluiClicked(){
		controllerExcluir = new ControllerExcluir(this); //Chamando tela de exclusão passando refencia da principal
		controllerExcluir.initialize();
		controllerExcluir.populatePane(getRowSelected());
	}
	
	private void sairClicked(){
		if(controllerIncluir!=null){
			controllerIncluir.close();	}
		if(controllerAlterar!=null){
			controllerAlterar.close();	}
		if(controllerExcluir!=null){
			controllerExcluir.close();	}
		this.dispose();
	}
	
	//pega registro da linha selecionada no JTable
	private UnidadeMedidaTO getRowSelected(){
		
		int linha = getTableUnidadeMedia().getTable().getSelectedRow();
		UnidadeMedidaTO unidade = new UnidadeMedidaTO();
		
		if(linha != -1){ 	//-1 é o flag quando nenhuma linha está selecionada.
			//Extrai conteudo da linha selecionada
			String codigo 	 = String.valueOf(getTableUnidadeMedia().getTable().getValueAt(linha, 0)); 
			String descricao = String.valueOf(getTableUnidadeMedia().getTable().getValueAt(linha, 1));
			
			unidade.setCodigo(codigo);
			unidade.setDescricao(descricao);
		}
		return unidade;
	}
	
	public static void main(String[] args) {
		setlookAndFeel(AERO);
		FramePrincipalUnidadeMedida f = new FramePrincipalUnidadeMedida();
		f.setVisible(true);
	}
}
