package org.anc.lapps.client;

import org.junit.Test;
import org.lappsgrid.api.WebService;

import javax.xml.rpc.ServiceException;

/**
 * @author Keith Suderman
 */
public class OpenNlpTests extends AbstractServiceTest
{
   private static final String SPLITTER = "lapps:OPENNLP_SPLITTER";
   private static final String TOKENIZER = "lapps:OPENNLP_TOKENIZER";
   private static final String TAGGER = "lapps:OPENNLP_TAGGER";

   @Test
   public void testOpenNlpSplitter() throws ServiceException
   {
      WebService service = new RemoteService(server, SPLITTER);
      print("OpenNLP splitter requires", service.requires());
      print("OpenNLP splitter produces", service.produces());
   }

   @Test
   public void testOpenNlpTokenizer() throws ServiceException
   {
      WebService service = new RemoteService(server, TOKENIZER);
      print("OpenNLP tokenizer requires", service.requires());
      print("OpenNLP tokenizer produces", service.produces());
   }

   @Test
   public void testOpenNlpTagger() throws ServiceException
   {
      WebService service = new RemoteService(server, TAGGER);
      print("OpenNLP tagger requires", service.requires());
      print("OpenNLP tagger produces", service.produces());
   }
}
