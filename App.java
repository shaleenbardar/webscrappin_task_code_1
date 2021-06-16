package com.shaleen.scrapping.scrapping;
import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

class myscrapy
{
	public static void main( String[] args ) throws IOException
	{    
    //fetching web page via HTTP	
    Document page = Jsoup.connect("https://prefeitura.pbh.gov.br/saude/licitacao/pregao-eletronico-151-2020").get();
    	
    //selecting all hyperlinks
    Elements pageElements = page.select("a[href]"); //This will fetch all the anchor tags that are there in webpage
    //Creating an array
    ArrayList<String> hyperLinks = new ArrayList<String>();
    //Selecting the Publication date 
    Element publicationDate = page.selectFirst("#block-views-block-view-noticia-pbh-block-5 > div > div > div > div > div > div.views-field.views-field-nothing > span > span:nth-child(1)");
    System.out.println(publicationDate.text()); // Output - > 02/02/2021
    //Selecting Bidding date
    Element biddingDate = page.selectFirst("#block-views-block-view-noticia-pbh-block-5 > div > div > div > div > div > div.views-field.views-field-nothing > span > span:nth-child(19)");
    System.out.println(biddingDate.text());//Output - > 02/18/2021
    //selecting the Object value
    Element object = page.selectFirst("#block-views-block-view-noticia-pbh-block-5 > div > div > div > div > div > div.views-field.views-field-nothing > span > p:nth-child(6)");
    System.out.println(object.text());//Output -> Price Registration for a period of 12 months, for the purchase of galvanized clamp
    //iterating and extracting
    //Printing the links along with the text associated with it
    for (Element e:pageElements) {
      hyperLinks.add("Text: " + e.text());
      hyperLinks.add("Link: " + e.attr("href"));
    }
    //Printing the hyperlinks
    for (String s : hyperLinks) {
      System.out.println(s);
    }
  }
}
