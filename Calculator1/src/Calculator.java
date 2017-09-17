import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Calculator {

	protected Shell shell;
	private Text firstNumber;
	private Text secondNumber;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Calculator window = new Calculator();
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
		
		firstNumber = new Text(shell, SWT.BORDER);
		firstNumber.setBounds(45, 53, 107, 21);
		
		secondNumber = new Text(shell, SWT.BORDER);
		secondNumber.setBounds(45, 109, 107, 21);
		
		Label lblFirstNumber = new Label(shell, SWT.NONE);
		lblFirstNumber.setBounds(45, 32, 107, 15);
		lblFirstNumber.setText("First Number");
		
		Label lblSecondNumber = new Label(shell, SWT.NONE);
		lblSecondNumber.setBounds(45, 88, 107, 15);
		lblSecondNumber.setText("Second Number");
		
		final Label answerLabel = new Label(shell, SWT.NONE);
		answerLabel.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.BOLD));
		answerLabel.setBounds(45, 196, 202, 25);
		answerLabel.setText("The answer is:   ");
		
		Button addButton = new Button(shell, SWT.NONE);
		addButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int number1,number2;
				try{
					number1=Integer.parseInt(firstNumber.getText());
				}
				catch(Exception exc)
				{
					MessageDialog.openError(shell, "Error", "bad first number");
					return;
				}
				try{
					number2=Integer.parseInt(secondNumber.getText());
				}
				catch(Exception exc)
				{
					MessageDialog.openError(shell, "Error", "bad second number");
					return;
				}
				int answer=number1+number2;
				answerLabel.setText("The answer is:"+answer);
			}
		});
		addButton.setToolTipText("Add");
		addButton.setBounds(45, 147, 75, 25);
		addButton.setText("+");
		
		Button substractButton = new Button(shell, SWT.NONE);
		substractButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int number1,number2;
				try{
					number1=Integer.parseInt(firstNumber.getText());
				}
				catch(Exception exc)
				{
					MessageDialog.openError(shell, "Error", "bad first number");
					return;
				}
				try{
					number2=Integer.parseInt(secondNumber.getText());
				}
				catch(Exception exc)
				{
					MessageDialog.openError(shell, "Error", "bad second number");
					return;
				}
				int answer=number1-number2;
				answerLabel.setText("The answer is:"+answer);
			}
		});
		substractButton.setToolTipText("substract");
		substractButton.setBounds(146, 147, 75, 25);
		substractButton.setText("-");
		
		

	}
}
