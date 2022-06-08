package com.ujc.eswa.mensalidade.aeit.service;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.ujc.eswa.mensalidade.aeit.model.Pagamento;

public class PDFGeneratorPayments {

	private List<Pagamento> paymentsList;

	public void generate(HttpServletResponse response) throws DocumentException, IOException {
		Document document = new Document(PageSize.A4);

		PdfWriter.getInstance(document, response.getOutputStream());

		document.open();

		Font fontTitle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		fontTitle.setSize(20);
		fontTitle.setColor(Color.BLUE);

		Paragraph paragraph = new Paragraph("List Of Payments", fontTitle);

		paragraph.setAlignment(Paragraph.ALIGN_CENTER);

		document.add(paragraph);

		PdfPTable table = new PdfPTable(3);
		table.setWidthPercentage(100f);
		table.setWidths(new int[] { 3, 3, 3 });
		table.setSpacingBefore(10);

		PdfPCell cell = new PdfPCell();

		cell.setBackgroundColor(CMYKColor.BLUE);
		cell.setPadding(5);

		Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		font.setColor(CMYKColor.WHITE);

		cell.setPhrase(new Phrase("Data Pagamento", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Estado", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Nome Estudante", font));
		table.addCell(cell);

		for (Pagamento pagamento : paymentsList) {
			table.addCell(pagamento.getDataPagamento());
			/*
			 * 
			 * status de pagamento 0-pago 1-nao paga 2-incompleta
			 */
			switch (pagamento.getStatus().toString()) {
			case "0":
				table.addCell("Paga");
				break;
			case "1":
				table.addCell("Nao Paga");

				break;
			case "2":
				table.addCell("Incompleta");

				break;

			default:
				break;
			}
//			table.addCell(String.valueOf(pagamento.getStatus()));
			table.addCell(pagamento.getEstudante().getNome());
		}

		document.add(table);

		document.close();
	}

	public List<Pagamento> getPaymentsList() {
		return paymentsList;
	}

	public void setPaymentsList(List<Pagamento> paymentsList) {
		this.paymentsList = paymentsList;
	}

}
