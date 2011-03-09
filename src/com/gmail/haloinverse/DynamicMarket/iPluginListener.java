package com.gmail.haloinverse.DynamicMarket;

import org.bukkit.event.server.PluginEvent;
import org.bukkit.event.server.ServerListener;
 
import com.nijikokun.bukkit.Permissions.Permissions;
import com.nijiko.coelho.iConomy.iConomy;
import org.bukkit.plugin.Plugin;
 
/**
 * iPluginListener
 * Allows us to hook into permissions even if it is loaded later on.
 *
 * Checks for Plugins on the event that they are enabled,
 * checks the name given with the usual name of the plugin to
 * verify the existence. If the name matches we pass the plugin along
 * to iConomy to utilize in various ways.
 *
 * @author Nijikokun
 */
public class iPluginListener extends ServerListener {
	public iPluginListener() { }
 
    @Override
    public void onPluginEnabled(PluginEvent event) {
    	if(event.getPlugin().getDescription().getName().equals("iConomy")) {
	        if(DynamicMarket.getiConomy() == null) {
	            Plugin iConomy = DynamicMarket.getTheServer().getPluginManager().getPlugin("iConomy");
	 
	            if (iConomy != null) {
	                DynamicMarket.setiConomy((iConomy)iConomy);
	                DynamicMarket.iConomyData();
	            }
	        }
    	}
    	if(event.getPlugin().getDescription().getName().equals("Permissions")) {
	        if(DynamicMarket.getPermissions() == null) {
	        	Plugin Permissions = DynamicMarket.getTheServer().getPluginManager().getPlugin("Permissions");
	        	
	        	if(Permissions != null) {
	        		DynamicMarket.setPermissions((Permissions)Permissions);
	        		System.out.println("[DynamicMarket] Successfully linked with Permissions.");
	        	}
	        }
    	}
    }
}