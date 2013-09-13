package org.anc.lapps.client;

import org.junit.Test;
import org.lappsgrid.api.WebService;

import javax.xml.rpc.ServiceException;

/**
 * @author Keith Suderman
 */
public class StanfordTests extends AbstractServiceTest
{
   private static final String SPLITTER = "lapps:STANFORD_SPLITTER";
   private static final String TOKENIZER = "lapps:STANFORD_TOKENIZER";
   private static final String TAGGER = "lapps:STANFORD_TAGGER";

   @Test
   public void testStanfordSplitter() throws ServiceException
   {
      WebService service = new RemoteService(server, SPLITTER);
      print("Stanford splitter requires", service.requires());
      print("Stanford splitter produces", service.produces());
   }

   @Test
   public void testStanfordTokenizer() throws ServiceException
   {
      WebService service = new RemoteService(server, TOKENIZER);
      print("Stanford tokenizer requires", service.requires());
      print("Stanford tokenizer produces", service.produces());
   }

   @Test
   public void testStanfordTagger() throws ServiceException
   {
      WebService service = new RemoteService(server, TAGGER);
      print("Stanford tagger requires", service.requires());
      print("Stanford tagger produces", service.produces());
   }
}
