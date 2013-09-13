package org.anc.lapps.client;

import org.anc.lapps.servers.Server;

/**
 * @author Keith Suderman
 */
public class Servers
{
   public static final Server LOCALHOST = new Server("http://localhost:8080", "operator1", "operator1");
   public static final Server ANCGRID = new Server("http://grid.anc.org:8080", "suderman", "lapplander");
}
