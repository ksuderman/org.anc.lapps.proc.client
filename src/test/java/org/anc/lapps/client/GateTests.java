package org.anc.lapps.client;

import org.anc.grid.data.masc.client.DataSourceClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.lappsgrid.api.DataSource;
import org.lappsgrid.discriminator.Types;

import javax.xml.rpc.ServiceException;

/**
 * @author Keith Suderman
 */
public class GateTests extends AbstractServiceTest
{
   private static final String SPLITTER = "lapps:GATE_SPLITTER";
   private static final String TOKENIER = "lapps:GATE_TOKENIZER";
   private static final String TAGGER = "lapps:GATE_TAGGER";

   private DataSource dataSource;

   @Before
   public void setup() throws ServiceException
   {
      dataSource = new DataSourceClient("http://localhost:8080/service_manager/invoker/lapps:MASC_TEXT", "operator1", "operator1");
   }

   @After
   public void teardown()
   {
      dataSource = null;
   }

   @Test
   public void testGateSplitter() throws ServiceException
   {
      long[] requires = { Types.GATE };
      long[] produces = { Types.GATE, Types.SENTENCE };
      testService(SPLITTER, requires, produces);
   }

   @Test
   public void testGateTokenizer() throws ServiceException
   {
      long[] requires = { Types.GATE, Types.SENTENCE };
      long[] produces = { Types.GATE, Types.SENTENCE, Types.TOKEN };
      testService(TOKENIER, requires, produces);
   }

   @Test
   public void testGateTagger() throws ServiceException
   {
      long[] requires = { Types.GATE, Types.SENTENCE, Types.TOKEN };
      long[] produces = { Types.GATE, Types.SENTENCE, Types.TOKEN, Types.POS };
      testService(TAGGER, requires, produces);
   }

}
