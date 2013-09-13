package org.anc.lapps.client;

import org.anc.lapps.servers.Server;
import org.lappsgrid.api.WebService;
import org.lappsgrid.discriminator.DiscriminatorRegistry;

import javax.xml.rpc.ServiceException;

import static org.junit.Assert.assertTrue;

/**
 * @author Keith Suderman
 */
public class AbstractServiceTest
{
   protected Server server = Servers.LOCALHOST;

   protected void testService(String name, long[] requires, long[] produces) throws ServiceException
   {
      System.out.println("Testing service " + name);
      WebService service = new RemoteService(server, name);
      assertTrue(satisfies(service.requires(), requires));
      assertTrue(satisfies(service.produces(), produces));
   }

//   protected void testServiceRequires(WebService service, long[] expected) throws ServiceException
//   {
//      long[] actual = service.requires();
//      print("Requires", actual);
//      satisfies(actual, expected);
//   }
//
//   protected void testServiceProduces(WebService service, long[] expected) throws ServiceException
//   {
//      long[] actual = service.produces();
//      print("Produces", actual);
//      satisfies(actual, expected);
//   }

   protected void print(String heading, long [] types)
   {
      System.out.println(heading);
      for (long type : types)
      {
         String name = DiscriminatorRegistry.get(type);
         System.out.println("\t" + name + " (" + type + ")");
      }
      System.out.println();
   }

   /** Returns true if the <em>actual</em> array contains all the
    *  items in the <em>expected</em>. This method is used to test
    *  if the types produced by one service are suitable inputs to
    *  another service.
    *
    * @param expected an array of items that must be present in the
    *                 <em>actual</em> array.
    * @param actual an array of {@link org.lappsgrid.discriminator.core.Discriminator Discriminator}
    *               values.
    * @return true if every value in the <em>expected</em> array is
    * also present in the <em>actual</em> array. Returns false otherwise.
    */
   protected boolean satisfies(long[] actual, long[] expected)
   {
      // The actual array MUST contain each of the expected items.
      for (long item : expected)
      {
         if (!contains(actual, item))
         {
//            System.out.println("Actual does not contain the expected item " + DiscriminatorRegistry.get(item));
//            dump("Expected", expected);
//            dump("Actual  ", actual);
            return false;
         }
      }
      return true;
   }

   private void dump(String header, long[] array)
   {
      System.out.print(header + ": [" + DiscriminatorRegistry.get(array[0]));
      for (int i = 1; i < array.length; ++i)
      {
         System.out.print(", " + DiscriminatorRegistry.get(array[i]));
      }
      System.out.println("]");
   }

   /**
    * Returns true if the <em>array</em> contains the <em>item</em>.
    */
   protected boolean contains(long[] array, long item)
   {
      for (long type : array)
      {
         if (DiscriminatorRegistry.isa(item, type))
         {
            return true;
         }
      }
      return false;
   }
}
