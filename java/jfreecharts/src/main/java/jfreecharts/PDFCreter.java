/**
 * 
 */
package jfreecharts;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * @author ntanwa
 *
 */
public class PDFCreter {

	/**
	 * @param args
	 * @throws DocumentException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException, DocumentException {
		Document document = new Document();
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("PDF.pdf"));
		document.open();

		Font font = FontFactory.getFont("C:\\WINDOWS\\Fonts\\mangal.ttf", BaseFont.IDENTITY_H, true);

		PdfPTable table = new PdfPTable(1);
		table.setWidthPercentage(100);
		PdfPCell customerLblCell = new PdfPCell(new Phrase("जन्मतिथि अंग्रेजी का आसमान", font));

		table.addCell(customerLblCell);
		document.add(table);

		document.close();
		
		/*Document document = new Document();
		PdfWriter.getInstance(document, new FileOutputStream("iTextHelloWorld.pdf"));
		 
		document.open();
		Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
		Chunk chunk = new Chunk("Hello World जन्मतिथि", font);
		 
		document.add(chunk);
		document.close();*/
	}

}
