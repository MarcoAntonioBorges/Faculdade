import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;
import org.apache.axis2.engine.AxisError;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import br.com.fiap.loja.bo.EstoqueBOStub;
import br.com.fiap.loja.bo.EstoqueBOStub.Camiseta;
import br.com.fiap.loja.bo.EstoqueBOStub.ConsultaProduto;
import br.com.fiap.loja.bo.EstoqueBOStub.ConsultaProdutoResponse;

public class Client {

	protected Shell shell;
	private Text txtMsg;
	private Label lblResultado;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Client window = new Client();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(522, 328);
		shell.setText("SWT Application");
		
		Label lblDigiteMsg = new Label(shell, SWT.NONE);
		lblDigiteMsg.setBounds(10, 13, 89, 15);
		lblDigiteMsg.setText("Digite o COD.:");
		
		txtMsg = new Text(shell, SWT.BORDER);
		txtMsg.setBounds(120, 10, 76, 25);
		
		Button btnEnviar = new Button(shell, SWT.NONE);
		btnEnviar.addSelectionListener(new SelectionAdapter(){
			@Override
			public void widgetSelected(SelectionEvent e) {
				int cod = Integer.parseInt(txtMsg.getText());
				
				EstoqueBOStub stub = null;
				try {
					stub = new EstoqueBOStub();
				} catch (AxisFault e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
					MessageDialog.openInformation(shell, "ERROR", "Produto não encontrado");
				}
				
				ConsultaProduto consulta = new ConsultaProduto();
				consulta.setCodigo(cod);

				ConsultaProdutoResponse response = null;
				try {
					response = stub.consultaProduto(consulta);
					
					Camiseta camiseta = response.get_return();
					
					
					txtMsg.setText("");
					lblResultado.setText(camiseta.getDesc());
					
					MessageDialog.openInformation(shell, "Resultado", camiseta.getAll());
					
				}catch(AxisFault err) {
					MessageDialog.openInformation(shell, "ERROR", "Produto não encontrado");
				}
				catch (RemoteException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
					MessageDialog.openInformation(shell, "ERROR", "Sistema fora do ar");
				}
			}
		});
		btnEnviar.setBounds(10, 62, 186, 25);
		btnEnviar.setText("Pesquisa");
		
		lblResultado = new Label(shell, SWT.NONE);
		lblResultado.setText("0");
		lblResultado.setBounds(317, 20, 179, 67);

	}
}
