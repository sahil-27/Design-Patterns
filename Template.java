/**
 * Template Method Pattern is a behavioral design pattern that defines the skeleton of an algorithm
 * in the superclass but lets subclasses override specific steps of the algorithm without changing its structure.
 */


abstract class ReportGenerator {
	public final void generateReport(){
		createHeader();
		bodyContent();
		if(displayCharts()){
			initializeCharts();
		}
		initializeFooter();
		exportFile();
	}

	protected final void createHeader(){
		System.out.println("Creating Header...");
	}

	protected abstract void bodyContent();

	protected boolean displayCharts(){
		return false;
	}

	protected void initializeCharts(){
		System.out.println("initializing charts");
	}

	protected final void initializeFooter(){
		System.out.println("creating footer");
	}

	protected abstract void exportFile();
}

class PdfReport extends ReportGenerator {
	@Override
	protected void bodyContent(){
		System.out.println("creating body");
	}

	@Override
	protected void exportFile(){
		System.out.println("exporting file in pdf format");
	}

	@Override
	protected boolean displayCharts(){
		return true;
	}
}

class CSVReport extends ReportGenerator {
	@Override
	protected void bodyContent(){
		System.out.println("creating body");
	}

	@Override
	protected void exportFile(){
		System.out.println("exporting file in CSV format");
	}
}

class XLSXReport extends ReportGenerator {
	@Override
	protected void bodyContent(){
		System.out.println("creating body");
	}

	@Override
	protected void exportFile(){
		System.out.println("exporting file in XLXS format");
	}
}

public class Main {
	public static void main(String[] args){
		ReportGenerator report = new PdfReport();
		report.generateReport();

		report = new CSVReport();
		report.generateReport();

		report = new XLSXReport();
		report.generateReport();
	}
}