import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

public class TelaConsultaCorreios {

	protected Shell shell;
	private Text txtOrigem;
	private Text text;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			TelaConsultaCorreios window = new TelaConsultaCorreios();
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
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		Label lblOrigem = new Label(shell, SWT.NONE);
		lblOrigem.setBounds(10, 10, 55, 15);
		lblOrigem.setText("Origem");
		
		txtOrigem = new Text(shell, SWT.BORDER);
		txtOrigem.setBounds(80, 4, 76, 21);
		
		Label lblDestino = new Label(shell, SWT.NONE);
		lblDestino.setBounds(10, 48, 55, 15);
		lblDestino.setText("Destino");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(80, 48, 76, 21);

	}
}
